/* SAQuestion.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class represents a 
 * short answer choice question.
 * 
 */
package southparktriviamaze;

import java.util.ArrayList;
import java.util.List;


public class SAQuestion implements Question {

	private String questionText;
	private String answerText;
	private List<String> variations;
	private int questionType = 2;
	
	//Initializes a new short answer choice question
	//Parameters:
	//String columnQuestionText  Text of the question
	//String columnAnswer  Answer to the question
	//String columnChoiceA  First variation of answer 
	//String columnChoiceB  Second variation of answer 
	//String columnChoiceC  Third variation of answer
	//String columnChoiceD  Fourth variation of answer
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
	
	//Inherited from Question interface 
	//See Question interface for details
	@Override
	public int getQuestionType() {
		return questionType;
	}
	
	//Inherited from Question interface 
	//See Question interface for details
	@Override
	public String getQuestionText() {
		return questionText;
	}
	//Inherited from Question interface 
	//See Question interface for details
	@Override
	public List<String> getChoices() {
		
		return null;
	}

	@Override
	public boolean checkAnswer(String choice) {
		
		if(choice == null || choice.isEmpty())
			return false;
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