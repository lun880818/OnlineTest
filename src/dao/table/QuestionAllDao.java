package dao.table;

import java.util.List;

import model.table.QuestionAll;

public interface QuestionAllDao {
	//C
	void add(QuestionAll q);
	
	//R
	QuestionAll selectByQuestionNo(String questionNo);
	List<QuestionAll> selectAll();
	
	//U
	void update(QuestionAll q);
	
	//D
	void deleteByQuestionNo(String questionNo);

}
