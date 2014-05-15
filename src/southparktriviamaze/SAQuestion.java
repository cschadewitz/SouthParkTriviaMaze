package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class SAQuestion implements Question {

	private String questionText;
	private String answerText;
	
	public SAQuestion(ResultSet randomQuestion) throws SQLException{
		this.questionText = randomQuestion.getString("QuestionText");
		this.answerText = randomQuestion.getString("Answer");
	}	
	@Override
	public String getQuestionText() {
		return questionText;
	}
	@Override
	public List<String> getChoices() {
		
		return null;
	}

	@Override
	public boolean checkAnswer(String choice) {
		if(choice != null)
			return (choice.toLowerCase() == answerText.toLowerCase());
		else
			throw new IllegalArgumentException("Answer cannot be blank");		
	}


}