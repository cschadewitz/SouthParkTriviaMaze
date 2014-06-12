/*UserInterface
 * Author: Olin L. Anderson
 * Revision: 2
 * Rev. Author: Casey Schadewitz
 * Description: the primary userInterface where the maze mas are displayed for the user and the user is able to chouse what 
 * direction they would like to go next. 
 */
package southparktriviamaze;

import java.awt.EventQueue;

//import javafx.embed.swing.JFXPanel;
//import javafx.scene.Scene;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Dimension;

import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

////////////////////////////////
//import java.io.*;
//import javax.imageio.*;
//import java.awt.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Button;

//===========================
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;

public class UserInterface 
{
	private static GameCore core;
	
	/*
	 * programs start location, displays the user interface screen and starts the game core
	 * Parameters:
	 * String[] args: the games cheat codes
	 * Returns:
	 * void
	 * throws:
	 * none
	 */
	public static void main(String[] args) 
	{
		UserInterface window;
		try 
		{	
			core = new GameCore(args);
			window = new UserInterface();
			core.setWindow(window);
			core.startGame();
			txtrTest.invalidate();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private JFrame frame;
	private static JPanel panel;
	private static JTextArea txtrTest;
	private JButton btnMoveDown;
	private JButton btnMoveRight;
	private JButton btnMoveLeft;
	private JButton btnMoveUp;
	private JButton btnHelp;
	private JButton btnQuitt;
//	private JButton btnQuit;
	private JLabel imag;
	private JPanel panelSound = new JPanel();
//	private final JFXPanel fxSound = new JFXPanel();
	private MazeConversion mapConverter;
//	protected void setMedia(MediaPair media)
//	{
//		Scene scene = SpecialEffects.createScene(media);
//		fxSound.setScene(scene);
//	}
	private UIKeyPressed key = new UIKeyPressed();
	
	//private GameCore core;
	/*
	 * calls the initialization of the UserInterface
	 * Parameters:
	 * none
	 * Returns:
	 * void
	 * throws:
	 * none
	 */
	public UserInterface() 
	{
		initialize();
	}
/*
 * Initializes the UserInterface class and displays the game screen
 * the UserInterface was designed using eclipse windowBuilder plugin and 
 * then the code was modified by Olin L. Anderson for the appropriate 
 * key listeners and button actions.
 */
	private void initialize() 
	{
		frame = new JFrame("Kenny's Quest");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 772, 508);	//default size
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets window to full screen
		frame.setUndecorated(true);	//removes the title bar
		frame.setResizable(false);	//prevents resizing the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//===========================================================================
		frame.addKeyListener(key);
		frame.requestFocusInWindow();
		//==========================================================================
		try
		{
		ImageIcon image = new ImageIcon(ImageIO.read(new File("Resources/1411_coon-2-hindsight_1920x1200.jpg")));//the backgound picture
		imag = new JLabel(image);
		imag.setBounds(0, 0, 1080, 1920);
		frame.setContentPane(imag);
		//===========================================================================
		}
		catch(Exception e)
		{
			System.out.println("Picture Failure");
		}
		//=====================================================================
		final JButton btnNewGame = new JButton("New Game");
		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				UserHelp.help();
			}
		});
		btnQuitt = new JButton("Quit");
		btnQuitt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.setVisible(false);
				frame.dispose();
			}
		});
		SpringLayout sl_imag = new SpringLayout();
		sl_imag.putConstraint(SpringLayout.WEST, btnNewGame, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnQuitt, 6, SpringLayout.SOUTH, btnHelp);
		sl_imag.putConstraint(SpringLayout.EAST, btnQuitt, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.WEST, btnQuitt, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnHelp, 6, SpringLayout.SOUTH, btnNewGame);
		sl_imag.putConstraint(SpringLayout.WEST, btnHelp, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnNewGame, 35, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().setLayout(sl_imag);
		frame.getContentPane().add(btnNewGame);
		frame.getContentPane().add(btnHelp);
		frame.getContentPane().add(btnQuitt);
		//=========================Panel start up================================
		panel = new JPanel();
		sl_imag.putConstraint(SpringLayout.EAST, panel, -100, SpringLayout.EAST, imag);
		panel.setVisible(false);
		//=========================================================================
		 txtrTest = new JTextArea();
		 //setup font=============================================================
		 try
		 {
			 InputStream mazeF = new FileInputStream("Resources//MazeCells.TTF");
			 
			 Font mazeFont = Font.createFont(Font.TRUETYPE_FONT, mazeF);
			 GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			 genv.registerFont(mazeFont);
			 // makesure to derive the size
			 mazeFont = mazeFont.deriveFont(35f);
			 txtrTest.setFont((mazeFont));
			 txtrTest.setBackground(Color.DARK_GRAY);
		 	 txtrTest.setForeground(Color.BLACK);
		 }
		 catch(Exception e)
		 {
			 System.out.println("The font was nott found");
			 txtrTest.setFont(new Font("Monospaced", Font.BOLD, 22));
		 }
		 //=======================================================================
		 
		 txtrTest.setEditable(false);
		 panel.add(txtrTest);
		 panel.setOpaque(true);
		 txtrTest.setBounds(1920/2 + 50, 1080/2 - 500, 300, 300);
		 
		sl_imag.putConstraint(SpringLayout.EAST, btnNewGame, -21, SpringLayout.WEST, panel);
		sl_imag.putConstraint(SpringLayout.NORTH, panel, 35, SpringLayout.NORTH, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, panel, 119, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel.setBounds(1920/2 - 325, 1080/2 - 335, 1050, 670);
		
		final JButton btnMoveUp = new JButton("UP");
		sl_imag.putConstraint(SpringLayout.SOUTH, panel, -17, SpringLayout.NORTH, btnMoveUp);
		sl_imag.putConstraint(SpringLayout.EAST, btnMoveUp, -97, SpringLayout.EAST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, btnMoveUp, -182, SpringLayout.EAST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.SOUTH, btnMoveUp, -67, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnMoveUp);
		btnMoveUp.setVisible(false);
		
		final JButton btnMoveLeft = new JButton("LEFT");

		frame.getContentPane().add(btnMoveLeft);
		btnMoveLeft.setVisible(false);
		
		final JButton btnMoveRight = new JButton("RIGHT");
		
		sl_imag.putConstraint(SpringLayout.WEST, btnMoveLeft, -93, SpringLayout.WEST, btnMoveRight);
		sl_imag.putConstraint(SpringLayout.EAST, btnMoveLeft, -8, SpringLayout.WEST, btnMoveRight);
		sl_imag.putConstraint(SpringLayout.EAST, btnMoveRight, -50, SpringLayout.EAST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, btnMoveRight, -135, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnMoveRight);
		btnMoveRight.setVisible(false);

		panel.setBounds(1920/2 - 325, 1080/2 - 335, 650, 670);
		panelSound.setBackground(new Color(255, 255, 255));
		panelSound.setBounds(523, 13, 18, 18);
		panel.add(panelSound);
		panelSound.setVisible(false);
//		panelSound.add(fxSound);
		
		JPanel mazePanel = new JPanel();
		mazePanel.setBounds(12, 13, 600, 600);
		panel.add(mazePanel);
		mapConverter = new MazeConversion(core.getMaze(), 1);
		mazePanel.add(mapConverter);
		mapConverter.setVisible(true);
		mapConverter.setPreferredSize(new Dimension(600, 600));
		
		
		final JButton btnMoveDown = new JButton("DOWN");

		sl_imag.putConstraint(SpringLayout.SOUTH, btnMoveRight, -5, SpringLayout.NORTH, btnMoveDown);
		sl_imag.putConstraint(SpringLayout.SOUTH, btnMoveLeft, -5, SpringLayout.NORTH, btnMoveDown);
		sl_imag.putConstraint(SpringLayout.EAST, btnMoveDown, 0, SpringLayout.EAST, btnMoveUp);
		sl_imag.putConstraint(SpringLayout.WEST, btnMoveDown, -182, SpringLayout.EAST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnMoveDown, -33, SpringLayout.SOUTH, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.SOUTH, btnMoveDown, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnMoveDown);
		btnMoveDown.setVisible(false);
		
		JLabel lblKennysQuest = new JLabel("Kenny's Quest");
		lblKennysQuest.setForeground(Color.YELLOW);
		sl_imag.putConstraint(SpringLayout.WEST, lblKennysQuest, 10, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.SOUTH, lblKennysQuest, -1, SpringLayout.NORTH, btnNewGame);
		lblKennysQuest.setFont(new Font("Pristina", Font.BOLD, 24));
		frame.getContentPane().add(lblKennysQuest);
		//========================================================
		//-------------New Game----------------------------------
		btnNewGame.addActionListener(new ActionListener()
		{
			/*
			 * (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 * changes the visibility of the screens buttons and the display panel 
			 * Parameters:
			 * ActionEvent arg0: the newGame/menu/resume button is pressed
			 * returns:
			 * void
			 * throws:
			 * none
			 */
			public void actionPerformed(ActionEvent arg0)
			{
				if(btnNewGame.getText().compareTo("New Game") == 0)
				{
				btnNewGame.setText("Menu");
				btnHelp.setVisible(false);
				btnQuitt.setVisible(false);
				panel.setVisible(true);
				btnMoveUp.setVisible(true);
				btnMoveDown.setVisible(true);
				btnMoveLeft.setVisible(true);
				btnMoveRight.setVisible(true);
				frame.requestFocusInWindow();
				key.setCore(core);
				//core.startGame();
				}
				else if(btnNewGame.getText().compareTo("Resume") == 0)
				{
					btnNewGame.setText("Menu");
					btnHelp.setVisible(false);
					btnQuitt.setVisible(false);
					btnMoveUp.setVisible(true);
					btnMoveDown.setVisible(true);
					btnMoveLeft.setVisible(true);
					btnMoveRight.setVisible(true);
					panel.setVisible(true);
					frame.requestFocusInWindow();//==================================================
					key.setCore(core);
				}
				else
				{
					btnNewGame.setText("Resume");
					btnHelp.setVisible(true);
					btnQuitt.setVisible(true);
					panel.setVisible(false);
					btnMoveUp.setVisible(false);
					btnMoveDown.setVisible(false);
					btnMoveLeft.setVisible(false);
					btnMoveRight.setVisible(false);
					key.setCore(null);
				}
			}
		});
		//=====================================================================
		//MOVE North
		/*
		 * tells the game core what direction the user wants to move.
		 * Parameters:
		 * ActionEvent: arg0 the btnMoveUp button was pressed
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		btnMoveUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				core.move(Direction.North);
			}
		});
		//=====================================================================
		//MOVE West
		/*
		 * tells the game core what direction the user wants to move.
		 * Parameters:
		 * ActionEvent: arg0 the btnMoveLeft button was pressed
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		btnMoveLeft.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				core.move(Direction.West);
			}
		});
		//=====================================================================
		//MOVE East
		/*
		 * tells the game core what direction the user wants to move.
		 * Parameters:
		 * ActionEvent: arg0 the btnMoveRight button was pressed
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		btnMoveRight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				core.move(Direction.East);
			}
		});
		//====================================================================
		//MOVE South
		/*
		 * tells the game core what direction the user wants to move.
		 * Parameters:
		 * ActionEvent: arg0 the btnMoveDown button was pressed
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		btnMoveDown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				core.move(Direction.South);
			}
		});
	}
	/*
	 * sets the visibility of the btnMoveUp, btnMoveDown, btnmoveLeft, and btnMoveRight to false, the buttons are now not visible
	 * Parameters:
	 * none
	 * Returns:
	 * void
	 * throws:
	 * none
	 */
		public void toggleButttonsOff()
		{
			btnMoveDown.setVisible(false);;
			btnMoveRight.setVisible(false);;
			btnMoveLeft.setVisible(false);;
			btnMoveUp.setVisible(false);
			return;
		}
		/*
		 * sets the visibility of the btnMoveUp, btnMoveDown, btnmoveLeft, and btnMoveRight to true, the buttons are now visible
		 * Parameters:
		 * none
		 * Returns:
		 * void
		 * throws:
		 * none
		 */
		public void toggleButtonsOn()
		{
			btnMoveDown.setVisible(true);;
			btnMoveRight.setVisible(true);;
			btnMoveLeft.setVisible(true);;
			btnMoveUp.setVisible(true);
			return;
		}
		
		/*
		 * updates the GUI Maze map on the screen
		 * Parameters:
		 * Maze maze the GUI maze data
		 * Location player the cordinates of the player in the Maze
		 * Location Destination the location on the maze where the player now needs to go
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		public void mazeupdate(Maze maze, Location player, Location destiniation)
		{
			int[][] array;
			
			mapConverter.setMaze(maze);
			array = mapConverter.convertedMaze();
			array[player.getRow()][ player.getColumn()] = 0;
			array[destiniation.getRow()][destiniation.getColumn()] = 5;
			mapUpdate(array);
			mapConverter.printCharMaze();
			mapConverter.setConvertedMaze(array);
			mapConverter.repaint();
			
		}
		/*
		 * updates the text maze map on the user interface screen
		 * Parameters:
		 * int[][] maze an 2 dimetional integer array which prepresents the maze and the layers location in the maze
		 * returns:
		 * void
		 * throws:
		 * none
		 */
		
		private void mapUpdate(int[][] maze)
		{
			try
			{
			txtrTest.setText("");
			String board = "";
			for(int i=0; i<maze.length; i++)
			{
				for(int j=0; j<maze[i].length; j++)
				{
					board += txtrTest.getText() + maze[i][j];
				}
				board += (txtrTest.getText() + "\n");
			}
			txtrTest.setText(board);
			}
			catch(Exception e)
			{
				txtrTest.setText("No maze yet\n ");
			}
			txtrTest.invalidate();
		}
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
