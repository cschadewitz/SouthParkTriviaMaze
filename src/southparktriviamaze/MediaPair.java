/* MediaPair.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class represents a 
 * sound to play.
 * 
 */
package southparktriviamaze;

public class MediaPair
{
	public Character character;
	public MediaType media;
	
	//Initializes a new MediaPair
	public MediaPair(Character c, MediaType m)
	{
		character = c;
		media = m;
	}
}