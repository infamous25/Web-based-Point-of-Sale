package WPOS;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class LogInFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userid;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInFrame frame = new LogInFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(304, 12, 108, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddIconHere = new JLabel("add icon here");
		lblAddIconHere.setBounds(31, 159, 176, 194);
		contentPane.add(lblAddIconHere);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUserId.setBounds(304, 166, 120, 33);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPassword.setBounds(304, 258, 120, 33);
		contentPane.add(lblPassword);
		
		userid = new JTextField();
		userid.setColumns(10);
		userid.setBounds(478, 159, 211, 50);
		contentPane.add(userid);
		
		password = new JPasswordField();
		password.setBounds(478, 258, 211, 50);
		contentPane.add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					Statement stmt= con.createStatement();
					String sql = "select * from Users where UserID = '"+userid.getText()+"' and Password = '"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "LogIn Successful");
						
						int Privilegde_check=Integer.parseInt(userid.getText()); 
						if (Privilegde_check >= 1000) {
							 
							 
						}
						
						Main_Dashboard window = new Main_Dashboard();
						window.getFrame().setVisible(true);
						
					}
					else
						JOptionPane.showMessageDialog(null, "LogIn Unsuccessful");
					con.close();
				}catch(Exception e) {System.out.print(e);}
			}
		});
		btnLogin.setBounds(514, 328, 150, 25);
		contentPane.add(btnLogin);
	}
}
