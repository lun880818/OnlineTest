package controller.teacherUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TeacherSelectUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherSelectUI frame = new TeacherSelectUI();
					frame.setLocationRelativeTo(null);
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
	public TeacherSelectUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師功能選單");
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
		
		JButton btnNewButton_2_1 = new JButton("登出");
		btnNewButton_2_1.setForeground(new Color(255, 255, 255));
		btnNewButton_2_1.setBackground(new Color(0, 128, 255));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		btnNewButton_2_1.setBounds(1078, 606, 145, 49);
		contentPane.add(btnNewButton_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(256, 174, 752, 403);
		contentPane.add(panel_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 732, 383);
		panel_2.add(panel);
		
		JButton btnNewButton = new JButton("教師個人資料管理");
		btnNewButton.setBackground(new Color(249, 221, 91));
		btnNewButton.setBounds(105, 295, 521, 49);
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTeacherUI ut = new UpdateTeacherUI();
				ut.setVisible(true);
				ut.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		
		JButton btnNewButton_2 = new JButton("出卷紀錄查詢");
		btnNewButton_2.setBackground(new Color(249, 221, 91));
		btnNewButton_2.setBounds(105, 209, 521, 49);
		panel.add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherQueryStudentTestUI t = new TeacherQueryStudentTestUI();
				t.setVisible(true);
				t.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		
		JButton btnNewButton_1_1 = new JButton("出考卷(手動選題)");
		btnNewButton_1_1.setBackground(new Color(249, 221, 91));
		btnNewButton_1_1.setBounds(105, 123, 521, 49);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectQuestionManualUI sui = new SelectQuestionManualUI();
				sui.setVisible(true);
				sui.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		
		JButton btnNewButton_1 = new JButton("出考卷(電腦選題)");
		btnNewButton_1.setBackground(new Color(249, 221, 91));
		btnNewButton_1.setBounds(105, 37, 521, 49);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectQuestionUI sq = new SelectQuestionUI();
				sq.setVisible(true);
				sq.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(256, 75, 752, 70);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("教師功能選單");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 36));
		lblNewLabel_1_1.setBounds(209, 14, 334, 41);
		panel_1.add(lblNewLabel_1_1);
	}

}
