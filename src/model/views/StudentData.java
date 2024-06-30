package model.views;

import java.io.Serializable;

public class StudentData implements Serializable{
	private String studentNo;
	private String school;
	private String grade;
	private String name;
	private String gender;
	private String username;
	private String password;
	private String phone;
	private String teacherNo;
	private String teacherName;
	
	public StudentData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentData(String studentNo, String school, String grade, String name, String gender, String username,
			String password, String phone, String teacherNo, String teacherName) {
		super();
		this.studentNo = studentNo;
		this.school = school;
		this.grade = grade;
		this.name = name;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
	}

	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}



}
