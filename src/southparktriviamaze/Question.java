/* Question.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class is the
 * interface implemented by all
 * classes of the question family.
 * 
 */
package southparktriviamaze;

import java.util.List;

public interface Question {
	//Get question text
	public String getQuestionText();
	//Get list of choices
	public List<String> getChoices();
	//Used to check the players answer
	//Parameters:
	//String choice answer given by player
	public boolean checkAnswer(String choice);
	//Get the question type
	public int getQuestionType();
}
