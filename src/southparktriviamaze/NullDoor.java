package southparktriviamaze;

public class NullDoor extends Door {
	
	public NullDoor()
	{
		super();
	}

	public void unlock()
	{
		System.out.println("Cannot unlock a NullDoor (Wall).");
	}

	public boolean isUnlocked() {
		return false;
	}

	public void setUnlocked(boolean unlocked) {
		super.setUnlocked(false);
	}
}
