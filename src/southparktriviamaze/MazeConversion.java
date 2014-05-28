	package southparktriviamaze;
	
	public class MazeConversion {
		
		private static final int CORNER = 1;
		private static final int ROOM = 0;
		private static final int WALL = 1;
		private static final int LOCKEDDOOR = 2;
		private static final int UNLOCKEDDOORHORZ = 4;
		private static final int UNLOCKEDDOORVERT = 3;
		
		private Maze maze;
		private int[][] array;
		
		public MazeConversion(Maze m) {
			this.maze = m;
			convertMazeToChar();
		}
		
		public int[][] convertedMaze()
		{
			return array;
		}
	
		private void convertMazeToChar() {
			this.array = new int[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
			
			this.array = initializeIntArray();
			
			tearDownWallsToDoors();
					
		}
	
		private void tearDownWallsToDoors() {
			for(int i = 1; i < array.length; i++)
				for(int j = 1; j < array[i].length; j++)
				{
					if(i % 2 == 1 && j % 2 == 1)
					{
						boolean[] neighboringRooms = this.maze.getNeighboringRooms(i/2, j/2);//North, South, East, West
						
						if(neighboringRooms[0] && !this.maze.northDoorUnlocked(i/2, j/2))//North locked
							this.array[i - 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[0] && this.maze.northDoorUnlocked(i/2, j/2))//North unlocked
							this.array[i - 1][j] = UNLOCKEDDOORHORZ;
						
						if(neighboringRooms[1] && !this.maze.southDoorUnlocked(i/2, j/2))//South locked
							this.array[i + 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[1] && this.maze.southDoorUnlocked(i/2, j/2))//South unlocked
							this.array[i + 1][j] = UNLOCKEDDOORHORZ;
						
						if(neighboringRooms[2] && !this.maze.eastDoorUnlocked(i/2, j/2))//East locked
							this.array[i][j + 1] = LOCKEDDOOR;
						
						if(neighboringRooms[2] && this.maze.eastDoorUnlocked(i/2, j/2))//East unlocked
							this.array[i][j + 1] = UNLOCKEDDOORVERT;
						
						if(neighboringRooms[3] && !this.maze.westDoorUnlocked(i/2, j/2))//West locked
							this.array[i][j - 1] = LOCKEDDOOR;
						
						if(neighboringRooms[3] && this.maze.westDoorUnlocked(i/2, j/2))//West unlocked
							this.array[i][j - 1] = UNLOCKEDDOORVERT;
					}
					
				}//end for j
		}
	
		private int[][] initializeIntArray() {
			int [][] temp = new int[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
			
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
