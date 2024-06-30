package model.views;

import java.io.Serializable;

public class TeacherData implements Serializable{
	private String teacherNo;
	private String school;
	private String name;
	private String gender;
	private String username;
	private String password;
	private String phone;
	public TeacherData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeacherData(String teacherNo, String school, String name, String gender, String username, String password,
			String phone) {
		super();
		this.teacherNo = teacherNo;
		this.school = school;
		this.name = name;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
