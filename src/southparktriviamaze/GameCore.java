package southparktriviamaze;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameCore {
	
	private UserInterface window;
	private QuestionFactory questionFactory;
	private Maze map;
	private Location player;
	private String[] cheats;
	private MazeConversion mapConverter;
	private int[][] array;
	
	public GameCore(UserInterface userWindow, String[] cheats)
	{
		window = userWindow;
		questionFactory = new RandomQuestionFactory();
		
	}
	
	public void startGame()
	{
		try {
			map = new Maze(10, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = new Location(1, 1);
		mapConverter = new MazeConversion(map);
		array = mapConverter.convertedMaze();
		array[player.getRow()][ player.getColumn()] = 5;
		window.mazeupdate(array);
	}
	public void move(Direction direction)
	{
		Location destination = player.neighbor(direction);
		CellType Q = map.getNeighborType(player.convertToCondensed(), direction);
		
		
		switch(map.getNeighborType(player.convertToCondensed(), direction))
		{
			case Wall: //Display message
				break;
			case Door: 
				/*@SuppressWarnings("unused")
				Question quest = null;
				try {
					quest = questionFactory.getQuestion();
					QuestionDisplay QDB = new QuestionDisplay();
					if( (QDB.askQuestion()))
						return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				*/
				mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				break;	
				
			case UnlockedDoorHorz: 	
				mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				break;
				
			case UnlockedDoorVert: 
				mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				break;
			case Player://Impossible
				break;
		}
	}

}
