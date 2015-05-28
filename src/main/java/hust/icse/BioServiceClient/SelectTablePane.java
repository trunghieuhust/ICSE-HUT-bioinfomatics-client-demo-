package hust.icse.BioServiceClient;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class SelectTablePane extends JPanel {

	private static final long serialVersionUID = 1L;
	private File[] fileList = null;
	private String[] fileListName = null;
	private boolean[] isUpload = null;
	private DefaultTableModel model;
	private String[] columnName = { "Filename", "Size", "Select", "Status" };
	private static final int DEFAULT_ROW = 20;
	private JTable jtable;

	public SelectTablePane() {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("400px:grow"), },
				new RowSpec[] { RowSpec.decode("default:grow"), }));
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				if (columnIndex == 2) {
					return Boolean.class;
				} else {
					return String.class;
				}
			}
		};
		model.setColumnIdentifiers(columnName);
		model.setRowCount(DEFAULT_ROW);

		jtable = new JTable(model);
		jtable.setPreferredScrollableViewportSize(new Dimension(450, 250));
		jtable.setMinimumSize(new Dimension(400, 0));
		jtable.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		jtable.setToolTipText("Select file");
		jtable.setFillsViewportHeight(false);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jtable.setAutoscrolls(true);
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable.setRowSelectionAllowed(true);
		jtable.setColumnSelectionAllowed(false);
		jtable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if ((boolean) model.getValueAt(e.getFirstIndex(), 2) == true) {
							updateStatus(e.getFirstIndex(), "Skip");
						} else {
							updateStatus(e.getFirstIndex(), "Ready");
						}
					}
				});
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "1, 1, fill, fill");
		scrollPane.setViewportView(jtable);
	}

	public void setFileList(File[] fileList) {
		this.fileList = fileList;
		isUpload = new boolean[this.fileList.length];
		clearList();
		this.fileListName = new String[this.fileList.length];
		for (int i = 0; i < fileList.length; i++) {
			isUpload[i] = true;
			fileListName[i] = fileList[i].getName();
			model.addRow(new Object[] { fileList[i].getName(),
					FileUtils.byteCountToDisplaySize(fileList[i].length()),
					isUpload[i], "Ready" });
		}
		fillTable();
	}

	public void fillTable() {
		if (model.getRowCount() < DEFAULT_ROW) {
			model.setRowCount(DEFAULT_ROW);
		}
		model.fireTableDataChanged();
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		jtable.setEnabled(enabled);
	}

	public boolean isUpload(int index) {
		return (boolean) model.getValueAt(index, 2);
	}

	public void clearList() {
		model.getDataVector().removeAllElements();
	}

	public void insertRow(Object[] row) {
		model.addRow(row);
	}

	public void updateStatus(int row, String status) {
		model.setValueAt(status, row, columnName.length - 1);
		model.fireTableDataChanged();
	}

	public File[] getFileList() {
		return fileList;
	}

	public int getRowCount() {
		return model.getRowCount();
	}

	public boolean isSelect(int index) {
		return (boolean) model.getValueAt(index, 2);
	}

	public String getFilename(int index) {
		return (String) model.getValueAt(index, 0);
	}
}
