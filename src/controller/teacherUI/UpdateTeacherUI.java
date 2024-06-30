package controller.teacherUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.table.impl.TeacherDaoImpl;
import model.table.Teacher;
import util.CheckWord;
import util.FileStream;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UpdateTeacherUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField school;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField checkPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateTeacherUI frame = new UpdateTeacherUI();
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
	public UpdateTeacherUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_教師修改資料");
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
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setBounds(294, 132, 677, 458);
		panel_2_2.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_2_2);
		panel_2_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 10, 657, 438);
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_2_2.add(panel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\u771F\u5BE6\u59D3\u540D:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(20, 10, 114, 33);
		panel_3.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\u767B\u5165\u5E33\u865F:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(20, 103, 91, 33);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("\u884C\u52D5\u96FB\u8A71:");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1_1_1.setBounds(352, 10, 114, 33);
		panel_3.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("\u5B78\u6821:");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1_1_1_1.setBounds(352, 103, 114, 33);
		panel_3.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("\u5BC6\u78BC:");
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1_1_1_1_1.setBounds(20, 183, 59, 33);
		panel_3.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("\u6AA2\u67E5\u5BC6\u78BC:");
		lblNewLabel_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(20, 276, 114, 33);
		panel_3.add(lblNewLabel_2_1_1_1_1_1_1);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(20, 42, 285, 32);
		panel_3.add(name);
		
		school = new JTextField();
		school.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		school.setColumns(10);
		school.setBounds(352, 135, 285, 32);
		panel_3.add(school);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		username.setEditable(false);
		username.setColumns(10);
		username.setBounds(20, 135, 285, 32);
		panel_3.add(username);
		
		JLabel checkPass = new JLabel("請輸入英文或數字且不可有空白");
		checkPass.setHorizontalAlignment(SwingConstants.LEFT);
		checkPass.setForeground(Color.BLACK);
		checkPass.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPass.setBounds(20, 244, 285, 22);
		panel_3.add(checkPass);
		
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
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		password.setColumns(10);
		password.setBounds(20, 215, 285, 32);
		panel_3.add(password);
		
		JLabel checkPhone = new JLabel("");
		checkPhone.setHorizontalAlignment(SwingConstants.LEFT);
		checkPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPhone.setBounds(352, 71, 285, 22);
		panel_3.add(checkPhone);
		
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
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		phone.setColumns(10);
		phone.setBounds(352, 42, 285, 32);
		panel_3.add(phone);
		
		JLabel checkPass2 = new JLabel("請再次輸入密碼");
		checkPass2.setHorizontalAlignment(SwingConstants.LEFT);
		checkPass2.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		checkPass2.setBounds(20, 337, 285, 22);
		panel_3.add(checkPass2);
		
		checkPassword = new JTextField();
		checkPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
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
		checkPassword.setColumns(10);
		checkPassword.setBounds(20, 308, 285, 32);
		panel_3.add(checkPassword);
		
		JLabel lblNewLabel_8 = new JLabel("性別：");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_8.setBounds(352, 183, 72, 33);
		panel_3.add(lblNewLabel_8);
		
		JComboBox<String> gender = new JComboBox<String>();
		gender.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		gender.setBounds(352, 215, 285, 33);
		panel_3.add(gender);
		gender.addItem("男");
		gender.addItem("女");
		
		
		/*讀取教師資料*/
		Teacher t = (Teacher)FileStream.readFile("teacher.txt");
		name.setText(t.getName());
		school.setText(t.getSchool());
		username.setText(t.getUsername());
		password.setText(t.getPassword());
		phone.setText(t.getPhone());
		gender.setSelectedIndex(t.getGender()-1);
		
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("不可修改");
		lblNewLabel_2_1_1_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2_1_1_2.setBounds(98, 103, 91, 33);
		panel_3.add(lblNewLabel_2_1_1_2);
		
		
		/*修改按鈕*/
		JButton btnNewButton = new JButton("確認修改");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String School = school.getText();
				String Name = name.getText();
				Integer Gender = gender.getSelectedIndex()+1;
				String Password = password.getText();
				String Phone = phone.getText();

				if(checkPass.getText().equals("密碼可使用") &&
						checkPass2.getText().equals("密碼正確") &&
						checkPhone.getText().equals("格式正確")) {
					int reply = JOptionPane.showConfirmDialog(null, "確定修改嗎?","確認視窗",JOptionPane.YES_NO_OPTION);
	        		if(reply==JOptionPane.YES_NO_OPTION) {
	        			t.setSchool(School);
						t.setName(Name);
						t.setGender(Gender);
						t.setPassword(Password);
						t.setPhone(Phone);
						new TeacherDaoImpl().update(t);
						JOptionPane.showMessageDialog(null, "修改成功！請重新登入");
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
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton.setBackground(new Color(249, 221, 91));
		btnNewButton.setBounds(392, 391, 214, 37);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回主選單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TeacherSelectUI tui = new TeacherSelectUI();
				tui.setVisible(true);
				tui.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		btnNewButton_1.setBackground(new Color(249, 221, 91));
		btnNewButton_1.setBounds(60, 391, 214, 37);
		panel_3.add(btnNewButton_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(303, 47, 659, 62);
		contentPane.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("＜教師資料修改＞");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		lblNewLabel.setBounds(185, 10, 289, 41);
		panel_5.add(lblNewLabel);
	}
}
