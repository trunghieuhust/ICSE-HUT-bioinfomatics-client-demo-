package hust.icse.BioServiceClient;

import hust.icse.bio.service.FileUploader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class UploadPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private SelectTablePane selectTable;
	private JButton chooseFile;
	private JButton uploadbtn;

	public UploadPane() {
		setupUI();
		addLabelandButton();
	}

	private void setupUI() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC }));
	}

	private void addLabelandButton() {
		JLabel uploadLabel = DefaultComponentFactory.getInstance().createLabel(
				"Choose file to upload");
		add(uploadLabel, "2,2, 3, 1");
		chooseFile = new JButton("Browse file");
		add(chooseFile, "2,4,left, default");
		chooseFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				File[] fileList = getUploadFile();
				selectTable.setFileList(fileList);
			}
		});
		selectTable = new SelectTablePane();
		add(selectTable, "2, 6, 3, 1, fill, fill");
		uploadbtn = new JButton("Upload");
		uploadbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UploadTask upload = new UploadTask();
				upload.execute();

			}
		});
		add(uploadbtn, "2, 8, left, default");
	}

	private File[] getUploadFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if (chooser.showSaveDialog(null) == JFileChooser.CANCEL_OPTION) {
			return null;
		} else {
			return chooser.getSelectedFiles();
		}
	}

	class UploadTask extends SwingWorker<Void, Void> {

		public UploadTask() {
		}

		@Override
		protected Void doInBackground() throws Exception {
			uploadbtn.setEnabled(false);
			selectTable.setEnabled(false);
			chooseFile.setEnabled(false);
			File[] fileList = selectTable.getFileList();
			for (int i = 0; i < fileList.length; i++) {
				if (selectTable.isUpload(i) == true) {
					FileUploader fileUploader = new FileUploader();
					fileUploader.setFile(new DataHandler(new FileDataSource(
							fileList[i])));
					fileUploader.setName(fileList[i].getName());
					System.out.println(fileList[i].getName());
					selectTable.updateStatus(i, "Uploading");
					Main.getBio().uploadData(Main.getUsername(),
							Main.getPassword(), fileUploader);
					selectTable.updateStatus(i, "Uploaded ");

				} else {
					System.out.println("skip " + fileList[i].getName());
				}
			}
			System.out.println("end");
			return null;
		}

		@Override
		protected void done() {
			uploadbtn.setEnabled(true);
			selectTable.setEnabled(true);
			chooseFile.setEnabled(true);
		}
	}
}
