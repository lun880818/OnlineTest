package dao.views.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.views.TestResultGroupByTestNoDao;
import model.views.TestResultGroupByTestNo;

public class TestResultGroupByTestNoDaoImpl implements TestResultGroupByTestNoDao{

	public static void main(String[] args) {
		// test selectAll
		List<TestResultGroupByTestNo> l = new TestResultGroupByTestNoDaoImpl().selectAll();
		for(TestResultGroupByTestNo a : l) {
			System.out.println(a.getAnswerTime());
		}
		
		

	}

	@Override
	public List<TestResultGroupByTestNo> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResultGroupByTestNo";
		List<TestResultGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResultGroupByTestNo t = new TestResultGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setStudentScoreSum(rs.getInt("StudentScoreSum"));
				t.setTestTotalScore(rs.getInt("TestTotalScore"));
				t.setAnswerTime(rs.getString("answerTime"));
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestResultGroupByTestNo> selectByTestNo(String testNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResultGroupByTestNo where testNo=?";
		List<TestResultGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResultGroupByTestNo t = new TestResultGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setStudentScoreSum(rs.getInt("StudentScoreSum"));
				t.setTestTotalScore(rs.getInt("TestTotalScore"));
				t.setAnswerTime(rs.getString("answerTime"));
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestResultGroupByTestNo> selectByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestResultGroupByTestNo where studentNo=?";
		List<TestResultGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestResultGroupByTestNo t = new TestResultGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setStudentScoreSum(rs.getInt("StudentScoreSum"));
				t.setTestTotalScore(rs.getInt("TestTotalScore"));
				t.setAnswerTime(rs.getString("answerTime"));

				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	

}
