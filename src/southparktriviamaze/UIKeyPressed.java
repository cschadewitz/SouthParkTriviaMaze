/*UIKeyPressed
 //*Author: Olin L. Anderson
 //*Revision: 2
 ///Rev. Author:
 //*Description: Support class for the UserInterface class which listens for key presses
 //*				and sends gameCore move instructions when appropriate keys have been pressed. 
 */
package southparktriviamaze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class UIKeyPressed extends KeyAdapter {

	private GameCore core;

	/*sets what the instance of the game core
//	 * parameters:
//	 * GameCore core the instance of the game core
//	 * returns:
//	 * void
//	 * throws:
	 * 
	 */
	public void setCore(GameCore core)
	{
		this.core = core;
	}
	
	/*
//	 * checks which key was pressed on the keyboard and calls a move instruction of the corect keys are ressed
//	 * Parameters:
//	 * KeyEvent arg0 The data for which key was pressed.
//	 * Returns:
//	 * void
//	 * throws:
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		
		if(arg0.getKeyChar() == 'W' || arg0.getKeyChar() == 'w')
		{
			core.move(Direction.North);
		}
		else if(arg0.getKeyChar() == 'A' || arg0.getKeyChar() == 'a')
		{
			core.move(Direction.West);
		}
		else if(arg0.getKeyChar() == 'S' || arg0.getKeyChar() == 's')
		{
			core.move(Direction.South);
		}
		else if(arg0.getKeyChar() == 'D' || arg0.getKeyChar() == 'd')
		{
			core.move(Direction.East);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			core.move(Direction.West);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			core.move(Direction.East);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			core.move(Direction.North);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			core.move(Direction.South);
		}
	}

}