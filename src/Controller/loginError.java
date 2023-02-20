package Controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class loginError extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginError frame = new loginError();
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
	public loginError() {
		setTitle("拼圖-登入失敗");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("請重新登入，或註冊新帳號");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 90, 254, 40);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("回登入頁");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUI l=new loginUI();
				l.show();
				dispose();
			}
		});
		back.setBounds(27, 163, 120, 31);
		contentPane.add(back);
		
		JButton add = new JButton("註冊");
		add.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addMemberUI a=new addMemberUI();
				a.show();
				dispose();
			}
		});
		add.setBounds(157, 163, 120, 31);
		contentPane.add(add);
		
		JButton find = new JButton("忘記密碼");
		find.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		find.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				forgetUI l=new forgetUI();
				l.show();
				dispose();
			}
		});
		find.setBounds(287, 163, 120, 31);
		contentPane.add(find);
		
		JLabel lblNewLabel_1 = new JLabel("登入失敗");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(82, 38, 254, 40);
		contentPane.add(lblNewLabel_1);
	}

}
