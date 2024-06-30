package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.table.TestDao;
import model.table.Test;

public class TestDaoImpl implements TestDao{

	public static void main(String[] args) {
		//test add
//		Test t = new Test("MT0003",1,1,"M005",100,"t002","s003");
//		new TestDaoImpl().add(t);
		
		//test selectByTestNoList
//		List<Test> t = new TestDaoImpl().selectByTestNoList("MT0001");
//		System.out.println(t);
		
		//test update
//		Test t = new TestDaoImpl().selectByTestNo("MT0003");
//		t.setQuestionOrder(2);
//		t.setQuestionNo("M004");
//		t.setEachScore(50);
//		t.setTeacherNo("t003");
//		t.setStudentNo("s001");
//		new TestDaoImpl().update(t);
		
		//test deleteBytestNo
		new TestDaoImpl().deleteByTestNo("123");
		
		//test queryByStudentNo
//		List<Test> t = new TestDaoImpl().queryByStudentNo("s003");
//		for(Test a:t) {
//			System.out.println(a.getTestNo());
//		}

	}

	@Override
	public void add(Test t) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into Test(testno, suject, questionOrder, questionNo, eachScore, teacherNo, studentNo) "
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, t.getTestNo());
			ps.setInt(2, t.getSuject());
			ps.setInt(3, t.getQuestionOrder());
			ps.setString(4, t.getQuestionNo());
			ps.setInt(5, t.getEachScore());
			ps.setString(6, t.getTeacherNo());
			ps.setString(7, t.getStudentNo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Test selectByTestNo(String testNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from Test where testNo=?";
		Test t = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Test();
				t.setId(rs.getInt("id"));
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getInt("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setEachScore(rs.getInt("eachscore"));				
				t.setTeacherNo(rs.getString("teacherno"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getTimestamp("time").toLocalDateTime());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public List<Test> selectByTestNoList(String testNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from Test where testNo=?";
		List<Test> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Test t = new Test();
				t.setId(rs.getInt("id"));
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getInt("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setEachScore(rs.getInt("eachscore"));				
				t.setTeacherNo(rs.getString("teacherno"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getTimestamp("time").toLocalDateTime());
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public List<Test> queryByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from Test where studentNo=?";
		List<Test> st = new ArrayList<Test>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Test t = new Test();
				t.setId(rs.getInt("id"));
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getInt("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setEachScore(rs.getInt("eachscore"));				
				t.setTeacherNo(rs.getString("teacherno"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getTimestamp("time").toLocalDateTime());
				
				st.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return st;
	}

	@Override
	public void update(Test t) {
		Connection conn = DbConnection.getDb();
		String SQL = "update Test set suject=?, questionOrder=?, questionNo=?, eachScore=?, teacherNo=?, studentNo=?, time=? where testno=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, t.getSuject());
			ps.setInt(2, t.getQuestionOrder());
			ps.setString(3, t.getQuestionNo());
			ps.setInt(4, t.getEachScore());
			ps.setString(5, t.getTeacherNo());
			ps.setString(6, t.getStudentNo());
			ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
			ps.setString(8, t.getTestNo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByTestNo(String testNo) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from test where testNo=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}





}
