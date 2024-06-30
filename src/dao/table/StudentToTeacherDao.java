package dao.table;

import model.table.StudentToTeacher;

public interface StudentToTeacherDao {
	//C
	void add(StudentToTeacher stt);
	
	//R
	StudentToTeacher selectByStudentNo(String StudentNo);
	
	//U
	void update(StudentToTeacher stt);
	
	//D
	void deleteByStudentNo(String studentNo);

}
