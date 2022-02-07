package WPOS;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Main_Dashboard {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Main_Dashboard window = new Main_Dashboard();
					//window.frame.setVisible(true);
					LogInFrame tologin = new LogInFrame();
					tologin.setVisible(true);
					
					//tologin.dispose();
					//Main_Dashboard window = new Main_Dashboard();
					//window.getFrame().setVisible(true);
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Main_Dashboard() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 802, 512);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DASHBOARD");
		lblNewLabel_1.setBounds(367, 12, 95, 15);
		getFrame().getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("add user pic here0");
		lblNewLabel.setBounds(367, 39, 104, 75);
		getFrame().getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("logged in users's name here");
		textField.setColumns(10);
		textField.setBounds(292, 126, 259, 32);
		getFrame().getContentPane().add(textField);
		
		JButton btnInventoryManagement = new JButton("Inventory Management");
		btnInventoryManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
				EditInventoryFrame ToEditInventoryFrame = new EditInventoryFrame();
				ToEditInventoryFrame.setVisible(true);
			}
		});
		btnInventoryManagement.setBounds(54, 221, 220, 100);
		getFrame().getContentPane().add(btnInventoryManagement);
		
		JButton btnSalesReports = new JButton("Sales & Reports");
		btnSalesReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
				SalesFrame ToSalesFrame = new SalesFrame();
				ToSalesFrame.setVisible(true);
			
			}
		});
		btnSalesReports.setBounds(313, 221, 220, 100);
		getFrame().getContentPane().add(btnSalesReports);
		
		JButton btnUsersManagement = new JButton(" Users Management");
		btnUsersManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
				EditUserFrame ToEditUserFrame = new EditUserFrame();
				ToEditUserFrame.setVisible(true);
			}
		});
		btnUsersManagement.setBounds(566, 221, 220, 100);
		getFrame().getContentPane().add(btnUsersManagement);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "logged out!!");
				
				getFrame().dispose();
				LogInFrame ToLogInFrame = new LogInFrame();
				ToLogInFrame.setVisible(true);
			}
		});
		btnLogOut.setBounds(566, 359, 220, 100);
		getFrame().getContentPane().add(btnLogOut);
		
		JButton btnMessages = new JButton("Messages");
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getFrame().dispose();
				Messages ToMessages = new Messages();
				ToMessages.setVisible(true);
			}
		});
		btnMessages.setBounds(313, 359, 220, 100);
		getFrame().getContentPane().add(btnMessages);
		
		JButton btnUserLogs = new JButton("User Logs");
		btnUserLogs.setBounds(54, 359, 220, 100);
		getFrame().getContentPane().add(btnUserLogs);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}