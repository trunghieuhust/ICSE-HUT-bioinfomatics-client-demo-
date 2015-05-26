package hust.icse.BioServiceClient;

import hust.icse.bio.service.Bio;
import hust.icse.bio.service.BioServiceImplService;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginWindow extends JFrame {
	private static final Dimension DEFAULT_LOGIN_SIZE = new Dimension(280, 200);
	private FlowLayout fl;
	private static InputField username;
	private static InputField password;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginWindow() {
		setUIBase();
		addInputField();
		addButton();
	}

	private void setUIBase() {
		// base info
		super.setTitle("Bio Service Client - login");
		super.setSize(DEFAULT_LOGIN_SIZE);
		super.setResizable(true);
		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent e) {
				setSize(new Dimension((int) DEFAULT_LOGIN_SIZE.getWidth(),
						getHeight()));
				super.componentResized(e);
			}
		});

		addWindowStateListener(new WindowAdapter() {

			@Override
			public void windowStateChanged(WindowEvent e) {
				if ((e.getNewState() & JFrame.MAXIMIZED_HORIZ) == JFrame.MAXIMIZED_HORIZ)
					setExtendedState(JFrame.NORMAL);
				else if ((e.getNewState() & JFrame.MAXIMIZED_BOTH) == JFrame.MAXIMIZED_BOTH)
					setExtendedState(JFrame.MAXIMIZED_VERT);
			}
		});

		// add components
		fl = new FlowLayout(FlowLayout.CENTER);
		super.getContentPane().setLayout(fl);

	}

	private void addInputField() {
		// username
		username = new InputField("User name", "ducdmk55");
		username.setMnemonic('u');
		super.getContentPane().add(username);

		// password
		password = new InputField("Password", "ducdmk55@123", true);
		password.setMnemonic('p');
		super.getContentPane().add(password);

	}

	private void addButton() {
		JButton loginButton = new LoginButton(this);
		super.getContentPane().add(loginButton);
		super.getRootPane().setDefaultButton(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (login(username.getValue(), password.getValue())) {
					Properties prop = new Properties();
					prop.put("username", username.getValue());
					prop.put("password", password.getValue());
					JFrame mainWindow = new MainWindow(prop);
					mainWindow.setVisible(true);
					close();
				} else {
					showLoginFailedDialog();
				}
			}
		});
		JButton cancelButton = new JButton();
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		super.getContentPane().add(cancelButton);
	}

	private void close() {
		super.setVisible(false);
		dispose();
	}

	private boolean login(String username, String password) {
		Bio bio = new BioServiceImplService().getBioServiceImplPort();
		return bio.authenticate(username, password);
	}

	public static String getUsername() {
		return username.getValue();
	}

	public static String getPassword() {
		return password.getValue();
	}

	private void showLoginFailedDialog() {
		JOptionPane.showMessageDialog(this, "Login failed", "Login",
				JOptionPane.WARNING_MESSAGE);
	}
}
