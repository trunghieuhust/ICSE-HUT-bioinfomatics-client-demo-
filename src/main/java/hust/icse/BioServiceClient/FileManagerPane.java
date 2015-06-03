package hust.icse.BioServiceClient;

import hust.icse.bio.service.Container;
import hust.icse.bio.service.File;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class FileManagerPane extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton refresh;
	private JButton delete;
	private JButton getLink;
	private FileTablePane fileTable;
	private JEditorPane resultPane;
	private List<Container> listContainer;

	// ▶▶▶▶▶▶▶
	public FileManagerPane() {
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
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC }));
	}

	private void addLabelandButton() {
		JLabel uploadLabel = DefaultComponentFactory.getInstance().createLabel(
				"Get file list from server");
		add(uploadLabel, "2,2, 3, 1");
		refresh = new JButton("Refresh");
		add(refresh, "2,4,left, default");
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RefreshTask refreshTask = new RefreshTask();
				refreshTask.execute();
			}
		});
		fileTable = new FileTablePane();
		add(fileTable, "2, 6, 3, 1, fill, fill");
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteTask deleteTask = new DeleteTask();
				deleteTask.execute();
			}
		});
		getLink = new JButton("Get Link");
		// add(delete, "2, 8, left, default");
		getLink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getLinkTask linkTask = new getLinkTask();
				linkTask.execute();
			}
		});
		// add(getLink, "3,8");
		JPanel buttonPane = new JPanel();
		buttonPane.add(delete);
		buttonPane.add(getLink);
		add(buttonPane, "2, 8, left, default");

		JLabel resultLabel = DefaultComponentFactory.getInstance().createLabel(
				"Result");
		add(resultLabel, "2,10,left, default");
		resultPane = new JEditorPane();
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 12, 3, 1, fill, fill");
		scrollPane.setToolTipText("Return data");
		scrollPane.setViewportView(resultPane);
		resultPane.setToolTipText("Result received from server");
		resultLabel.setLabelFor(resultPane);
		resultPane.setEditable(false);
	}

	private class RefreshTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			refresh.setEnabled(false);
			delete.setEnabled(false);

			listContainer = Main.getBio().getAllContainer(Main.getUsername(),
					Main.getPassword());
			fileTable.setContainerList(listContainer);
			return null;
		}

		@Override
		protected void done() {
			refresh.setEnabled(true);
			delete.setEnabled(true);
		}
	}

	private class DeleteTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			refresh.setEnabled(false);
			delete.setEnabled(false);
			resultPane.setText("");
			String[] selected = fileTable.getSelected();
			StringBuilder resultText = new StringBuilder();
			for (int i = 0; i < selected.length; i++) {
				Container cont = getContainer(selected[i]);
				if (cont != null) {
					boolean result = Main.getBio()
							.deleteContainer(Main.getUsername(),
									Main.getPassword(), selected[i]);
					resultText.append("Delete container '" + selected[i]
							+ "': " + result);
					i = i + cont.getFileList().size();
				} else {
					String filename = selected[i].replace("▶", "");
					boolean result = Main.getBio().deleteFile(
							Main.getUsername(), Main.getPassword(),
							getContainerOfFile(filename).getName(), filename);
					resultText.append("Delete file '" + filename + "': "
							+ result);
				}
				resultPane.setText(resultText.toString());
			}
			delete.setEnabled(true);
			return null;
		}

		@Override
		protected void done() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			RefreshTask refreshTask = new RefreshTask();
			refreshTask.execute();
		}
	}

	private class getLinkTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			getLink.setEnabled(false);
			String[] selected = fileTable.getSelected();
			resultPane.setText("");
			StringBuilder resultText = new StringBuilder();
			for (int i = 0; i < selected.length; i++) {
				Container cont = getContainer(selected[i]);
				if (cont != null) {
					List<File> fileList = cont.getFileList();
					resultText.append("\nContainer: " + selected[i]);
					for (File file : fileList) {
						resultText.append("\n   ▶ " + file.getName() + ": "
								+ "\n     " + file.getFileURL());
					}
					i = i + cont.getFileList().size();
				} else {
					Container container = null;
					String fileName = selected[i].replace("▶", "").trim();
					container = getContainerOfFile(fileName);
					resultText.append("\nContainer: " + container.getName()
							+ ": ");
					resultText
							.append("\n   ▶ " + getFile(fileName).getName()
									+ ": " + "\n     "
									+ getFile(fileName).getFileURL());
				}
			}
			resultPane.setText(resultText.toString());
			getLink.setEnabled(true);
			return null;
		}
	}

	private Container getContainer(String name) {
		for (Container container : listContainer) {
			if (container.getName().equals(name)) {
				return container;
			}
		}
		return null;
	}

	public Container getContainerOfFile(String fileName) {
		for (Container container : listContainer) {
			List<File> fileList = container.getFileList();
			for (File file : fileList) {
				if (file.getName().equals(fileName)) {
					System.out.println("found " + container.getName());
					return container;
				}
			}
		}
		System.out.println("not found" + fileName);
		return null;
	}

	public File getFile(String fileName) {
		for (Container container : listContainer) {
			List<File> fileList = container.getFileList();
			for (File file : fileList) {
				if (file.getName().equals(fileName)) {
					return file;
				}
			}
		}
		return null;
	}
}
