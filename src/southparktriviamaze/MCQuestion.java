package southparktriviamaze;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class MCQuestion implements Question {
	private String questionText;
	private String answerText;
	private List<String> choices;
	
	public MCQuestion()
	{
	
	}
	public MCQuestion(String columnQuestionText, String columnAnswer, String columnChoiceA, String columnChoiceB, String columnChoiceC, String columnChoiceD){
		this.questionText = columnQuestionText;
		this.answerText = columnAnswer;
		this.choices.add(columnChoiceA);
		this.choices.add(columnChoiceB);
		this.choices.add(columnChoiceC);
		this.choices.add(columnChoiceD);
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
