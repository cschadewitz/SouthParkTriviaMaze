package southparktriviamaze;

import java.awt.EventQueue;

public class GameCore {
	
	private UserInterface window;
	private QuestionFactory questionFactory;
	private Maze map;
	private Location player;
	private String[] cheats;
	
	public GameCore(UserInterface userWindow, String[] cheats)
	{
		window = userWindow;
		questionFactory = new RandomQuestionFactory();
	}
	
	public char[][] StartGame()
	{
		map = new Maze();
		return new char[][]();
	}
	
	public void Move(Direction direction)
	{
		Location destination;
		destination = player.neighbor(direction);
		switch(map.getNeighborType(direction))
		{
			case Room: player = destination;
				//Update map display
				break;
			case Wall: //Display message
				break;
			case Door: if(true/*Display Question answered correctly*/)
						{
							player = destination;
							//Update map display
							
						}
				break;					
		}
	}

}
