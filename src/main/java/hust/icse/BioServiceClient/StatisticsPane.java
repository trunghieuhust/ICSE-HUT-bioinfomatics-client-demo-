package hust.icse.BioServiceClient;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class StatisticsPane extends JPanel {
	private DefaultTableModel model;
	private String[] columnName = { "Flavor", "Total time" };
	private static final int DEFAULT_ROW = 20;
	private JTable jtable;

	public StatisticsPane() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("400px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC }, new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC }));
		JLabel statistics = DefaultComponentFactory.getInstance().createLabel(
				"Statistics");
		add(statistics, "2,2, left, bottom");

		model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
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

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, " 2, 4, fill, fill");
		scrollPane.setViewportView(jtable);
		model.getDataVector().removeAllElements();
		model.addRow(new Object[] { "clustalo-small", "00:04:02" });
		model.addRow(new Object[] { "fasttree-small", "00:02:12" });
		model.setRowCount(DEFAULT_ROW);

		model.fireTableDataChanged();
		JButton getstatistics = new JButton("Refresh statistics");
		add(getstatistics, "2,6, left, default");
	}
}
