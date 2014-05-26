package southparktriviamaze;

/*
 * @author Chris Purta
 * 
 * Description: Represent a door to be opened in the maze. Its fields consist of two booleans:
 * unlocked to tell whether or not the door has been unlocked, and exists to tell whether or not the 
 * door exists. This could be potentially re-factored to a null-Door pattern by inheritance. Door will
 * set to be unlocked based upon a question that is attached to an SQLite database.
 * 
 */

public class Door {
	
	private boolean unlocked;
	
	public Door()
	{
		this.unlocked = false;
	}
	
	public Door(boolean l)
	{
		this.unlocked = l;
	}
	
	public boolean isDoor()
	{
		return true;
	}

	public void unlock()
	{
		this.unlocked = true;	
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

}//end class

