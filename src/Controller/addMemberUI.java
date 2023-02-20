package Controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class addMemberUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMemberUI frame = new addMemberUI();
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
	public addMemberUI() {
		setTitle("拼圖-註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		show.setBounds(104, 186, 233, 65);
		contentPane.add(show);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 63, 70, 31);
		contentPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		username.setBounds(184, 63, 136, 31);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("註冊");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(159, 10, 98, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(104, 104, 70, 31);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(184, 104, 136, 31);
		contentPane.add(password);
		
		JButton add = new JButton("註冊");
		add.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				
				boolean a=Username.matches("[a-zA-Z]{3,6}");
				if(a) {
					boolean b=new implMember().queryUser(Username);
					if(b) {
						show.setText("已註冊的帳號");
					}
					else {
						member m=new member(Username,Password);
						new implMember().add(m);
						show.setText("註冊成功");
					}
				}
				else {
					show.setText("帳號限定3~6個英文字母");
				}
			}
		});
		add.setBounds(104, 145, 98, 31);
		contentPane.add(add);
		
		JButton back = new JButton("返回登入");
		back.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.getUsername().setText(username.getText());;
				l.show();
				dispose();
			}
		});
		back.setBounds(217, 145, 120, 31);
		contentPane.add(back);
	}
}
