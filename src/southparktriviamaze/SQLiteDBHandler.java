/* SQLiteDBHandler.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class that handles 
 * the connection to the question DB
 * 
 */
package southparktriviamaze;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.sqlite.*;

public class SQLiteDBHandler implements SQLProxy {

	private List<Integer> questionIDs = new ArrayList<Integer>();
	private Integer[] questionIDsFull;
	Random rand = new Random();
	private int countOfQuestions = 0;
	private static Question currentQuestion;
	//TESTER MAIN
	public static void main( String args[] )
	{
		SQLiteDBHandler db = new SQLiteDBHandler();
		Question q = db.getRandomQuestion();
		Class<? extends Question> c = q.getClass();
		System.out.println("WIN");
		
	}
	
	//Initializes a new SQLiteDBHandler
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
				countOfQuestions++;
			}
			questionIDsFull = new Integer[countOfQuestions];
			questionIDsFull = questionIDs.toArray(questionIDsFull);
			count.close();
			command.close();
			conn.close();
			} catch ( Exception e ) {
			System.err.println(e.getClass().getName() + ":" + e.getMessage());
			System.exit(0);
		} 
		
	}
	
	//Inherited from SQLProxy interface 
	//See SQLProxy interface for details
	@Override
	public Question getRandomQuestion() {
		if(questionIDs.isEmpty())
		{
			for(int i = 0; i < countOfQuestions; i++)
				questionIDs.add(questionIDsFull[i]);
		}
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
	//Creates a Connection to DB
	//Returns:
	//Connection connection to DB
	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:Questions.sqlite");
		conn.setAutoCommit(false);
		return conn;
	}

	//Inherited from SQLProxy interface 
	//See SQLProxy interface for details
	@Override
	public Question getRandomQuestion(String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
