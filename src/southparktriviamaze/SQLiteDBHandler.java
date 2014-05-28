package southparktriviamaze;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SQLiteDBHandler implements SQLProxy {

	private List<Integer> questionIDs = new ArrayList<Integer>();
	private Random rand = new Random();
	public static void main( String args[] )
	{
		SQLiteDBHandler db = new SQLiteDBHandler();
		db.getRandomQuestion();
		System.out.println("WIN");
		
	}
	public SQLiteDBHandler()
	{
		Connection conn = null;
		Statement command = null;
		ResultSet count = null;
		try {
			conn = getConnection();
			System.out.println("DB opened successfully");
			
			command = conn.createStatement();
			count = command.executeQuery("SELECT QuestionID AS total FROM QUESTIONS;");
			while (count.next())
			{
				questionIDs.add(count.getInt("total"));
			}
			count.close();
			command.close();
			conn.close();
			} catch ( Exception e ) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
		} 
		
	}
	@Override
	public Question getRandomQuestion() {
		Connection conn = null;
		Statement command = null;
		ResultSet randomQuestion;
		Question returnQuestion = null;
		//returnQuestion = new MCQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"), randomQuestion.getString("ChoiceA"), randomQuestion.getString("ChoiceB"), randomQuestion.getString("ChoiceC"), randomQuestion.getString("ChoiceD"));
		try {
			conn = getConnection();
			System.out.println("DB opened successfully");
			command = conn.createStatement();
			int questionIDListIndex = rand.nextInt(questionIDs.size());
			randomQuestion = command.executeQuery("SELECT * FROM QUESTIONS WHERE QuestionID = " + questionIDs.get(questionIDListIndex));
			
			returnQuestion = new MCQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"), randomQuestion.getString("ChoiceA"), randomQuestion.getString("ChoiceB"), randomQuestion.getString("ChoiceC"), randomQuestion.getString("ChoiceD"));
			switch(randomQuestion.getInt("Type"))
			{
				case 1: //return new MCQuestion(randomQuestion);
				case 2: return new TFQuestion(randomQuestion);
				case 3: return new SAQuestion(randomQuestion);
				default: return null;
			}
		} catch ( Exception e ) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
		}
		return returnQuestion;
	}
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Questions.sqlite");
		conn.setAutoCommit(false);
		return conn;
	}

	@Override
	public Question getRandomQuestion(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
