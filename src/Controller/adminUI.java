package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class adminUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminUI frame = new adminUI();
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
	public adminUI() {}
	public adminUI(member m) {
		setTitle("拼圖-會員管理");
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
		
		id = new JTextField();
		id.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		id.setColumns(10);
		id.setBounds(58, 49, 65, 31);
		panel.add(id);
		
		JButton delete = new JButton("刪除");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new implMember().delete(Integer.parseInt(id.getText()));
			}
		});
		delete.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		delete.setBounds(221, 10, 75, 31);
		panel.add(delete);
		
		password = new JTextField();
		password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(200, 88, 96, 31);
		panel.add(password);
		
		username = new JTextField();
		username.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		username.setBounds(200, 49, 96, 31);
		panel.add(username);
		username.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 394, 104);
		panel.add(scrollPane);
		
		JTextArea show = new JTextArea();
		scrollPane.setViewportView(show);
		show.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));

		
		JButton queryALL = new JButton("查詢全部");
		queryALL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show.setText(new implMember().queryAll1());
			}
		});
		queryALL.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		queryALL.setBounds(10, 10, 118, 31);
		panel.add(queryALL);
		
		JButton update = new JButton("修改");
		update.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				int ID=Integer.parseInt(id.getText());
				member m=new implMember().queryId(ID);
				m.setUsername(Username);
				m.setPassword(Password);
				new implMember().update(m);;
				
				show.setText(new implMember().queryAll1());
			}
		});
		update.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		update.setBounds(138, 10, 75, 31);
		panel.add(update);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(122, 49, 57, 31);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(122, 88, 57, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblId.setBounds(10, 49, 38, 31);
		panel.add(lblId);
		
		JButton exit = new JButton("上一頁");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginSuccess l=new loginSuccess(m);
				l.show();
				dispose();
			}
		});
		exit.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		exit.setBounds(306, 10, 99, 31);
		panel.add(exit);
		

	}
}
