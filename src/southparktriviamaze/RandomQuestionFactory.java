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
import java.util.List;


public class RandomQuestionFactory extends QuestionFactory {
	
	//Initializes a new RandomQuestionFactory
	public RandomQuestionFactory()
	{
		super.dbProxy = new SQLiteDBHandler();
	}
	
	//Implemented from QuestionFactory
	//see QuestionFactory for details
	@Override
	protected Question generateQuestion() throws SQLException {
		return super.dbProxy.getRandomQuestion();
	}
	
	//Implemented from QuestionFactory
	//see QuestionFactory for details
	@Override
	protected Question generateQuestion(String category) throws SQLException {
		return super.dbProxy.getRandomQuestion(category);
		
	}

}