package model.table;

import java.io.Serializable;

public class Answer implements Serializable{
	private Integer id;
	private String testNo;
	private Integer qustionOrder;
	private Integer answer;

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(String testNo, Integer qustionOrder, Integer answer) {
		super();
		this.testNo = testNo;
		this.qustionOrder = qustionOrder;
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

	public Integer getQustionOrder() {
		return qustionOrder;
	}

	public void setQustionOrder(Integer qustionOrder) {
		this.qustionOrder = qustionOrder;
	}

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	
	
	
}
