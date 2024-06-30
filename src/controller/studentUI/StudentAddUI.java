package controller.studentUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.table.impl.StudentDaoImpl;
import dao.table.impl.StudentToTeacherDaoImpl;
import dao.table.impl.TeacherDaoImpl;
import model.table.Student;
import model.table.StudentToTeacher;
import model.table.Teacher;
import util.CheckWord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.LoginUI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentAddUI extends JFrame {

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
					StudentAddUI frame = new StudentAddUI();
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
	public StudentAddUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_學生註冊");
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
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(222, 51, 821, 58);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("＜學生註冊＞");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel_1.setBounds(300, 8, 220, 41);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(222, 119, 821, 487);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 801, 467);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 27, 106, 33);
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		name.setColumns(10);
		name.setBounds(126, 27, 224, 32);
		panel.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("帳號：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(21, 100, 106, 33);
		panel.add(lblNewLabel_2);
		
		JLabel checkUsername = new JLabel("");
		checkUsername.setText("請輸入英文或數字且不可有空白");
		checkUsername.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkUsername.setForeground(new Color(0, 0, 0));
		checkUsername.setBounds(126, 132, 224, 22);
		panel.add(checkUsername);
		
		username = new JTextField();
		username.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
            	Student SUsername = new StudentDaoImpl().queryUsername(username.getText());
            	if(SUsername==null) {
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
            	Student SUsername = new StudentDaoImpl().queryUsername(username.getText());
            	if(SUsername==null) {
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
            	Student SUsername = new StudentDaoImpl().queryUsername(username.getText());
            	if(SUsername==null) {
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
		username.setBounds(126, 100, 224, 32);
		panel.add(username);
		
		JLabel lblNewLabel_3 = new JLabel("密碼：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(21, 174, 106, 33);
		panel.add(lblNewLabel_3);
		
		JLabel checkPass = new JLabel("請輸入英文或數字且不可有空白");
		checkPass.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPass.setForeground(new Color(0, 0, 0));
		checkPass.setBounds(126, 206, 224, 22);
		panel.add(checkPass);
		
		password = new JTextField();
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
		password.setBounds(126, 174, 224, 32);
		panel.add(password);
		
		JLabel lblNewLabel_4 = new JLabel("確認密碼：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_4.setBounds(21, 253, 106, 33);
		panel.add(lblNewLabel_4);
		
		JLabel checkPass2 = new JLabel("請再次輸入密碼");
		checkPass2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPass2.setBounds(126, 284, 224, 22);
		panel.add(checkPass2);
		
		checkPassword = new JTextField();
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
		checkPassword.setBounds(126, 253, 224, 32);
		panel.add(checkPassword);
		
		JLabel lblNewLabel_5 = new JLabel("電話：");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_5.setBounds(417, 27, 95, 33);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_9_2 = new JLabel("格式範例：0987654321");
		lblNewLabel_9_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_9_2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_9_2.setBounds(511, 56, 224, 22);
		panel.add(lblNewLabel_9_2);
		
		JLabel checkPhone = new JLabel("");
		checkPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPhone.setBounds(669, 56, 89, 22);
		panel.add(checkPhone);
		
		phone = new JTextField();
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
		phone.setBounds(511, 27, 224, 32);
		panel.add(phone);
		
		JLabel lblNewLabel_6 = new JLabel("學校：");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_6.setBounds(417, 100, 95, 33);
		panel.add(lblNewLabel_6);
		
		school = new JTextField();
		school.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		school.setColumns(10);
		school.setBounds(511, 100, 224, 32);
		panel.add(school);
		
		JLabel lblNewLabel_7 = new JLabel("年級：");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_7.setBounds(417, 174, 95, 33);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("性別：");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_8.setBounds(417, 253, 95, 33);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_1 = new JLabel("你的老師：");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_8_1.setBounds(349, 330, 164, 33);
		panel.add(lblNewLabel_8_1);
		
		JComboBox<String> teacherNo = new JComboBox<String>();
		teacherNo.setBackground(new Color(255, 255, 255));
		teacherNo.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		teacherNo.setBounds(512, 330, 224, 33);
		panel.add(teacherNo);
		teacherNo.addItem("--選擇老師--");
		teacherNo.setSelectedIndex(0);
		
		//讀出所有老師清單並放入ComboBox
		List<Teacher> l = new TeacherDaoImpl().selectAll();
		Teacher[] t = l.toArray(new Teacher[l.size()]);
		for(Teacher a:t) {
			teacherNo.addItem(a.getName()+"("+a.getTeacherNo()+")");
		}
		
		JComboBox<String> gender = new JComboBox<String>();
		gender.setBackground(new Color(255, 255, 255));
		gender.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		gender.setBounds(511, 253, 224, 33);
		panel.add(gender);
		gender.addItem("--選擇性別--");
		gender.addItem("男");
		gender.addItem("女");
		
		
		JComboBox<String> grade = new JComboBox<String>();
		grade.setBackground(new Color(255, 255, 255));
		grade.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		grade.setBounds(511, 174, 224, 33);
		panel.add(grade);
		grade.addItem("--選擇年級--");
		grade.addItem("一年級");
		grade.addItem("二年級");
		grade.addItem("三年級");
		grade.addItem("四年級");
		grade.addItem("五年級");
		grade.addItem("六年級");
		
		
		JButton studentLoginButton = new JButton("註冊");
		studentLoginButton.setBackground(new Color(253, 230, 15));
		studentLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String School = school.getText();
				Integer Grade = grade.getSelectedIndex();
				String Name = name.getText();
				Integer Gender = gender.getSelectedIndex();
				String Username = username.getText();
				String Password = password.getText();
				String Phone = phone.getText();
				
				if(checkUsername.getText().equals("帳號可使用") &&
						checkPass.getText().equals("密碼可使用") &&
						checkPass2.getText().equals("密碼正確") &&
						checkPhone.getText().equals("格式正確") &&
						grade.getSelectedIndex()!=0 &&
						gender.getSelectedIndex()!=0 &&
						teacherNo.getSelectedIndex()!=0) {
					int reply = JOptionPane.showConfirmDialog(null, "確定註冊嗎?","確認視窗",JOptionPane.YES_NO_OPTION);
	        		if(reply==JOptionPane.YES_NO_OPTION) {
	        			Student s = new Student(School, Grade, Name, Gender, Username, Password, Phone);
						new StudentDaoImpl().add(s);
						Student newS = new StudentDaoImpl().queryUsername(Username);
						StudentToTeacher stt = new StudentToTeacher(newS.getStudentNo(),t[teacherNo.getSelectedIndex()-1].getTeacherNo());
						new StudentToTeacherDaoImpl().add(stt);
						JOptionPane.showMessageDialog(null, "註冊成功！請重新登入");
						LoginUI lUI = new LoginUI();
						lUI.setVisible(true);
						lUI.setLocationRelativeTo(null);
						dispose();
	        		}
				}else {
					JOptionPane.showMessageDialog(null, "請再次確認填寫的資料皆正確");
				}			
			}
		});
		studentLoginButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		studentLoginButton.setBounds(444, 396, 218, 49);
		panel.add(studentLoginButton);
		
		JButton studentLoginButton_1 = new JButton("←返回登入頁");
		studentLoginButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				l.setLocationRelativeTo(null);
				dispose();
			}
		});
		studentLoginButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		studentLoginButton_1.setBackground(new Color(253, 230, 15));
		studentLoginButton_1.setBounds(161, 396, 218, 49);
		panel.add(studentLoginButton_1);
		
	}
}
