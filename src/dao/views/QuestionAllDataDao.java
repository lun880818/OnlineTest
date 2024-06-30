package dao.views;

import java.util.List;

import model.views.QuestionAllData;

public interface QuestionAllDataDao {
	//R
	List<QuestionAllData> selectAll();
	List<QuestionAllData> selectByID(int id);
	QuestionAllData selectByQuestionNo(String questionNo);
	List<QuestionAllData> selectBySuject(String suject);
	List<QuestionAllData> selectByGrade(String grade);
	List<QuestionAllData> selecteBySujectAndGrade(String suject, String grade);

}
