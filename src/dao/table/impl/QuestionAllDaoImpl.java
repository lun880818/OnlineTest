package dao.table.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.table.QuestionAllDao;
import model.table.QuestionAll;

public class QuestionAllDaoImpl implements QuestionAllDao{

	public static void main(String[] args) {
		// test add
//		QuestionAll q = new QuestionAll("M006",1,2,"6/3=?","1","2","3","4",2);
//		new QuestionAllDaoImpl().add(q);
		
		//test selectByQuestionNo
//		QuestionAll q = new QuestionAllDaoImpl().selectByQuestionNo("M006");
//		System.out.println(q.getTopic());
		
		//test update
//		QuestionAll q = new QuestionAllDaoImpl().selectByQuestionNo("M006");
//		q.setGrade(4);
//		q.setTopic("已知正三角形和正方形的周長都是 24 公分，請問它們的邊長相差多少公分？");
//		q.setOptionA("0");
//		q.setOptionB("2");
//		q.setOptionC("12");
//		q.setOptionD("24");
//		q.setCorrectAnswer(4);
//		new QuestionAllDaoImpl().update(q);
		
		//test deleteByQuestionNo
		new QuestionAllDaoImpl().deleteByQuestionNo("M007");

	}

	@Override
	public void add(QuestionAll q) {
		Connection conn = DbConnection.getDb();
		String SQL = "insert into QuestionAll(questionNo, suject, grade, topic, optionA, optionB,"
				+ "	optionC, optionD, correctAnswer) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1,q.getQuestionNo());
			ps.setInt(2, q.getSuject());
			ps.setInt(3, q.getGrade());
			ps.setString(4, q.getTopic());
			ps.setString(5,q.getOptionA());
			ps.setString(6,q.getOptionB());
			ps.setString(7,q.getOptionC());
			ps.setString(8,q.getOptionD());
			ps.setInt(9, q.getCorrectAnswer());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public QuestionAll selectByQuestionNo(String questionNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAll where questionNo=?";
		QuestionAll q = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, questionNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				q = new QuestionAll();
				q.setId(rs.getInt("id"));
				q.setQuestionNo(rs.getString("questionNo"));
				q.setSuject(rs.getInt("suject"));
				q.setGrade(rs.getInt("grade"));
				q.setTopic(rs.getString("topic"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setOptionD(rs.getString("optionD"));
				q.setCorrectAnswer(rs.getInt("correctAnswer"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return q;
	}
	
	@Override
	public List<QuestionAll> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAll";
		List<QuestionAll> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				QuestionAll q = new QuestionAll();
				q.setId(rs.getInt("id"));
				q.setQuestionNo(rs.getString("questionNo"));
				q.setSuject(rs.getInt("suject"));
				q.setGrade(rs.getInt("grade"));
				q.setTopic(rs.getString("topic"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setOptionD(rs.getString("optionD"));
				q.setCorrectAnswer(rs.getInt("correctAnswer"));
				
				l.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}
	
	/*@Override
	public List<QuestionAll> selectRandom(int numberOfQ) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAll";
		List<QuestionAll> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				QuestionAll q = new QuestionAll();
				q.setId(rs.getInt("id"));
				q.setQuestionNo(rs.getString("questionNo"));
				q.setSuject(rs.getInt("suject"));
				q.setGrade(rs.getInt("grade"));
				q.setTopic(rs.getString("topic"));
				q.setOptionA(rs.getString("optionA"));
				q.setOptionB(rs.getString("optionB"));
				q.setOptionC(rs.getString("optionC"));
				q.setOptionD(rs.getString("optionD"));
				q.setCorrectAnswer(rs.getInt("correctAnswer"));
				
				l.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}*/

	@Override
	public void update(QuestionAll q) {
		Connection conn = DbConnection.getDb();
		String SQL = "update QuestionAll set grade=?,topic=?,"
				+ "optionA=?,optionB=?,optionC=?,optionD=?,correctAnswer=? "
				+ "where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
//			ps.setString(1, q.getQuestionNo());
//			ps.setInt(2, q.getSuject());
			ps.setInt(1, q.getGrade());
			ps.setString(2, q.getTopic());
			ps.setString(3, q.getOptionA());
			ps.setString(4, q.getOptionB());
			ps.setString(5, q.getOptionC());
			ps.setString(6, q.getOptionD());
			ps.setInt(7, q.getCorrectAnswer());
			ps.setInt(8, q.getId());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByQuestionNo(String questionNo) {
		Connection conn = DbConnection.getDb();
		String SQL = "delete from QuestionAll where questionNo=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, questionNo);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}





}
