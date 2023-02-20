package Controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.member;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class loginSuccess extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginSuccess frame = new loginSuccess();
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
	//member m
	public loginSuccess() {}
	public loginSuccess(member m) {
		setTitle("拼圖-登入成功");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(150, 82, 130, 34);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("回登入頁");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.getUsername().setText(m.getUsername());
				l.show();
				dispose();
			}
		});
		back.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		back.setBounds(10, 157, 130, 34);
		contentPane.add(back);
		
		JButton go = new JButton("進入遊戲");
		go.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectUI l=new selectUI(m);
				l.show();
				dispose();
			}
		});
		go.setBounds(290, 157, 130, 34);
		go.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		contentPane.add(go);
		
		JButton admin = new JButton("會員管理");
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				adminUI l=new adminUI(m);
				l.show();
				dispose();
			}
		});
		admin.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		admin.setBounds(150, 157, 130, 34);
		contentPane.add(admin);
	}
}
