	package southparktriviamaze;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
		private static final int PLAYER = 5;
		private static final int pixelWidth = 50, pixelLength = 50;
		
		private Image room, wall, lockedDoor, unlockedDoor, player;
		
		private Maze maze;
		private int[][] array;
		
		public static void main(String[] args)
		{
			Maze maze = null;
			try{
			maze = new Maze(6, 6);
			}
			catch(Exception e)
			{
				System.out.println("too small");
			}
			MazeConversion mC = new MazeConversion(maze);
			
			mC.printCharMaze();
			
			JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(800, 800);
	        frame.add(mC);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
		}
		
		public MazeConversion(Maze m) {
			this.maze = m;
			convertMazeToChar();
			
			try {
				this.room = new ImageIcon(ImageIO.read(new File("Resources/Room.png"))).getImage();
				
				this.wall = new ImageIcon(ImageIO.read(new File("Resources/Wall.png"))).getImage();

				this.lockedDoor = new ImageIcon(ImageIO.read(new File("Resources/lockedDoor.png"))).getImage();

				this.unlockedDoor = new ImageIcon(ImageIO.read(new File("Resources/unlockedDoor.png"))).getImage();

				this.player = new ImageIcon(ImageIO.read(new File("Resources/KennyRoom.png"))).getImage();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			this.array[1][1] = PLAYER;
		}//end mazeConversion
		
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
							this.array[i - 1][j] = UNLOCKEDDOOR;
						
						if(neighboringRooms[1] && !this.maze.southDoorUnlocked(i/2, j/2))//South locked
							this.array[i + 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[1] && this.maze.southDoorUnlocked(i/2, j/2))//South unlocked
							this.array[i + 1][j] = UNLOCKEDDOOR;
						
						if(neighboringRooms[2] && !this.maze.eastDoorUnlocked(i/2, j/2))//East locked
							this.array[i][j + 1] = LOCKEDDOOR;
						
						if(neighboringRooms[2] && this.maze.eastDoorUnlocked(i/2, j/2))//East unlocked
							this.array[i][j + 1] = UNLOCKEDDOOR;
						
						if(neighboringRooms[3] && !this.maze.westDoorUnlocked(i/2, j/2))//West locked
							this.array[i][j - 1] = LOCKEDDOOR;
						
						if(neighboringRooms[3] && this.maze.westDoorUnlocked(i/2, j/2))//West unlocked
							this.array[i][j - 1] = UNLOCKEDDOOR;
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
						g.drawImage(wall, j * pixelLength, i * pixelWidth, null);
					if(this.array[i][j] == ROOM)
						g.drawImage(room, j * pixelLength, i * pixelWidth, null);
					if(this.array[i][j] == LOCKEDDOOR)
						g.drawImage(lockedDoor, j * pixelLength, i * pixelWidth, null);
					if(this.array[i][j] == UNLOCKEDDOOR)
						g.drawImage(unlockedDoor, j * pixelLength, i * pixelWidth, null);
					if(this.array[i][j] == PLAYER)
						g.drawImage(player, j * pixelLength, i * pixelWidth, null);
				}//end for j
			
		}//end paintComponent
	
	}
