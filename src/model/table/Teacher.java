package model.table;

import java.io.Serializable;

public class Teacher implements Serializable{
	private Integer id;
	private String teacherNo;
	private String school;
	private String name;
	private Integer gender;
	private String username;
	private String password;
	private String phone;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String school, String name, Integer gender, String username, String password,
			String phone) {
		super();
		this.school = school;
		this.name = name;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
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