package southparktriviamaze;

import java.util.ArrayList;
import java.util.List;


public class MCQuestion implements Question {
	private String questionText;
	private String answerText;
	private List<String> choices;
	private int questionType = 0;
	
	public MCQuestion()
	{
	
	}
	public MCQuestion(String columnQuestionText, String columnAnswer, String columnChoiceA, String columnChoiceB, String columnChoiceC, String columnChoiceD){
		choices = new ArrayList<String>();
		this.questionText = columnQuestionText;
		this.answerText = columnAnswer;
		this.choices.add(columnChoiceA);
		this.choices.add(columnChoiceB);
		this.choices.add(columnChoiceC);
		this.choices.add(columnChoiceD);
	}
	@Override
	public int getQuestionType() {
		return questionType ;
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
			return (choice.equalsIgnoreCase(answerText));
		else
			throw new IllegalArgumentException("Answer cannot be blank");		
	}
}
