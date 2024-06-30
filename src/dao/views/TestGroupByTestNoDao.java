package dao.views;

import java.util.List;

import model.views.TestGroupByTestNo;

public interface TestGroupByTestNoDao {
	//R
	List<TestGroupByTestNo> selectAll();
	List<TestGroupByTestNo> selectByStudentNo(String studentNo);
	List<TestGroupByTestNo> haveNotDoneTest(String studentNo);

}
