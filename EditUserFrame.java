package WPOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
//import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.*;

//import org.jcp.xml.dsig.internal.dom.DOMUtils;

//import com.sun.org.apache.xerces.internal.util.DOMUtil;

import java.util.Properties;

public class EditUserFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Token_User;
	private JTextField Name_Add;
	private JTextField Surname_Add;
	private JTextField UserPriv__Add;
	private JTextField UserID_Add;
	private JTextField Password_Add;
	private JTextField UserPriv_Update;
	private JTextField Name_Update;
	private JTextField Surname_Update;
	private JTextField UserID_Update;
	private JTextField Password_Update;
	private JTextField UserID_Remove;

	/**
	 * Launch the application.
	 * 
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUserFrame frame = new EditUserFrame();
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
	public EditUserFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_Dashboard window = new Main_Dashboard();
				window.getFrame().setVisible(true);
			}
		});
		btnDashboard.setBounds(12, 0, 117, 25);
		contentPane.add(btnDashboard);
		
		JLabel lblUserManagement = new JLabel("User Management");
		lblUserManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserManagement.setFont(new Font("Dialog", Font.BOLD, 21));
		lblUserManagement.setBounds(207, 0, 239, 39);
		contentPane.add(lblUserManagement);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(484, 0, 104, 25);
		contentPane.add(btnSearch);
		
		Token_User = new JTextField();
		Token_User.setColumns(10);
		Token_User.setBounds(608, 0, 171, 25);
		contentPane.add(Token_User);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 78, 767, 380);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add User", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(12, 65, 108, 29);
		panel_1.add(lblName);
		
		Name_Add = new JTextField();
		Name_Add.setColumns(10);
		Name_Add.setBounds(138, 65, 218, 29);
		panel_1.add(Name_Add);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSurname.setBounds(12, 106, 108, 29);
		panel_1.add(lblSurname);
		
		Surname_Add = new JTextField();
		Surname_Add.setColumns(10);
		Surname_Add.setBounds(138, 106, 218, 29);
		panel_1.add(Surname_Add);
		
		JLabel lblAddUser = new JLabel("Add User");
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAddUser.setBounds(287, 12, 131, 39);
		panel_1.add(lblAddUser);
		
		UserPriv__Add = new JTextField();
		UserPriv__Add.setColumns(10);
		UserPriv__Add.setBounds(505, 65, 218, 29);
		panel_1.add(UserPriv__Add);
		
		JLabel lblUserPrivilege = new JLabel("User Privilege");
		lblUserPrivilege.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPrivilege.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblUserPrivilege.setBounds(374, 65, 119, 29);
		panel_1.add(lblUserPrivilege);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblUserId.setBounds(374, 106, 108, 29);
		panel_1.add(lblUserId);
		
		UserID_Add = new JTextField();
		UserID_Add.setColumns(10);
		UserID_Add.setBounds(505, 106, 218, 29);
		panel_1.add(UserID_Add);
		
		Password_Add = new JTextField();
		Password_Add.setColumns(10);
		Password_Add.setBounds(505, 151, 218, 29);
		panel_1.add(Password_Add);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblPassword.setBounds(379, 151, 108, 29);
		panel_1.add(lblPassword);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String UserID, Password,Privilege, Name, Surname;	
				
				
				UserID = UserID_Add.getText();
				Password = Password_Add.getText();
				Privilege = UserPriv__Add.getText();
				Name = Name_Add.getText();
				Surname = Surname_Add.getText();
				
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					
					String sql = "insert into Users (UserID, Password, Privilege, Name, Surname) values (?,?,?,?,?)";  
					PreparedStatement pst = con.prepareStatement(sql);
					
					pst.setString(1, UserID);
					pst.setString(2, Password);
					pst.setString(3, Privilege);
					pst.setString(4, Name);
					pst.setString(5, Surname);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "User Added!");
					
					UserID_Add.setText("");
					Password_Add.setText("");
					UserPriv__Add.setText("");
					Name_Add.setText("");
					Surname_Add.setText("");
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
								
				
				
			}
		});
		btnAdd.setBounds(633, 12, 117, 25);
		panel_1.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Update User", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblUpdateUser = new JLabel("Update User");
		lblUpdateUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateUser.setFont(new Font("Dialog", Font.BOLD, 21));
		lblUpdateUser.setBounds(222, 14, 236, 39);
		panel_2.add(lblUpdateUser);
		
		JButton btnUpdate_1 = new JButton("UPDATE");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String UserID, Password,Privilege, Name, Surname;	
				
				
				UserID = UserID_Update.getText();
				Password = Password_Update.getText();
				Privilege = UserPriv_Update.getText();
				Name = Name_Update.getText();
				Surname = Surname_Update.getText();
				
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					 
					String sql = "UPDATE Users SET Password = ?, Privilege = ?, Name = ?, Surname = ? WHERE UserID = ? ";  
					PreparedStatement pst = con.prepareStatement(sql);
					
					
					pst.setString(1, Password);
					pst.setString(2, Privilege);
					pst.setString(3, Name);
					pst.setString(4, Surname);
					pst.setString(5 , UserID);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "User Updated");
					
					UserID_Update.setText("");
					Password_Update.setText("");
					UserPriv_Update.setText("");
					Name_Update.setText("");
					Surname_Update.setText("");
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
				
			}
		});
		btnUpdate_1.setBounds(278, 229, 117, 25);
		panel_2.add(btnUpdate_1);
		
		UserPriv_Update = new JTextField();
		UserPriv_Update.setColumns(10);
		UserPriv_Update.setBounds(495, 65, 218, 29);
		panel_2.add(UserPriv_Update);
		
		Name_Update = new JTextField();
		Name_Update.setColumns(10);
		Name_Update.setBounds(128, 65, 218, 29);
		panel_2.add(Name_Update);
		
		JLabel lblUserPrivilege_2 = new JLabel("User Privilege");
		lblUserPrivilege_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPrivilege_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblUserPrivilege_2.setBounds(364, 65, 119, 29);
		panel_2.add(lblUserPrivilege_2);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblName_1.setBounds(2, 65, 108, 29);
		panel_2.add(lblName_1);
		
		JLabel lblSurname_1 = new JLabel("Surname");
		lblSurname_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSurname_1.setBounds(2, 106, 108, 29);
		panel_2.add(lblSurname_1);
		
		Surname_Update = new JTextField();
		Surname_Update.setColumns(10);
		Surname_Update.setBounds(128, 106, 218, 29);
		panel_2.add(Surname_Update);
		
		JLabel lblUserId_1 = new JLabel("User ID");
		lblUserId_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblUserId_1.setBounds(364, 106, 108, 29);
		panel_2.add(lblUserId_1);
		
		UserID_Update = new JTextField();
		UserID_Update.setColumns(10);
		UserID_Update.setBounds(495, 106, 218, 29);
		panel_2.add(UserID_Update);
		
		Password_Update = new JTextField();
		Password_Update.setColumns(10);
		Password_Update.setBounds(495, 151, 218, 29);
		panel_2.add(Password_Update);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblPassword_1.setBounds(369, 151, 108, 29);
		panel_2.add(lblPassword_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Remove User", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String UserID;	
				
				
				UserID = UserID_Remove.getText();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					 
					String sql = "delete from Users where UserID = ? ";  
					PreparedStatement pst = con.prepareStatement(sql);

					pst.setString(1 , UserID);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "User Removed");
					
					UserID_Remove.setText("");
					
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};

			
			}
		});
		btnRemove.setBounds(311, 237, 117, 25);
		panel_3.add(btnRemove);
		
		UserID_Remove = new JTextField();
		UserID_Remove.setColumns(10);
		UserID_Remove.setBounds(268, 98, 218, 29);
		panel_3.add(UserID_Remove);
		
		JLabel lblRemoveUser = new JLabel("Remove User");
		lblRemoveUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveUser.setFont(new Font("Dialog", Font.BOLD, 21));
		lblRemoveUser.setBounds(244, 12, 240, 39);
		panel_3.add(lblRemoveUser);
		
		JLabel lblUserId_2 = new JLabel("User ID");
		lblUserId_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserId_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblUserId_2.setBounds(71, 98, 157, 29);
		panel_3.add(lblUserId_2);
		
		JButton btnRefresh = new JButton("View Users");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
			    	Class.forName("com.mysql.jdbc.Driver");
			    	String url = "Jdbc:mysql://localhost:3306/W_POS_DB";
			      String user = "root";
			      String password = "";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			    
			      String query = "SELECT * FROM Users";
			    
			      Statement stm = con.createStatement();
			      ResultSet res = stm.executeQuery(query);
			    
			      String columns[] = { "User ID", "Privilege", "Name", "Surname"};
			      String data[][] = new String[12][4];
			    
			      int i = 0;
			      while (res.next()) {
			        String userid = res.getString("UserID");
			        String privilege = res.getString("Privilege");
			        String name = res.getString("Name");
			        String surname = res.getString("Surname");
			       
			
			        data[i][0] = userid;
			        data[i][1] = privilege;
			        data[i][2] = name;
			        data[i][3] = surname;
			        
			        i++;
			      }
			    
			      DefaultTableModel model = new DefaultTableModel(data, columns);
			      JTable table = new JTable(model);
			      table.setShowGrid(true);
			      table.setShowVerticalLines(true);
			      JScrollPane pane = new JScrollPane(table);
			      JFrame f = new JFrame("User List");
			      JPanel panel = new JPanel();
			      panel.add(pane);
			      f.getContentPane().add(panel);
			      f.setSize(500, 250);
			      //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      f.setVisible(true);
			    
			    } catch(SQLException e) {
			      e.printStackTrace();
			    } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRefresh.setBounds(651, 37, 117, 25);
		contentPane.add(btnRefresh);
	}
}
