package southparktriviamaze;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
	
	public class MazeConversion extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final int CORNER = 1;
		private static final int ROOM = 0;
		private static final int WALL = 1;
		private static final int LOCKEDDOOR = 2;
		private static final int UNLOCKEDDOOR = 3;
		
		private static final int pixelWidth = 100;
		private static final int pixelLength = 100;
		
		
		private Maze maze;
		private int[][] array;
		private Image room, wall, lockedDoor, unlockedDoor;
		
		public static void main(String [] args) throws Exception
		{
			Maze m = new Maze(5, 5);
			MazeConversion mC = new MazeConversion(m);
			
			JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(600, 600);
	        frame.add(mC);
	        frame.setVisible(true);
		}
		
		public MazeConversion(Maze m) {
			this.maze = m;
			convertMazeToChar();
			
			this.room = new ImageIcon("/Resources/Room.png").getImage();
			this.wall = new ImageIcon("/Resources/Wall.png").getImage();
			this.lockedDoor = new ImageIcon("/Resources/LockedDoor.png").getImage();
			this.unlockedDoor = new ImageIcon("/Resources/UnlockedDoor.png").getImage();
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
						
						if(neighboringRooms[0])//North
							this.array[i - 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[1])//South
							this.array[i + 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[2])//East
							this.array[i][j + 1] = LOCKEDDOOR;
						
						if(neighboringRooms[3])//West
							this.array[i][j - 1] = LOCKEDDOOR;
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
		
		public void paint(Graphics g)
		{
			super.paint(g);
			
			for(int i = 0; i < this.array.length; i++)
				for(int j = 0; j < this.array[i].length; j++)
				{
					if(this.array[i][j] == CORNER || this.array[i][j] == WALL)
						g.drawImage(wall, i * pixelWidth, j * pixelLength, null);
					if(this.array[i][j] == ROOM)
						g.drawImage(room, i * pixelWidth, j * pixelLength, null);
					if(this.array[i][j] == LOCKEDDOOR)
						g.drawImage(lockedDoor, i * pixelWidth, j * pixelLength, null);
					if(this.array[i][j] == UNLOCKEDDOOR)
						g.drawImage(unlockedDoor, i * pixelWidth, j * pixelLength, null);
				}//end for j
			
		}//end paintComponent
	
	}
