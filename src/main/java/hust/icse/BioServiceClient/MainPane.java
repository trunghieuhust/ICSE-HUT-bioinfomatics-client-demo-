package hust.icse.BioServiceClient;

import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class MainPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private Properties prop;

	public MainPane() {
		setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("38px:grow"), },
				new RowSpec[] { RowSpec.decode("7px:grow"),
						FormSpecs.DEFAULT_ROWSPEC, }));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		add(tabbedPane, "1, 1, fill, fill");

		WorkflowPane workflowPane = new WorkflowPane();
		tabbedPane.addTab("Workflow", null, workflowPane, "Workflow");

		DataPane dataPane = new DataPane();
		tabbedPane.addTab("Data", dataPane);

		StatisticsPane statisticsPane = new StatisticsPane();
		tabbedPane.addTab("Statistics", statisticsPane);
	}
}
