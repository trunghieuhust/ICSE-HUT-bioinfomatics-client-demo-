package hust.icse.BioServiceClient;

import java.util.List;

import hust.icse.bio.service.ActivityStatus;
import hust.icse.bio.service.Bio;
import hust.icse.bio.service.BioServiceImplService;
import hust.icse.bio.service.Status;
import hust.icse.bio.service.TaskStatus;
import junit.framework.TestCase;

public class TestClient extends TestCase {
	private final static String TEST = "<workflow name='2step'><activities><activity name='aligment'><task name='clusltal'><tool-alias>clustal</tool-alias><input-files input='input'></input-files><output-files output='output'></output-files></task><task name='clustal'><tool-alias>clustalo2</tool-alias><input-files input='input'></input-files><output-files output='output3'></output-files></task></activity><activity name='fasttree'><task clustal='fasttree'><tool-alias>fasttree</tool-alias><input-files input='output'></input-files><output-files output='output-fasttree'></output-files></task></activity></activities></workflow><tools><tool><alias>clustal</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output -v'></execute></tool><tool><alias>clustalo2</alias><name>clustalo</name><version>1.2.1</version><package>clustalo</package><execute command='--infile=$input --outfile=$output --outfmt=clustal -v'></execute></tool><tool><alias>fasttree</alias><name>fasttree</name><version>2.1</version><package>fasttree</package><execute command='$input > $output'></execute></tool></tools>";

	public void testClient() throws Exception {
//		Bio bio = new BioServiceImplService().getBioServiceImplPort();
//		String ID = bio.createWorkflow("ducdmk55", "ducdmk55@123", TEST);
//		
//		System.err.println("WorkflowID: " + ID);
//		for (int i = 0; i < 1000; i++) {
//			Status status = bio.getStatus(ID);
//			System.out.println("\nWorkflow name: " + status.getName()
//					+ "\nStatus: " + status.getStatus() + "\nStatus Code: "
//					+ status.getStatusCode());
//			List<ActivityStatus> a = status.getActivityStatusList();
//			for (ActivityStatus activityStatus : a) {
//				System.out.println("\nActivity status:\n\tName: "
//						+ activityStatus.getName()+ "\n\tStatus: "+ activityStatus.getStatus());
//				List<TaskStatus> tasklist = activityStatus.getTaskStatusList();
//				for (TaskStatus taskStatus : tasklist) {
//					System.out.println("\n\t\tTask name: " + taskStatus.getName()
//							+ "\n\t\tTaskID: " + taskStatus.getID()
//							+ "\n\t\tTask status: " + taskStatus.getStatus()
//							+ "\n\t\tTask status code: "
//							+ taskStatus.getStatusCode());
//				}
//			}
//			Thread.sleep(5000);
//		}
	}
}
