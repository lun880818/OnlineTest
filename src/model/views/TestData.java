package model.views;

import java.time.LocalDateTime;

public class TestData {
	private String testNo;
	private String suject;
	private Integer questionOrder;
	private String questionNo;
	private String correctAnswer;
	private Integer eachScore;
	private String teacherNo;
	private String teacherName;
	private String studentNo;
	private String studentName;
	private LocalDateTime time;
	public TestData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestData(String testNo, String suject, Integer questionOrder, String questionNo, String correctAnswer,
			Integer eachScore, String teacherNo, String teacherName, String studentNo, String studentName,
			LocalDateTime time) {
		super();
		this.testNo = testNo;
		this.suject = suject;
		this.questionOrder = questionOrder;
		this.questionNo = questionNo;
		this.correctAnswer = correctAnswer;
		this.eachScore = eachScore;
		this.teacherNo = teacherNo;
		this.teacherName = teacherName;
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.time = time;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public String getSuject() {
		return suject;
	}
	public void setSuject(String suject) {
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
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	

}
