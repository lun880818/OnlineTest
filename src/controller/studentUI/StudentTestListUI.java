package controller.studentUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.views.impl.TestGroupByTestNoDaoImpl;
import model.table.Student;
import model.views.TestGroupByTestNo;
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

public class StudentTestListUI extends JFrame {

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
					StudentTestListUI frame = new StudentTestListUI();
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
	public StudentTestListUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_學生考卷列表");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(154, 139, 957, 428);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 937, 408);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"考卷編號", "科目", "教師出卷時間", "考卷總題數"}
			);
		
		//抓出學生登入資料
		Student s = (Student)FileStream.readFile("student.txt");
		
		//抓學生還沒完成的考卷清單
		List<TestGroupByTestNo> NotDoneList = new TestGroupByTestNoDaoImpl().haveNotDoneTest(s.getStudentNo());
		for(TestGroupByTestNo a : NotDoneList) {
			String TestNo = a.getTestNo();
			String suject = a.getSuject();
			String time = a.getTime();
			Integer QuestionSum = a.getQuestionSum();
			model.addRow(new Object[] {
					TestNo, suject, time, QuestionSum});
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 22, 869, 291);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.setRowHeight(30);
		
		JButton selectButton = new JButton("←回主選單");
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
		selectButton.setBounds(291, 355, 293, 33);
		panel_1.add(selectButton);
		selectButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JButton selectButton_1 = new JButton("開始作答");
		selectButton_1.setBackground(new Color(249, 221, 91));
		selectButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int SelectRow = table.getSelectedRow();
				TestGroupByTestNo[] t = NotDoneList.toArray(new TestGroupByTestNo[NotDoneList.size()]);
				FileStream.saveFile("selectTest.txt", t[SelectRow]);
				
				TestUI t1 = new TestUI();
				t1.setVisible(true);
				t1.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		selectButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		selectButton_1.setBounds(609, 355, 293, 33);
		panel_1.add(selectButton_1);
		
		JLabel lblNewLabel = new JLabel("※請選擇一份考卷，再點擊「開始作答」");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(472, 323, 430, 27);
		panel_1.add(lblNewLabel);
				
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(165, 62, 935, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜考卷列表＞");
		lblNewLabel_1.setBounds(315, 7, 304, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		
		for(int i = 0; i<4; i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(50);
		}
	}
}
