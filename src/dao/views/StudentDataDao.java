package dao.views;

import java.util.List;

import model.views.StudentData;

public interface StudentDataDao {
	//R
	List<StudentData> selectByTeacherNo(String teacherNo);
	StudentData selectByStudentNo(String studentNo);
//	List<StudentData> selectAll();
//	List<StudentData> selectBySchool(String school);
//	List<StudentData> selectByGrade(String grade);
//	List<StudentData> selectBySchoolAndGrade(String school, String grade);
//	//↓註冊確認帳號未重複↓
//	List<StudentData> queryUsername(String username);
//	//↓登入用↓
//	List<StudentData> queryLogin(String username, String password);
//	//↓忘記密碼用↓
//	List<StudentData> queryByStudentNoAndPhone(String studentNo, String phone);
	
	

}
