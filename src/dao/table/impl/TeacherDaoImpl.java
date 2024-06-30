package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.table.TeacherDao;
import model.table.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	public static void main(String[] args) {
		//test add()
//		Teacher t = new Teacher("school2", "teacher5",2,"teacher5","123","0912345678");
//		new TeacherDaoImpl().add(t);
		
		//test selectByTeacherNo
//		Teacher t =new TeacherDaoImpl().selectByTeacherNo("t006");
//		System.out.println(t);
		
		
		//test update
//		Teacher t =new TeacherDaoImpl().selectByTeacherNo("t005");
//		t.setSchool("school4");
//		t.setName("t555");
//		t.setGender(1);
//		t.setPassword("000");
//		t.setPhone("0987654321");
//		new TeacherDaoImpl().update(t);
//		System.out.println(t.getName()+"\t"+t.getGender()+"\t"+t.getPassword());
		
		//test deleteByTeacherNo
//		new TeacherDaoImpl().deleteByTeacherNo("t005");
		
		//test selectAll
		List<Teacher> l=new TeacherDaoImpl().selectAll();
		System.out.println(l);

	}

	@Override
	public void add(Teacher t) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into teacher(teacherno, school, name, gender, username, password, phone) "
				+ "values(?,?,?,?,?,?,?)";
		
		/*流水號*/
		Teacher tq =null;
		Integer count=0;
		String teacherNo="";
		do{
			count++;
			String no = String.format("%04d", count);
			teacherNo = "t"+ no;
			tq = new TeacherDaoImpl().selectByTeacherNo(teacherNo);
		}while(tq!=null);
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, teacherNo);
			ps.setString(2, t.getSchool());
			ps.setString(3, t.getName());
			ps.setInt(4, t.getGender());
			ps.setString(5, t.getUsername());
			ps.setString(6, t.getPassword());
			ps.setString(7, t.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public Teacher selectByTeacherNo(String teacherNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from teacher where teacherNo=?";
		Teacher t = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, teacherNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setTeacherNo(rs.getString("teacherno"));
				t.setSchool(rs.getString("school"));
				t.setName(rs.getString("name"));
				t.setGender(rs.getInt("gender"));
				t.setUsername(rs.getString("username"));
				t.setPassword(rs.getString("password"));
				t.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	@Override
	public Teacher queryLogin(String username, String password) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from teacher where username=? and password=?";
		Teacher t = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setTeacherNo(rs.getString("teacherno"));
				t.setSchool(rs.getString("school"));
				t.setName(rs.getString("name"));
				t.setGender(rs.getInt("gender"));
				t.setUsername(rs.getString("username"));
				t.setPassword(rs.getString("password"));
				t.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public Teacher queryUsername(String username) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from teacher where username=?";
		Teacher t = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setTeacherNo(rs.getString("teacherno"));
				t.setSchool(rs.getString("school"));
				t.setName(rs.getString("name"));
				t.setGender(rs.getInt("gender"));
				t.setUsername(rs.getString("username"));
				t.setPassword(rs.getString("password"));
				t.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	@Override
	public List<Teacher> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from teacher";
		List<Teacher> l=new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Teacher t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setTeacherNo(rs.getString("teacherno"));
				t.setSchool(rs.getString("school"));
				t.setName(rs.getString("name"));
				t.setGender(rs.getInt("gender"));
				t.setUsername(rs.getString("username"));
				t.setPassword(rs.getString("password"));
				t.setPhone(rs.getString("phone"));
				l.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	@Override
	public Teacher forgetPassword(String username, String phone) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from teacher where username=? and phone=?";
		Teacher t = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, phone);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt("id"));
				t.setTeacherNo(rs.getString("teacherno"));
				t.setSchool(rs.getString("school"));
				t.setName(rs.getString("name"));
				t.setGender(rs.getInt("gender"));
				t.setUsername(rs.getString("username"));
				t.setPassword(rs.getString("password"));
				t.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}

	@Override
	public void update(Teacher t) {
		Connection conn = DbConnection.getDb();
		String SQL = "update teacher set school=?, name=?, gender=?, password=?, phone=? where teacherno=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, t.getSchool());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getGender());
			ps.setString(4, t.getPassword());
			ps.setString(5, t.getPhone());
			ps.setString(6, t.getTeacherNo());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByTeacherNo(String teacherNo) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from teacher where teacherNo=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, teacherNo);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
