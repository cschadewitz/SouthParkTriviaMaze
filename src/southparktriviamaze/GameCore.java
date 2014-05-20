package southparktriviamaze;

import java.awt.EventQueue;

public class GameCore {
	
	private UserInterface window;
	private QuestionFactory questionFactory;
	private Maze map;
	private Location player;
	private String[] cheats;
	private MazeConversion mapConverter;
	
	public GameCore(UserInterface userWindow, String[] cheats)
	{
		window = userWindow;
		questionFactory = new RandomQuestionFactory();
	}
	
	public void startGame()
	{
		map = new Maze();
		mapConverter = new MazeConversion(map);
		window.mazeupdate(mapConverter.printCharMaze());
	}
	public void move(Direction direction)
	{
		Location destination;
		destination = player.neighbor(direction);
		switch(map.getNeighborType(player.convertToCondensed(), direction))
		{
			case Room: player = destination;
				//Update map display
				break;
			case Wall: //Display message
				break;
			case Door: if(QuestionDisplay.askQuestion())
						{
							map.unlockDoor(player.convertToCondensed(), direction);
							player = destination;
							window.mazeupdate(maze);
							
						}
				break;	
			case UnlockedDoorHorz: player = destination;
				break;
			case UnlockedDoorVert: player = destination;
				break;
			case Player://Impossible
				break;
		}
	}

}
