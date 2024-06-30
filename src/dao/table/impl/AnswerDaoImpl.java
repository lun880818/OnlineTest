package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DbConnection;
import dao.table.AnswerDao;
import model.table.Answer;

public class AnswerDaoImpl implements AnswerDao{

	public static void main(String[] args) {
		//test add
//		Answer answer = new Answer("ET0001",2,2);
//		new AnswerDaoImpl().add(answer);
		
		//test selectByTestNo
//		Answer answer = new AnswerDaoImpl().selectByTestNoAndQuestionOrder("MT0001",1);
//		System.out.println(answer.getTestNo());
		
		//test update
//		Answer a = new AnswerDaoImpl().selectByTestNoAndQuestionOrder("ET0001",2);
//		a.setAnswer(3);
//		new AnswerDaoImpl().update(a);
		
		//test deleteBytestNoAndQuestionOrder
		new AnswerDaoImpl().deleteBytestNoAndQuestionOrder("ET0001",2);
		

	}

	@Override
	public void add(Answer answer) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into answer(testNo, questionOrder, answer) "
				+ "values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, answer.getTestNo());
			ps.setInt(2, answer.getQustionOrder());
			ps.setInt(3, answer.getAnswer());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Answer selectByTestNoAndQuestionOrder(String testNo, Integer questionOrder) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from Answer where testNo=? and questionOrder=?";
		Answer a = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ps.setInt(2, questionOrder);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Answer();
				a.setId(rs.getInt("id"));
				a.setTestNo(rs.getString("testNo"));
				a.setQustionOrder(rs.getInt("questionOrder"));
				a.setAnswer(rs.getInt("answer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public void update(Answer answer) {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "update answer set answer=? where testno=? and questionOrder=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, answer.getAnswer());
			ps.setString(2, answer.getTestNo());
			ps.setInt(3, answer.getQustionOrder());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBytestNoAndQuestionOrder(String testNo, Integer questionOrder) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from answer where testNo=? and questionOrder=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, testNo);
			ps.setInt(2, questionOrder);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
