package dao.table;

import model.table.Answer;

public interface AnswerDao {
	//C
	void add(Answer answer);
	
	//R
	Answer selectByTestNoAndQuestionOrder(String testNo, Integer questionOrder);
	
	//U
	void update(Answer answer);
	
	//D
	void deleteBytestNoAndQuestionOrder(String testNo, Integer questionOrder);

}
