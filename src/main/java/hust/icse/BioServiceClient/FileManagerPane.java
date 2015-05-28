package hust.icse.BioServiceClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

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
	private SelectTablePane selectTable;

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
		selectTable = new SelectTablePane();
		add(selectTable, "2, 6, 3, 1, fill, fill");
		delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteTask deleteTask = new DeleteTask();
				deleteTask.execute();
			}
		});
		add(delete, "2, 8, left, default");
		getLink = new JButton("Get Link");
		getLink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				getLinkTask linkTask = new getLinkTask();
				linkTask.execute();
			}
		});
	}

	private class RefreshTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			refresh.setEnabled(false);
			delete.setEnabled(false);

			List<String> listContainer = Main.getBio().getAllContainer(
					Main.getUsername(), Main.getPassword());
			selectTable.clearList();
			for (String container : listContainer) {
				selectTable.insertRow(new Object[] { container, 0, true,
						"Ready" });
				List<String> listFile = Main.getBio().getAllFileInContainer(
						Main.getUsername(), Main.getPassword(), container);
				for (String file : listFile) {
					selectTable.insertRow(new Object[] { "   ▶" + file, 0,
							true, "Ready" });
				}
			}
			return null;
		}

		@Override
		protected void done() {
			selectTable.fillTable();
			refresh.setEnabled(true);
			delete.setEnabled(true);
		}
	}

	private class DeleteTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			refresh.setEnabled(false);
			delete.setEnabled(false);

			int rowCount = selectTable.getRowCount();
			String currentContainer = null;
			for (int i = 0; i < rowCount; i++) {
				String name = selectTable.getFilename(i);
				if (name.contains("▶")) {
					if (selectTable.isSelect(i)) {
						String filename = name.trim().replace("▶", "");
						Main.getBio().deleteFile(Main.getUsername(),
								Main.getPassword(), currentContainer, filename);
					}
				} else {
					currentContainer = name;
					if (selectTable.isSelect(i)) {
						Main.getBio().deleteContainer(Main.getUsername(),
								Main.getPassword(), name);
					}
				}
			}
			refresh.setEnabled(true);
			delete.setEnabled(true);
			return null;
		}

		@Override
		protected void done() {
			RefreshTask refreshTask = new RefreshTask();
			refreshTask.execute();
		}
	}

	private class getLinkTask extends SwingWorker<Void, Void> {

		@Override
		protected Void doInBackground() throws Exception {
			refresh.setEnabled(false);
			delete.setEnabled(false);
			selectTable.setEnabled(false);
			int rowCount = selectTable.getRowCount();
			String currentContainer = null;
			int currentContainerIndex = -1;
			for (int i = 0; i < rowCount; i++) {
				String name = selectTable.getFilename(i);
				if (name.contains("▶")) {
					if (selectTable.isSelect(i)) {
						String filename = name.trim().replace("▶", "");
						if (!selectTable.isSelect(currentContainerIndex)) {
							Main.getBio().deleteFile(Main.getUsername(),
									Main.getPassword(), currentContainer, filename);

						}
					}
				} else {
					currentContainer = name;
					currentContainerIndex = i;
					if (selectTable.isSelect(i)) {
//						Strin
					}
				}
			}
			return null;
		}
	}
}
