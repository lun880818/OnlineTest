package controller.studentUI;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.table.impl.AnswerDaoImpl;
import dao.table.impl.TestDaoImpl;
import dao.views.impl.QuestionAllDataDaoImpl;
import model.table.Answer;
import model.table.Test;
import model.views.QuestionAllData;
import model.views.TestGroupByTestNo;
import util.FileStream;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<JComboBox<String>> comboBoxes = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI frame = new TestUI();
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
	public TestUI() {
		setTitle("未知出版社_國小線上題庫暨測驗系統_考卷作答頁");
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
		panel_1.setBounds(511, 5, 243, 49);
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("＜開始作答＞");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(1, 1, 1254, 575);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		contentPane.add(panel, BorderLayout.CENTER);
		
		//讀取學生選哪一張考卷
		TestGroupByTestNo t = (TestGroupByTestNo)FileStream.readFile("selectTest.txt");
		String testNo = t.getTestNo();
		
		//用testNo調出有哪些questionNo
		List<Test> tdiL = new TestDaoImpl().selectByTestNoList(testNo);
		ArrayList<String> questionNos = new ArrayList<String>();
		for(Test a : tdiL) {
			questionNos.add(a.getQuestionNo());
		}
		
		//用questionNo從QuestionAll調出題目內容
		ArrayList<QuestionAllData> questions = new ArrayList<QuestionAllData>();
		for(String a : questionNos) {
			QuestionAllData qa = new QuestionAllDataDaoImpl().selectByQuestionNo(a);
			questions.add(qa);
		}
		
		//開始做panel
		/*
		 * 1.題號
		 * 2.題目
		 * 3.選項A、B、C、D & 其內容
		 * 4.ComboBox讓學生選擇=>會回傳int(getSelectIndex)
		 * 
		 */
		
		for(int i = 0; i<questions.size(); i++) {
			JPanel panelcontent = new JPanel();
	        panelcontent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelcontent.setPreferredSize(new Dimension(600, 300)); // 設置每個Panel的大小
	        panelcontent.setLayout(new BorderLayout());
	        panelcontent.setBackground(new Color(255, 255, 255));
	        
	        
	        //題目
	        JLabel titleLabel = new JLabel( "<html>"+ (i+1) + ". "+questions.get(i).getTopic()+"<html>");
	        titleLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
	        panelcontent.add(titleLabel, BorderLayout.NORTH);

	        //選項
	        JLabel optionLabel = new JLabel(
	        		"<html>" +
	        		"A. " + questions.get(i).getOptionA() +"<br>"+
	        		"B. " + questions.get(i).getOptionB() +"<br>"+
	        		"C. " + questions.get(i).getOptionC() +"<br>"+
	        		"D. " + questions.get(i).getOptionD()+"<html>");
	        optionLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
	        panelcontent.add(optionLabel, BorderLayout.CENTER);
	        
	        
	        
	        //ComboBox選項
	        JComboBox<String> option = new JComboBox<String>();
	        option.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
	        option.setSize(50, 30);
	        option.addItem("--選擇答案--");
	        option.addItem("A");
	        option.addItem("B");
	        option.addItem("C");
	        option.addItem("D");
	        
	        panelcontent.add(option, BorderLayout.SOUTH);
	        comboBoxes.add(option);

	        panel.add(panelcontent);
		}

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(5, 54, 1256, 577);
        contentPane.add(scrollPane);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(418, 631, 430, 47);
        panel_2.setBackground(new Color(255, 255, 255));
        contentPane.add(panel_2);
        
        JButton btnNewButton_1 = new JButton("　　回上一頁　　");
        btnNewButton_1.setBackground(new Color(249, 221, 91));
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		StudentTestListUI sui = new StudentTestListUI();
        		sui.setVisible(true);
        		sui.setLocationRelativeTo(null);
        		dispose();
        	}
        });
        btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        panel_2.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("　　　交卷　　　");
        btnNewButton.setBackground(new Color(249, 221, 91));
        btnNewButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int reply = JOptionPane.showConfirmDialog(null, "確定交卷嗎?","確認視窗",JOptionPane.YES_NO_OPTION);
        		if(reply==JOptionPane.YES_NO_OPTION) {
        			Answer answer = null;
            		boolean allAnswer = true;
            		for (int i = 0; i < comboBoxes.size(); i++) {
                    	int selectedIndex = comboBoxes.get(i).getSelectedIndex();
            			if(selectedIndex ==0) {
            				JOptionPane.showMessageDialog(null, "有題目尚未作答，請再次確認");
                        	allAnswer = false;
                        	break;
                        }
                    }
            		
            		if(allAnswer) {
            			for(int i = 0; i < comboBoxes.size(); i++) {
            				int selectedIndex = comboBoxes.get(i).getSelectedIndex();
            				answer = new Answer(testNo,i+1,selectedIndex);
                            new AnswerDaoImpl().add(answer);
            			}
                		TestResultUI tUI = new TestResultUI();
                		tUI.setVisible(true);
                		tUI.setLocationRelativeTo(null);
                		dispose();
            		}
        		}
        	}
        });
        btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
        panel_2.add(btnNewButton);
        


	}
	
	/*想法:
	 * 中間做一個scrollPane
	 * 塞考卷資料進panel裡
	 * 然後看有幾題就迴圈複製幾次&塞考卷資料
	 * 準備一個arrayList
	 * 學生有按答案的話，產出一個answer類型物件，丟進arrayList
	 * 下一個panel要算位置往下放
	 * 
	 * 最後有個按鈕，要蒐集上面的答題資料(arrayList)做AnswerDaoImpl().add
	 * 
	 * 然後跳下一頁，可以看答題狀況，以及獲得的分數
	 * 按列印成績單/按回主選單
	 * 
	 * **上面不知道能不能固定一個panel放基本資料
	 * */
	

}
