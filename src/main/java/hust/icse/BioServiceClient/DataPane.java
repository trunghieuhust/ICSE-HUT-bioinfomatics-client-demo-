package hust.icse.BioServiceClient;

import javax.swing.JTabbedPane;

public class DataPane extends JTabbedPane {

	private static final long serialVersionUID = 1L;

	public DataPane() {
		super(DataPane.TOP);
		UploadPane uploadPane = new UploadPane();
		addTab("Upload", null, uploadPane, "Upload file to server.");

		FileManagerPane fileManagerPane = new FileManagerPane();
		addTab("Remote file manager", null, fileManagerPane,
				"Remote file manager");
	}

}
