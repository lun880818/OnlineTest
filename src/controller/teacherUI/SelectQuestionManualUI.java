package controller.teacherUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.views.impl.QuestionAllDataDaoImpl;
import model.table.Test;
import model.views.QuestionAllData;
import util.FileStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectQuestionManualUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectQuestionManualUI frame = new SelectQuestionManualUI();
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
	public SelectQuestionManualUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師手動選題");
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 88, 1246, 272);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 1226, 54);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8_2 = new JLabel("篩選條件");
		lblNewLabel_8_2.setBounds(0, 10, 77, 33);
		panel_2.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		
		JLabel lblNewLabel_8 = new JLabel("※科目：");
		lblNewLabel_8.setBounds(100, 10, 67, 33);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		
		JComboBox<String> suject = new JComboBox<String>();
		suject.setBackground(new Color(255, 255, 255));
		suject.setBounds(163, 10, 200, 33);
		panel_2.add(suject);
		suject.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		suject.addItem("--選擇科目--");
		suject.addItem("數學");
		suject.addItem("英文");
		
		JLabel lblNewLabel_8_1 = new JLabel("※年級：");
		lblNewLabel_8_1.setBounds(403, 10, 67, 33);
		panel_2.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		
		JComboBox<String> grade = new JComboBox<String>();
		grade.setBackground(new Color(255, 255, 255));
		grade.setBounds(469, 10, 200, 33);
		panel_2.add(grade);
		grade.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		grade.addItem("--選擇年級--");
		grade.addItem("一年級");
		grade.addItem("二年級");
		grade.addItem("三年級");
		grade.addItem("四年級");
		grade.addItem("五年級");
		grade.addItem("六年級");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBounds(10, 417, 1246, 256);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		//考卷清單table
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(10, 10, 1226, 194);
		panel_1.add(scrollPane2);
		DefaultTableModel model2 = new DefaultTableModel(
				new Object[][] {},
				new String[] {"題號", "題目", "選項A", "選項B", "選項C", "選項D", "正確答案"}
			);
		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		table2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		table2.setDefaultEditor(Object.class, null);
		table2.setModel(model2);
		table2.getColumnModel().getColumn(0).setPreferredWidth(50);
		table2.getColumnModel().getColumn(1).setPreferredWidth(150);
		table2.getColumnModel().getColumn(2).setPreferredWidth(50);
		table2.getColumnModel().getColumn(3).setPreferredWidth(50);
		table2.getColumnModel().getColumn(4).setPreferredWidth(50);
		table2.getColumnModel().getColumn(5).setPreferredWidth(50);
		table2.getColumnModel().getColumn(6).setPreferredWidth(50);
		table2.setRowHeight(30);		
		
		JButton releaseTestButton = new JButton("下一步");
		releaseTestButton.setBackground(new Color(249, 221, 91));
		releaseTestButton.setBounds(1000, 209, 236, 37);
		panel_1.add(releaseTestButton);
		releaseTestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//System.out.print(table2.getValueAt(1, 0).toString());
				ArrayList<QuestionAllData> questionList = new ArrayList<QuestionAllData>();
				for(int i = 0; i<table2.getRowCount(); i++) {
					String QNo = table2.getValueAt(i, 0).toString();
					QuestionAllData q = new QuestionAllDataDaoImpl().selectByQuestionNo(QNo);
					questionList.add(q);
				}
				FileStream.saveFile("questionList.txt", questionList);
				
				/*====先存一些test資料到下一頁====*/
				Integer Suject = suject.getSelectedIndex();
				Test t = new Test(Suject);
				FileStream.saveFile("test.txt", t);
				
				TeacherCheckTestUI tct = new TeacherCheckTestUI(SelectQuestionManualUI.this);
				tct.setVisible(true);
				tct.setLocationRelativeTo(null);
				dispose();
			}
		});
		releaseTestButton.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		
		JButton releaseTestButton_1 = new JButton("←返回主選單");
		releaseTestButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherSelectUI tui = new TeacherSelectUI();
				tui.setVisible(true);
				tui.setLocationRelativeTo(null);
				dispose();
			}
		});
		releaseTestButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 26));
		releaseTestButton_1.setBackground(new Color(249, 221, 91));
		releaseTestButton_1.setBounds(701, 209, 236, 37);
		panel_1.add(releaseTestButton_1);
		
		
		//題目清單table
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 74, 1226, 188);
		panel.add(scrollPane);
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"題號", "題目", "選項A", "選項B", "選項C", "選項D", "正確答案"}
			);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.setRowHeight(30);
		
		JButton queryButton = new JButton("篩選");
		queryButton.setBackground(new Color(249, 221, 91));
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				if(grade.getSelectedIndex()!=0 && suject.getSelectedIndex()!=0) {
					//倒進選題列表的資料
					String Grade = grade.getSelectedItem().toString();
					String Suject = suject.getSelectedItem().toString();
					List<QuestionAllData> questionList = new QuestionAllDataDaoImpl().selecteBySujectAndGrade(Suject,Grade);
					
					//設定Table顯示內容
					for(QuestionAllData q : questionList) {
						model.addRow(new Object[] {q.getQuestionNo(), q.getTopic(),
								q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD(), q.getCorrectAnswer()});
					}
					
					//為了不要加入其他科目&年級的題目，先關閉篩選功能
					suject.setEnabled(false);
					grade.setEnabled(false);
					queryButton.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "請選擇篩選條件");
				}
				
			}
		});
		queryButton.setBounds(709, 9, 157, 33);
		panel_2.add(queryButton);
		queryButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton reQueryButton = new JButton("重新篩選");
		reQueryButton.setBackground(new Color(249, 221, 91));
		reQueryButton.setBounds(876, 9, 157, 33);
		panel_2.add(reQueryButton);
		reQueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				suject.setEnabled(true);
				grade.setEnabled(true);
				queryButton.setEnabled(true);
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
				DefaultTableModel model2 = (DefaultTableModel)table2.getModel();
				model2.setRowCount(0);
				
			}
		});
		reQueryButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		
		
		
		JButton addButton = new JButton("↓新增↓");
		addButton.setBackground(new Color(249, 221, 91));
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table.getSelectedRow();
				if(selectRow>=0) {
					Object[] row = new Object[table.getColumnCount()];
					for(int i = 0; i< table.getColumnCount(); i++) {
						row[i] = table.getValueAt(selectRow, i);
					}
					model2.addRow(row);
					model.removeRow(selectRow);
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一行以新增到考卷清單");
				}
				
			}
		});
		addButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		addButton.setBounds(451, 370, 135, 37);
		contentPane.add(addButton);
		
		JButton deleteButton = new JButton("↑刪除↑");
		deleteButton.setBackground(new Color(249, 221, 91));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectRow = table2.getSelectedRow();
				if(selectRow>=0) {
					Object[] row = new Object[table2.getColumnCount()];
					for(int i = 0; i< table2.getColumnCount(); i++) {
						row[i] = table2.getValueAt(selectRow, i);
					}
					model.addRow(row);
					model2.removeRow(selectRow);
				}else {
					JOptionPane.showMessageDialog(null, "請選擇一行以新增到考卷清單");
				}
			}
		});
		deleteButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		deleteButton.setBounds(674, 370, 135, 37);
		contentPane.add(deleteButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(522, 10, 221, 46);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜手動選題＞");
		lblNewLabel_1.setBounds(14, 2, 193, 41);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(10, 387, 135, 37);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("2. 考卷清單");
		lblNewLabel_2.setBounds(16, 4, 119, 28);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(10, 51, 299, 37);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. 題目清單（請先篩選題目）");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(18, 4, 262, 33);
		panel_5.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		
	}
}
