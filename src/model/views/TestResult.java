package model.views;

import java.time.LocalDateTime;

public class TestResult {
	private String testNo;
	private String teacherNo;
	private String studentNo;
	private String suject;
	private Integer questionOrder;
	private String questionNo;
	private String topic;
	private String correctAnswer;
	private String answer;
	private Integer eachScore;
	private Integer score;
	private LocalDateTime answerTime;
	public TestResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestResult(String testNo, String teacherNo, String studentNo, String suject, Integer questionOrder,
			String questionNo, String topic, String correctAnswer, String answer, Integer eachScore, Integer score,
			LocalDateTime answerTime) {
		super();
		this.testNo = testNo;
		this.teacherNo = teacherNo;
		this.studentNo = studentNo;
		this.suject = suject;
		this.questionOrder = questionOrder;
		this.questionNo = questionNo;
		this.topic = topic;
		this.correctAnswer = correctAnswer;
		this.answer = answer;
		this.eachScore = eachScore;
		this.score = score;
		this.answerTime = answerTime;
	}
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Integer getEachScore() {
		return eachScore;
	}
	public void setEachScore(Integer eachScore) {
		this.eachScore = eachScore;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public LocalDateTime getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(LocalDateTime answerTime) {
		this.answerTime = answerTime;
	}

	
		

}
