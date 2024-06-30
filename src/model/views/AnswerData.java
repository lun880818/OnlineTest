package model.views;

public class AnswerData {
	private Integer id;
	private String testNo;
	private Integer questionOrder;
	private String answer;
	public AnswerData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerData(Integer id, String testNo, Integer questionOrder, String answer) {
		super();
		this.id = id;
		this.testNo = testNo;
		this.questionOrder = questionOrder;
		this.answer = answer;
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
	public Integer getQuestionOrder() {
		return questionOrder;
	}
	public void setQuestionOrder(Integer questionOrder) {
		this.questionOrder = questionOrder;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
