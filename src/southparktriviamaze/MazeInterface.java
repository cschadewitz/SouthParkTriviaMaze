/* MazeInterface.java
 * Author: Chris Purta
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This interface is used
 * to communicate with the maze
 * 
 */
package southparktriviamaze;

public interface MazeInterface {
	
	//Gets the number of rows
	public int getRows();
	
	//Gets the number of columns
	public int getCols();
	
	//Gets the NeightorType
	//Parameters:
	//Location location currentLocation
	//Direction direction direction to move in
	//Returns:
	//CellType type of area the neighbor location is
	public CellType getNeighborType(Location location, Direction direction) throws Exception;
	
	//Unlocks the door in the direction given from the location given
	//Parameters:
	//Location location currentLocation
	//Direction direction direction of door to unlock
	public void unlockDoor(Location location, Direction direction);

}
