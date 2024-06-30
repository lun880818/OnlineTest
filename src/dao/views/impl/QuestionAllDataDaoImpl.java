package dao.views.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.views.QuestionAllDataDao;
import model.views.QuestionAllData;

public class QuestionAllDataDaoImpl implements QuestionAllDataDao{

	public static void main(String[] args) {
		//test selectAll
//		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selectAll();
//		System.out.println(l);
		
		//test selectByID
//		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selectByID(11);
//		System.out.println(l);
		
		//test selectByQuestionNo
//		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selectByQuestionNo("E003");
//		System.out.println(l);
		
		//test selectBySuject
//		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selectBySuject("數學");
//		QuestionAllData[] q = l.toArray(new QuestionAllData[l.size()]);
//		System.out.println(q[4].getTopic());
		
		//test selectByGrade
//		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selectByGrade("2年級");
//		QuestionAllData[] q = l.toArray(new QuestionAllData[l.size()]);
//		System.out.println(q[1].getTopic());
		
		//test selecteBySujectAndGrade
		List<QuestionAllData> l = new QuestionAllDataDaoImpl().selecteBySujectAndGrade("英文","2年級");
		QuestionAllData[] q = l.toArray(new QuestionAllData[l.size()]);
		System.out.println(q[0].getTopic());

	}

	@Override
	public List<QuestionAllData> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData";
		List<QuestionAllData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuestionAllData qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
				l.add(qad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<QuestionAllData> selectByID(int id) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData where id=?";
		List<QuestionAllData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuestionAllData qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
				l.add(qad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public QuestionAllData selectByQuestionNo(String questionNo) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData where questionNo=?";
		QuestionAllData qad =null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, questionNo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return qad;
	}

	@Override
	public List<QuestionAllData> selectBySuject(String suject) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData where suject=?";
		List<QuestionAllData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, suject);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuestionAllData qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
				l.add(qad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<QuestionAllData> selectByGrade(String grade) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData where grade=?";
		List<QuestionAllData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, grade);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuestionAllData qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
				l.add(qad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<QuestionAllData> selecteBySujectAndGrade(String suject, String grade) {
		Connection conn = DbConnection.getDb();
		String SQL ="select * from QuestionAllData where suject=? and grade=?";
		List<QuestionAllData> l = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, suject);
			ps.setString(2, grade);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuestionAllData qad = new QuestionAllData();
				qad.setId(rs.getInt("id"));
				qad.setQuestionNo(rs.getString("questionNo"));
				qad.setSuject(rs.getString("suject"));
				qad.setGrade(rs.getString("grade"));
				qad.setTopic(rs.getString("topic"));
				qad.setOptionA(rs.getString("optionA"));
				qad.setOptionB(rs.getString("optionB"));
				qad.setOptionC(rs.getString("optionC"));
				qad.setOptionD(rs.getString("optionD"));
				qad.setCorrectAnswer(rs.getString("correctAnswer"));
				
				l.add(qad);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

}
