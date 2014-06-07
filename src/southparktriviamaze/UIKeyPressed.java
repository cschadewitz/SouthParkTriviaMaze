package southparktriviamaze;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class UIKeyPressed extends KeyAdapter {

	private GameCore core;

	public void setCore(GameCore core)
	{
		this.core = core;
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {

		//System.out.println(arg0.getKeyChar());
		
		
		if(arg0.getKeyChar() == 'W' || arg0.getKeyChar() == 'w')
		{
			//System.out.println("HELLO OLIN YOU PRESSES W");
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

//	@Override
//	public void keyReleased(KeyEvent arg0) {
//
//	}
//
//	@Override
//	public void keyTyped(KeyEvent arg0) {
//
//		System.out.println(arg0.getKeyChar());
//	}

}
