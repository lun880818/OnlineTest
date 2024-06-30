package model.views;

import java.io.Serializable;

public class TestGroupByTestNo implements Serializable{
	private String testNo;
	private String suject;
	private Integer questionSum;
	private Integer scoreSum;
	private String teacherNo;
	private String studentNo;
	private String time;
	public TestGroupByTestNo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestGroupByTestNo(String testNo, String suject, Integer questionSum, Integer scoreSum, String teacherNo, String studentNo,
			String time) {
		super();
		this.testNo = testNo;
		this.questionSum = questionSum;
		this.scoreSum = scoreSum;
		this.teacherNo = teacherNo;
		this.studentNo = studentNo;
		this.time = time;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public Integer getQuestionSum() {
		return questionSum;
	}
	public void setQuestionSum(Integer questionSum) {
		this.questionSum = questionSum;
	}
	public Integer getScoreSum() {
		return scoreSum;
	}
	public void setScoreSum(Integer scoreSum) {
		this.scoreSum = scoreSum;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSuject() {
		return suject;
	}
	public void setSuject(String suject) {
		this.suject = suject;
	}
	
	

}
