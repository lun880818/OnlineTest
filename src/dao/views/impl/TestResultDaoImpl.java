package dao.views.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.views.TestResultDao;
import model.views.TestResult;

public class TestResultDaoImpl implements TestResultDao{

	public static void main(String[] args) {
		//test selectAll
//		List<TestResult> l = new TestResultDaoImpl().selectAll();
//		System.out.println(l);
		
		//test selectByTestNo
//		List<TestResult> l = new TestResultDaoImpl().selectByTestNo("MT0001");
//		System.out.println(l);
		
		//test selectByTeacherNo
//		List<TestResult> l = new TestResultDaoImpl().selectByTeacherNo("t001");
//		System.out.println(l);
		
		//test selectByStudentNo
		List<TestResult> l = new TestResultDaoImpl().selectByStudentNo("s002");
		System.out.println(l);
		
		

	}

	@Override
	public List<TestResult> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResult";
		List<TestResult> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResult t = new TestResult();
				t.setTestNo(rs.getString("testNo"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setTopic(rs.getString("topic"));
				t.setCorrectAnswer(rs.getString("correctAnswer"));
				t.setAnswer(rs.getString("answer"));
				t.setEachScore(rs.getInt("eachScore"));
				t.setScore(rs.getInt("score"));
				t.setAnswerTime(rs.getTimestamp("answerTime").toLocalDateTime());
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestResult> selectByTestNo(String testNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResult where testNo=?";
		List<TestResult> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResult t = new TestResult();
				t.setTestNo(rs.getString("testNo"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setTopic(rs.getString("topic"));
				t.setCorrectAnswer(rs.getString("correctAnswer"));
				t.setAnswer(rs.getString("answer"));
				t.setEachScore(rs.getInt("eachScore"));
				t.setScore(rs.getInt("score"));
				t.setAnswerTime(rs.getTimestamp("answerTime").toLocalDateTime());
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestResult> selectByTeacherNo(String teacherNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResult where teacherNo=?";
		List<TestResult> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, teacherNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResult t = new TestResult();
				t.setTestNo(rs.getString("testNo"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setTopic(rs.getString("topic"));
				t.setCorrectAnswer(rs.getString("correctAnswer"));
				t.setAnswer(rs.getString("answer"));
				t.setEachScore(rs.getInt("eachScore"));
				t.setScore(rs.getInt("score"));
				t.setAnswerTime(rs.getTimestamp("answerTime").toLocalDateTime());
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestResult> selectByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResult where studentNo=?";
		List<TestResult> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResult t = new TestResult();
				t.setTestNo(rs.getString("testNo"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionOrder(rs.getInt("questionOrder"));
				t.setQuestionNo(rs.getString("questionNo"));
				t.setTopic(rs.getString("topic"));
				t.setCorrectAnswer(rs.getString("correctAnswer"));
				t.setAnswer(rs.getString("answer"));
				t.setEachScore(rs.getInt("eachScore"));
				t.setScore(rs.getInt("score"));
				t.setAnswerTime(rs.getTimestamp("answerTime").toLocalDateTime());
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
