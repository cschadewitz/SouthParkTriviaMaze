	package southparktriviamaze;

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
//import javax.swing.Timer;
	
	public class MazeConversion extends JPanel /*implements ActionListener, KeyListener*/{
		
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
		private static final int pixelWidth = 25, pixelLength = 25;
		
		private Image room, wall, lockedDoor, unlockedDoor, player;
		
		//private Timer timer = new Timer(100, this);
		private Maze maze;
		private int[][] array;
		private int playerX, playerY/*, deltaX, deltaY*/;
		public void setMaze(Maze maze)
		{
			this.maze = maze;
		}
		
//		public static void main(String[] args)
//		{
//			Maze maze = null;
//			try {
//				maze = new Maze(10, 10);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			MazeConversion mC = new MazeConversion(maze);
//						
//			JFrame frame = new JFrame();
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setSize(800, 800);
//	        frame.add(mC);
//	        frame.setVisible(true);
//	        frame.setLocationRelativeTo(null);
//		}
		
		public MazeConversion(Maze m, int playerNum) {
//			this.timer.start();
			this.maze = m;
			this.playerX = 1;
			this.playerY = 1;
			convertMazeToChar();
			
//			addKeyListener(this);
//			setFocusable(true);
//			setFocusTraversalKeysEnabled(false);
			
			try {
				this.room = new ImageIcon(ImageIO.read(new File("Resources/Room.png"))).getImage();
				
				this.wall = new ImageIcon(ImageIO.read(new File("Resources/Wall.png"))).getImage();

				this.lockedDoor = new ImageIcon(ImageIO.read(new File("Resources/lockedDoor.png"))).getImage();

				this.unlockedDoor = new ImageIcon(ImageIO.read(new File("Resources/unlockedDoor.png"))).getImage();
				
				switch(playerNum)
				{
					//Mysterion
					case 0: this.player = new ImageIcon(ImageIO.read(new File("Resources/MysterionRoom.png"))).getImage();
						break;
					//The Coon
					case 1: this.player = new ImageIcon(ImageIO.read(new File("Resources/TheCoonRoom.png"))).getImage();
						break;
					//Tool Shed
					case 2: this.player = new ImageIcon(ImageIO.read(new File("Resources/ToolShedRoom.png"))).getImage();
						break;
					//Human Kite
					case 3: this.player = new ImageIcon(ImageIO.read(new File("Resources/HumanKiteRoom.png"))).getImage();
						break;
					//Professor Chaos
					case 4: this.player = new ImageIcon(ImageIO.read(new File("Resources/ProfessorChaosRoom.png"))).getImage();
						break;
					//Default Myseterion
					default: this.player = new ImageIcon(ImageIO.read(new File("Resources/MyseterionRoom.png"))).getImage();
				}//end switch
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}//end mazeConversion
		
		public void setConvertedMaze(int[][] a)
		{
			this.array = a;
		}
		
		public int[][] convertedMaze()
		{
			return array;
		}
	
		private void convertMazeToChar() {
			this.array = new int[2 * maze.getRows() + 1][2 * maze.getCols() + 1];
			this.array = initializeIntArray();
			
			tearDownWallsToDoors();
			this.array[this.playerX][this.playerY] = PLAYER;
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
			
			System.out.println();
		}//end printCharMaze
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			final int OFFSET = 30;
			
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
					if(this.array[i][j] == PLAYER)
						g.drawImage(player, j * pixelLength + OFFSET, i * pixelWidth + OFFSET, null);
				}//end for j
			
		}//end paintComponent

//		@Override
//		public void keyTyped(KeyEvent e) {
//			
//		}
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			int keyCode = e.getKeyCode();
//			
//			if(keyCode == KeyEvent.VK_UP && this.playerY > 1)//Move UP
//			{
//				this.deltaX = 0;
//				this.deltaY = -2;
//			}
//			
//			if(keyCode == KeyEvent.VK_DOWN && this.playerY < this.array[this.array.length - 1].length - 2)//Move DOWN
//			{
//				this.deltaX = 0;
//				this.deltaY = 2;
//			}
//			
//			if(keyCode == KeyEvent.VK_RIGHT && this.playerX < this.array[playerX].length - 2)//Move RIGHT
//			{
//				this.deltaX = 2;
//				this.deltaY = 0;
//			}
//			
//			if(keyCode == KeyEvent.VK_LEFT && this.playerX > 1)//Move LEFT
//			{
//				this.deltaX = -2;
//				this.deltaY = 0;
//			}
//			
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//			this.deltaX = 0;
//			this.deltaY = 0;
//		}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			this.array[this.playerY][this.playerX] = ROOM;
//			this.array[(this.playerY + this.playerY + deltaY)/2][(this.playerX + this.playerX + deltaX)/2] = UNLOCKEDDOOR;
//			
//			this.playerX += deltaX;
//			this.playerY += deltaY;
//			
//			this.array[this.playerY][this.playerX] = PLAYER;
//						
//			repaint();
//		}
	
	}
