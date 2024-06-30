package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.table.SujectDao;
import model.table.Suject;

public class SujectDaoImpl implements SujectDao{

	public static void main(String[] args) {
		//test add
//		Suject s = new Suject("國文");
//		new SujectDaoImpl().add(s);
		
		//test selectAll
//		List<Suject> l = new SujectDaoImpl().selectAll();
//		System.out.println(l);
		
		//test update
		List<Suject> l = new SujectDaoImpl().selectAll();
		Suject[] s = l.toArray(new Suject[l.size()]);
		s[2].setSuject("生物");
		new SujectDaoImpl().update(s[2]);
		
		//test delete
		new SujectDaoImpl().deleteById(3);

	}

	@Override
	public void add(Suject s) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into Suject(suject) "
				+ "values(?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, s.getSuject());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Suject> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from Suject";
		List<Suject> l = new ArrayList<Suject>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Suject s = new Suject();
				s.setIdsuject(rs.getInt("idsuject"));
				s.setSuject(rs.getString("suject"));
				
				l.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public void update(Suject s) {
		Connection conn = DbConnection.getDb();
		String SQL = "update Suject set Suject=? "
				+ "where idsuject=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, s.getSuject());
			ps.setInt(2, s.getIdsuject());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(int id) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from Suject where idSuject=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
