package dao.table;

import model.table.Student;

public interface StudentDao {
	//C
	void add(Student s);	
	
	//R
	Student selectByStudentNo(String studentNo);
	Student queryLogin(String username, String password);
	Student queryUsername(String username);
	Student forgetPassword(String username, String phone);
	
	//U
	void update(Student s);
	
	
	//D
	void deleteByStudentNo(String studentNo);
	
	
	
}
