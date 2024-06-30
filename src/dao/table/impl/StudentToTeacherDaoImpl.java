package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbConnection;
import dao.table.StudentToTeacherDao;
import model.table.StudentToTeacher;

public class StudentToTeacherDaoImpl implements StudentToTeacherDao{

	public static void main(String[] args) {
		//test add
//		StudentToTeacher s = new StudentToTeacher("s006","t002");
//		new StudentToTeacherDaoImpl().add(s);
		
		//test selectByStudentNo
//		StudentToTeacher s = new StudentToTeacherDaoImpl().selectByStudentNo("s001");
//		System.out.println(s.getTeacherNo());
		
		//test update
//		StudentToTeacher s = new StudentToTeacherDaoImpl().selectByStudentNo("s006");
//		s.setTeacherNo("t003");
//		new StudentToTeacherDaoImpl().update(s);
		
		//test delete
		new StudentToTeacherDaoImpl().deleteByStudentNo("s006");

	}

	@Override
	public void add(StudentToTeacher stt) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into StudentToTeacher(studentno, teacherNo) "
				+ "values(?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, stt.getStudentNo());
			ps.setString(2, stt.getTeacherNo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public StudentToTeacher selectByStudentNo(String StudentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from StudentToTeacher where studentNo=?";
		StudentToTeacher s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, StudentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new StudentToTeacher();
				s.setId(rs.getInt("id"));
				s.setStudentNo(rs.getString("studentno"));
				s.setTeacherNo(rs.getString("teacherNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public void update(StudentToTeacher stt) {
		Connection conn = DbConnection.getDb();
		String SQL = "update StudentToTeacher set teacherNo=? "
				+ "where studentno=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, stt.getTeacherNo());
			ps.setString(2, stt.getStudentNo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from StudentToTeacher where studentNo=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
