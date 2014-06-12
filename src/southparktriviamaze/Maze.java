//Maze
//Author: Chris Purta
///Revision: 1
//rev. Author:
//NA
 //* 	Description: This is a Maze class that holds as the underlying structure a 2-d array of
// * 	Cells, which contains four walls and then uses a recursive backtracking algorithm that 
// * 	"knocks down" walls as needed.

package southparktriviamaze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class Maze implements MazeInterface 
{
	private Room[][] roomMaze;
	private int startX, startY, endX, endY;
	private int rows;
	private int cols;
	
	/*
	 * Room class that holds the coordinates of the Room tells whether or not 
	 * the Room has been visited and contains four walls that will tear down
	 * certain walls upon creation of the maze.  
	 */
	private class Room {
		
		private int x;
		private int y;
		private boolean visited;
		private Door leftDoor;
		private Door rightDoor;
		private Door upperDoor;
		private Door lowerDoor;
		
		///initalizes a new room
		///Parameters:
		///int i the x coordinate
		//int j the y axis
		///boolean v sets if the room has been visited yet.
		///returns:
		///void
		///throws:
		///none
		public Room(int i, int j, boolean v)
		{
			this.x = i;
			this.y = j;
			this.visited = v;
			this.leftDoor = new NullDoor();
			this.rightDoor = new NullDoor();
			this.upperDoor = new NullDoor();
			this.lowerDoor = new NullDoor();
		}
		
		///sets the left doors attributes
		//Parameters:
		//Door leftDoor sets the rooms left door the the left door parameter
		//returns:
		//void
		//throws:
		//none
		public void setLeftDoor(Door leftDoor) {
			this.leftDoor = leftDoor;
		}

		///sets the right doors attributes
		//Parameters:
		//Door rightDoor sets the rooms left door the the left door parameter
		//returns:
		//void
		//throws:
		//none
		public void setRightDoor(Door rightDoor) {
			this.rightDoor = rightDoor;
		}

		///sets the upper doors attributes
		//Parameters:
		//Door upperDoor sets the rooms left door the the left door parameter
		//returns:
		//void
		//throws:
		//none
		public void setUpperDoor(Door upperDoor) {
			this.upperDoor = upperDoor;
		}

		///sets the lower doors attributes
		//Parameters:
		//Door lowerDoor sets the rooms left door the the left door parameter
		//returns:
		//void
		//throws:
		//none
		public void setLowerDoor(Door lowerDoor) {
			this.lowerDoor = lowerDoor;
		}

		//returns the x coordinate of the room
		//Parameters:
		//none
		//returns:
		//x coordinate 
		//throws:
		//none
		public int getX() {
			return x;
		}
		//returns the x coordinate of the room
		//Parameters:
		//none
		//returns:
		//y coordinate 
		//throws:
		//none
		public int getY() {
			return y;
		}

		//returns if the room has been visited
		//Parameters:
		//none
		//returns:
		//boolean if the door has been visited
		//throws:
		//none
		public boolean isVisited() {
			return visited;
		}

		//set the room to visited or not visited
		//Parameters:
		//none
		//returns:
		//void
		//throws:
		//none
		public void setVisited(boolean inMaze) {
			this.visited = inMaze;
		}
		
		
	}//end Room class
	
	public Maze()
	{
		this.rows = 10;
		this.cols = 10;
		this.startX = 0;
		this.startY = 0;
		this.endX = this.rows - 1;
		this.endY = this.cols - 1;
		
		this.roomMaze = new Room[this.rows][this.cols];
		
		mazeGenerator();
	}
	
	//initalizes the maze
	//parameters:
	//int x the x location
	//int y the y location
	//
	
	public Maze(int x, int y) throws Exception
	{
		if(x <= 1 || y <= 1)
			throw new Exception("Row or column dimension must be larger than 1.");
		
		this.rows = x;
		this.cols = y;
		this.startX = 0;
		this.startY = 0;
		this.endX = rows - 1;
		this.endY = cols - 1;
		
		this.roomMaze = new Room[this.rows][this.cols];
		
		mazeGenerator();
		
	}
	
	//returns the number of rows in the maze
	//parameters:
	//none
	//returns:
	//the number of rows in the maze
	//throws:
	//none
	public int getRows() {
		return this.rows;
	}
	
	//returns the number of columns in the maze
	//parameters:
	//none
	//returns:
	//int the number of columns in the maze
	public int getCols() {
		return this.cols;
	}
	
	//returns the upper doors state
	//parameters:
	//int i the x location of the room
	//int j the y location of the room
	//returns 
	//boolean whether the upper door is locked or not
	//throws:
	//none
	public boolean northDoorUnlocked(int i, int j)
	{
		return this.roomMaze[i][j].upperDoor.isUnlocked();
	}
	
	//returns the lower doors state
	//parameters:
	//int i the x location of the room
	//int j the y location of the room
	//returns 
	//boolean whether the lower door is locked or not
	//throws:
	//none
	public boolean southDoorUnlocked(int i, int j)
	{
		return this.roomMaze[i][j].lowerDoor.isUnlocked();
	}
	
	//returns the right doors state
	//parameters:
	//int i the x location of the room
	//int j the y location of the room
	//returns 
	//boolean whether the right door is locked or not
	//throws:
	//none
	public boolean eastDoorUnlocked(int i, int j)
	{
		return this.roomMaze[i][j].rightDoor.isUnlocked();
	}
	
	//returns the Left doors state
	//parameters:
	//int i the x location of the room
	//int j the y location of the room
	//returns 
	//boolean whether the Left door is locked or not
	//throws:
	//none
	public boolean westDoorUnlocked(int i, int j)
	{
		return this.roomMaze[i][j].leftDoor.isUnlocked();
	}
	
	//returns the type of the neighbor room, wall, room, door
	//parameters:
	//location the location of the room we are in
	//direction the direction to the room we want to be in
	//returns:
	//CellType the type of cell  next to the room we are in
	//throws:
	//none
	public CellType getNeighborType(Location location, Direction direction)
	{
		//if(location.getX() < 1 || location.getX() >= rows || location.getY() < 1 || location.getY() >= cols)
			//throw new Exception("Location out of bounds of the maze.");
		
		Room curRoom = roomMaze[location.getRow()][location.getColumn()];
		
		switch(direction)
		{
			case North: return determineType(direction, curRoom.upperDoor);
			case South: return determineType(direction, curRoom.lowerDoor);
			case East: return determineType(direction, curRoom.rightDoor);
			case West: return determineType(direction, curRoom.leftDoor);
			default: return CellType.Wall;
		}//end switch
	}
	
	//returns the type of the neighbor cell, wall, room, door
	//parameters:
	//direction the direction to the room we want to be in
	//Door the door in the direction we are going
	//returns:
	//CellType the type of cell  next to the room we are in
	//throws:
	//none
	public CellType determineType(Direction direction, Door door)
	{
		if(!door.isDoor())
			return CellType.Wall;
		else if(door.isDoor() && !door.isUnlocked())
			return CellType.Door;
		else if(door.isDoor() && door.isUnlocked() && direction == Direction.West || direction == Direction.East)
			return CellType.UnlockedDoorHorz;
		else if(door.isDoor() && door.isUnlocked() && direction == Direction.North || direction == Direction.South)
			return CellType.UnlockedDoorVert;
		else 
			return CellType.Room;
	}
	
	//unlocks a neighbor door
	//parameters:
	//location the location of the room we are in
	//the direction the direction we are going
	//returns:
	//void
	//throws:
	//none
	public void unlockDoor(Location location, Direction direction)
	{
		int x = location.getRow();
		int y = location.getColumn();
		
		Room curRoom = this.roomMaze[x][y];
		
		switch(direction)
		{
			case North: curRoom.upperDoor.unlock();
						this.roomMaze[x - 1][y].lowerDoor.unlock();
				break;
				
			case South: curRoom.lowerDoor.unlock();
						this.roomMaze[x + 1][y].upperDoor.unlock();
				break;
				
			case East:	curRoom.rightDoor.unlock();
						this.roomMaze[x][y + 1].leftDoor.unlock();
				break;
			
			case West:	curRoom.leftDoor.unlock();
						this.roomMaze[x][y - 1].rightDoor.unlock();
				break;
		}//end switch
	}
	
	//returns an array of booleans for the neighbors, door or not
	//parameters:
	//int i the x location of the room we are in
	//int j the y location of teh room we are in
	//returns:
	//boolean array
	//throws:
	//none
	public boolean[] getNeighboringRooms(int i, int j)
	{
		Room curRoom = this.roomMaze[i][j];
		
		boolean [] rooms = {false, false, false, false}; //North, South, East, West
		
		rooms[0] = curRoom.upperDoor.isDoor();
		
		rooms[1] = curRoom.lowerDoor.isDoor();
		
		rooms[2] = curRoom.rightDoor.isDoor();
		
		
		rooms[3] = curRoom.leftDoor.isDoor();
		
		return rooms;
	}
	
	//generates a random maze
	//arameters:
	//none
	//returns:
	//void
	//throws:
	//none
	private void mazeGenerator()
	{
		/*
		 * Recursive backtracking algorithm found from: http://en.wikipedia.org/wiki/Maze_generation_algorithm
		 */
		
		Room curRoom;
		int totalCells = this.rows * this.cols;
		int visitedCells = 0;
		Stack<Room> cellStack = new Stack<Room>();
		Random rand = new Random();
		ArrayList<Room> visitedNeighbors;
		
		//Initialize each cell with the co-ordinates and visited to be false 
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				roomMaze[i][j] = new Room(i, j, false);
		
		curRoom = roomMaze[startX][startY];
		curRoom.setVisited(true);
		visitedCells++;
		
		while(visitedCells < totalCells)
		{
			visitedNeighbors = getVisitedNeighbors(curRoom);
			
			if(visitedNeighbors.size() > 0)
			{
				int randIndex = rand.nextInt(visitedNeighbors.size());
				Room randRoom = visitedNeighbors.get(randIndex);
				
				cellStack.push(curRoom);
				removeWalls(curRoom, randRoom);
				curRoom = randRoom;
				curRoom.setVisited(true);
				visitedCells++;
			}//end if
			
			else if(!cellStack.empty())
				curRoom = cellStack.pop();
			
			else
			{
				curRoom = roomMaze[rand.nextInt(this.rows)][rand.nextInt(this.cols)];
				
				while(curRoom.isVisited())
					curRoom = roomMaze[rand.nextInt(this.rows)][rand.nextInt(this.cols)];
				
				visitedCells++;
			}//end else
			
		}//end while
		
	}//end mazeGenerator


	//removers the wals between the randome cell and trhe current cell while generating a maze
	//Parameters:
	//Room curRoom the room we are in
	//Room randCell a random adjoined room
	//returns:
	//void
	//throws:
	//none
	private void removeWalls(Room curRoom, Room randCell) {
		
		/*
		 * All the possible cases for removal of walls
		 * 
		 * 						[Top]
		 * 					-------------
		 * 					|			|
		 * 					|	rand	|
		 * 		[Left]		-------------	[Right]
		 *   -------------	------------- -------------
		 * 	 |			 |	|			| |			  |
		 * 	 |	 rand    |	|	 cur 	| |	  rand	  |
		 * 	 -------------	------------- -------------
		 * 		  			-------------
		 * 					|			|
		 * 					|	rand  	|
		 * 					-------------
		 * 					   [Bottom]
		 */
		
		//Rand: Top
		if(randCell.getY() == curRoom.getY() && randCell.getX() == curRoom.getX() - 1)
		{
			randCell.setLowerDoor(new Door());
			curRoom.setUpperDoor(new Door());
		}//end if
		
		//Rand: Bottom
		if(randCell.getY() == curRoom.getY() && randCell.getX() == curRoom.getX() + 1)
		{
			randCell.setUpperDoor(new Door());
			curRoom.setLowerDoor(new Door());
		}//end if
		
		//Rand: Right
		if(randCell.getX() == curRoom.getX() && randCell.getY() == curRoom.getY() + 1)
		{
			randCell.setLeftDoor(new Door());
			curRoom.setRightDoor(new Door());
		}//end if
		
		//Rand: Left
		if(randCell.getX() == curRoom.getX() && randCell.getY() == curRoom.getY() - 1)
		{
			randCell.setRightDoor(new Door());
			curRoom.setLeftDoor(new Door());
		}//end if
	}//end removeWalls

	//gets the neighboring visited rooms for the current room
	//parameters:
	//Room curRoom the room we are looking at
	//returns:
	//Arrayist<Room> an array list of the adjoined rooms
	//throws:
	//none
	private ArrayList<Room> getVisitedNeighbors(Room curRoom) {
		
		ArrayList<Room> neighbors = new ArrayList<Room>();
		
		//Look at top...
		if(curRoom.getX() - 1 >= 0 && !roomMaze[curRoom.getX() - 1][curRoom.getY()].isVisited())
			neighbors.add(roomMaze[curRoom.getX() - 1][curRoom.getY()]);
		
		//Look at bottom...
		if(curRoom.getX() + 1 < rows && !roomMaze[curRoom.getX() + 1][curRoom.getY()].isVisited())
			neighbors.add(roomMaze[curRoom.getX() + 1][curRoom.getY()]);
		
		//Look at right...
		if(curRoom.getY() + 1 < cols && !roomMaze[curRoom.getX()][curRoom.getY() + 1].isVisited())
			neighbors.add(roomMaze[curRoom.getX()][curRoom.getY() + 1]);
		
		//Look at right...
		if(curRoom.getY() - 1 >= 0 && !roomMaze[curRoom.getX()][curRoom.getY() - 1].isVisited())
			neighbors.add(roomMaze[curRoom.getX()][curRoom.getY() - 1]);
		
		neighbors.trimToSize();
				
		return neighbors;
	}//end getVisitedNeighbors


}//end Maze class

