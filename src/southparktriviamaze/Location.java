/* Location.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class is used to represent
 * a location in the maze.
 * 
 */
package southparktriviamaze;

public class Location {
	private int column;
	private int row;
	
	//Initializes a new Location with the given row and column
	//Parameters:
	//int row row
	//int column column
	public Location(int row, int column)
	{
		this.column = column;
		this.row = row;
	}
	
	//Gets the column value
	public int getColumn()
	{
		return column;
	}
	
	//Gets the row value
	public int getRow()
	{
		return row;
	}
	
	//Sets the row value
	public void setRow(int row)
	{
		this.row = row;
	}
	
	//Sets the column value
	public void setColumn(int column)
	{
		this.column = column;
	}
	
	//Creates condensed version of the location
	//This is used to interface with the maze class
	//Returns:
	//Location Condensed version of location
	public Location convertToCondensed()
	{
		Location temp = new Location(
		this.row/2, this.column/2);
		return temp;
	}
	
	//Returns a location which has the row and column values
	//of this location and the given location added together.
	//Parameters:
	//Location vectorEndPoint Location to add to this location
	//Returns:
	//Location Result of addition of locations
	public Location add(Location vectorEndPoint)
	{
		Location temp = new Location( 
				this.row + vectorEndPoint.row,
				this.column + vectorEndPoint.column
		);
		return temp;
	}
	
	//Returns a location which is the neighbor of this location
	//in the given direction.
	//Parameters:
	//Direction direction Direction to neighbor to retrieve
	//Returns:
	//Location Retrieved neighbor
	public Location neighbor(Direction direction)
	{
		return this.add(Location.vector(direction));
	}
	
	//Returns a movement vector
	//Parameters:
	//Direction direction Direction of vector to create
	//Returns:
	//Location movement vector
	private static Location vector(Direction direction)
	{
		switch(direction)
		{
			case North: return new Location(-2, 0);						
			case East: return new Location(0, 2);
			case South: return new Location(2, 0);
			case West: return new Location(0, -2);
			default: return vectorZero();
			
		}
		
	}
	
	//Returns a Location with row and column
	//equal to zero
	private static Location vectorZero()
	{
		return new Location(0, 0); 
	}
	
}
