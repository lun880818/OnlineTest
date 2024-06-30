package dao.views;

import java.util.List;

import model.views.TestResult;

public interface TestResultDao {
	List<TestResult> selectAll();
	List<TestResult> selectByTestNo(String testNo);
	List<TestResult> selectByTeacherNo(String teacherNo);
	List<TestResult> selectByStudentNo(String studentNo);

}
