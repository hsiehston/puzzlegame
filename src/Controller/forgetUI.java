package Controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

public class forgetUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgetUI frame = new forgetUI();
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
	public forgetUI() {
		setTitle("拼圖-忘記密碼");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 414, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		output.setBounds(56, 172, 250, 59);
		panel.add(output);
		
		JLabel lblNewLabel = new JLabel("輸入帳號，以找回密碼");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(56, 25, 246, 33);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(56, 72, 68, 30);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		username.setBounds(115, 71, 114, 34);
		panel.add(username);
		username.setColumns(10);
		
		JButton find = new JButton("找回密碼");
		find.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				boolean b=new implMember().queryUser(Username);
				if(b) {
					output.setText("找回密碼成功，"+"\n你的密碼是"+ 
				new implMember().queryMember2(Username).getPassword());
				}
				else {
					output.setText("查無此帳號，請重新輸入，"+"\n或返回登入頁註冊");
					username.setText("");
				}
			}
		});
		find.setBounds(56, 123, 120, 30);
		panel.add(find);
		
		JButton back = new JButton("回登入頁");
		back.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.getUsername().setText(username.getText());
				l.show();
				dispose();
			}
		});
		back.setBounds(186, 123, 120, 30);
		panel.add(back);
	}
}
