package hust.icse.BioServiceClient;

import hust.icse.bio.service.ActivityStatus;
import hust.icse.bio.service.Bio;
import hust.icse.bio.service.BioServiceImplService;
import hust.icse.bio.service.Status;
import hust.icse.bio.service.TaskResult;
import hust.icse.bio.service.TaskStatus;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class WorkflowPane extends JPanel implements ActionListener,
		PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane resultPane;
	private JEditorPane xmlEditor;
	private JButton btnExecute;
	private JButton btnSubmit;
	private Bio bio;
	private final static String TEST = "<workflow name='2step' save-as-template='true'><activities><activity name='aligment'><task name='clustal1'><tool-alias>clustal</tool-alias><input-files input='input'></input-files><output-files output='output1'></output-files><flavor>small</flavor></task><task name='clustal2'><tool-alias>clustalo2</tool-alias><input-files input='input'></input-files><output-files output='output2'></output-files></task></activity><activity name='fasttree'><task name='fasttree'><tool-alias>fasttree</tool-alias><input-files input='output2'></input-files><output-files output='output-fasttree'></output-files><flavor>small</flavor></task></activity></activities></workflow><tools><tool><alias>clustal</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output -v'></execute></tool><tool><alias>clustalo2</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output --outfmt=clustal -v'></execute></tool><tool><alias>fasttree</alias><name>fasttree</name><version>2.1</version><package>fasttree</package><execute command='$input > $output'></execute></tool></tools>";

	public WorkflowPane() {
		bio = new BioServiceImplService().getBioServiceImplPort();

		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(75dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.BUTTON_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.BUTTON_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC }));

		JLabel submitLabel = DefaultComponentFactory.getInstance().createLabel(
				"Workflow");
		add(submitLabel, "2,2, right, bottom");

		JScrollPane scrollPane_1 = new JScrollPane();
		add(scrollPane_1, "2, 4, 3, 1, fill, fill");

		xmlEditor = new JEditorPane();
		scrollPane_1.setViewportView(xmlEditor);
		submitLabel.setLabelFor(xmlEditor);
		xmlEditor.setEditable(true);

		btnExecute = new JButton("Execute");
		add(btnExecute, "2, 6, left, default");
		btnExecute.setMnemonic('s');
		btnExecute.setToolTipText("Draw workflow graph");
		btnExecute.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		JLabel graphLabel = DefaultComponentFactory.getInstance().createLabel(
				"Graph");
		add(graphLabel, "2,8, right, bottom");

		JScrollPane scrollGraphPane = new JScrollPane();
		add(scrollGraphPane, "2, 10, 3, 1, fill, fill");
		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			Object start = graph.insertVertex(parent, null, "start", 40, 40,
					100, 40);

			Object task1 = graph.insertVertex(parent, null, "clustal1", 40, 40,
					100, 40);
			Object task2 = graph.insertVertex(parent, null, "clustal2", 0, 0,
					100, 40);
			graph.insertEdge(parent, null, null, start, task1);
			graph.insertEdge(parent, null, null, start, task2);

			Object fasttree = graph.insertVertex(parent, null, "fasttree", 0,
					0, 100, 40);
			graph.insertEdge(parent, null, null, task1, fasttree);
			graph.insertEdge(parent, null, null, task2, fasttree);
			Object end = graph.insertVertex(parent, null, "end", 0, 0, 100, 40);
			graph.insertEdge(parent, null, null, fasttree, end);
			// Object loads = graph.insertVertex(parent, null, "Loads", 0, 0,
			// 200, 400, "shape=swimlane;");
			// graph.groupCells(loads, 5, new Object[] { load1, load2 });

			mxHierarchicalLayout layout = new mxHierarchicalLayout(graph,
					SwingConstants.WEST);
			layout.execute(parent);

		} finally {
			graph.getModel().endUpdate();
		}
		Rectangle bounds = scrollGraphPane.getViewport().getViewRect();
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		JScrollBar horizontal = scrollGraphPane.getHorizontalScrollBar();
		horizontal.setValue((horizontal.getMaximum() - bounds.width) / 2);

		JScrollBar vertical = scrollGraphPane.getVerticalScrollBar();
		vertical.setValue((vertical.getMaximum() - bounds.height) / 2);
		scrollGraphPane.setViewportView(graphComponent);

		btnSubmit = new JButton("Submit");
		add(btnSubmit, "2,12,left, default");
		btnSubmit.addActionListener(this);
		JLabel lblResult = DefaultComponentFactory.getInstance().createLabel(
				"Result");
		add(lblResult, "2, 14, 3, 1");

		resultPane = new JEditorPane();
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "2, 16, 3, 1, fill, fill");
		scrollPane.setToolTipText("Return data");
		scrollPane.setViewportView(resultPane);
		resultPane.setToolTipText("Result received from server");
		lblResult.setLabelFor(resultPane);
		resultPane.setEditable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Task task = new Task();
		task.execute();
	}

	private String getResultText(Status status) {
		StringBuffer sb = new StringBuffer();
		sb.append("Workflow name: " + status.getName());
		sb.append("\nWorkflow ID: " + status.getID());
		sb.append("\nStatus: " + status.getStatus());
		// List<ActivityStatus> activityList = status.getActivityStatusList();
		//
		// for (ActivityStatus activityStatus : activityList) {
		// sb.append("\n\n\tActivity Name: " + activityStatus.getName());
		// sb.append(" .ID: " + activityStatus.getID());
		// sb.append("\n\tActivity Status: " + activityStatus.getStatus());
		// List<TaskStatus> taskList = activityStatus.getTaskStatusList();
		// for (TaskStatus taskStatus : taskList) {
		// sb.append("\n\n\t\tTask name: " + taskStatus.getName());
		// sb.append("  .ID: " + taskStatus.getID());
		// sb.append("\n\t\tTask status: " + taskStatus.getStatus());
		// if (taskStatus.getStatusCode() == 2) {
		// TaskResult result = bio.getResult(Main.getUsername(),
		// Main.getPassword(), taskStatus.getID());
		// sb.append("\n\t\tOutput console: "
		// + result.getOutputConsole());
		// sb.append("\n\t\tOutput file: " + result.getOutputFile());
		// sb.append("\n\t\tUptime: " + result.getDurationTime());
		// }
		// }
		// }
		return sb.toString();
	}

	class Task extends SwingWorker<Void, Void> {
		@Override
		protected Void doInBackground() throws Exception {
			btnExecute.setEnabled(false);
			xmlEditor.setEditable(false);
			String workflow = xmlEditor.getText();
			System.out.println(workflow);
//			String ID = bio.createWorkflow(Main.getUsername(),
//					Main.getPassword(), workflow);
//			bio.createWorkflowFromTemplate(username, password, workflow)
			String ID = bio.createWorkflowFromTemplate(Main.getUsername(), Main.getPassword(), xmlEditor.getText(), null);
			Status status = null;
			while (status == null || status.getStatusCode() != 2) {
				status = bio.getStatus(ID);
				resultPane.setText(getResultText(status));
				System.out.println(getResultText(status));
				if (status.getStatusCode() == 1 || status.getStatusCode() == 4) {
					break;
				}
				Thread.sleep(3000);
			}
			return null;
		}

		@Override
		protected void done() {
			btnExecute.setEnabled(true);
			xmlEditor.setEditable(true);
			super.done();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
