package WPOS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Messages extends JFrame {

	private JPanel contentPane;
	private JTextField UserID_Message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messages frame = new Messages();
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
	public Messages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 513);
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
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(667, 0, 117, 25);
		contentPane.add(btnRefresh);
		
		JTextPane newMessages = new JTextPane();
		newMessages.setBounds(12, 49, 549, 252);
		contentPane.add(newMessages);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 21));
		lblMessage.setBounds(286, 12, 240, 39);
		contentPane.add(lblMessage);
		
		UserID_Message = new JTextField();
		UserID_Message.setColumns(10);
		UserID_Message.setBounds(573, 350, 211, 69);
		contentPane.add(UserID_Message);
		
		JLabel lblNewLabel_1 = new JLabel("Input user");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setBounds(573, 318, 211, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(573, 437, 211, 25);
		contentPane.add(btnSend);
		
		JEditorPane Message = new JEditorPane();
		Message.setBounds(12, 350, 549, 112);
		contentPane.add(Message);
		
		JLabel lblNewLabel = new JLabel("Compose new message");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(48, 313, 459, 25);
		contentPane.add(lblNewLabel);
	}
}