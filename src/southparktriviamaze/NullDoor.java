/* NullDoor.cs
 * Author: Chris Purta
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class represents a Wall
 * 
 */
package southparktriviamaze;

public class NullDoor extends Door {
	
	//Initializes a new NullDoor
	public NullDoor()
	{
		super();
	}
	
	//Checks if the door is a door
	//Returns:
	//boolean always returns false
	public boolean isDoor()
	{
		return false;
	}
	
	//Unlockes the door
	public void unlock()
	{
		System.out.println("Cannot unlock a NullDoor (Wall).");
	}

	//Checks if the door is unlocked
	//Returns:
	//boolean always returns false
	public boolean isUnlocked() {
		return false;
	}

	//Sets door to locked
	//Parameter:
	//boolean unlocked unused
	public void setUnlocked(boolean unlocked) {
		super.setUnlocked(false);
	}
}
