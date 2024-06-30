package model.views;


public class TestResultGroupByTestNo {
	private String testNo;
	private String teacherNo;
	private String studentNo;
	private String suject;
	private Integer studentScoreSum;
	private Integer testTotalScore;
	private String answerTime;

	public TestResultGroupByTestNo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestResultGroupByTestNo(String testNo, String teacherNo, String studentNo, String suject,
			Integer studentScoreSum, Integer testTotalScore, String answerTime) {
		super();
		this.testNo = testNo;
		this.teacherNo = teacherNo;
		this.studentNo = studentNo;
		this.suject = suject;
		this.studentScoreSum = studentScoreSum;
		this.testTotalScore = testTotalScore;
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
	public Integer getStudentScoreSum() {
		return studentScoreSum;
	}
	public void setStudentScoreSum(Integer studentScoreSum) {
		this.studentScoreSum = studentScoreSum;
	}
	public Integer getTestTotalScore() {
		return testTotalScore;
	}
	public void setTestTotalScore(Integer testTotalScore) {
		this.testTotalScore = testTotalScore;
	}
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	

}
