package controller.studentUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.views.impl.TestResultGroupByTestNoDaoImpl;
import model.table.Student;
import model.views.TestResultGroupByTestNo;
import util.FileStream;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentQueryTestResultUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentQueryTestResultUI frame = new StudentQueryTestResultUI();
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
	public StudentQueryTestResultUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_學生歷史成績查詢");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon icon = new ImageIcon(LoginUI.class.getResource("/image/201.jpg"));
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(158, 148, 950, 445);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"完成的時間", "考卷編號", "科目", "分數", "考卷總分", "得分百分比"}
			);
		
		//抓出學生登入資料
		Student s = (Student)FileStream.readFile("student.txt");
		
		//用studentNo查詢testResultGroupByTestNo
		TestResultGroupByTestNoDaoImpl trgbtndi = new TestResultGroupByTestNoDaoImpl();
		List<TestResultGroupByTestNo> l = trgbtndi.selectByStudentNo(s.getStudentNo());
		TestResultGroupByTestNo[] trgbtn = l.toArray(new TestResultGroupByTestNo[l.size()]);
		for(TestResultGroupByTestNo a : trgbtn) {
			String percentage = (int)((a.getStudentScoreSum()*1.0/a.getTestTotalScore())*100)+"%";
			
			model.addRow(new Object[] {
					a.getAnswerTime(), a.getTestNo(), a.getSuject(), 
					a.getStudentScoreSum(), a.getTestTotalScore(), 
					percentage});
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 930, 425);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		
		JButton selectButton = new JButton("回主選單");
		selectButton.setBounds(660, 360, 240, 41);
		panel_2.add(selectButton);
		selectButton.setBackground(new Color(249, 221, 91));
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentSelectUI ts = new StudentSelectUI();
				ts.setVisible(true);
				ts.setLocationRelativeTo(null);
				dispose();
			}
		});
		selectButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 18, 869, 320);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		
		table.setRowHeight(30);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(361, 50, 543, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜歷史成績查詢＞");
		lblNewLabel_1.setBounds(119, 11, 304, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		

		
		
	}
}
