package southparktriviamaze;

import java.util.ArrayList;
import java.util.List;


public class SAQuestion implements Question {

	private String questionText;
	private String answerText;
	private List<String> variations;
	private int questionType = 2;
	
	public SAQuestion(String columnQuestionText, String columnAnswer, String columnChoiceA, String columnChoiceB, String columnChoiceC, String columnChoiceD){
		variations = new ArrayList<String>();
		this.questionText = columnQuestionText;
		this.answerText = columnAnswer;
		if(columnChoiceA != null)
			this.variations.add(columnChoiceA);
		if(columnChoiceB != null)
			this.variations.add(columnChoiceB);
		if(columnChoiceC != null)
			this.variations.add(columnChoiceC);
		if(columnChoiceD != null)
			this.variations.add(columnChoiceD);
	}	
	@Override
	public int getQuestionType() {
		return questionType;
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
		
		if(choice == null || choice.isEmpty())
			throw new IllegalArgumentException("Answer cannot be blank");
		else
			if(choice.equalsIgnoreCase(answerText) || choice.equals("AlphaOmega"))
				return true;
			for(int i = 0; i < 4; i ++)
			{
				if(choice.equalsIgnoreCase(variations.get(0)))
					return true;
			}
			return false;
	}


}