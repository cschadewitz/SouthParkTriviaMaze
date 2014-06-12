/* SQLProxy.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This interface is implemented by 
 * the SQL handler.
 * 
 */
package southparktriviamaze;


import southparktriviamaze.Question;


public interface SQLProxy {

	//Gets a random Question from DB
	//Returns:
	//Question Result of the question generation
	public Question getRandomQuestion();
	
	//Gets a random Question of a certain catagory from DB
	//Parameters:
	//String category category of question to ask
	//Returns:
	//Question Result of the question generation
	public Question getRandomQuestion(String category);
	
}

