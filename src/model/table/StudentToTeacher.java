package model.table;

public class StudentToTeacher {
	private Integer id;
	private String studentNo;
	private String teacherNo;
	public StudentToTeacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentToTeacher(String studentNo, String teacherNo) {
		super();
		this.studentNo = studentNo;
		this.teacherNo = teacherNo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	
}
