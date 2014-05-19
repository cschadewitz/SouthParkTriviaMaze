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
 * 	Work that needs to be done: 
 * 
 *	1.) Needs to set up Rooms with doors in the proper place.
 *	2.) Need to set up a display method (look at toString() )
 */

public class Maze
{
	private Cell[][] cellMaze;
	private int startX, startY, endX, endY;
	private int rows;
	private int cols;
	
	/*
	 * Cell class that holds the coordinates of the Cell tells whether or not 
	 * the Cell has been visited and contains four walls that will tear down
	 * certain walls upon creation of the maze.  
	 */
	private class Cell
	{
		private int x, y;
		private boolean visited;
		private Room room;
		
		public Cell(int i, int j, boolean v)
		{
			this.x = i;
			this.y = j;
			this.visited = v;
			this.room = new Room();
		}

		public void setNorthDoor() {
			this.room.setUpperDoor(new Door());
		}

		public void setSouthDoor() {
			this.room.setLowerDoor(new Door());;
		}

		public void setEastDoor() {
			this.room.setRightDoor(new Door());;
		}

		public void setWestDoor() {
			this.room.setLeftDoor(new Door());;
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
		
		
	}//end Cell class
	
	public Maze()
	{
		this.rows = 10;
		this.cols = 10;
		this.startX = 0;
		this.startY = 0;
		this.endX = this.rows - 1;
		this.endY = this.cols - 1;
		
		this.cellMaze = new Cell[this.rows][this.cols];
		
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
		
		this.cellMaze = new Cell[this.rows][this.cols];
		
		mazeGenerator();
		
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getCols() {
		return this.cols;
	}
	
	private void mazeGenerator()
	{
		/*
		 * Recursive backtracking algorithm found from: http://en.wikipedia.org/wiki/Maze_generation_algorithm
		 */
		
		Cell curCell;
		int totalCells = this.rows * this.cols;
		int visitedCells = 0;
		Stack<Cell> cellStack = new Stack<Cell>();
		Random rand = new Random();
		ArrayList<Cell> visitedNeighbors;
		
		//Initialize each cell with the co-ordinates and visited to be false 
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++)
				cellMaze[i][j] = new Cell(i, j, false);
		
		curCell = cellMaze[startX][startY];
		curCell.setVisited(true);
		visitedCells++;
		
		while(visitedCells < totalCells)
		{
			visitedNeighbors = getVisitedNeighbors(curCell);
			
			if(visitedNeighbors.size() > 0)
			{
				int randIndex = rand.nextInt(visitedNeighbors.size());
				Cell randCell = visitedNeighbors.get(randIndex);
				
				cellStack.push(curCell);
				removeWalls(curCell, randCell);
				curCell = randCell;
				curCell.setVisited(true);
				visitedCells++;
			}//end if
			
			else if(!cellStack.empty())
				curCell = cellStack.pop();
			
			else
			{
				curCell = cellMaze[rand.nextInt(this.rows)][rand.nextInt(this.cols)];
				
				while(curCell.isVisited())
					curCell = cellMaze[rand.nextInt(this.rows)][rand.nextInt(this.cols)];
				visitedCells++;
			}//end else
			
		}//end while
		
	}//end mazeGenerator

	
	private void removeWalls(Cell curCell, Cell randCell) {
		
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
		if(randCell.getY() == curCell.getY() && randCell.getX() == curCell.getX() - 1)
		{
			randCell.setSouthDoor();
			curCell.setNorthDoor();
		}//end if
		
		//Rand: Bottom
		if(randCell.getY() == curCell.getY() && randCell.getX() == curCell.getX() + 1)
		{
			randCell.setNorthDoor();
			curCell.setSouthDoor();
		}//end if
		
		//Rand: Right
		if(randCell.getX() == curCell.getX() && randCell.getY() == curCell.getY() + 1)
		{
			randCell.setWestDoor();
			curCell.setEastDoor();
		}//end if
		
		//Rand: Left
		if(randCell.getX() == curCell.getX() && randCell.getY() == curCell.getY() - 1)
		{
			randCell.setEastDoor();
			curCell.setWestDoor();
		}//end if
	}//end removeWalls

	private ArrayList<Cell> getVisitedNeighbors(Cell curCell) {
		
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		
		//Look at top...
		if(curCell.getX() - 1 >= 0 && !cellMaze[curCell.getX() - 1][curCell.getY()].isVisited())
			neighbors.add(cellMaze[curCell.getX() - 1][curCell.getY()]);
		
		//Look at bottom...
		if(curCell.getX() + 1 < rows && !cellMaze[curCell.getX() + 1][curCell.getY()].isVisited())
			neighbors.add(cellMaze[curCell.getX() + 1][curCell.getY()]);
		
		//Look at right...
		if(curCell.getY() + 1 < cols && !cellMaze[curCell.getX()][curCell.getY() + 1].isVisited())
			neighbors.add(cellMaze[curCell.getX()][curCell.getY() + 1]);
		
		//Look at right...
		if(curCell.getY() - 1 >= 0 && !cellMaze[curCell.getX()][curCell.getY() - 1].isVisited())
			neighbors.add(cellMaze[curCell.getX()][curCell.getY() - 1]);
		
		neighbors.trimToSize();
				
		return neighbors;
	}//end getVisitedNeighbors


}//end Maze class

