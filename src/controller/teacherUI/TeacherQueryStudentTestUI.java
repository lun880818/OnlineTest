package controller.teacherUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.table.impl.TestDaoImpl;
import dao.views.impl.StudentDataDaoImpl;
import dao.views.impl.TestGroupByTestNoDaoImpl;
import dao.views.impl.TestResultGroupByTestNoDaoImpl;
import model.table.Teacher;
import model.views.StudentData;
import model.views.TestGroupByTestNo;
import model.views.TestResultGroupByTestNo;
import util.FileStream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherQueryStudentTestUI extends JFrame {

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
					TeacherQueryStudentTestUI frame = new TeacherQueryStudentTestUI();
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
	public TeacherQueryStudentTestUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師出卷紀錄查詢");
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
				new String[] {"考卷編號", "科目", "教師出卷時間", "學生是否完成作答", "分數", "考卷總分", "得分百分比"}
			);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(506, 70, 255, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜教師出卷紀錄＞");
		lblNewLabel_1.setBounds(0, 10, 255, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(155, 141, 956, 434);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 936, 414);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 53, 869, 284);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(10);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setPreferredWidth(10);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(10);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.setRowHeight(30);
		
		JButton selectButton = new JButton("←回主選單");
		selectButton.setBackground(new Color(249, 221, 91));
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherSelectUI ts = new TeacherSelectUI();
				ts.setVisible(true);
				ts.setLocationRelativeTo(null);
				dispose();
			}
		});
		selectButton.setBounds(387, 354, 230, 33);
		panel_1.add(selectButton);
		selectButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JButton selectButton_1_1 = new JButton("刪除考卷");
		selectButton_1_1.setBackground(new Color(249, 221, 91));
		selectButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow()>=0) {
					String doneOrNot = table.getValueAt(table.getSelectedRow(), 3).toString();
					if(!doneOrNot.equals("完成")) {
						int reply = JOptionPane.showConfirmDialog(null, "確定要刪除嗎?","確認視窗",JOptionPane.YES_NO_OPTION);
		        		if(reply==JOptionPane.YES_NO_OPTION) {
		        			String TestNo = table.getValueAt(table.getSelectedRow(), 0).toString();
							new TestDaoImpl().deleteByTestNo(TestNo);
							model.removeRow(table.getSelectedRow());
							JOptionPane.showMessageDialog(null, "刪除成功");
		        		}
					}else {
						JOptionPane.showMessageDialog(null, "學生已完成的考卷不能刪除，請重新選擇");
					}
				}else {
					JOptionPane.showMessageDialog(null, "請選擇要刪除的考卷");
				}
			}
		});
		selectButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		selectButton_1_1.setBounds(672, 354, 230, 33);
		panel_1.add(selectButton_1_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("選擇您的學生：");
		lblNewLabel_8_2.setBounds(33, 10, 163, 33);
		panel_1.add(lblNewLabel_8_2);
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JComboBox<String> student = new JComboBox<String>();
		student.setBackground(new Color(255, 255, 255));
		student.setBounds(190, 10, 173, 33);
		panel_1.add(student);
		student.addItem("--選擇學生--");
		
		Teacher teacher = (Teacher)FileStream.readFile("teacher.txt");
		StudentDataDaoImpl addi = new StudentDataDaoImpl();
		List<StudentData> sl = addi.selectByTeacherNo(teacher.getTeacherNo());
		StudentData[] students = sl.toArray(new StudentData[sl.size()]);
		for(StudentData a : students) {
			student.addItem(a.getName()+"("+a.getStudentNo()+")");
		}
		
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				if(student.getSelectedIndex()!=0) {
					//抓出學生底下的所有testNo
					List<TestGroupByTestNo> tgbtnL = new TestGroupByTestNoDaoImpl().selectByStudentNo(students[student.getSelectedIndex()-1].getStudentNo());
					//用TestResultGroupByTestNoDaoImpl().selectByTestNo搜尋，如果isEmpty，就代表學生還沒做
					for(TestGroupByTestNo a : tgbtnL) {
						TestResultGroupByTestNoDaoImpl trgbtndi = new TestResultGroupByTestNoDaoImpl();
						List<TestResultGroupByTestNo> l = trgbtndi.selectByTestNo(a.getTestNo());
						TestResultGroupByTestNo[] trgbtn = l.toArray(new TestResultGroupByTestNo[l.size()]);
						String studentDone;
						Integer score;
						Integer TestTotalScore = a.getScoreSum();
						String percentage ;
						if(l.isEmpty()) {
							studentDone = "<html><font color=\"#FF0000\">未完成</font><html>";
							score = 0;
							percentage="0%";
						}else {
							studentDone = "完成";
							score = trgbtn[0].getStudentScoreSum();
							percentage = (int)(score*1.0/TestTotalScore*100) + "%";
						}
						model.addRow(new Object[] {
								a.getTestNo(), a.getSuject(), a.getTime(),
								studentDone, score, TestTotalScore, percentage});
					}
				}
			}
		});
		student.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("（考卷狀態為「未完成」才能刪除）");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(672, 388, 230, 15);
		panel_1.add(lblNewLabel);



		
		
	}
}
