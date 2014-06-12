/* QuestionFactory.java
 * Author: Casey Schadewitz
 * Revision: 1
 * Rev. Author: N/A
 * Description: QuestionFactory is the abstract class for the family
 * of question factories such as RandomQuestionFactory. 
 */
package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class QuestionFactory {
	
	//Generates a random question
	//Returns:
	//Question Result of the question generation
	//Throws:
	//SQLException
	protected abstract Question generateQuestion() throws SQLException;
	
	//Generates a random question
	//Parameters:
	//String category category of question to ask
	//Returns:
	//Question Result of the question generation
	//Throws:
	//SQLException
	protected abstract Question generateQuestion(String category) throws SQLException;
	
	protected SQLProxy dbProxy;
	
	//Get a question
	//Returns:
	//Question Result of the question generation
	//Throws:
	//SQLException
	public Question getQuestion() throws SQLException
	{
		return generateQuestion();
	}
	//Get a question
	//Parameters:
	//String category category of question to ask
	//Returns:
	//Question Result of the question generation
	//Throws:
	//SQLException
	public Question getQuestion(String category) throws SQLException
	{
		return generateQuestion(category);
	}

}