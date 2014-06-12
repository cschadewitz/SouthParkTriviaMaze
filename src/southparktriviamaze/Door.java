package southparktriviamaze;
///
///Door class
///Author: Chris Purta
///Revision: 1
///Rev. Author:
///N/A
///Description: Represent a door to be opened in the maze. Its fields consist of two booleans:
///* unlocked to tell whether or not the door has been unlocked, and exists to tell whether or not the 
///* door exists. This could be potentially re-factored to a null-Door pattern by inheritance. Door will
///* set to be unlocked based upon a question that is attached to an SQLite database.


public class Door {
	
	private boolean unlocked;
	
	///initalizes a new door
	public Door()
	{
		this.unlocked = false;
	}
	
	///initalizes an new door
	///Parameters:
	///Boolean l sets the doors locked state
	public Door(boolean l)
	{
		this.unlocked = l;
	}
	
	///returns the doors locked state
	///Parameters:
	///none
	///returns:
	///boolean the doors state locked or unlocked
	public boolean isDoor()
	{
		return true;
	}
	
	///unlocks a door
	///parameters:
	///none
	///returns:
	///void
	///throws:
	///none
		
	public void unlock()
	{
		this.unlocked = true;	
	}

	///returns true if door is unlocked
	///parameters:
	///none
	///returns:
	///boolean true if door is unlocked
	///throws:
	///none
	public boolean isUnlocked() {
		return unlocked;
	}
	
	///unlockes the door
	///parameters:
	///boolean unlocked, set the door to unlocked or locked based on the input parmeter
	///returns:
	///void;
	///throws:
	///none

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

}//end class

