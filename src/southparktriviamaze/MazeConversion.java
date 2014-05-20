package southparktriviamaze;

public class MazeConversion {
	
	private static final char CORNER = 'C';
	private static final char ROOM = 'R';
	private static final char WALL = 'W';
	private static final char LOCKEDDOOR = 'D';
	private static final char UNLOCKEDDOOR = 'U';
	
	private Maze maze;
	private char[][] array;
	
	public MazeConversion(Maze m) {
		this.maze = m;
		convertMazeToChar();
	}

	private void convertMazeToChar() {
		this.array = new char[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
		
		this.array = initializeCharArray();
		
		tearDownWallsToDoors();
				
	}

	private void tearDownWallsToDoors() {
		for(int i = 1; i < array.length; i++)
			for(int j = 1; j < array[i].length; j++)
			{
				if(i % 2 == 1 && j % 2 == 1)
				{
					boolean neighboringRooms = this.maze.getNeighboringRooms(i/2, j/2);
					
					if(neighboringRooms[0])//North
						this.array[i - 1][j] = LOCKEDDOOR;
					
					else if(neighboringRooms[1])//South
						this.array[i + 1][j] = LOCKEDDOOR;
					
					else if(neighboringRooms[2])//East
						this.array[i][j + 1] = LOCKEDDOOR;
					
					else if(neighboringRooms[3])//West
						this.array[i][j - 1] = LOCKEDDOOR;
				}
				
			}//end for j
	}

	private char[][] initializeCharArray() {
		char [][] temp = new char[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
		
		for(int i = 0; i < temp.length; i++)
			for(int j = 0; j < temp[i].length; j++)
			{
				if(i % 2 == 0)
				{
					if(j % 2 == 0)
						temp[i][j] = CORNER;
					else
						temp[i][j] = WALL;
				}//end if
				
				else
				{
					if(j % 2 == 0)
						temp[i][j] = WALL;
					else
						temp[i][j] = ROOM;
				}//end else
				
			}//end for j
		
		return temp;
	}
	
	public void printCharMaze()
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array[i].length; j++)
				System.out.print(array[i][j] + " ");
			
			System.out.println();
		}//end for i
		
	}//end printCharMaze

}
