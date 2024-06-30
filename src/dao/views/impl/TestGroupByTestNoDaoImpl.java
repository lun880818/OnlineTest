package dao.views.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.views.TestGroupByTestNoDao;
import model.views.TestGroupByTestNo;

public class TestGroupByTestNoDaoImpl implements TestGroupByTestNoDao{

	public static void main(String[] args) {
		//test selectAll
		List<TestGroupByTestNo> l = new TestGroupByTestNoDaoImpl().selectAll();
		TestGroupByTestNo[] t = l.toArray(new TestGroupByTestNo[l.size()]);
		for(TestGroupByTestNo a : t) {
			System.out.println(a.getTime());
		}
		
		//test haveNotDoneTest
//		List<TestGroupByTestNo> l = new TestGroupByTestNoDaoImpl().haveNotDoneTest("s0002");
//		for(TestGroupByTestNo a : l) {
//			System.out.println(a.getTestNo());
//		}
	}

	@Override
	public List<TestGroupByTestNo> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestGroupByTestNo";
		List<TestGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestGroupByTestNo t = new TestGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionSum(rs.getInt("questionSum"));
				t.setScoreSum(rs.getInt("scoreSum"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getString("teachertime"));
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public List<TestGroupByTestNo> selectByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestGroupByTestNo where studentNo=?";
		List<TestGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestGroupByTestNo t = new TestGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionSum(rs.getInt("questionSum"));
				t.setScoreSum(rs.getInt("scoreSum"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getString("teachertime"));
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<TestGroupByTestNo> haveNotDoneTest(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from TestGroupByTestNo where testNo not in "
				+ "(select testresultgroupbytestno.testNo from testresultgroupbytestno)"
				+ "and studentNo = ?";
		List<TestGroupByTestNo> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TestGroupByTestNo t = new TestGroupByTestNo();
				t.setTestNo(rs.getString("testNo"));
				t.setSuject(rs.getString("suject"));
				t.setQuestionSum(rs.getInt("questionSum"));
				t.setScoreSum(rs.getInt("scoreSum"));
				t.setTeacherNo(rs.getString("teacherNo"));
				t.setStudentNo(rs.getString("studentNo"));
				t.setTime(rs.getString("teachertime"));
				
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
