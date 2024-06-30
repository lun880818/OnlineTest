package controller;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.studentUI.StudentAddUI;
import controller.teacherUI.TeacherAddUI;
import dao.table.impl.StudentDaoImpl;
import dao.table.impl.TeacherDaoImpl;
import model.table.Student;
import model.table.Teacher;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QueryPasswordUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryPasswordUI frame = new QueryPasswordUI();
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
	public QueryPasswordUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_密碼查詢");
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
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(320, 75, 626, 62);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("＜密碼查詢＞");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel.setBounds(168, 10, 289, 41);
		panel_5.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(320, 172, 626, 392);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 53, 606, 329);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("登入帳號:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(65, 74, 114, 33);
		panel_1.add(lblNewLabel_2_1);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		username.setColumns(10);
		username.setBounds(174, 74, 302, 32);
		panel_1.add(username);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("連絡電話:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1_1.setBounds(65, 128, 114, 33);
		panel_1.add(lblNewLabel_2_1_1);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		phone.setColumns(10);
		phone.setBounds(174, 129, 302, 32);
		panel_1.add(phone);
		
		
		
		JLabel nameShow_1_1_1_1_1_1_1_1_1 = new JLabel("若尚未註冊，請先註冊：");
		nameShow_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		nameShow_1_1_1_1_1_1_1_1_1.setForeground(Color.BLACK);
		nameShow_1_1_1_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		nameShow_1_1_1_1_1_1_1_1_1.setBounds(108, 256, 215, 33);
		panel_1.add(nameShow_1_1_1_1_1_1_1_1_1);
		
		JLabel teacherAddLabel = new JLabel("<html><u>點我註冊教師帳號<u><html>");
		teacherAddLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherAddUI taUI = new TeacherAddUI();
				taUI.setVisible(true);
				taUI.setLocationRelativeTo(null);
				dispose();
			}
			public void mouseEntered(MouseEvent e) {
				teacherAddLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		teacherAddLabel.setHorizontalAlignment(SwingConstants.LEFT);
		teacherAddLabel.setForeground(Color.BLUE);
		teacherAddLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		teacherAddLabel.setBounds(320, 256, 156, 33);
		panel_1.add(teacherAddLabel);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("選擇身分:");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1_2.setBounds(65, 20, 114, 33);
		panel_1.add(lblNewLabel_2_1_2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		comboBox.setBounds(174, 20, 302, 33);
		panel_1.add(comboBox);
		
		comboBox.addItem("--選擇身分--");
		comboBox.addItem("教師");
		comboBox.addItem("學生");
		
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
		studentAddLabel.setBounds(320, 286, 156, 33);
		panel_1.add(studentAddLabel);
		
		JLabel nameShow_1 = new JLabel("請輸入您的基本資料查詢密碼：");
		nameShow_1.setForeground(new Color(255, 255, 255));
		nameShow_1.setBounds(10, 10, 310, 33);
		panel.add(nameShow_1);
		nameShow_1.setHorizontalAlignment(SwingConstants.LEFT);
		nameShow_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JButton btnNewButton = new JButton("查詢密碼");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboBox.getSelectedIndex()!=0) {
					String Username = username.getText();
					String Phone = phone.getText();
					if(comboBox.getSelectedIndex()==2) {
						Student s = new StudentDaoImpl().forgetPassword(Username, Phone);
						if(s!=null) {
							String Password = s.getPassword();
							JOptionPane.showMessageDialog(null, "您的密碼為："+Password+"\n請重新登入");
							LoginUI l = new LoginUI();
							l.setVisible(true);
							l.setLocationRelativeTo(null);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "查無資料，請重新查詢"+"\n如未註冊請先註冊會員");
						}
					}else {
						Teacher t = new TeacherDaoImpl().forgetPassword(Username, Phone);
						if(t!=null) {
							String Password = t.getPassword();
							JOptionPane.showMessageDialog(null, "您的密碼為："+Password+"\n請重新登入");
							LoginUI l = new LoginUI();
							l.setVisible(true);
							l.setLocationRelativeTo(null);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "查無資料，請重新查詢"+"\n如未註冊請先註冊會員");
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "請選擇您的身分");
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		btnNewButton.setBackground(new Color(249, 221, 91));
		btnNewButton.setBounds(222, 194, 185, 47);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回登入頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton_1.setBackground(new Color(249, 221, 91));
		btnNewButton_1.setBounds(760, 566, 185, 32);
		contentPane.add(btnNewButton_1);
	}
}
