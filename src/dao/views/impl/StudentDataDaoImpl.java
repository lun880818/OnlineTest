package dao.views.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.views.StudentDataDao;
import model.views.StudentData;

public class StudentDataDaoImpl implements StudentDataDao{

	public static void main(String[] args) {
		//test selectAll
//		List<StudentData> l = new StudentDataDaoImpl().selectAll();
//		System.out.println(l);
		
		//test selectBySchool
//		List<StudentData> l = new StudentDataDaoImpl().selectBySchool("school2");
//		System.out.println(l);
		
		//test selectByGrade
//		List<StudentData> l = new StudentDataDaoImpl().selectByGrade("5年級");
//		System.out.println(l);
		
		//test selectBySchoolAndGrade
//		List<StudentData> l = new StudentDataDaoImpl().selectBySchoolAndGrade("school4","5年級");
//		System.out.println(l);
		
		//test selectByTeacherNo
//		List<StudentData> l = new StudentDataDaoImpl().selectByTeacherNo("t005");
//		System.out.println(l);
		
		//test queryUsername
//		List<StudentData> l = new StudentDataDaoImpl().queryUsername("student1");
//		System.out.println(l);
		
		//teat queryLogin
//		List<StudentData> l = new StudentDataDaoImpl().queryLogin("student1","1234");
//		System.out.println(l);
		
		//test queryByStudentNoAndPhone
//		List<StudentData> l = new StudentDataDaoImpl().queryByStudentNoAndPhone("s001","0912345678");
//		System.out.println(l);

	}
	
	@Override
	public List<StudentData> selectByTeacherNo(String teacherNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from StudentData where teacherNo=?";
		List<StudentData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, teacherNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentData sd = new StudentData();
				sd.setStudentNo(rs.getString("studentNo"));
				sd.setSchool(rs.getString("school"));
				sd.setGrade(rs.getString("grade"));
				sd.setName(rs.getString("name"));
				sd.setGender(rs.getString("gender"));
				sd.setUsername(rs.getString("username"));
				sd.setPassword(rs.getString("password"));
				sd.setPhone(rs.getString("phone"));
				sd.setTeacherNo(rs.getString("teacherNo"));
				sd.setTeacherName(rs.getString("teacherName"));
				
				l.add(sd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public StudentData selectByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from StudentData where studentNo=?";
		StudentData sd = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sd = new StudentData();
				sd.setStudentNo(rs.getString("studentNo"));
				sd.setSchool(rs.getString("school"));
				sd.setGrade(rs.getString("grade"));
				sd.setName(rs.getString("name"));
				sd.setGender(rs.getString("gender"));
				sd.setUsername(rs.getString("username"));
				sd.setPassword(rs.getString("password"));
				sd.setPhone(rs.getString("phone"));
				sd.setTeacherNo(rs.getString("teacherNo"));
				sd.setTeacherName(rs.getString("teacherName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sd;
	}

//	@Override
//	public List<StudentData> selectAll() {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	@Override
//	public List<StudentData> selectBySchool(String school) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where school=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, school);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	@Override
//	public List<StudentData> selectByGrade(String grade) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where grade=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, grade);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	@Override
//	public List<StudentData> selectBySchoolAndGrade(String school, String grade) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where school=? and grade=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, school);
//			ps.setString(2, grade);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	
//
//	@Override
//	public List<StudentData> queryUsername(String username) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where username=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	@Override
//	public List<StudentData> queryLogin(String username, String password) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where username=? and password=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, username);
//			ps.setString(2, password);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}
//
//	@Override
//	public List<StudentData> queryByStudentNoAndPhone(String studentNo, String phone) {
//		Connection conn = DbConnection.getDb();
//		String SQL ="select * from StudentData where studentNo=? and phone=?";
//		List<StudentData> l = new ArrayList<>();
//		try {
//			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, studentNo);
//			ps.setString(2, phone);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				StudentData sd = new StudentData();
//				sd.setStudentNo(rs.getString("studentNo"));
//				sd.setSchool(rs.getString("school"));
//				sd.setGrade(rs.getString("grade"));
//				sd.setName(rs.getString("name"));
//				sd.setGender(rs.getString("gender"));
//				sd.setUsername(rs.getString("username"));
//				sd.setPassword(rs.getString("password"));
//				sd.setPhone(rs.getString("phone"));
//				sd.setTeacherNo(rs.getString("teacherNo"));
//				sd.setTeacherName(rs.getString("teacherName"));
//				
//				l.add(sd);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return l;
//	}

}
