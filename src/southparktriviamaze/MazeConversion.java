/* MazeConversion.java
 * Author: Chris Purta
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class is used to convert the
 * maze into a displayable form and displays it.
 * 
 */
package southparktriviamaze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.JPanel;

	
	public class MazeConversion extends JPanel{
		
		private static final long serialVersionUID = 1L;
		private static final int CORNER = 1;
		private static final int ROOM = 0;
		private static final int WALL = 1;
		private static final int LOCKEDDOOR = 2;
		private static final int UNLOCKEDDOOR = 3;
		private static final int VERTUNLOCKEDDOOR = 4;
		private static final int PLAYER = 5;
		private static final int pixelWidth = 35, pixelLength = 35;
		
		private Image room, wall, lockedDoor, unlockedDoor, player;
		private Maze maze;
		private int[][] array;
		private int playerX, playerY/*, deltaX, deltaY*/;
		
		//Sets the maze reference
		//Parameters:
		//Maze maze reference to maze
		public void setMaze(Maze maze)
		{
			this.maze = maze;
		}
		

		//Initializes a new MazeConversion object
		//Parameters:
		//Maze m reference to the maze
		//int playerNum integer value representing a character
		public MazeConversion(Maze m, int playerNum) {
			this.maze = m;
			this.playerX = 1;
			this.playerY = 1;
			convertMazeToChar();
			
			try {
				this.room = new ImageIcon(ImageIO.read(new File("Room.png"))).getImage();
				
				this.wall = new ImageIcon(ImageIO.read(new File("Wall.png"))).getImage();

				this.lockedDoor = new ImageIcon(ImageIO.read(new File("lockedDoor.png"))).getImage();

				this.unlockedDoor = new ImageIcon(ImageIO.read(new File("unlockedDoor.png"))).getImage();
				
				switch(playerNum)
				{
					//Mysterion
					case 0: this.player = new ImageIcon(ImageIO.read(new File("MysterionRoom.png"))).getImage();
						break;
					//The Coon
					case 1: this.player = new ImageIcon(ImageIO.read(new File("TheCoonRoom.png"))).getImage();
						break;
					//Tool Shed
					case 2: this.player = new ImageIcon(ImageIO.read(new File("ToolShedRoom.png"))).getImage();
						break;
					//Human Kite
					case 3: this.player = new ImageIcon(ImageIO.read(new File("HumanKiteRoom.png"))).getImage();
						break;
					//Professor Chaos
					case 4: this.player = new ImageIcon(ImageIO.read(new File("ProfessorChaosRoom.png"))).getImage();
						break;
					//Default Myseterion
					default: this.player = new ImageIcon(ImageIO.read(new File("MyseterionRoom.png"))).getImage();
				}//end switch
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}//end mazeConversion
		
		//Sets the converted maze array
		//Parameters:
		//int[][] a sets the convertedMaze to the table of a
		public void setConvertedMaze(int[][] a)
		{
			this.array = a;
		}
		
		//Returns the converted maze array
		//Returns:
		//int[][] reference to maze array
		public int[][] convertedMaze()
		{
			return array;
		}
	
		//Converts the maze to a converted maze array
		private void convertMazeToChar() {
			this.array = new int[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
			this.array = initializeIntArray();
			
			tearDownWallsToDoors();
			this.array[this.playerX][this.playerY] = PLAYER;
		}
	
		//Tears down walls to properly display
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
							this.array[i - 1][j] = VERTUNLOCKEDDOOR;
						
						if(neighboringRooms[1] && !this.maze.southDoorUnlocked(i/2, j/2))//South locked
							this.array[i + 1][j] = LOCKEDDOOR;
						
						if(neighboringRooms[1] && this.maze.southDoorUnlocked(i/2, j/2))//South unlocked
							this.array[i + 1][j] = VERTUNLOCKEDDOOR;
						
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
	
		//Initializes an int array for converted maze array
		//Returns:
		//int[][] converted maze array
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
		
		//Prints the map to the console
		public void printCharMaze()
		{
			for(int i = 0; i < array.length; i++)
			{
				for(int j = 0; j < array[i].length; j++)
					System.out.print(array[i][j] + " ");
				
				System.out.println();
			}//end for i
			
			System.out.println();
		}//end printCharMaze
		
		//Repaints the display
		public void paintComponent(Graphics g)
		{
			//pack();
			super.paintComponent(g);
			final int OFFSET = 0;
			
			for(int i = 0; i < this.array.length; i++)
				for(int j = 0; j < this.array[i].length; j++)
				{
					if(this.array[i][j] == CORNER || this.array[i][j] == WALL)
						g.drawImage(wall, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
					if(this.array[i][j] == ROOM)
						g.drawImage(room, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
					if(this.array[i][j] == LOCKEDDOOR)
						g.drawImage(lockedDoor, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
					if(this.array[i][j] == UNLOCKEDDOOR)
						g.drawImage(unlockedDoor, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
					if(this.array[i][j] == VERTUNLOCKEDDOOR)
						g.drawImage(unlockedDoor, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
					if(this.array[i][j] == PLAYER)
						g.drawImage(player, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
				}//end for j
			
		}//end paintComponent

//		
	
	}
