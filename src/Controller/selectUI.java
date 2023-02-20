package Controller;

import java.awt.EventQueue;
import java.awt.Image;
import Model.member;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Font;
import javax.swing.JButton;

public class selectUI extends JFrame {

	private JPanel contentPane;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectUI frame = new selectUI();
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
	public selectUI() {}
	public selectUI(member m) {
		setTitle("拼圖-選擇頁面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 564, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon icon1=new ImageIcon();
		ImageIcon icon2=new ImageIcon();
		ImageIcon icon3=new ImageIcon();
		ImageIcon icon4=new ImageIcon();
		
		icon1=new ImageIcon(getClass().getResource("puzzle0/puzzle0.jpg"));
		icon2=new ImageIcon(getClass().getResource("puzzle1/puzzle0.jpg"));
		icon3=new ImageIcon(getClass().getResource("puzzle2/puzzle0.jpg"));
		icon4=new ImageIcon(getClass().getResource("puzzle3/puzzle0.jpg"));
		
		JLabel lblNewLabel = new JLabel("點圖片選擇拼圖");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 10, 167, 38);
		panel.add(lblNewLabel);
		
		JLabel puzzle1 = new JLabel();
		puzzle1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				puzzleUI l=new puzzleUI(m, 0);
				l.show();
				dispose();
			}
		});
		puzzle1.setBounds(23, 58, 176, 158);
		Image image1=icon1.getImage().getScaledInstance(puzzle1.getWidth(), puzzle1.getHeight(),1);
		puzzle1.setIcon(new ImageIcon(image1));
		panel.add(puzzle1);
		
		JLabel puzzle2 = new JLabel();
		puzzle2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				puzzleUI l=new puzzleUI(m, 1);
				l.show();
				dispose();
			}
		});
		puzzle2.setBounds(206, 58, 176, 158);
		Image image2=icon2.getImage().getScaledInstance(puzzle2.getWidth(), puzzle2.getHeight(),1);
		puzzle2.setIcon(new ImageIcon(image2));
		panel.add(puzzle2);
		
		JLabel puzzle3 = new JLabel();
		puzzle3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				puzzleUI l=new puzzleUI(m, 2);
				l.show();
				dispose();
			}
		});
		puzzle3.setBounds(23, 223, 176, 158);
		Image image3=icon3.getImage().getScaledInstance(puzzle2.getWidth(), puzzle2.getHeight(),1);
		puzzle3.setIcon(new ImageIcon(image3));
		panel.add(puzzle3);
		
		JLabel puzzle4 = new JLabel();
		puzzle4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				puzzleUI l=new puzzleUI(m, 3);
				l.show();
				dispose();
			}
		});
		puzzle4.setBounds(206, 223, 176, 158);
		Image image4=icon4.getImage().getScaledInstance(puzzle2.getWidth(), puzzle2.getHeight(),1);
		puzzle4.setIcon(new ImageIcon(image4));
		panel.add(puzzle4);
		
		JButton leadboard = new JButton("前往排行榜");
		leadboard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leaderboardUI l=new leaderboardUI(m);
				l.show();
				dispose();
			}
		});
		leadboard.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		leadboard.setBounds(242, 13, 143, 33);
		panel.add(leadboard);
		
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
		back.setBounds(411, 13, 143, 33);
		panel.add(back);
		
	}

}
