package controller.teacherUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.table.impl.TeacherDaoImpl;
import model.table.Teacher;
import util.CheckWord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.LoginUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherAddUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField checkPassword;
	private JTextField phone;
	private JTextField school;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherAddUI frame = new TeacherAddUI();
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
	public TeacherAddUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師註冊");
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
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(182, 154, 902, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 10, 880, 424);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setBounds(30, 33, 106, 33);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		name = new JTextField();
		name.setBounds(146, 33, 224, 32);
		panel_1.add(name);
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("帳號：");
		lblNewLabel_2.setBounds(30, 106, 106, 33);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel checkUsername = new JLabel("");
		checkUsername.setBounds(146, 138, 224, 22);
		panel_1.add(checkUsername);
		checkUsername.setText("請輸入英文或數字且不可有空白");
		checkUsername.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkUsername.setForeground(new Color(0, 0, 0));
		
		username = new JTextField();
		username.setBounds(146, 106, 224, 32);
		panel_1.add(username);
		username.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
            	Teacher TUsername = new TeacherDaoImpl().queryUsername(username.getText());
            	if(TUsername==null) {
            		if(CheckWord.noContainChinese(username.getText())) {
            			checkUsername.setText("帳號可使用");
            			checkUsername.setForeground(new Color(0, 160, 0));
            			
            		}else {
            			checkUsername.setText("請輸入英文或數字且不可有空白");
            			checkUsername.setForeground(new Color(200, 0, 0));
            		}
            	}else {
            		checkUsername.setText("帳號已有人使用");
            		checkUsername.setForeground(new Color(200, 0, 0));
            	}            	

            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            	Teacher TUsername = new TeacherDaoImpl().queryUsername(username.getText());
            	if(TUsername==null) {
            		if(CheckWord.noContainChinese(username.getText())) {
            			checkUsername.setText("帳號可使用");
            			checkUsername.setForeground(new Color(0, 160, 0));
            			
            		}else {
            			checkUsername.setText("請輸入英文或數字且不可有空白");
            			checkUsername.setForeground(new Color(200, 0, 0));
            		}
            	}else {
            		checkUsername.setText("帳號已有人使用");
            		checkUsername.setForeground(new Color(200, 0, 0));
            	}
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
            	Teacher TUsername = new TeacherDaoImpl().queryUsername(username.getText());
            	if(TUsername==null) {
            		if(CheckWord.noContainChinese(username.getText())) {
            			checkUsername.setText("帳號可使用");
            			checkUsername.setForeground(new Color(0, 160, 0));
            			
            		}else {
            			checkUsername.setText("請輸入英文或數字且不可有空白");
            			checkUsername.setForeground(new Color(200, 0, 0));
            		}
            	}else {
            		checkUsername.setText("帳號已有人使用");
            		checkUsername.setForeground(new Color(200, 0, 0));
            	}
            }
        });
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		username.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("密碼：");
		lblNewLabel_3.setBounds(30, 180, 106, 33);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel checkPass = new JLabel("請輸入英文或數字且不可有空白");
		checkPass.setBounds(146, 212, 224, 22);
		panel_1.add(checkPass);
		checkPass.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPass.setForeground(new Color(0, 0, 0));
		
		password = new JTextField();
		password.setBounds(146, 180, 224, 32);
		panel_1.add(password);
		password.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.noContainChinese(password.getText())) {
            		checkPass.setText("密碼可使用");
            		checkPass.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass.setText("請輸入英文或數字且不可有空白");
        			checkPass.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.noContainChinese(password.getText())) {
            		checkPass.setText("密碼可使用");
            		checkPass.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass.setText("請輸入英文或數字且不可有空白");
        			checkPass.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.noContainChinese(password.getText())) {
            		checkPass.setText("密碼可使用");
            		checkPass.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass.setText("請輸入英文或數字且不可有空白");
        			checkPass.setForeground(new Color(200, 0, 0));
        		}
            }
        });
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		password.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("確認密碼：");
		lblNewLabel_4.setBounds(30, 259, 106, 33);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel checkPass2 = new JLabel("請再次輸入密碼");
		checkPass2.setBounds(146, 290, 224, 22);
		panel_1.add(checkPass2);
		checkPass2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		
		checkPassword = new JTextField();
		checkPassword.setBounds(146, 259, 224, 32);
		panel_1.add(checkPassword);
		checkPassword.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.checkPassword(password.getText(),checkPassword.getText())) {
            		checkPass2.setText("密碼正確");
            		checkPass2.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass2.setText("與密碼不同");
        			checkPass2.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.checkPassword(password.getText(),checkPassword.getText())) {
            		checkPass2.setText("密碼正確");
            		checkPass2.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass2.setText("與密碼不同");
        			checkPass2.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.checkPassword(password.getText(),checkPassword.getText())) {
            		checkPass2.setText("密碼正確");
            		checkPass2.setForeground(new Color(0, 160, 0));
        			
        		}else {
        			checkPass2.setText("與密碼不同");
        			checkPass2.setForeground(new Color(200, 0, 0));
        		}
            }
        });
		checkPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		checkPassword.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("電話：");
		lblNewLabel_5.setBounds(441, 33, 95, 33);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JLabel lblNewLabel_9_2 = new JLabel("格式範例：0987654321");
		lblNewLabel_9_2.setBounds(546, 62, 224, 22);
		panel_1.add(lblNewLabel_9_2);
		lblNewLabel_9_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_9_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		
		JLabel checkPhone = new JLabel("");
		checkPhone.setBounds(771, 38, 89, 22);
		panel_1.add(checkPhone);
		checkPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		
		phone = new JTextField();
		phone.setBounds(546, 33, 224, 32);
		panel_1.add(phone);
		phone.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.phoneIsNumber(phone.getText())) {
            		checkPhone.setText("格式正確");
            		checkPhone.setForeground(new Color(0, 160, 0));
        		}else {
        			checkPhone.setText("格式錯誤");
        			checkPhone.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.phoneIsNumber(phone.getText())) {
            		checkPhone.setText("格式正確");
            		checkPhone.setForeground(new Color(0, 160, 0));
        		}else {
        			checkPhone.setText("格式錯誤");
        			checkPhone.setForeground(new Color(200, 0, 0));
        		}
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
            	if(CheckWord.phoneIsNumber(phone.getText())) {
            		checkPhone.setText("格式正確");
            		checkPhone.setForeground(new Color(0, 160, 0));
        		}else {
        			checkPhone.setText("格式錯誤");
        			checkPhone.setForeground(new Color(200, 0, 0));
        		}
            }
        });
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		phone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("學校：");
		lblNewLabel_6.setBounds(441, 106, 95, 33);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		school = new JTextField();
		school.setBounds(546, 106, 224, 32);
		panel_1.add(school);
		school.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		school.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("性別：");
		lblNewLabel_8.setBounds(441, 180, 95, 33);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		JComboBox<String> gender = new JComboBox<String>();
		gender.setBounds(546, 180, 224, 33);
		panel_1.add(gender);
		gender.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		
		
		JButton teacherLoginButton = new JButton("註冊");
		teacherLoginButton.setBackground(new Color(249, 221, 91));
		teacherLoginButton.setBounds(468, 343, 190, 49);
		panel_1.add(teacherLoginButton);
		teacherLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String School = school.getText();
				String Name = name.getText();
				Integer Gender = gender.getSelectedIndex();
				String Username = username.getText();
				String Password = password.getText();
				String Phone = phone.getText();
				
				if(checkUsername.getText().equals("帳號可使用") &&
						checkPass.getText().equals("密碼可使用") &&
						checkPass2.getText().equals("密碼正確") &&
						checkPhone.getText().equals("格式正確") &&
						gender.getSelectedIndex()!=0) {
					Teacher t = new Teacher(School, Name, Gender, Username, Password, Phone);
					new TeacherDaoImpl().add(t);
					JOptionPane.showMessageDialog(null, "註冊成功！請重新登入");
					LoginUI lUI = new LoginUI();
					lUI.setVisible(true);
					lUI.setLocationRelativeTo(null);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "請再次確認填寫的資料皆正確");
				}			
			}
		});
		teacherLoginButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		
		JButton teacherLoginButton_1 = new JButton("←返回登入頁");
		teacherLoginButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		teacherLoginButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		teacherLoginButton_1.setBackground(new Color(249, 221, 91));
		teacherLoginButton_1.setBounds(242, 343, 190, 49);
		panel_1.add(teacherLoginButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(515, 55, 235, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("＜教師註冊＞");
		lblNewLabel_1.setBounds(7, 8, 220, 41);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		gender.addItem("--選擇性別--");
		gender.addItem("男");
		gender.addItem("女");
		

		


		

	}
}
