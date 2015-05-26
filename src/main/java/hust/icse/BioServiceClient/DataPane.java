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
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.commons.io.FileUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class DataPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private SelectTablePane selectTable;
	private JButton chooseFile;
	private JButton uploadbtn;

	public DataPane() {
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
				"Upload");
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
				upload(selectTable.getFileList());
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

	private void upload(File[] fileList) {
		boolean[] isUpload = selectTable.getChosenFile();
		for (int i = 0; i < fileList.length; i++) {
			if (isUpload[i] == true) {
				UploadTask upload = new UploadTask(fileList[i], i);
				upload.execute();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class UploadTask extends SwingWorker<Void, Void> {
		private File file;
		private int index;

		public UploadTask(File file, int index) {
			this.file = file;
			this.index = index;
		}

		@Override
		protected Void doInBackground() throws Exception {
			uploadbtn.setEnabled(false);
			selectTable.setEnabled(false);
			chooseFile.setEnabled(false);
			FileUploader fileUploader = new FileUploader();
			fileUploader.setFile(new DataHandler(new FileDataSource(file)));
			fileUploader.setName(file.getName());
			System.out.println(file.getName());
			selectTable.updateStatus(index, "Uploading");
			long sentByte = Main.getBio().uploadData(fileUploader);
			selectTable.updateStatus(index,
					"Uploaded " + FileUtils.byteCountToDisplaySize(sentByte));
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
