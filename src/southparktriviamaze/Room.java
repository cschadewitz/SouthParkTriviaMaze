package southparktriviamaze;

/*
 * @author Chris Purta
 * 
 * Description: Room class that represented four Doors that are all set to be unlocked
 * 
 */

public class Room {
	
	private Door leftDoor;
	private Door rightDoor;
	private Door upperDoor;
	private Door lowerDoor;

	public Room() {
		this.leftDoor = new NullDoor();
		this.rightDoor = new NullDoor();
		this.upperDoor = new NullDoor();
		this.lowerDoor = new NullDoor();
	}

	public Door getLeftDoor() {
		return leftDoor;
	}

	public void setLeftDoor(Door leftDoor) {
		this.leftDoor = leftDoor;
	}

	public Door getRightDoor() {
		return rightDoor;
	}

	public void setRightDoor(Door rightDoor) {
		this.rightDoor = rightDoor;
	}

	public Door getUpperDoor() {
		return upperDoor;
	}

	public void setUpperDoor(Door upperDoor) {
		this.upperDoor = upperDoor;
	}

	public Door getLowerDoor() {
		return lowerDoor;
	}

	public void setLowerDoor(Door lowerDoor) {
		this.lowerDoor = lowerDoor;
	}

}

