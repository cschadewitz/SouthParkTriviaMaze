/* MCQuestion.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class represents a 
 * multiple choice question.
 * 
 */
package southparktriviamaze;

import java.util.ArrayList;
import java.util.List;


public class MCQuestion implements Question {
	private String questionText;
	private String answerText;
	private List<String> choices;
	private int questionType = 0;
	
	//Initializes a new multiple choice question
	//Parameters:
	//String columnQuestionText  Text of the question
	//String columnAnswer  Answer to the question
	//String columnChoiceA  First choice 
	//String columnChoiceB  Second choice 
	//String columnChoiceC  Third choice
	//String columnChoiceD  Fourth choice
	
	public MCQuestion(String columnQuestionText, String columnAnswer, String columnChoiceA, String columnChoiceB, String columnChoiceC, String columnChoiceD){
		choices = new ArrayList<String>();
		this.questionText = columnQuestionText;
		this.answerText = columnAnswer;
		this.choices.add(columnChoiceA);
		this.choices.add(columnChoiceB);
		this.choices.add(columnChoiceC);
		this.choices.add(columnChoiceD);
	}
	
	//Inherited from Question interface 
	//See Question interface for details
	@Override
	public int getQuestionType() {
		return questionType ;
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
		
		return this.choices;
	}
	
	//Inherited from Question interface 
	//See Question interface for details
	@Override
	public boolean checkAnswer(String choice) {
		if(choice != null)
			return (choice.equalsIgnoreCase(answerText));
		else
			throw new IllegalArgumentException("Answer cannot be blank");		
	}
}
