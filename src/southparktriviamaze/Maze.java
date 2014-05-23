package southparktriviamaze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
/*
 * 	@author Chris Purta
 * 
 * 	Description: This is a Maze class that holds as the underlying structure a 2-d array of
 * 	Cells, which contains four walls and then uses a recursive backtracking algorithm that 
 * 	"knocks down" walls as needed.
 * 
 */

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

		public void setLeftDoor(Door leftDoor) {
			this.leftDoor = leftDoor;
		}

		public void setRightDoor(Door rightDoor) {
			this.rightDoor = rightDoor;
		}

		public void setUpperDoor(Door upperDoor) {
			this.upperDoor = upperDoor;
		}

		public void setLowerDoor(Door lowerDoor) {
			this.lowerDoor = lowerDoor;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public boolean isVisited() {
			return visited;
		}

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
	
	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	public CellType getNeighborType(Location location, Direction direction)
	{
		//if(location.getX() < 1 || location.getX() >= rows || location.getY() < 1 || location.getY() >= cols)
			//throw new Exception("Location out of bounds of the maze.");
		
		Room curRoom = roomMaze[location.getX()][location.getY()];
		
		switch(direction)
		{
			case North: return determineType(direction, curRoom.upperDoor);
			case South: return determineType(direction, curRoom.lowerDoor);
			case East: return determineType(direction, curRoom.rightDoor);
			case West: return determineType(direction, curRoom.leftDoor);
			default: return CellType.Wall;
		}//end switch
	}
	
	public CellType determineType(Direction direction, Door door)
	{
		if(door.getClass().getSimpleName().equals("NullDoor"))
			return CellType.Wall;
		else if(isDoor(door) && !door.isUnlocked())
			return CellType.Door;
		else if(isDoor(door) && door.isUnlocked() && direction == Direction.West || direction == Direction.East)
			return CellType.UnlockedDoorVert;
		else if(isDoor(door) && door.isUnlocked() && direction == Direction.North || direction == Direction.South)
			return CellType.UnlockedDoorHorz;
		else 
			return CellType.Room;
	}
	
	public void unlockDoor(Location location, Direction direction)
	{
		int x = location.getX();
		int y = location.getY();
		
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
	
	public boolean[] getNeighboringRooms(int i, int j)
	{
		Room curRoom = this.roomMaze[i][j];
		
		boolean [] rooms = {false, false, false, false}; //North, South, East, West
		
		if(isDoor(curRoom.upperDoor))
			rooms[0] = true;
		else if(isDoor(curRoom.lowerDoor))
			rooms[1] = true;
		else if(isDoor(curRoom.rightDoor))
			rooms[2] = true;
		else if(isDoor(curRoom.leftDoor))
			rooms[3] = true;
		
		return rooms;
	}
	
	private boolean isDoor(Door door)
	{
		return door.getClass().getSimpleName().equals("Door");
	}
	
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

