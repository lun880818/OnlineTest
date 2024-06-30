package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbConnection;
import dao.table.StudentDao;
import model.table.Student;

public class StudentDaoImpl implements StudentDao{

	public static void main(String[] args) {
		// test add()
		Student s = new Student("school4",1,"student7",2,"s777","123","0912345678");
		new StudentDaoImpl().add(s);
		
		//test selectByStudentNo
//		Student s =new StudentDaoImpl().selectByStudentNo("s005");
//		System.out.println(s.getName());
		
		//test update
//		Student s =new StudentDaoImpl().selectByStudentNo("s006");
//		s.setSchool("schoolABC");
//		s.setGrade(6);
//		s.setName("s6666");
//		s.setGender(1);
//		s.setPassword("000");
//		s.setPhone("0987654321");
//		new StudentDaoImpl().update(s);
//		System.out.println(s.getName()+"\t"+s.getGender()+"\t"+s.getPassword()+"\t"+s.getGrade());
		
		//test deleteByStudentNo
//		new StudentDaoImpl().deleteByStudentNo("s006");
		
	}

	@Override
	public void add(Student s) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "insert into student(studentno, school, grade, name, gender, username, password, phone) "
				+ "values(?,?,?,?,?,?,?,?)";
		/*流水號*/
		Student sq =null;
		Integer count=0;
		String studentNo="";
		do{
			count++;
			String no = String.format("%04d", count);
			studentNo = "s"+ no;
			sq = new StudentDaoImpl().selectByStudentNo(studentNo);
		}while(sq!=null);

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ps.setString(2, s.getSchool());
			ps.setInt(3, s.getGrade());
			ps.setString(4, s.getName());
			ps.setInt(5, s.getGender());
			ps.setString(6, s.getUsername());
			ps.setString(7, s.getPassword());
			ps.setString(8, s.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public Student selectByStudentNo(String studentNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from student where studentNo=?";
		Student s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, studentNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setStudentNo(rs.getString("studentno"));
				s.setSchool(rs.getString("school"));
				s.setGrade(rs.getInt("grade"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getInt("gender"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	@Override
	public Student queryLogin(String username, String password) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from student where username=? and password=?";
		Student s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setStudentNo(rs.getString("studentno"));
				s.setSchool(rs.getString("school"));
				s.setGrade(rs.getInt("grade"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getInt("gender"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	@Override
	public Student queryUsername(String username) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from student where username=?";
		Student s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setStudentNo(rs.getString("studentno"));
				s.setSchool(rs.getString("school"));
				s.setGrade(rs.getInt("grade"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getInt("gender"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	
	@Override
	public Student forgetPassword(String username, String phone) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from student where username=? and phone=?";
		Student s = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, phone);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setStudentNo(rs.getString("studentno"));
				s.setSchool(rs.getString("school"));
				s.setGrade(rs.getInt("grade"));
				s.setName(rs.getString("name"));
				s.setGender(rs.getInt("gender"));
				s.setUsername(rs.getString("username"));
				s.setPassword(rs.getString("password"));
				s.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
	

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "update student set school=?, grade=?, name=?, gender=?, password=?, phone=? "
				+ "where studentno=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, s.getSchool());
			ps.setInt(2, s.getGrade());
			ps.setString(3, s.getName());
			ps.setInt(4, s.getGender());
			ps.setString(5, s.getPassword());
			ps.setString(6, s.getPhone());
			ps.setString(7, s.getStudentNo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByStudentNo(String studentNo) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "delete from student where studentNo=?";
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
