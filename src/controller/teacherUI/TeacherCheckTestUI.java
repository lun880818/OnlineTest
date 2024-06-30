package controller.teacherUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.LoginUI;
import dao.table.impl.TestDaoImpl;
import dao.views.impl.StudentDataDaoImpl;
import model.table.Teacher;
import model.table.Test;
import model.views.QuestionAllData;
import model.views.StudentData;
import util.CheckWord;
import util.FileStream;
import util.OtherFunctions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class TeacherCheckTestUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField eachScore;
	private JFrame previousFrame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherCheckTestUI frame = new TeacherCheckTestUI(null);
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
	public TeacherCheckTestUI(JFrame previousFrame) {
		setTitle("未知出版社_國小線上題庫暨測驗系統_考卷題目預覽");
		this.previousFrame = previousFrame;
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
		panel_1.setBounds(104, 122, 1058, 490);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 10, 1038, 470);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox<String> studentSelect = new JComboBox<String>();
		studentSelect.setBackground(new Color(255, 255, 255));
		studentSelect.setBounds(716, 342, 185, 33);
		panel_2.add(studentSelect);
		studentSelect.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		studentSelect.addItem("--選擇學生--");
		
		//倒進選題列表的資料
		@SuppressWarnings("unchecked")
		ArrayList<QuestionAllData> questionList = (ArrayList<QuestionAllData>)FileStream.readFile("questionList.txt");
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {},
				new String[] {"題號", "題目", "選項A", "選項B", "選項C", "選項D", "正確答案"}
			);
		//設定Table顯示內容
		int i = 1;
		for(QuestionAllData q : questionList) {
			model.addRow(new Object[] {i, q.getTopic(),
					q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD(), q.getCorrectAnswer()});
			i++;
		}
		Teacher teacher = (Teacher)FileStream.readFile("teacher.txt");
		StudentDataDaoImpl addi = new StudentDataDaoImpl();
		List<StudentData> sl = addi.selectByTeacherNo(teacher.getTeacherNo());
		StudentData[] students = sl.toArray(new StudentData[sl.size()]);
		for(StudentData a : students) {
			studentSelect.addItem(a.getName()+"("+a.getStudentNo()+")");
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(504, 53, 258, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜考卷題目預覽＞");
		lblNewLabel_1.setBounds(7, 9, 243, 41);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 10, 961, 322);
		panel_2.add(scrollPane);
		
		//建立JTable並帶入上一頁的訂單資料		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(10);
		table.setRowHeight(30);
		
		JLabel lblNewLabel_8 = new JLabel("※考卷要給哪位學生：");
		lblNewLabel_8.setBounds(518, 342, 200, 33);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		
		
		JButton releaseTestButton_1 = new JButton("←返回重新選題");
		releaseTestButton_1.setBackground(new Color(249, 221, 91));
		releaseTestButton_1.setBounds(518, 422, 216, 38);
		panel_2.add(releaseTestButton_1);
		releaseTestButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				previousFrame.setVisible(true);
				previousFrame.setLocationRelativeTo(null);
				dispose();
			}
		});
		releaseTestButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JLabel lblNewLabel_8_3_2_1_1 = new JLabel("（考卷總分小計：");
		lblNewLabel_8_3_2_1_1.setBounds(53, 378, 177, 33);
		panel_2.add(lblNewLabel_8_3_2_1_1);
		lblNewLabel_8_3_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel scoreSum = new JLabel("0");
		scoreSum.setBounds(231, 378, 124, 33);
		panel_2.add(scoreSum);
		scoreSum.setHorizontalAlignment(SwingConstants.RIGHT);
		scoreSum.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel lblNewLabel_8_3_1_1_1 = new JLabel("分）");
		lblNewLabel_8_3_1_1_1.setBounds(356, 378, 40, 33);
		panel_2.add(lblNewLabel_8_3_1_1_1);
		lblNewLabel_8_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel lblNewLabel_8_3_2_1 = new JLabel("※請輸入每題分數：");
		lblNewLabel_8_3_2_1.setBounds(53, 342, 177, 33);
		panel_2.add(lblNewLabel_8_3_2_1);
		lblNewLabel_8_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_3_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		eachScore = new JTextField();
		eachScore.setBounds(231, 342, 124, 32);
		panel_2.add(eachScore);
		eachScore.setHorizontalAlignment(SwingConstants.RIGHT);
		eachScore.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e){
		        char c = e.getKeyChar();
		        // 檢查是否是數字，如果不是，則消除事件
		        if (!(c>='0' && c<='9')) {
		            e.consume();  // 使事件失效
		        }
		    }
		});
		eachScore.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			@Override
		    public void insertUpdate(javax.swing.event.DocumentEvent e) {
		    	if(!eachScore.getText().isEmpty()) {
		    		if(CheckWord.isNumber(eachScore.getText())) {
		    			Integer Question = questionList.size();
			    		Integer EachScore = Integer.valueOf(eachScore.getText());
			        	scoreSum.setText((Question*EachScore)+"");
		    		}else {
			    		scoreSum.setText("0");
			    	}
		    	}else {
		    		scoreSum.setText("0");
		    	}
		    }

		    @Override
		    public void removeUpdate(javax.swing.event.DocumentEvent e) {
		    	if(!eachScore.getText().isEmpty()) {
		    		if(CheckWord.isNumber(eachScore.getText())) {
		    			Integer Question = questionList.size();
			    		Integer EachScore = Integer.valueOf(eachScore.getText());
			        	scoreSum.setText((Question*EachScore)+"");
		    		}else {
			    		scoreSum.setText("0");
			    	}
		    	}else {
		    		scoreSum.setText("0");
		    	}
		    }

		    @Override
		    public void changedUpdate(javax.swing.event.DocumentEvent e) {
		    	if(!eachScore.getText().isEmpty()) {
		    		if(CheckWord.isNumber(eachScore.getText())) {
		    			Integer Question = questionList.size();
			    		Integer EachScore = Integer.valueOf(eachScore.getText());
			        	scoreSum.setText((Question*EachScore)+"");
		    		}else {
			    		scoreSum.setText("0");
			    	}
		    	}else {
		    		scoreSum.setText("0");
		    	}
		    }
		});
		eachScore.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		eachScore.setColumns(10);
		
		JLabel lblNewLabel_8_3_1_1_1_1 = new JLabel("分");
		lblNewLabel_8_3_1_1_1_1.setBounds(356, 342, 31, 33);
		panel_2.add(lblNewLabel_8_3_1_1_1_1);
		lblNewLabel_8_3_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton releaseTestButton = new JButton("確定出卷→");
		releaseTestButton.setBackground(new Color(249, 221, 91));
		releaseTestButton.setBounds(788, 422, 216, 38);
		panel_2.add(releaseTestButton);
		releaseTestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(studentSelect.getSelectedIndex()!=0 && !eachScore.getText().equals("")) {
					int reply = JOptionPane.showConfirmDialog(null, "確定要送出考卷嗎?","確認視窗",JOptionPane.YES_NO_OPTION);
	        		if(reply==JOptionPane.YES_NO_OPTION) {
	        			Test test = (Test)FileStream.readFile("test.txt");
						String TestNo = new OtherFunctions().setTestNumber();
						Integer Suject = test.getSuject();
						Integer EachScore = Integer.parseInt(eachScore.getText());
						String TeacherNo = teacher.getTeacherNo();
						String studentNo = students[studentSelect.getSelectedIndex()-1].getStudentNo();
						int j = 1;
						for(QuestionAllData q : questionList) {
							Test t = new Test(TestNo, Suject, j, q.getQuestionNo(), EachScore, TeacherNo, studentNo);
							new TestDaoImpl().add(t);
							j++;
						}
						JOptionPane.showMessageDialog(null, "出卷成功！"+"\n您將回主選單");
						TeacherSelectUI ts = new TeacherSelectUI();
						ts.setVisible(true);
						ts.setLocationRelativeTo(null);
						dispose();
	        		}
				}else {
					JOptionPane.showMessageDialog(null, "請輸入每題的分數並選擇學生");
				}
			}
		});
		releaseTestButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		
	}
}
