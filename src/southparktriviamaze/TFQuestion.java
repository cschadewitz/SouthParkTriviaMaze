package southparktriviamaze;

import java.util.ArrayList;
import java.util.List;

public class TFQuestion implements Question {
	private String questionText;
	private boolean answer;
	private List<String> choices;
	private int questionType = 1;
	
	public TFQuestion(String columnQuestionText, String columnAnswer){
		this.choices = new ArrayList<String>();
		this.questionText = columnQuestionText;
		switch(columnAnswer.toLowerCase())
		{
			case "true": this.answer = true;
			break;
			case "false": this.answer = false;
			break;
		}
		this.choices.add("True");
		this.choices.add("False");
	}	
	@Override
	public String getQuestionText() {
		return questionText;
	}
	@Override
	public List<String> getChoices() {
		
		return choices;
	}
	@Override
	public int getQuestionType() {
		return questionType ;
	}

	@Override
	public boolean checkAnswer(String choice) {
		if(choice != null)
		{
			switch(choice.toLowerCase())
			{
				case "true": return this.answer == true;
				case "false": return this.answer == false;
				default: throw new IllegalArgumentException("Answers for T/F questions must be true or false.");
			}
		}
		else
			throw new IllegalArgumentException("Answer cannot be blank");		
	}	

}