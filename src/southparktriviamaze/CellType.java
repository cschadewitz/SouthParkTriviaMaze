/* CellType.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This enum class is used to represent 
 * the type of a specific location on the maze grid 
 * 
 */
package southparktriviamaze;

public enum CellType {
	Room,
	Wall,
	Door,
	UnlockedDoorHorz,
	UnlockedDoorVert,
	Player;
}
