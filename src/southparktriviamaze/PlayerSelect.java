/*
 * Author: Olin L. Anderson
 * Revision: 1
 * Rev. Author:
 * Description: PlayerSelect class calls the GetPlayer class which displays a dialog box with 
 * the available players to select from. Once the player has been selects the getName method
 * in GetPlayer which returns the name of the player is called. and then the GetPlayer dialog box is
 * disposed of and the player name is returned.
 */
package southparktriviamaze;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
//import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class PlayerSelect
{
	/*
	 * calls the playerSelect class and then returns the enu of the player returned from the PlayerSelect getName method
	 * Parameters:
	 * none
	 * returns:
	 * Enum of the player name 
	 * throws:
	 * 
	 */
	public static Character getPlayer()
	{
		String playerName="";
		try {
			GetPlayer dialog = new GetPlayer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			playerName = dialog.getName();
			dialog.dispose();
			if(playerName.compareTo("Token") == 0)
			{
				return Character.Butters;
			}
			else if(playerName.compareTo("Stan") == 0)
			{
				return Character.Stan;
			}
			else if(playerName.compareTo("Kenny") == 0)
			{
				return Character.Kenny;
			}
			else if(playerName.compareTo("Kyle") == 0)
			{
				return Character.Kyle;
			}
			else if(playerName.compareTo("Cartmen") == 0)
			{
				return character.Cartman;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

class GetPlayer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnKenny;
	private JButton btnToken;
	private JButton btnKyle;
	private JButton btnStan;
	private JButton btnCartman;
	private String playerName="";
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			GetPlayer dialog = new GetPlayer();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public GetPlayer() {
		setBounds(100, 100, 740, 275);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.YELLOW);
		contentPanel.setBackground(Color.GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		//setOpacity(.8f);
		//contentPanel.setOpaque(false);
		setLocationRelativeTo(null);
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnKenny = new JButton("");
			btnKenny.setBorderPainted(false);
			btnKenny.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					if(e.getKeyCode() == KeyEvent.VK_ENTER)
					{
						playerName = "Kenny";
						contentPanel.setVisible(false);
					}
					if(e.getKeyCode() == KeyEvent.VK_LEFT)
					{
						btnKyle.requestFocus();
					}
					if(e.getKeyCode() == KeyEvent.VK_RIGHT)
					{
						btnStan.requestFocus();
					}
				}
			});
			btnKenny.setBackground(Color.GRAY);
			btnKenny.setSize(new Dimension(75, 100));
			///btnKenny.setOpaque(true);
			setOpacity(.9f);
			btnKenny.setIcon(new ImageIcon(new ImageIcon("Resources\\KennyMcCormick.png").getImage().getScaledInstance(btnKenny.getWidth(),  btnKenny.getHeight(), java.awt.Image.SCALE_SMOOTH)));
			btnKenny.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					playerName = "Kenny";
					setVisible(false);
				}
			});
		}
		
		btnStan = new JButton("");
		btnStan.setBorderPainted(false);
		btnStan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					playerName = "Stan";
					contentPanel.setVisible(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					btnKenny.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					btnCartman.requestFocus();
				}
			}
		});
		btnStan.setBackground(Color.GRAY);
		btnStan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = "Stan";
				setVisible(false);
			}
		});
		btnStan.setSize(new Dimension(60, 100));
		btnStan.setIcon(new ImageIcon(new ImageIcon("Resources\\StanMarsh.png").getImage().getScaledInstance(btnStan.getWidth(),  btnStan.getHeight(), java.awt.Image.SCALE_SMOOTH)));

		btnCartman = new JButton("");
		btnCartman.setBorderPainted(false);
		btnCartman.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					playerName = "Cartman";
					contentPanel.setVisible(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					btnStan.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					btnToken.requestFocus();
				}
			}
		});
		btnCartman.setBackground(Color.GRAY);
		btnCartman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = "Cartman";
				setVisible(false);
			}
		});
		btnCartman.setSize(new Dimension(90, 100));
		btnCartman.setIcon(new ImageIcon(new ImageIcon("Resources\\EricCartman.png").getImage().getScaledInstance(btnCartman.getWidth(),  btnCartman.getHeight(), java.awt.Image.SCALE_SMOOTH)));

		btnKyle = new JButton("");
		btnKyle.setBorderPainted(false);
		btnKyle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					playerName = "Kyle";
					contentPanel.setVisible(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					btnToken.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					btnKenny.requestFocus();
				}
				
			}
		});
		btnKyle.setBackground(Color.GRAY);
		btnKyle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = "Butters";
				setVisible(false);
			}
			
		});
		btnKyle.setSize(new Dimension(75, 100));
		btnKyle.setIcon(new ImageIcon(new ImageIcon("Resources\\KyleBroflovski.png").getImage().getScaledInstance(btnKyle.getWidth(),  btnKyle.getHeight(), java.awt.Image.SCALE_SMOOTH)));

		btnToken = new JButton("");
		btnToken.setBorderPainted(false);
		btnToken.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					playerName = "Token";
					contentPanel.setVisible(false);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					btnCartman.requestFocus();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					btnKyle.requestFocus();
				}
				
			}
		});
		btnToken.setBackground(Color.GRAY);
		btnToken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				playerName = "Token";
				setVisible(false);
			}
		});
		btnToken.setSize(new Dimension(75, 100));
		btnToken.setIcon(new ImageIcon(new ImageIcon("Resources\\TokenBlack.png").getImage().getScaledInstance(btnToken.getWidth(),  btnToken.getHeight(), java.awt.Image.SCALE_SMOOTH)));

		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addGap(112)
					.addComponent(btnToken, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnKyle, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnKenny, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnStan, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCartman, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(106))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCartman, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnToken, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKyle, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnStan, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnKenny, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(106, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
	}
	public String getName()
	{
	return this.playerName;	
	}
}
