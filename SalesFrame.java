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

public class SalesFrame extends JFrame {

	private JPanel salesframe;
	private JTextField ItemCode;
	private JTextField Quantity;
	private JTable table;
	private JTextField Total;
	private JTextField Amount;
	private JTextField Change;
	private float Floattotal = 0;
	private float FTotal ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesFrame frame = new SalesFrame();
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
	public SalesFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 504);
		salesframe = new JPanel();
		salesframe.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(salesframe);
		salesframe.setLayout(null);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_Dashboard window = new Main_Dashboard();
				window.getFrame().setVisible(true);
				
			}
		});
		btnDashboard.setBounds(12, 0, 117, 25);
		salesframe.add(btnDashboard);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSales.setFont(new Font("Dialog", Font.BOLD, 21));
		lblSales.setBounds(323, 0, 131, 39);
		salesframe.add(lblSales);
		
		ItemCode = new JTextField();
		ItemCode.setFont(new Font("Dialog", Font.PLAIN, 25));
		ItemCode.setBounds(12, 95, 242, 45);
		salesframe.add(ItemCode);
		ItemCode.setColumns(10);
		
		JLabel lblProductCode = new JLabel("Item code");
		lblProductCode.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProductCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode.setBounds(12, 68, 242, 15);
		salesframe.add(lblProductCode);
		
		Quantity = new JTextField();
		Quantity.setFont(new Font("Dialog", Font.PLAIN, 25));
		Quantity.setBounds(288, 95, 90, 45);
		salesframe.add(Quantity);
		Quantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Dialog", Font.BOLD, 15));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(288, 68, 90, 15);
		salesframe.add(lblQuantity);
		
		JButton btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			    
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					
					String itemcode = ItemCode.getText();
					int quantity = Integer.parseInt(Quantity.getText());
					float subtotal = 0;
					
					String sql = "select ProductCode, ProductName, Quantity, SellingPrice, CostPrice from Beer where ProductCode = ?";  
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1 , itemcode);
					 
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						String price = rs.getString(4);
						String dbquantity = rs.getString(3);
						
						float Fprice = Float.parseFloat(price);
						int intDBquantity = Integer.parseInt(dbquantity);
						subtotal = Fprice * quantity; 
						
						FTotal = FTotal + subtotal;
						Floattotal = FTotal;
						String strTotal = Float.toString(Floattotal);
						Total.setText(strTotal);
						
						//System.out.println(subtotal);
					}
					
					
					
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
				
			}
		});
		btnAddToCart.setBounds(391, 95, 143, 45);
		salesframe.add(btnAddToCart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 204, 519, 257);
		salesframe.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Total = new JTextField();
		Total.setHorizontalAlignment(SwingConstants.TRAILING);
		Total.setFont(new Font("Dialog", Font.BOLD, 26));
		Total.setBounds(546, 95, 227, 111);
		salesframe.add(Total);
		Total.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(605, 59, 104, 32);
		salesframe.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(715, 0, 70, 15);
		salesframe.add(label);
		
		JButton btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(656, 0, 117, 25);
		salesframe.add(btnDeleteItem);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Dialog", Font.BOLD, 15));
		lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmount.setBounds(556, 218, 217, 25);
		salesframe.add(lblAmount);
		
		Amount = new JTextField();
		Amount.setFont(new Font("Dialog", Font.BOLD, 25));
		Amount.setHorizontalAlignment(SwingConstants.TRAILING);
		Amount.setBounds(546, 244, 227, 45);
		salesframe.add(Amount);
		Amount.setColumns(10);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setFont(new Font("Dialog", Font.BOLD, 15));
		lblChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblChange.setBounds(546, 296, 227, 37);
		salesframe.add(lblChange);
		
		Change = new JTextField();
		Change.setFont(new Font("Dialog", Font.BOLD, 25));
		Change.setHorizontalAlignment(SwingConstants.TRAILING);
		Change.setBounds(543, 345, 230, 54);
		salesframe.add(Change);
		Change.setColumns(10);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float Fchange;
				float Famount = Float.parseFloat(Amount.getText());
				
				Fchange = Famount -  FTotal;
				
				String strchange = Float.toString(Fchange);
				Change.setText(strchange);
				
				
				
			
			}
		});
		btnCheckOut.setBounds(556, 422, 192, 25);
		salesframe.add(btnCheckOut);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ItemCode.setText("");
				Change.setText("");
				Total.setText("");
				Quantity.setText("");
				Amount.setText("");
				FTotal = 0;
				
				
				
			}
		});
		btnRefresh.setBounds(12, 31, 117, 25);
		salesframe.add(btnRefresh);
	}
}
