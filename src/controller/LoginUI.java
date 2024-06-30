package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.studentUI.StudentAddUI;
import controller.studentUI.StudentSelectUI;
import controller.teacherUI.TeacherAddUI;
import controller.teacherUI.TeacherSelectUI;
import dao.table.impl.StudentDaoImpl;
import dao.table.impl.TeacherDaoImpl;
import model.table.Student;
import model.table.Teacher;
import util.FileStream;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentUsername;
	private JTextField studentPassword;
	private JTextField teacherUsername;
	private JTextField teacherPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統");
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
		panel_1.setBounds(312, 39, 641, 70);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 621, 50);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("＜未知出版社_國小線上題庫暨測驗系統＞");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(319, 164, 628, 400);
		contentPane.add(tabbedPane);
		
		JPanel teacherPanel = new JPanel();
		teacherPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("教師登入", null, teacherPanel, null);
		teacherPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("帳號：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(108, 91, 95, 33);
		teacherPanel.add(lblNewLabel_3);
		
		teacherUsername = new JTextField();
		teacherUsername.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		teacherUsername.setColumns(10);
		teacherUsername.setBounds(176, 91, 270, 32);
		teacherPanel.add(teacherUsername);
		
		JLabel lblNewLabel_2_1 = new JLabel("密碼：");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(108, 161, 95, 33);
		teacherPanel.add(lblNewLabel_2_1);
		
		teacherPassword = new JTextField();
		teacherPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		teacherPassword.setColumns(10);
		teacherPassword.setBounds(176, 161, 270, 32);
		teacherPanel.add(teacherPassword);
		
		JLabel lblNewLabel_3_1 = new JLabel("教師登入");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(261, 22, 95, 33);
		teacherPanel.add(lblNewLabel_3_1);
		
		JPanel StudentPanel = new JPanel();
		StudentPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("學生登入", null, StudentPanel, null);
		StudentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setBounds(108, 91, 95, 33);
		StudentPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		studentUsername = new JTextField();
		studentUsername.setBounds(176, 91, 270, 32);
		StudentPanel.add(studentUsername);
		studentUsername.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		studentUsername.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("密碼：");
		lblNewLabel_2.setBounds(108, 161, 95, 33);
		StudentPanel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		studentPassword = new JTextField();
		studentPassword.setBounds(176, 161, 270, 32);
		StudentPanel.add(studentPassword);
		studentPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		studentPassword.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("學生登入");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(261, 22, 95, 33);
		StudentPanel.add(lblNewLabel_3_1_1);
		
		JButton teacherLoginButton = new JButton("登入");
		teacherLoginButton.setBackground(new Color(249, 221, 91));
		teacherLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String TUsername= teacherUsername.getText();
				String TPassword = teacherPassword.getText();
				Teacher t= new TeacherDaoImpl().queryLogin(TUsername, TPassword);
				if(t==null) {
					JOptionPane.showMessageDialog(null, "帳號密碼錯誤，請重新登入"+"\n如未註冊請先註冊會員");
				}else {
					FileStream.saveFile("teacher.txt", t);
					TeacherSelectUI tsUI = new TeacherSelectUI();
					tsUI.setVisible(true);
					tsUI.setLocationRelativeTo(null);
					dispose();
				}
			}
			public void mouseEntered(MouseEvent e) {
				teacherLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		teacherLoginButton.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		teacherLoginButton.setBounds(142, 260, 338, 49);
		teacherPanel.add(teacherLoginButton);
		
		JLabel teacherAddLabel = new JLabel("<html><u>點我註冊教師帳號<u><html>");
		teacherAddLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherAddUI tUI = new TeacherAddUI();
				tUI.setVisible(true);
				tUI.setLocationRelativeTo(null);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				teacherAddLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		teacherAddLabel.setForeground(new Color(0, 0, 255));
		teacherAddLabel.setHorizontalAlignment(SwingConstants.LEFT);
		teacherAddLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		teacherAddLabel.setBounds(314, 308, 156, 33);
		teacherPanel.add(teacherAddLabel);
		
		JLabel studentAddLabel_1_1 = new JLabel("<html><u>忘記密碼?<u><html>");
		studentAddLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QueryPasswordUI sui = new QueryPasswordUI();
				sui.setVisible(true);
				sui.setLocationRelativeTo(null);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				studentAddLabel_1_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			
		});
		studentAddLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
		studentAddLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		studentAddLabel_1_1.setForeground(Color.BLUE);
		studentAddLabel_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		studentAddLabel_1_1.setBounds(351, 191, 95, 33);
		teacherPanel.add(studentAddLabel_1_1);
		
		JLabel nameShow_1_1_1_1_1_1_1_1_1 = new JLabel("若尚未註冊，請先");
		nameShow_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nameShow_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		nameShow_1_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		nameShow_1_1_1_1_1_1_1_1_1.setBounds(152, 308, 164, 33);
		teacherPanel.add(nameShow_1_1_1_1_1_1_1_1_1);
		
		JButton studentLoginButton = new JButton("登入");
		studentLoginButton.setBackground(new Color(249, 221, 91));
		studentLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String SUsername = studentUsername.getText();
				String SPassword = studentPassword.getText();
				Student s= new StudentDaoImpl().queryLogin(SUsername, SPassword);
				if(s==null) {
					JOptionPane.showMessageDialog(null, "帳號密碼錯誤，請重新登入"+"\n如未註冊請先註冊會員");
				}else {
					FileStream.saveFile("student.txt", s);
					StudentSelectUI ssUI = new StudentSelectUI();
					ssUI.setVisible(true);
					ssUI.setLocationRelativeTo(null);
					dispose();
				}
			}
			public void mouseEntered(MouseEvent e) {
				studentLoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		studentLoginButton.setBounds(142, 260, 338, 49);
		StudentPanel.add(studentLoginButton);
		studentLoginButton.setFont(new Font("微軟正黑體", Font.BOLD, 29));
		
		JLabel studentAddLabel = new JLabel("<html><u>點我註冊學生帳號<u><html>");
		studentAddLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentAddUI saUI = new StudentAddUI();
				saUI.setVisible(true);
				saUI.setLocationRelativeTo(null);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				studentAddLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		studentAddLabel.setHorizontalAlignment(SwingConstants.LEFT);
		studentAddLabel.setForeground(Color.BLUE);
		studentAddLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		studentAddLabel.setBounds(314, 308, 156, 33);
		StudentPanel.add(studentAddLabel);
		
		JLabel studentAddLabel_1 = new JLabel("<html><u>忘記密碼?<u><html>");
		studentAddLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				QueryPasswordUI sui = new QueryPasswordUI();
				sui.setVisible(true);
				sui.setLocationRelativeTo(null);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				studentAddLabel_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		studentAddLabel_1.setVerticalAlignment(SwingConstants.TOP);
		studentAddLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		studentAddLabel_1.setForeground(Color.BLUE);
		studentAddLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		studentAddLabel_1.setBounds(351, 191, 95, 33);
		StudentPanel.add(studentAddLabel_1);
		
		JLabel nameShow_1_1_1_1_1_1_1_1 = new JLabel("若尚未註冊，請先");
		nameShow_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nameShow_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		nameShow_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		nameShow_1_1_1_1_1_1_1_1.setBounds(152, 308, 164, 33);
		StudentPanel.add(nameShow_1_1_1_1_1_1_1_1);
		

	}
}
