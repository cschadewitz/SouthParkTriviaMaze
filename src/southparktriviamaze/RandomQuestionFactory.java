package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RandomQuestionFactory extends QuestionFactory {
	
	public RandomQuestionFactory()
	{
		super.dbProxy = new SQLiteDBHandler();
	}
	
	@Override
	protected Question generateQuestion() throws SQLException {
		return super.dbProxy.getRandomQuestion();
	}

	@Override
	protected Question generateQuestion(String category) throws SQLException {
		return super.dbProxy.getRandomQuestion(category);
		
	}

}