package controller.teacherUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.views.impl.QuestionAllDataDaoImpl;
import model.table.Test;
import model.views.QuestionAllData;
import util.FileStream;
import util.OtherFunctions;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;

public class SelectQuestionUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<QuestionAllData> l;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectQuestionUI frame = new SelectQuestionUI();
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
	public SelectQuestionUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師電腦選題");
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
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(511, 66, 244, 59);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜電腦選題＞");
		lblNewLabel_1.setBounds(20, 9, 203, 41);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(179, 149, 908, 422);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 885, 400);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("科目：");
		lblNewLabel_8.setBounds(30, 69, 67, 33);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JComboBox<String> suject = new JComboBox<String>();
		suject.setBounds(107, 69, 173, 33);
		panel.add(suject);
		suject.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		suject.addItem("--選擇科目--");
		suject.addItem("數學");
		suject.addItem("英文");
		
		JLabel lblNewLabel_8_1 = new JLabel("年級：");
		lblNewLabel_8_1.setBounds(290, 69, 95, 33);
		panel.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JComboBox<String> grade = new JComboBox<String>();
		grade.setBounds(395, 69, 173, 33);
		panel.add(grade);
		grade.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		grade.addItem("--選擇年級--");
		grade.addItem("一年級");
		grade.addItem("二年級");
		grade.addItem("三年級");
		grade.addItem("四年級");
		grade.addItem("五年級");
		grade.addItem("六年級");
		
		JLabel lblNewLabel_8_2 = new JLabel("1. 選擇題目篩選條件");
		lblNewLabel_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_2.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblNewLabel_8_2.setBounds(30, 10, 344, 33);
		panel.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_8_4 = new JLabel("=========================================================");
		lblNewLabel_8_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_8_4.setBounds(0, 133, 885, 33);
		panel.add(lblNewLabel_8_4);
		
		JLabel lblNewLabel_8_3 = new JLabel("※符合篩選條件之總題數：");
		lblNewLabel_8_3.setBounds(30, 219, 244, 33);
		panel.add(lblNewLabel_8_3);
		lblNewLabel_8_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel totalQuestion = new JLabel("0");
		totalQuestion.setBounds(275, 219, 124, 33);
		panel.add(totalQuestion);
		totalQuestion.setHorizontalAlignment(SwingConstants.RIGHT);
		totalQuestion.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel lblNewLabel_8_3_1_1 = new JLabel("題");
		lblNewLabel_8_3_1_1.setBounds(400, 219, 31, 33);
		panel.add(lblNewLabel_8_3_1_1);
		lblNewLabel_8_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel lblNewLabel_8_3_2 = new JLabel("3. 請輸入要出的題數：");
		lblNewLabel_8_3_2.setBounds(30, 329, 292, 33);
		panel.add(lblNewLabel_8_3_2);
		lblNewLabel_8_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_2.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		
		JSpinner spinner= new JSpinner();
		spinner.setBounds(307, 328, 124, 33);
		panel.add(spinner);
		spinner.setEnabled(false);
		spinner.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		JLabel lblNewLabel_8_3_1_1_2 = new JLabel("題");
		lblNewLabel_8_3_1_1_2.setBounds(432, 329, 31, 33);
		panel.add(lblNewLabel_8_3_1_1_2);
		lblNewLabel_8_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_3_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton releaseTestButton = new JButton("預覽考卷題目");
		releaseTestButton.setEnabled(false);
		releaseTestButton.setBounds(660, 323, 202, 49);
		panel.add(releaseTestButton);
		releaseTestButton.setBackground(new Color(249, 221, 91));
		releaseTestButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Integer TotalQuestion = Integer.parseInt(totalQuestion.getText());
				Integer select = (int)spinner.getValue();
				QuestionAllData[] LQ = l.toArray(new QuestionAllData[l.size()]);
				
				ArrayList<QuestionAllData> questionList = new ArrayList<QuestionAllData>();
				ArrayList<Integer> number = new OtherFunctions().RandomSelect(0, TotalQuestion-1, select);
				for(Integer a : number) {
					questionList.add(LQ[a]);
				}
				FileStream.saveFile("questionList.txt", questionList);

				/*====先存一些test資料到下一頁====*/
				Integer Suject = suject.getSelectedIndex();
				Test t = new Test(Suject);
				FileStream.saveFile("test.txt", t);
				
				TeacherCheckTestUI tct = new TeacherCheckTestUI(SelectQuestionUI.this);
				tct.setVisible(true);
				tct.setLocationRelativeTo(null);
				dispose();
				
			}
		});
		releaseTestButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JLabel lblNewLabel_8_4_1 = new JLabel("=========================================================");
		lblNewLabel_8_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_4_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_8_4_1.setBounds(0, 279, 885, 33);
		panel.add(lblNewLabel_8_4_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("2. 篩選結果");
		lblNewLabel_8_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblNewLabel_8_2_1.setBounds(30, 176, 344, 33);
		panel.add(lblNewLabel_8_2_1);
		
		JButton selectButton = new JButton("篩選");
		selectButton.setBackground(new Color(249, 221, 91));
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Suject = suject.getSelectedItem().toString();
				String Grade = grade.getSelectedItem().toString();
				l = new QuestionAllDataDaoImpl().selecteBySujectAndGrade(Suject, Grade);
				totalQuestion.setText(Integer.toString(l.size()));
				Comparable<Integer> spinnerMax = l.size();
				SpinnerNumberModel model = new SpinnerNumberModel(1, 1, spinnerMax, 1);
				spinner.setModel(model);
				spinner.setEnabled(true);
				releaseTestButton.setEnabled(true);
			}
		});
		selectButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		selectButton.setBounds(664, 61, 187, 49);
		panel.add(selectButton);
		
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
		releaseTestButton_1.setBounds(851, 588, 203, 37);
		contentPane.add(releaseTestButton_1);

	}
}
