package dao.views;

import java.util.List;

import model.views.TestResultGroupByTestNo;

public interface TestResultGroupByTestNoDao {
	List<TestResultGroupByTestNo> selectAll();
	List<TestResultGroupByTestNo> selectByTestNo(String TestNo);//老師尋找學生有沒有做考卷用
	List<TestResultGroupByTestNo> selectByStudentNo(String studentNo);//學生查成績用的
	
}
