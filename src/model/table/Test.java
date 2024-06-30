package model.table;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Test implements Serializable{
	private Integer id;
	private String testNo;
	private Integer suject;
	private Integer questionOrder;
	private String questionNo;
	private Integer eachScore;
	private String teacherNo;
	private String studentNo;
	private LocalDateTime time;
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Test(String testNo, Integer suject, Integer questionOrder, String questionNo, Integer eachScore,
			String teacherNo, String studentNo) {
		super();
		this.testNo = testNo;
		this.suject = suject;
		this.questionOrder = questionOrder;
		this.questionNo = questionNo;
		this.eachScore = eachScore;
		this.teacherNo = teacherNo;
		this.studentNo = studentNo;
	}
	
	
	
	public Test(Integer suject) {
		super();
		this.suject = suject;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public Integer getSuject() {
		return suject;
	}
	public void setSuject(Integer suject) {
		this.suject = suject;
	}
	public Integer getQuestionOrder() {
		return questionOrder;
	}
	public void setQuestionOrder(Integer questionOrder) {
		this.questionOrder = questionOrder;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public Integer getEachScore() {
		return eachScore;
	}
	public void setEachScore(Integer eachScore) {
		this.eachScore = eachScore;
	}
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
}
