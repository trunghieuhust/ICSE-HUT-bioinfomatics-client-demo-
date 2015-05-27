package hust.icse.BioServiceClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MainWindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(e.getWindow(),
						"Are you sure want to quit?", "Quit?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					e.getWindow().setVisible(false);
					e.getWindow().dispose();
				}
			}

		});
		setTitle("Bio Service Client");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 896, 587);

		setMenu();

		contentPane = new MainPane();
		setContentPane(contentPane);
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMain = new JMenu("Main");
		mnMain.setMnemonic('m');
		menuBar.add(mnMain);
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(MainWindow.this,
						"Are you sure want to quit?", "Quit?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					MainWindow.this.setVisible(false);
					MainWindow.this.dispose();
				}
			}
		});
		mnMain.add(mntmQuit);
	}
}
