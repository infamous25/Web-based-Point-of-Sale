package WPOS;

import java.awt.EventQueue;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
//import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.*;

//import org.jcp.xml.dsig.internal.dom.DOMUtils;

//import com.sun.org.apache.xerces.internal.util.DOMUtil;

import java.util.Properties;


public class  tables extends JFrame {
	public tables() {
	}
  public static void main(String[] args) 
  {
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
      JFrame f = new JFrame("Populate JTable from Database");
      JPanel panel = new JPanel();
      panel.add(pane);
      f.getContentPane().add(panel);
      f.setSize(500, 250);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
    
    } catch(SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
