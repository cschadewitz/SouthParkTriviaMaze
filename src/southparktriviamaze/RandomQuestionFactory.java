package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RandomQuestionFactory extends QuestionFactory {
	
	protected static List<Integer> usedQuestions;
	
	@Override
	protected Question generateQuestion() throws SQLException {
		ResultSet randomQuestion;
		Question returnQuestion;
		
		do
		{
			randomQuestion = super.dbProxy.getRandomQuestion();
		}while(usedQuestions.contains(randomQuestion.getInt("QuestionID")));
		switch(randomQuestion.getInt("Type"))
		{
			case 1: returnQuestion = new MCQuestion(randomQuestion);
			break;
			case 2: returnQuestion = new TFQuestion(randomQuestion);
			break;
			case 3: returnQuestion = new SAQuestion(randomQuestion);
			break;
			default: return null;
		}
		return returnQuestion;
	}

	@Override
	protected Question generateQuestion(String category) throws SQLException {
		ResultSet randomQuestion;
		Question returnQuestion;
		
		do
		{
			randomQuestion = super.dbProxy.getRandomQuestion(category);
		}while(usedQuestions.contains(randomQuestion.getInt("QuestionID")));

		switch(randomQuestion.getInt("Type"))
		{
			case 1: returnQuestion = new MCQuestion(randomQuestion);
			break;
			case 2: returnQuestion = new TFQuestion(randomQuestion);
			break;
			case 3: returnQuestion = new SAQuestion(randomQuestion);
			break;
			default: return null;
		}
		return returnQuestion;
	}

}