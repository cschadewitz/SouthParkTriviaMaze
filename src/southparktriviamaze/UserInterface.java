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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import java.awt.Button;

public class UserInterface {

	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Kenny's Quest");
		frame.getContentPane().setBackground(new Color(100, 149, 237));
		
		frame.setBounds(0, 0, 772, 508);	//default size
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //sets window to full screen
		frame.setUndecorated(true);	//removes the title bar
		
		frame.setResizable(false);	//prevents resizing the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
		
		
		//==========================================================================
		//Background picture needs to be resized
		JLabel temp;
		try{
			
		ImageIcon image = new ImageIcon(ImageIO.read(new File("Resources/testpic1.jpg")));//the backgound picture
		JLabel imag = new JLabel(image);
		imag.setText("Menu");
		temp = imag;
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
		final JButton btnSave = new JButton("Save/Load");
		final JButton btnHelp = new JButton("HELP");
		final JButton btnQuitGame = new JButton("Quit Game");
		JButton btnTest = new JButton("TEST");
				
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, btnNewGame, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnTest, 6, SpringLayout.SOUTH, btnQuitGame);
		springLayout.putConstraint(SpringLayout.EAST, btnTest, 0, SpringLayout.EAST, btnNewGame);
		springLayout.putConstraint(SpringLayout.NORTH, btnQuitGame, 6, SpringLayout.SOUTH, btnHelp);
		springLayout.putConstraint(SpringLayout.EAST, btnQuitGame, 0, SpringLayout.EAST, btnNewGame);
		springLayout.putConstraint(SpringLayout.NORTH, btnHelp, 6, SpringLayout.SOUTH, btnSave);
		springLayout.putConstraint(SpringLayout.EAST, btnHelp, 0, SpringLayout.EAST, btnNewGame);
		springLayout.putConstraint(SpringLayout.EAST, btnSave, 0, SpringLayout.EAST, btnNewGame);
		springLayout.putConstraint(SpringLayout.WEST, btnTest, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnQuitGame, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnHelp, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnSave, 6, SpringLayout.SOUTH, btnNewGame);
		springLayout.putConstraint(SpringLayout.WEST, btnSave, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnNewGame, 35, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(btnNewGame);
		frame.getContentPane().add(btnSave);
		frame.getContentPane().add(btnHelp);
		frame.getContentPane().add(btnQuitGame);
		frame.getContentPane().add(btnTest);
		
		//=========================Panel start up================================
		final JPanel panel = new JPanel();
		panel.setVisible(false);
		
		//========================================================================
		// panel.add(picLabel);
		 
		 final JTextArea txtrTest = new JTextArea();
		 txtrTest.setFont(new Font("Monospaced", Font.BOLD, 22));
		 
		 txtrTest.setEditable(false);
		 txtrTest.setBounds(37, 31, 555, 324);
		 //txtrTest.set
		 panel.add(txtrTest);
		
		
		//========================================================================

		
		//panel.setVisible(false);
		

		springLayout.putConstraint(SpringLayout.EAST, btnNewGame, -21, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 35, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 119, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -26, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JButton btnMoveUp = new JButton("UP");
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -17, SpringLayout.NORTH, btnMoveUp);
		springLayout.putConstraint(SpringLayout.EAST, btnMoveUp, -97, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnMoveUp, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnMoveUp, -67, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnMoveUp);
		btnMoveUp.setVisible(false);
		
		final JButton btnMoveLeft = new JButton("LEFT");

		frame.getContentPane().add(btnMoveLeft);
		btnMoveLeft.setVisible(false);
		
		final JButton btnMoveRight = new JButton("RIGHT");
		
		springLayout.putConstraint(SpringLayout.WEST, btnMoveLeft, -93, SpringLayout.WEST, btnMoveRight);
		springLayout.putConstraint(SpringLayout.EAST, btnMoveLeft, -8, SpringLayout.WEST, btnMoveRight);
		springLayout.putConstraint(SpringLayout.EAST, btnMoveRight, -50, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnMoveRight, -135, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnMoveRight);
		btnMoveRight.setVisible(false);
		
		
		final JButton btnMoveDown = new JButton("DOWN");

		springLayout.putConstraint(SpringLayout.SOUTH, btnMoveRight, -5, SpringLayout.NORTH, btnMoveDown);
		springLayout.putConstraint(SpringLayout.SOUTH, btnMoveLeft, -5, SpringLayout.NORTH, btnMoveDown);
		springLayout.putConstraint(SpringLayout.EAST, btnMoveDown, 0, SpringLayout.EAST, btnMoveUp);
		springLayout.putConstraint(SpringLayout.WEST, btnMoveDown, -182, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, btnMoveDown, -33, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnMoveDown, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnMoveDown);
		btnMoveDown.setVisible(false);
		
		JLabel lblKennysQuest = new JLabel("Kenny's Quest");
		lblKennysQuest.setForeground(new Color(128, 128, 0));
		springLayout.putConstraint(SpringLayout.WEST, lblKennysQuest, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblKennysQuest, -1, SpringLayout.NORTH, btnNewGame);
		lblKennysQuest.setFont(new Font("Pristina", Font.BOLD, 24));
		frame.getContentPane().add(lblKennysQuest);
		
		//=======================================================
		try//working on loading a picture here for startup 
		{
		BufferedImage image = ImageIO.read(new File("Resources/testpic.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(image));
//		 panel.add(picLabel);
//		 
//		 JTextArea txtrTest = new JTextArea();
//		 
//		 txtrTest.setEditable(false);
//		 txtrTest.setText("test");
//		 txtrTest.setBounds(37, 31, 555, 302);
//		 panel.add(txtrTest);
		//panel.repaint();

		}
		catch(Exception e)
		{
			System.out.println("Failed to load picture");
			panel.setBackground(new Color(103, 245, 34));
		}
		panel.repaint();
		//=======================================================
		//--------------Test-------------------------------------
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("test button still works!!!");	
				
				
				txtrTest.setText("1110100101101001\n"
								+"0011111000101010\n"
								+"1010010010101000\n"
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
		//MOVE UP
		btnMoveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtrTest.setText(txtrTest.getText() + "\nMove UP");
			}
		});
		//=====================================================================
		//MOVE LEFT
		btnMoveLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrTest.setText(txtrTest.getText() + "\nMove LEFT");
			}
		});
		//=====================================================================
		//MOVE RIGHT
		btnMoveRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrTest.setText(txtrTest.getText() + "\nMove RIGHT");
			}
		});
		//====================================================================
		//MOVE DOWN
		btnMoveDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrTest.setText(txtrTest.getText() + "\nMove DOWN");
			}
		});
	}
}

