package WPOS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;

public class EditInventoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Token;
	private JTextField ProductCode_Remove;
	private JTextField ProductCode_Add;
	private JTextField Quantity__Add;
	private JTextField ProductName_New;
	private JTextField ProductCode_New;
	private JTextField Quantity_New;
	private JTextField CostPrice_New;
	private JTextField SellingPrice_New;
	private JTextField ProductCode_Edit;
	private JTextField ProductName_Edit;
	private JTextField Quantity_Edit;
	private JTextField CostPrice_Edit;
	private JTextField SellingPrice_Edit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditInventoryFrame frame = new EditInventoryFrame();
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
	public EditInventoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory Management");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(229, -1, 295, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnDashboard = new JButton("Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main_Dashboard window = new Main_Dashboard();
				window.getFrame().setVisible(true);
				
			}
		});
		btnDashboard.setBounds(12, 0, 117, 25);
		contentPane.add(btnDashboard);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 65, 763, 400);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add New Inventory", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblAddNewInventory = new JLabel("Add New Inventory");
		lblAddNewInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddNewInventory.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAddNewInventory.setBounds(251, 12, 240, 39);
		panel_2.add(lblAddNewInventory);
		
		JLabel lblProductName = new JLabel("Product  Name");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductName.setBounds(59, 52, 157, 29);
		panel_2.add(lblProductName);
		
		JLabel lblProductCode_2 = new JLabel("Product  Code");
		lblProductCode_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductCode_2.setBounds(59, 112, 157, 29);
		panel_2.add(lblProductCode_2);
		
		JLabel lblSellingPrice = new JLabel("Selling Price");
		lblSellingPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellingPrice.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSellingPrice.setBounds(59, 277, 157, 29);
		panel_2.add(lblSellingPrice);
		
		JLabel lblCostPrice = new JLabel("Cost Price");
		lblCostPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostPrice.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblCostPrice.setBounds(59, 227, 157, 29);
		panel_2.add(lblCostPrice);
		
		JLabel lblQuantity_2 = new JLabel("Quantity");
		lblQuantity_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblQuantity_2.setBounds(59, 174, 157, 29);
		panel_2.add(lblQuantity_2);
		
		ProductName_New = new JTextField();
		ProductName_New.setColumns(10);
		ProductName_New.setBounds(261, 52, 218, 29);
		panel_2.add(ProductName_New);
		
		ProductCode_New = new JTextField();
		ProductCode_New.setColumns(10);
		ProductCode_New.setBounds(261, 112, 218, 29);
		panel_2.add(ProductCode_New);
		
		Quantity_New = new JTextField();
		Quantity_New.setColumns(10);
		Quantity_New.setBounds(261, 174, 218, 29);
		panel_2.add(Quantity_New);
		
		CostPrice_New = new JTextField();
		CostPrice_New.setColumns(10);
		CostPrice_New.setBounds(261, 227, 218, 29);
		panel_2.add(CostPrice_New);
		
		SellingPrice_New = new JTextField();
		SellingPrice_New.setColumns(10);
		SellingPrice_New.setBounds(261, 277, 218, 29);
		panel_2.add(SellingPrice_New);
		
		JButton btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String product_name, product_code,quantity, selling_price, cost_price;	
				
				
				product_name = ProductName_New.getText();
				product_code = ProductCode_New.getText();
				quantity = Quantity_New.getText();
				selling_price = SellingPrice_New.getText();
				cost_price = CostPrice_New.getText();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					
					String sql = "insert into Beer (ProductCode, ProductName, Quantity, SellingPrice, CostPrice) values (?,?,?,?,?)";  
					PreparedStatement pst = con.prepareStatement(sql);
					
					pst.setString(1, product_code);
					pst.setString(2, product_name);
					pst.setString(3, quantity);
					pst.setString(4, selling_price);
					pst.setString(5, cost_price);
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "New Inventory Added!");
					
					ProductName_New.setText("");
					ProductCode_New.setText("");
					Quantity_New.setText("");
					CostPrice_New.setText("");
					SellingPrice_New.setText("");
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
				
			}
		});
		btnAdd_1.setBounds(319, 336, 117, 25);
		panel_2.add(btnAdd_1);
		
		JPanel Quantity_Add = new JPanel();
		tabbedPane.addTab("Add Inventory", null, Quantity_Add, null);
		Quantity_Add.setLayout(null);
		
		JLabel lblAddInventory = new JLabel("Add Inventory");
		lblAddInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddInventory.setFont(new Font("Dialog", Font.BOLD, 21));
		lblAddInventory.setBounds(245, 12, 240, 39);
		Quantity_Add.add(lblAddInventory);
		
		JLabel lblProductCode_1 = new JLabel("Product Code");
		lblProductCode_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductCode_1.setBounds(79, 93, 157, 29);
		Quantity_Add.add(lblProductCode_1);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblQuantity_1.setBounds(79, 179, 157, 29);
		Quantity_Add.add(lblQuantity_1);
		
		ProductCode_Add = new JTextField();
		ProductCode_Add.setColumns(10);
		ProductCode_Add.setBounds(267, 98, 218, 29);
		Quantity_Add.add(ProductCode_Add);
		
		Quantity__Add = new JTextField();
		Quantity__Add.setColumns(10);
		Quantity__Add.setBounds(267, 184, 218, 29);
		Quantity_Add.add(Quantity__Add);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					
					String productcode = ProductCode_Add.getText();
					int quantity = Integer.parseInt(Quantity__Add.getText());
					//int newquantity;
					String quantitycheck = Quantity__Add.getText();
					
					String sql = "select ProductCode, ProductName, Quantity, SellingPrice, CostPrice from Beer where ProductCode = ?";  
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1 , productcode);
					 
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()==true) {
						
						String dbproductcode = rs.getString(1);
						System.out.println(dbproductcode);
						String dbproductname = rs.getString(2);
						System.out.println(dbproductname);
						String dbquantity = rs.getString(3);
						
						int intdbquantity = Integer.parseInt(dbquantity);
						String newdbquantity = Integer.toString(intdbquantity + quantity);
						System.out.println(newdbquantity);
						String dbsellingprice = rs.getString(4);
						System.out.println(dbsellingprice);
						String dbcostprice = rs.getString(5);
						System.out.println(dbcostprice);
						
						try {
							
							System.out.println("first try run fine");
							Class.forName("com.mysql.jdbc.Driver");
							Connection con1 = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
							System.out.println("connection successful");
							String sql1 = "UPDATE Beer SET ProductName = ?, Quantity = ?, SellingPrice = ?, CostPrice = ? WHERE ProductCode = ? ";  
							PreparedStatement pst1 = con1.prepareStatement(sql);
							System.out.println("pst creation was successfull");
							
							pst1.setString(1, dbproductname);
							System.out.println(dbproductname);
							pst1.setString(2, quantitycheck);
							System.out.println(quantitycheck);
							pst1.setString(3, dbsellingprice);
							System.out.println(dbsellingprice);
							pst1.setString(4, dbcostprice);
							System.out.println(dbcostprice);
							pst1.setString(5 , dbproductcode);
							System.out.println(dbproductcode);
							
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Inventory Updated");
							
							
						} catch(Exception e) {
							JOptionPane.showMessageDialog(null, "Something went wrong!!");
						};
						
						
							
						
							
							
								
								
								
						
						
						
						
						
						//JOptionPane.showMessageDialog(null, "something went wrong!");
					}
					
					
					
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
			
			
			
			}
		});
		btnAdd.setBounds(320, 273, 117, 25);
		Quantity_Add.add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Edit Inventory", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblProductCode_2_1 = new JLabel("Product  Code");
		lblProductCode_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode_2_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductCode_2_1.setBounds(137, 71, 157, 29);
		panel_1.add(lblProductCode_2_1);
		
		ProductCode_Edit = new JTextField();
		ProductCode_Edit.setColumns(10);
		ProductCode_Edit.setBounds(339, 71, 218, 29);
		panel_1.add(ProductCode_Edit);
		
		JLabel lblEditInventory_1 = new JLabel("Edit Inventory");
		lblEditInventory_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditInventory_1.setFont(new Font("Dialog", Font.BOLD, 21));
		lblEditInventory_1.setBounds(267, 12, 240, 39);
		panel_1.add(lblEditInventory_1);
		
		JLabel lblProductName_1 = new JLabel("Product  Name");
		lblProductName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductName_1.setBounds(137, 130, 157, 29);
		panel_1.add(lblProductName_1);
		
		ProductName_Edit = new JTextField();
		ProductName_Edit.setColumns(10);
		ProductName_Edit.setBounds(339, 130, 218, 29);
		panel_1.add(ProductName_Edit);
		
		JLabel lblQuantity_2_1 = new JLabel("Quantity");
		lblQuantity_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity_2_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblQuantity_2_1.setBounds(137, 174, 157, 29);
		panel_1.add(lblQuantity_2_1);
		
		Quantity_Edit = new JTextField();
		Quantity_Edit.setColumns(10);
		Quantity_Edit.setBounds(339, 174, 218, 29);
		panel_1.add(Quantity_Edit);
		
		CostPrice_Edit = new JTextField();
		CostPrice_Edit.setColumns(10);
		CostPrice_Edit.setBounds(339, 227, 218, 29);
		panel_1.add(CostPrice_Edit);
		
		JLabel lblCostPrice_1 = new JLabel("Cost Price");
		lblCostPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCostPrice_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblCostPrice_1.setBounds(137, 227, 157, 29);
		panel_1.add(lblCostPrice_1);
		
		JLabel lblSellingPrice_1 = new JLabel("Selling Price");
		lblSellingPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSellingPrice_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblSellingPrice_1.setBounds(137, 277, 157, 29);
		panel_1.add(lblSellingPrice_1);
		
		SellingPrice_Edit = new JTextField();
		SellingPrice_Edit.setColumns(10);
		SellingPrice_Edit.setBounds(339, 277, 218, 29);
		panel_1.add(SellingPrice_Edit);
		
		JButton btnAdd_1_1 = new JButton("Edit");
		btnAdd_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String productcode, productname, quantity, costprice;	
				
				
				productcode = ProductCode_Edit.getText();
				productname = ProductName_Edit.getText();
				quantity = Quantity_Edit.getText();
				String selling = SellingPrice_Edit.getText();
				costprice = CostPrice_Edit.getText();
				
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					 
					String sql = "UPDATE Beer SET ProductName = ?, Quantity = ?, SellingPrice = ?, CostPrice = ? WHERE ProductCode = ? ";  
					PreparedStatement pst = con.prepareStatement(sql);
					
					
					pst.setString(1, productname);
					pst.setString(2, quantity);
					pst.setString(3, selling);
					pst.setString(4, costprice);
					pst.setString(5 , productcode);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inventory Updated");
					
					ProductCode_Edit.setText("");
					ProductName_Edit.setText("");
					Quantity_Edit.setText("");
					SellingPrice_Edit.setText("");
					CostPrice_Edit.setText("");
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};

				
			}
		});
		btnAdd_1_1.setBounds(397, 336, 117, 25);
		panel_1.add(btnAdd_1_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Remove Inventory", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblremoveInventory = new JLabel("Remove Inventory");
		lblremoveInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblremoveInventory.setFont(new Font("Dialog", Font.BOLD, 21));
		lblremoveInventory.setBounds(252, 12, 240, 39);
		panel_3.add(lblremoveInventory);
		
		JLabel lblProductCode = new JLabel("Product Code");
		lblProductCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCode.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		lblProductCode.setBounds(74, 76, 157, 29);
		panel_3.add(lblProductCode);
		
		ProductCode_Remove = new JTextField();
		ProductCode_Remove.setColumns(10);
		ProductCode_Remove.setBounds(252, 81, 218, 29);
		panel_3.add(ProductCode_Remove);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
											
				String productcode;	
				
				
				productcode = ProductCode_Remove.getText();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("Jdbc:mysql://localhost:3306/W_POS_DB","root","");
					 
					String sql = "delete from Beer where ProductCode = ? ";  
					PreparedStatement pst = con.prepareStatement(sql);

					pst.setString(1 , productcode);
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Product Removed");
					
					ProductCode_Remove.setText("");
					
					

				} catch(Exception e) {
					JOptionPane.showMessageDialog(null, "something went wrong!");
				};
				
				 
			
			
			}
		});
		btnRemove.setBounds(300, 237, 117, 25);
		panel_3.add(btnRemove);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(563, 0, 83, 25);
		contentPane.add(btnSearch);
		
		Token = new JTextField();
		Token.setBounds(658, 2, 117, 22);
		contentPane.add(Token);
		Token.setColumns(10);
		
		JButton btnViewInventory = new JButton("View Inventory");
		btnViewInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try 
				  {
				    	Class.forName("com.mysql.jdbc.Driver");
				    	String url = "Jdbc:mysql://localhost:3306/W_POS_DB";
				      String user = "root";
				      String password = "";
				    
				      Connection con = DriverManager.getConnection(url, user, password);
				    
				      String query = "SELECT * FROM Beer";
				    
				      Statement stm = con.createStatement();
				      ResultSet res = stm.executeQuery(query);
				    
				      String columns[] = { "Product code", "Product name", "Quantity", "Selling price", "Cost price" };
				      String data[][] = new String[8][5];
				    
				      int i = 0;
				      while (res.next()) {
				        String productcode = res.getString("ProductCode");
				        String productname = res.getString("ProductName");
				        String quantity = res.getString("Quantity");
				        String sellingprice = res.getString("SellingPrice");
				        String costprice = res.getString("CostPrice");

				        data[i][0] = productcode;
				        data[i][1] = productname;
				        data[i][2] = quantity;
				        data[i][3] = sellingprice;
				        data[i][4] = costprice;
				        i++;
				      }
				    
				      DefaultTableModel model = new DefaultTableModel(data, columns);
				      JTable table = new JTable(model);
				      table.setShowGrid(true);
				      table.setShowVerticalLines(true);
				      JScrollPane pane = new JScrollPane(table);
				      JFrame f = new JFrame("Availbale Inventory");
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
		btnViewInventory.setBounds(636, 48, 139, 25);
		contentPane.add(btnViewInventory);
	}
}