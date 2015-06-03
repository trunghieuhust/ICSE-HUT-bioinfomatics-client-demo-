package hust.icse.BioServiceClient;

import hust.icse.bio.service.Container;
import hust.icse.bio.service.File;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

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

public class FileTablePane extends JPanel {

	private static final long serialVersionUID = 1L;
	private List<Container> containterList;
	private DefaultTableModel model;
	private String[] columnName = { "Filename", "Size", "Select", "Status" };
	private static final int DEFAULT_ROW = 20;
	private JTable jtable;

	public FileTablePane() {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("400px:grow"), },
				new RowSpec[] { RowSpec.decode("default:grow"), }));
		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

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
		jtable.setFillsViewportHeight(false);
		jtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jtable.setAutoscrolls(true);
		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable.setRowSelectionAllowed(true);
		jtable.setColumnSelectionAllowed(false);
		jtable.enableInputMethods(false);
		jtable.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						if ((boolean) model.getValueAt(e.getFirstIndex(), 2) == true) {
							updateStatus(e.getFirstIndex(), "Skip");
							model.setValueAt(false, e.getFirstIndex(),
									columnName.length - 2);
							String name = (String) model.getValueAt(
									e.getFirstIndex(), 0);
							Container cont = getContainer(name);
							if (cont != null) {
								int size = cont.getFileList().size();
								System.out.println(size);
								int pos = e.getFirstIndex();
								for (int i = 0; i < size; i++) {
									pos++;
									model.setValueAt(false, pos, 2);
									updateStatus(pos, "Skip");
								}
							}

						} else {
							updateStatus(e.getFirstIndex(), "Ready");
							model.setValueAt(true, e.getFirstIndex(),
									columnName.length - 2);
							String name = (String) model.getValueAt(
									e.getFirstIndex(), 0);
							Container cont = getContainer(name);
							if (cont != null) {
								int size = cont.getFileList().size();
								System.out.println(size);
								int pos = e.getFirstIndex();
								for (int i = 0; i < size; i++) {
									pos++;
									model.setValueAt(true, pos, 2);
									updateStatus(pos, "Ready");
								}
							}
						}
						model.fireTableDataChanged();
					}
				});
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "1, 1, fill, fill");
		scrollPane.setViewportView(jtable);
	}

	public void setContainerList(List<Container> containerList) {
		this.containterList = containerList;
		clearList();
		for (Container container : containterList) {
			insertRow(new Object[] { container.getName(),
					FileUtils.byteCountToDisplaySize(container.getByteUsed()),
					true, "Ready" });
			List<File> listFile = container.getFileList();
			for (File file : listFile) {
				insertRow(new Object[] { "   ▶" + file.getName(),
						FileUtils.byteCountToDisplaySize(file.getBytes()),
						true, "Ready" });
			}
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

	public int getRowCount() {
		return model.getRowCount();
	}

	public boolean isSelect(int index) {
		return (boolean) model.getValueAt(index, 2);
	}

	public String getFilename(int index) {
		return (String) model.getValueAt(index, 0);
	}

	public Container getContainer(String name) {
		for (Container container : containterList) {
			if (container.getName().equals(name)) {
				return container;
			}
		}
		return null;
	}

	public Container getContainerOfFile(String fileName) {
		for (Container container : containterList) {
			List<File> fileList = container.getFileList();
			for (File file : fileList) {
				if (file.getName().equals(fileName)) {
					return container;
				}
			}
		}
		return null;
	}

	public String[] getSelected() {
		ArrayList<String> selected = new ArrayList<String>();
		for (int i = 0; i < model.getRowCount(); i++) {
			if (model.getValueAt(i, 0) == null) {
				break;
			}
			boolean select = (boolean) model.getValueAt(i, 2);
			if (select == true) {
				selected.add((String) model.getValueAt(i, 0));
			}
		}
		return selected.toArray(new String[selected.size()]);
	}
}
