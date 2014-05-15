package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MCQuestion implements Question {
	private String questionText;
	private String answerText;
	private List<String> choices;
	
	public MCQuestion(ResultSet randomQuestion) throws SQLException{
		this.questionText = randomQuestion.getString("QuestionText");
		this.answerText = randomQuestion.getString("Answer");
		this.choices.add(randomQuestion.getString("ChoiceA"));
		this.choices.add(randomQuestion.getString("ChoiceB"));
		this.choices.add(randomQuestion.getString("ChoiceC"));
		this.choices.add(randomQuestion.getString("ChoiceD"));
	}	
	@Override
	public String getQuestionText() {
		return questionText;
	}
	@Override
	public List<String> getChoices() {
		
		return this.choices;
	}

	@Override
	public boolean checkAnswer(String choice) {
		if(choice != null)
			return (choice.toLowerCase() == answerText.toLowerCase());
		else
			throw new IllegalArgumentException("Answer cannot be blank");		
	}

	

}