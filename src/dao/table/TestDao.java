package dao.table;


import java.util.List;

import model.table.Test;

public interface TestDao {
	//C
	void add(Test t);
	
	//R
	List<Test> selectByTestNoList(String testNo);
	Test selectByTestNo(String testNo);
	List<Test> queryByStudentNo(String studentNo);
	
	//U
	void update(Test t);
	
	//D
	void deleteByTestNo(String testNo);

}
