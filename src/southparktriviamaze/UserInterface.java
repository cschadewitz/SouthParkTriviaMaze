package southparktriviamaze;



import java.awt.EventQueue;

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
//=============================

public class UserInterface {
	private static GameCore core;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("HELLO WORLD");
		UserInterface window;
		//UpdateMaze upDateMazeData;
		try {	
			
			
			window = new UserInterface();

			core = new GameCore(window, args);

			core.startGame();
			
			txtrTest.invalidate();

			
			//QuestionDisplay question = new QuestionDisplay();
			//System.out.println(question.askQuestion("I am Flying!!!!", "T", "F", null, null));
			
//			window.toggleButttonsOff();
//			boolean TF = QuestionDisplay.askQuestion();
//			window.toggleButtonsOn();
			
//			System.out.println(TF);
			
			
			//upDateMazeData = new UpdateMaze(window);
			
			
			
			
			//upDateMazeData.mazeData(maze);
			//window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	private JFrame frame;
	private static JTextArea txtrTest;
	private JButton btnMoveDown;
	private JButton btnMoveRight;
	private JButton btnMoveLeft;
	private JButton btnMoveUp;
	private JButton btnSave;
	private JButton btnHelp;
	private JButton btnQuit;
	private JButton btnTest;
	private JLabel imag;
	//private GameCore core;
	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
		//QuestionDisplay.askQuestion();
	}
	

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Kenny's Quest");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(0, 0, 772, 508);	//default size
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets window to full screen
		frame.setUndecorated(true);	//removes the title bar
		frame.setResizable(false);	//prevents resizing the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//===========================================================================

		//==========================================================================
		//Background picture needs to be resized
		//JLabel temp;
		try{
			
		ImageIcon image = new ImageIcon(ImageIO.read(new File("Resources/1411_coon-2-hindsight_1920x1200.jpg")));//the backgound picture
		imag = new JLabel(image);
		imag.setBounds(0, 0, 1080, 1920);
		
		//imag.setText("Menu");
		//temp = imag;
		frame.setContentPane(imag);
		//===========================================================================
		}
		catch(Exception e)
		{
			System.out.println("HELLO");
		}

		//=====================================================================
		
		
		//=====================================================================
		final JButton btnNewGame = new JButton("New Game");
		btnSave = new JButton("Save/Load");
		btnHelp = new JButton("HELP");
		final JButton btnQuitGame = new JButton("Quit Game");
		btnTest = new JButton("TEST");
				
		SpringLayout sl_imag = new SpringLayout();
		sl_imag.putConstraint(SpringLayout.WEST, btnNewGame, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnTest, 6, SpringLayout.SOUTH, btnQuitGame);
		sl_imag.putConstraint(SpringLayout.EAST, btnTest, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.NORTH, btnQuitGame, 6, SpringLayout.SOUTH, btnHelp);
		sl_imag.putConstraint(SpringLayout.EAST, btnQuitGame, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.NORTH, btnHelp, 6, SpringLayout.SOUTH, btnSave);
		sl_imag.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, btnNewGame);
		sl_imag.putConstraint(SpringLayout.WEST, btnTest, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, btnQuitGame, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, btnHelp, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnSave, 6, SpringLayout.SOUTH, btnNewGame);
		sl_imag.putConstraint(SpringLayout.WEST, btnSave, 0, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.NORTH, btnNewGame, 35, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().setLayout(sl_imag);
		frame.getContentPane().add(btnNewGame);
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(btnHelp);
		frame.getContentPane().add(btnQuitGame);
		frame.getContentPane().add(btnTest);
		//=========================Panel start up================================
		final JPanel panel = new JPanel();
		sl_imag.putConstraint(SpringLayout.EAST, panel, -100, SpringLayout.EAST, imag);
		panel.setVisible(false);
		

		
		
		
		//========================================================================
		// panel.add(picLabel);
		 
		 txtrTest = new JTextArea();
		 //setup font=============================================================
		 try
		 {
			// File fontFile = new File("/mazeCells");
			 InputStream mazeF = new FileInputStream("Resources//MazeCells.TTF");
			 
		 Font mazeFont = Font.createFont(Font.TRUETYPE_FONT, mazeF);
		 GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		 genv.registerFont(mazeFont);
		 // makesure to derive the size
		 mazeFont = mazeFont.deriveFont(50f);
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
		 
		// txtrTest.setFont(new Font("Monospaced", Font.BOLD, 22));
		 
		 txtrTest.setEditable(false);
		 //txtrTest.set
		 panel.add(txtrTest);
		 panel.setOpaque(false);
		 txtrTest.setBounds(1920/2 - 450, 1080/2 - 400, 650, 670);
		 //panel.setBounds(1920/2 - 325, 1080/2 - 335, 650, 670);
		 
	//	UpdateMaze upDateMazeData = new UpdateMaze(this);
	//	upDateMazeData.paintMaze(txtrTest);
		
		
//		public void upMaze(int[][] maze)
//		{
//			try
//			{
//			txtrTest.setText("");
//			for(int i=0; i<maze.length; i++)
//			{
//				for(int j=0; j<maze[i].length; j++)
//				{
//					txtrTest.setText(txtrTest.getText() + maze[i][j]);
//				}
//				txtrTest.setText(txtrTest.getText() + "\n");
//			}
//			}
//			catch(Exception e)
//			{
//				txtrTest.setText("No maze yet\n ");
//			}
//		}
		
		
		//========================================================================

		
		//panel.setVisible(false);
		

		sl_imag.putConstraint(SpringLayout.EAST, btnNewGame, -21, SpringLayout.WEST, panel);
		sl_imag.putConstraint(SpringLayout.NORTH, panel, 35, SpringLayout.NORTH, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.WEST, panel, 119, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel.setBounds(1920/2 - 325, 1080/2 - 335, 650, 670);
		
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
		lblKennysQuest.setForeground(new Color(128, 128, 0));
		sl_imag.putConstraint(SpringLayout.WEST, lblKennysQuest, 10, SpringLayout.WEST, frame.getContentPane());
		sl_imag.putConstraint(SpringLayout.SOUTH, lblKennysQuest, -1, SpringLayout.NORTH, btnNewGame);
		lblKennysQuest.setFont(new Font("Pristina", Font.BOLD, 24));
		frame.getContentPane().add(lblKennysQuest);
		//=======================================================
//		try//working on loading a picture here for startup 
//		{
//		BufferedImage image = ImageIO.read(new File("Resources/testpic.jpg"));
//		JLabel picLabel = new JLabel(new ImageIcon(image));
////		 panel.add(picLabel);
////		 
////		 JTextArea txtrTest = new JTextArea();
////		 
////		 txtrTest.setEditable(false);
////		 txtrTest.setText("test");
////		 txtrTest.setBounds(37, 31, 555, 302);
////		 panel.add(txtrTest);
//		//panel.repaint();
//
//		}
//		catch(Exception e)
//		{
//			System.out.println("Failed to load picture");
//			panel.setBackground(new Color(103, 245, 34));
//		}
//		panel.repaint();
		//=======================================================
		//--------------Test-------------------------------------
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("test button still works!!!");	
				
				
				txtrTest.setText("5103030111011101\n"
								+"2141114111411141\n"
								+"0303030111030301\n"
								+"0000011110000000\n"
								+"0001110011100011\n"
								+"0011000001000000\n"
								+"0110000001111111\n");
				
				}
		});
		

		//========================================================
		//--------------Quit Game---------------------------------
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		//========================================================
		//-------------New GAme----------------------------------
		btnNewGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("NEW GAME!!!");
				
				if(btnNewGame.getText().compareTo("New Game") == 0)
				{
				btnNewGame.setText("Menu");
				btnSave.setVisible(false);
				btnHelp.setVisible(false);
				panel.setVisible(true);
				
				btnMoveUp.setVisible(true);
				btnMoveDown.setVisible(true);
				btnMoveLeft.setVisible(true);
				btnMoveRight.setVisible(true);
				//core.startGame();
				}
				else if(btnNewGame.getText().compareTo("Resume") == 0)
				{
					btnNewGame.setText("Menu");
					btnSave.setVisible(false);
					btnHelp.setVisible(false);
				
					btnMoveUp.setVisible(true);
					btnMoveDown.setVisible(true);
					btnMoveLeft.setVisible(true);
					btnMoveRight.setVisible(true);
					
					panel.setVisible(true);
					
				}
				else
				{
					btnNewGame.setText("Resume");
					btnSave.setVisible(true);
					btnHelp.setVisible(true);
					panel.setVisible(false);
					
					btnMoveUp.setVisible(false);
					btnMoveDown.setVisible(false);
					btnMoveLeft.setVisible(false);
					btnMoveRight.setVisible(false);
				}
				
				
			}
		});
		//=====================================================================
		//MOVE North
		btnMoveUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				core.move(Direction.North);
			}
		});
		//=====================================================================
		//MOVE West
		btnMoveLeft.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				core.move(Direction.West);
			}
		});
		//=====================================================================
		//MOVE East
		btnMoveRight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
				core.move(Direction.East);
			}
		});
		//====================================================================
		//MOVE South
		btnMoveDown.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				core.move(Direction.South);
			}
		});
	}
		public void toggleButttonsOff()
		{
			btnMoveDown.setVisible(false);;
			btnMoveRight.setVisible(false);;
			btnMoveLeft.setVisible(false);;
			btnMoveUp.setVisible(false);
			return;
		}
		
		public void toggleButtonsOn()
		{
			btnMoveDown.setVisible(true);;
			btnMoveRight.setVisible(true);;
			btnMoveLeft.setVisible(true);;
			btnMoveUp.setVisible(true);
			return;
		}
		
		
		public void mazeupdate(int[][] maze)
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

	
	

//	class UpdateMaze
//	{
//		
//		private UserInterface mazeDisplay;
//		private int[][] maze;// = new int[2][2];
//		
//		public UpdateMaze(UserInterface mazeDisplay)
//		{
//			this.mazeDisplay = mazeDisplay;
//		}
//		
//		public void mazeData(int[][] maze)
//		{
//			this.maze = maze;
//		}
//		
//		
//		
//		public void paintMaze(final JTextArea txtrTest)
//		{
//			try
//			{
//			txtrTest.setText("");
//			for(int i=0; i<maze.length; i++)
//			{
//				for(int j=0; j<maze[i].length; j++)
//				{
//					txtrTest.setText(txtrTest.getText() + maze[i][j]);
//				}
//				txtrTest.setText(txtrTest.getText() + "\n");
//			}
//			}
//			catch(Exception e)
//			{
//				txtrTest.setText("No maze yet\n ");
//			}
//		}
//	}
//	
//
//	
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
