package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Dao.implRecord;
import Model.gamerecord;
import Model.member;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

public class puzzleUI extends JFrame implements MouseListener, MouseMotionListener {

	private JPanel contentPane;
	private JLabel img[]=new JLabel[9];
	private JLabel target[]=new JLabel[9];
	private Point pressPoint;
	List<Integer> list = Arrays.asList(0,1,2,3,4);
	long startTime = System.nanoTime();
	private JButton submitBtn = new JButton("完成");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					puzzleUI frame = new puzzleUI();
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
	//member m,Integer a
	public puzzleUI() {}
	public puzzleUI(member m,Integer a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		setTitle("拼圖");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel left = new JPanel();
		left.setBounds(28, 49, 519, 491);
		contentPane.add(left);
		left.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		getContentPane().add(left,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBounds(557, 49, 592, 491);
		contentPane.add(panel);
		panel.setOpaque(false);
		//setGlassPane(panel);
		//getGlassPane().setVisible(true);
		
		ImageIcon icon1=new ImageIcon();
		icon1=new ImageIcon(getClass().getResource("puzzle"+a+"/puzzle0.jpg"));
		JLabel pic = new JLabel();
		pic.setIcon(icon1);
		pic.setVisible(false);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(pic);
		
		JButton show_1 = new JButton("顯示原圖");
		show_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(pic.isVisible()==false) {
					pic.setVisible(true);
				}
				else {
					pic.setVisible(false);
				}
			}
		});
		show_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		show_1.setBounds(1011, 10, 130, 33);
		contentPane.add(show_1);
		
		JButton back = new JButton("回選擇頁");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectUI l=new selectUI(m);
				l.show();
				dispose();
			}
		});
		back.setFont(new Font("新細明體", Font.PLAIN, 20));
		back.setBounds(871, 10, 130, 33);
		contentPane.add(back);

		JPanel right = new JPanel();
		right.setBounds(348, 10, 826, 541);
		right.setOpaque(false);
		right.setLayout(null);
		setGlassPane(right);
		getGlassPane().setVisible(true);
		
		ImageIcon icon[] =new ImageIcon[9];	
		for (int i=0;i<=8;i++) {
			icon[i]=new ImageIcon(getClass().getResource("puzzle"+a+"/"+(i+1)+".jpg"));
		}
		
		for (int i=0;i<9;i++) {
			img[i]=new JLabel(icon[i]);
			img[i].setSize(130,130);
			img[i].setBorder(new LineBorder(Color.gray));
			
			int x=(int)(Math.random()*(getWidth()-50));
			int y=(int)(Math.random()*(getHeight()-150));
			img[i].setLocation(x-20, y-20);
			img[i].addMouseListener(this);
			img[i].addMouseMotionListener(this);
			right.add(img[i]);
			
			target[i]=new JLabel();
			target[i].setOpaque(true);
			target[i].setBackground(Color.orange);
			target[i].setHorizontalTextPosition(SwingConstants.CENTER);
			target[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			target[i].setPreferredSize(new Dimension(150,150));
			target[i].setHorizontalAlignment(SwingConstants.CENTER);
			target[i].setFont(new Font("標楷體", Font.PLAIN, 16));
			target[i].setBorder(new LineBorder(Color.gray));
			left.add(target[i]);

		}	
		
		this.submitBtn.setFont(new Font("新細明體", Font.PLAIN, 20));
		this.submitBtn.setBounds(773, 10, 88, 33);
		this.submitBtn.addActionListener(e->{
			if(check()==true) {
				long engTime = System.nanoTime();
		        long elapsedTime = engTime - this.startTime;
		        long convertTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
		        gamerecord g=new gamerecord(m.getUsername(),a.toString(),convertTime);
		        new implRecord().add(g);
			}
			leaderboardUI l =new leaderboardUI(m);
			l.show();
			dispose();
		});
		contentPane.add(submitBtn);
	}
	
	//檢查是否完成
	private boolean check() {
		boolean result=false;
			for(int i=0;i<9;i++) {
				if(target[i].getIcon().equals(img[i].getIcon())) {
					result=true;
				}
			}
		return result;
	}

	private boolean checkPosition() {
		boolean result=true;
		for(int i=0;i<9;i++) {
			Point location=img[i].getLocationOnScreen();
			Point seat=target[i].getLocationOnScreen();
			target[i].setBackground(Color.GREEN);
			if(location.x<seat.x||location.y<seat.y||location.x>seat.x+80||location.y>seat.y+80) {
				target[i].setBackground(Color.orange);
				result=false;
			}
		}
		return  result;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		JLabel source=(JLabel)e.getSource();
		Point imgPoint=source.getLocation();
		Point point=e.getPoint();
		source.setLocation(imgPoint.x+point.x-pressPoint.x , imgPoint.y+point.y-pressPoint.y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressPoint=e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(checkPosition()) {
			getGlassPane().setVisible(false);
			for(int i=0;i<9;i++) {
				target[i].setIcon(img[i].getIcon());
				target[i].setBorder(null);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
