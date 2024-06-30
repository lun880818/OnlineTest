package dao.table;

import java.util.List;

import model.table.Suject;

public interface SujectDao {
	//C
	void add(Suject s);
	
	//R
	List<Suject> selectAll();
	
	//U
	void update(Suject s);
	
	//D
	void deleteById(int id);

}
