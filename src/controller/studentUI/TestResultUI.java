package controller.studentUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.views.impl.TestResultDaoImpl;
import dao.views.impl.TestResultGroupByTestNoDaoImpl;
import model.views.TestGroupByTestNo;
import model.views.TestResult;
import model.views.TestResultGroupByTestNo;
import util.FileStream;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestResultUI extends JFrame {

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
					TestResultUI frame = new TestResultUI();
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
	public TestResultUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_學生考試結果");
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
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"題號", "題目", "正確答案", "你的答案", "本題得分"}
			);
		

		//讀取學生選哪一張考卷
		TestGroupByTestNo t = (TestGroupByTestNo)FileStream.readFile("selectTest.txt");
		String testNo = t.getTestNo();
		
		//讀出TestResult
		List<TestResult> testResultList = new TestResultDaoImpl().selectByTestNo(testNo);
		TestResult[] testResult = testResultList.toArray(new TestResult[testResultList.size()]);
		for(int i = 0; i<testResult.length; i++) {
			model.addRow(new Object[] {
					i+1, testResult[i].getTopic(), testResult[i].getCorrectAnswer(), 
					testResult[i].getAnswer(), testResult[i].getScore()
					});
		}
		
		//用testNo抓TestResultGroupByTestNo
		List<TestResultGroupByTestNo> l = new TestResultGroupByTestNoDaoImpl().selectByTestNo(testNo);
		TestResultGroupByTestNo[] TR = l.toArray(new TestResultGroupByTestNo[l.size()]);
		Integer scoreSum = TR[0].getStudentScoreSum();
		Integer totalSum = TR[0].getTestTotalScore();
		
		int percentage = (int)(scoreSum*1.0/totalSum*100);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(442, 37, 381, 59);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("＜考試結果＞");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 10, 217, 39);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(133, 131, 1000, 462);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 979, 395);
		panel_2.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 10, 854, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.setRowHeight(30);
		
		JLabel lblNewLabel_1_1 = new JLabel("答對率：");
		lblNewLabel_1_1.setBounds(693, 342, 112, 39);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		JLabel showScoreSum_1 = new JLabel(percentage+"%");
		showScoreSum_1.setBounds(806, 342, 112, 39);
		panel.add(showScoreSum_1);
		showScoreSum_1.setHorizontalAlignment(SwingConstants.CENTER);
		showScoreSum_1.setForeground(new Color(0, 0, 160));
		showScoreSum_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
				
				JLabel lblNewLabel_1 = new JLabel("總得分：");
				lblNewLabel_1.setBounds(398, 342, 112, 39);
				panel.add(lblNewLabel_1);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
				
				JLabel showScoreSum = new JLabel(scoreSum.toString());
				showScoreSum.setBounds(511, 342, 112, 39);
				panel.add(showScoreSum);
				showScoreSum.setForeground(new Color(0, 0, 160));
				showScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
				showScoreSum.setFont(new Font("微軟正黑體", Font.BOLD, 30));
				
				
				
				JButton btnNewButton = new JButton("回主選單");
				btnNewButton.setBounds(796, 415, 193, 37);
				panel_2.add(btnNewButton);
				btnNewButton.setBackground(new Color(249, 221, 91));
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						StudentSelectUI s = new StudentSelectUI();
						s.setVisible(true);
						s.setLocationRelativeTo(null);
						dispose();
					}
				});
				btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		//

		
		
		
	}
}
