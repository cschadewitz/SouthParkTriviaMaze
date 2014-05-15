/* QuestionFactory.cs
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
	
	//Generates a question
	//Returns:
	//Question Result of the question generation
	//Throws:
	//SQLException
	protected abstract Question generateQuestion() throws SQLException;
	protected abstract Question generateQuestion(String category) throws SQLException;
	protected SQLProxy dbProxy;
	protected ResultSet randomQuestion;
	public Question getQuestion() throws SQLException
	{
		return generateQuestion();
	}
	public Question getQuestion(String category) throws SQLException
	{
		return generateQuestion(category);
	}

}