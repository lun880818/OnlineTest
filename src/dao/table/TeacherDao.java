package dao.table;


import java.util.List;

import model.table.Teacher;

public interface TeacherDao {
	//C
	void add(Teacher t);
	
	//R
	Teacher selectByTeacherNo(String teacherNo);
	Teacher queryLogin(String username, String password);
	Teacher queryUsername(String username);
	List<Teacher> selectAll();
	Teacher forgetPassword(String username, String phone);
	
	//U
	void update(Teacher t);
	
	//D
	void deleteByTeacherNo(String teacherNo);
	
}
