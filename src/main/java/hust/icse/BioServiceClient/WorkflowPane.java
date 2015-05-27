package hust.icse.BioServiceClient;

import hust.icse.bio.service.ActivityStatus;
import hust.icse.bio.service.Bio;
import hust.icse.bio.service.BioServiceImplService;
import hust.icse.bio.service.Status;
import hust.icse.bio.service.TaskResult;
import hust.icse.bio.service.TaskStatus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class WorkflowPane extends JPanel implements ActionListener,
		PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane resultPane;
	private JEditorPane xmlEditor;
	private JButton btnSubmit;
	private Bio bio;
	private final static String TEST = "<workflow name='2step'><activities><activity name='aligment'><task name='clustal1'><tool-alias>clustal</tool-alias><input-files input='input'></input-files><output-files output='output1'></output-files></task><task name='clustal2'><tool-alias>clustalo2</tool-alias><input-files input='input'></input-files><output-files output='output2'></output-files></task></activity><activity name='fasttree'><task name='fasttree'><tool-alias>fasttree</tool-alias><input-files input='output2'></input-files><output-files output='output-fasttree'></output-files></task></activity></activities></workflow><tools><tool><alias>clustal</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output -v'></execute></tool><tool><alias>clustalo2</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output --outfmt=clustal -v'></execute></tool><tool><alias>fasttree</alias><name>fasttree</name><version>2.1</version><package>fasttree</package><execute command='$input > $output'></execute></tool></tools>";

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

		btnSubmit = new JButton("Submit");
		add(btnSubmit, "2, 6, left, default");
		btnSubmit.setMnemonic('s');
		btnSubmit.setToolTipText("Sumit XML");
		btnSubmit.addActionListener(this);

		JLabel lblResult = DefaultComponentFactory.getInstance().createLabel(
				"Result");
		add(lblResult, "2, 8, 3, 1");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Returning data");
		add(scrollPane, "2, 10, 3, 1, fill, fill");

		resultPane = new JEditorPane();
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
		List<ActivityStatus> activityList = status.getActivityStatusList();

		for (ActivityStatus activityStatus : activityList) {
			sb.append("\n\n\tActivity Name: " + activityStatus.getName());
			sb.append(" .ID: " + activityStatus.getID());
			sb.append("\n\tActivity Status: " + activityStatus.getStatus());
			List<TaskStatus> taskList = activityStatus.getTaskStatusList();
			for (TaskStatus taskStatus : taskList) {
				sb.append("\n\n\t\tTask name: " + taskStatus.getName());
				sb.append("  .ID: " + taskStatus.getID());
				sb.append("\n\t\tTask status: " + taskStatus.getStatus());
				if (taskStatus.getStatusCode() == 2) {
					TaskResult result = bio.getResult(Main.getUsername(),
							Main.getPassword(), taskStatus.getID());
					sb.append("\n\t\tOutput console: "
							+ result.getOutputConsole());
					sb.append("\n\t\tOutput file: " + result.getOutputFile());
					sb.append("\n\t\tUptime: " + result.getDurationTime());
				}
			}
		}
		return sb.toString();
	}

	class Task extends SwingWorker<Void, Void> {
		@Override
		protected Void doInBackground() throws Exception {
			btnSubmit.setEnabled(false);
			xmlEditor.setEditable(false);
			String workflow = xmlEditor.getText();
			System.out.println(workflow);
			String ID = bio.createWorkflow(Main.getUsername(),
					Main.getPassword(), workflow);
			Status status = null;
			while (status == null || status.getStatusCode() != 2) {
				status = bio.getStatus(ID);
				resultPane.setText(getResultText(status));
				System.out.println(getResultText(status));
				Thread.sleep(3000);
			}
			return null;
		}

		@Override
		protected void done() {
			btnSubmit.setEnabled(true);
			xmlEditor.setEditable(true);
			super.done();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {

	}

}
