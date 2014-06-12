package southparktriviamaze;

import java.awt.EventQueue;

//import javafx.application.Platform;

import javax.swing.SwingUtilities;

import java.sql.SQLException;

public class GameCore {
	
	private UserInterface window;
	private QuestionFactory questionFactory;
	private Maze map;
	private Location player;
	private String[] cheats;
	private int[][] array;
	private QuestionDisplay qd = new QuestionDisplay();
	private MediaPair media;
	private Character playerCharacter = Character.Butters;
//	private Runnable playEffect = new Runnable() {
//		@Override
//		public void run() {
//			window.setMedia(media);
//		}
//	};
	public GameCore(String[]cheats)
	{

		try {
			map = new Maze(4, 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		questionFactory = new RandomQuestionFactory();
	}
	
	public GameCore(UserInterface userWindow, String[] cheats)
	{
		window = userWindow;
		
		questionFactory = new RandomQuestionFactory();
		
	}
	public void setWindow(UserInterface userWindow)
	{
		this.window = userWindow;
	}
	public Maze getMaze()
	{
		return map;
	}
	
	public void startGame()
	{
		try {
			map = new Maze(4, 4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player = new Location(1, 1);
		window.mazeupdate(map, player, player);
	}
	
	public void move(Direction direction)
	{
		Location destination = player.neighbor(direction);
		//CellType Q = map.getNeighborType(player.convertToCondensed(), direction);
		
		
		switch(map.getNeighborType(player.convertToCondensed(), direction))
		{
			case Wall: //Display message
				break;
			case Door: 
				//Question quest = null;
				try {
					Question quest = questionFactory.getQuestion();
					if( !(qd.doQuestion(quest)))
					{
						media = new MediaPair(playerCharacter, MediaType.Failure);
			//			Platform.runLater(playEffect);
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				media = new MediaPair(playerCharacter, MediaType.Success);
		//		Platform.runLater(playEffect);
				/*mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				
				switch(direction)
				{
					case North: array[player.getRow()- 1][player.getColumn()] = 4;
						break;
					case South: array[player.getRow()+ 1][player.getColumn()] = 4;
						break;
					case East: array[player.getRow()][player.getColumn() + 1] = 3;
						break;
					case West: array[player.getRow()][player.getColumn() - 1] = 3;
						break;
				}
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				*/
				map.unlockDoor(player.convertToCondensed(), direction);
				window.mazeupdate(map, player, destination);
				player = destination;
				break;	
				
			case UnlockedDoorHorz: 	
				/*mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				*/

				window.mazeupdate(map, player, destination);
				player = destination;
				break;
				
			case UnlockedDoorVert: 
				/*mapConverter = new MazeConversion(map);
				array = mapConverter.convertedMaze();
				array[player.getRow()][ player.getColumn()] = 0;
				array[destination.getRow()][destination.getColumn()] =5;
				player = destination;
				window.mazeupdate(array);
				*/

				window.mazeupdate(map, player, destination);
				player = destination;
				break;
			case Player://Impossible
				break;
		default:
			//Error
			break;
		}
		//if(player.getRow() == )
	}

}
