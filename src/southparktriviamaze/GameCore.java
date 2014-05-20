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
		player = new Location(1, 1);
		mapConverter = new MazeConversion(map);
		int[][] array = mapConverter.convertedMaze();
		array[player.getX()][ player.getY()] = 5;
		window.mazeupdate(array);
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

							mapConverter = new MazeConversion(map);
							int[][] array = mapConverter.convertedMaze();
							array[player.getX()][ player.getY()] = 5;
							window.mazeupdate(array);
							
						}
				break;	
			case UnlockedDoorHorz: player = destination;
				mapConverter = new MazeConversion(map);
				int[][] array = mapConverter.convertedMaze();
				array[player.getX()][ player.getY()] = 5;
				window.mazeupdate(array);
				break;
			case UnlockedDoorVert: player = destination;
				mapConverter = new MazeConversion(map);
				int[][] array1 = mapConverter.convertedMaze();
				array1[player.getX()][ player.getY()] = 5;
				window.mazeupdate(array1);
				break;
			case Player://Impossible
				break;
		}
	}

}
