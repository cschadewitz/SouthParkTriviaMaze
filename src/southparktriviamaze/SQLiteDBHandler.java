package southparktriviamaze;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.sqlite.*;

public class SQLiteDBHandler implements SQLProxy {

	private List<Integer> questionIDs = new ArrayList<Integer>();
	private Random rand = new Random();
	private static Question currentQuestion;
	public static void main( String args[] )
	{
		SQLiteDBHandler db = new SQLiteDBHandler();
		Question q = db.getRandomQuestion();
		Class<? extends Question> c = q.getClass();
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
		
		try {
			conn = getConnection();
			System.out.println("DB opened successfully");
			command = conn.createStatement();
			int questionIDListIndex = rand.nextInt(questionIDs.size());
			randomQuestion = command.executeQuery("SELECT * FROM QUESTIONS WHERE QuestionID = " + questionIDs.get(questionIDListIndex));
			questionIDs.remove(questionIDListIndex);
			//if(randomQuestion.next())
			//	currentQuestion = new southparktriviamaze.MCQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"), randomQuestion.getString("ChoiceA"), randomQuestion.getString("ChoiceB"), randomQuestion.getString("ChoiceC"), randomQuestion.getString("ChoiceD"));
			switch(randomQuestion.getInt("Type"))
			{
				case 0: return new MCQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"), randomQuestion.getString("ChoiceA"), randomQuestion.getString("ChoiceB"), randomQuestion.getString("ChoiceC"), randomQuestion.getString("ChoiceD"));
				case 1: return new TFQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"));
				case 2: return new SAQuestion(randomQuestion.getString("QuestionText"), randomQuestion.getString("Answer"), randomQuestion.getString("ChoiceA"), randomQuestion.getString("ChoiceB"), randomQuestion.getString("ChoiceC"), randomQuestion.getString("ChoiceD"));
				default: return null;
			}
		} catch ( Exception e ) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
		}
		return null;
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
