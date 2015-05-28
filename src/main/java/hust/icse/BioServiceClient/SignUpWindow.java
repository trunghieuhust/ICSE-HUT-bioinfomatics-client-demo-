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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SignUpWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final Dimension DEFAULT_LOGIN_SIZE = new Dimension(280, 200);
	private FlowLayout fl;
	private static InputField username;
	private static InputField password;

	public SignUpWindow() {
		setUIBase();
		addInputField();
		addButton();
//		addSignUpLink();
	}

	private void setUIBase() {
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
		username = new InputField("User name", "");
		username.setMnemonic('u');
		super.getContentPane().add(username);

		// password
		password = new InputField("Password", "", true);
		password.setMnemonic('p');
		super.getContentPane().add(password);

	}

	private void addButton() {
		JButton signUpButton = new JButton("Sign Up");
		super.getContentPane().add(signUpButton);
		super.getRootPane().setDefaultButton(signUpButton);
		signUpButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				boolean result = Main.getBio().signUp(username.getValue(),
						password.getValue());
				if (result == true) {
					showSignUpDialog("Sign up completed !");
					Main.showLoginWindows();
					close();
				} else {
					showSignUpDialog("Sign up failed !");
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

	private void showSignUpDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Sign Up",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
