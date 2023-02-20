package Controller;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Dao.implRecord;
import Model.gamerecord;
import Model.member;
import Dao.createExcel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class leaderboardUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leaderboardUI frame = new leaderboardUI();
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
	public leaderboardUI() {}
	public leaderboardUI(member m) {
		setTitle("拼圖-排行榜");
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
		
		JButton exit = new JButton("離開");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 434, 328);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		model=new DefaultTableModel();
		Object[] column = {"帳號","拼圖","時間"};
		final Object[] row=new Object[3];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		List<gamerecord> l=new implRecord().selectALL();
		for(gamerecord p:l){
			row[0]=p.getUsername();
			row[1]=p.getPuzzle();
			row[2]=p.getTime();
			model.addRow(row);
		}	
	
		
		exit.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		exit.setBounds(453, 348, 101, 33);
		panel.add(exit);
		JButton puzzle0 = new JButton("puzzle0");
		puzzle0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer i=0;
				List<gamerecord> l=new implRecord().select1();
				model.setRowCount(0);
				Object[] column = {"名次","帳號","時間"};
				final Object[] row=new Object[3];
				model.setColumnIdentifiers(column);
				table.setModel(model);	
				for(gamerecord p:l){
					i++;
					row[0]=i;
					row[1]=p.getUsername();
					row[2]=p.getTime();
					model.addRow(row);
				}	
			}
		});
		puzzle0.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		puzzle0.setBounds(10, 10, 101, 33);
		panel.add(puzzle0);
		
		JButton puzzle1 = new JButton("puzzle1");
		puzzle1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer i=0;
				List<gamerecord> l=new implRecord().select2();
				model.setRowCount(0);
				Object[] column = {"名次","帳號","時間"};
				final Object[] row=new Object[3];
				model.setColumnIdentifiers(column);
				table.setModel(model);	
				for(gamerecord p:l){
					i++;
					row[0]=i;
					row[1]=p.getUsername();
					row[2]=p.getTime();
					model.addRow(row);
				}	
			}
		});
		puzzle1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		puzzle1.setBounds(121, 10, 101, 33);
		panel.add(puzzle1);
		
		JButton puzzle2 = new JButton("puzzle2");
		puzzle2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer i=0;
				List<gamerecord> l=new implRecord().select3();
				model.setRowCount(0);
				Object[] column = {"名次","帳號","時間"};
				final Object[] row=new Object[3];
				model.setColumnIdentifiers(column);
				table.setModel(model);	
				for(gamerecord p:l){
					i++;
					row[0]=i;
					row[1]=p.getUsername();
					row[2]=p.getTime();
					model.addRow(row);
				}	
			}
		});
		puzzle2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		puzzle2.setBounds(232, 10, 101, 33);
		panel.add(puzzle2);
		
		JButton puzzle3 = new JButton("puzzle3");
		puzzle3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer i=0;
				List<gamerecord> l=new implRecord().select4();
				model.setRowCount(0);
				Object[] column = {"名次","帳號","時間"};
				final Object[] row=new Object[3];
				model.setColumnIdentifiers(column);
				table.setModel(model);	
				for(gamerecord p:l){
					i++;
					row[0]=i;
					row[1]=p.getUsername();
					row[2]=p.getTime();
					model.addRow(row);
				}	
			}
		});
		puzzle3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		puzzle3.setBounds(343, 10, 101, 33);
		panel.add(puzzle3);
		
		JButton outputexcel = new JButton("匯出");
		outputexcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				do_insertButton_actionPerformed(arg0);
			}
		});
		outputexcel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		outputexcel.setBounds(454, 305, 101, 33);
		panel.add(outputexcel);
		
		
		JButton allpuzzle = new JButton("all");
		allpuzzle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<gamerecord> l=new implRecord().selectALL();
				model.setRowCount(0);
				Object[] column = {"帳號","拼圖","時間"};
				final Object[] row=new Object[3];
				model.setColumnIdentifiers(column);
				table.setModel(model);	
				
				for(gamerecord p:l){
					row[0]=p.getUsername();
					row[1]=p.getPuzzle();
					row[2]=p.getTime();
					model.addRow(row);
				}	
			}
		});
		allpuzzle.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		allpuzzle.setBounds(453, 10, 101, 33);
		panel.add(allpuzzle);
		
		JButton back = new JButton("選擇頁");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectUI l=new selectUI(m);
				l.show();
				dispose();
			}
		});
		back.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		back.setBounds(454, 53, 101, 33);
		panel.add(back);
	}
	
	protected void do_insertButton_actionPerformed(ActionEvent arg0) {
		List<gamerecord> l=new implRecord().selectALL();
		String url="";
        createExcel create = new createExcel();
        File file = new File(url);
        if(!file.exists()){
            create.createExcel();
        }
        for(gamerecord p:l) {
			String ID = p.getId().toString();
	        String Username = p.getUsername();
	        String Puzzle = p.getPuzzle();
	        String Time = p.getTime().toString();
			create.insertvalue(ID, Username,Puzzle,Time);
		}
        JOptionPane.
        showMessageDialog(getContentPane(), "資料增加成功！", "資訊提示框", JOptionPane.WARNING_MESSAGE);

    }
}
