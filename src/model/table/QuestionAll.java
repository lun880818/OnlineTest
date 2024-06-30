package model.table;

public class QuestionAll {
	private Integer id;
	private String questionNo;
	private Integer suject;
	private Integer grade;
	private String topic;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Integer correctAnswer;
	public QuestionAll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionAll(String questionNo, Integer suject, Integer grade, String topic, String optionA, String optionB,
			String optionC, String optionD, Integer correctAnswer) {
		super();
		this.questionNo = questionNo;
		this.suject = suject;
		this.grade = grade;
		this.topic = topic;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctAnswer = correctAnswer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public Integer getSuject() {
		return suject;
	}
	public void setSuject(Integer suject) {
		this.suject = suject;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public Integer getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(Integer correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
}
