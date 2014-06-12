/* GameCore.java
 * Author: Casey Schadewitz
 * Revision: N/A
 * Rev. Author: N/A
 * Description: This class is used to act as a mediator
 * between many of the main classes. This class handles 
 * user input received from the UserInterface.
 * 
 */
package southparktriviamaze;

import java.awt.EventQueue;

import javafx.application.Platform;

import javax.swing.JOptionPane;
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
	private int mapSize = 10;
	
	//This Runnable is used to make an async call to the UserInterface to play a sound
	private Runnable playEffect = new Runnable() {
		@Override
		public void run() {
			window.setMedia(media);
		}
	};
	
	//Initialized a new GameCore and all supporting classes
	//Parameters:
	//String[] cheats used to indicated whether the game is censored
	public GameCore(String[]cheats)
	{

		try {
			map = new Maze(mapSize, mapSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		questionFactory = new RandomQuestionFactory();
	}
	
	//Initialized a new GameCore, sets the UserInterface reference and builds all supporting classes
	//Parameters:
	//String[] cheats used to indicated whether the game is censored
	//UserInterface userWndow: reference to the calling interface
	public GameCore(UserInterface userWindow, String[] cheats)
	{
		window = userWindow;
		
		questionFactory = new RandomQuestionFactory();
		
	}
	
	//Sets the UserInterface reference
	//Parameters:
	//UserInterface userWndow: reference to the calling interface
	public void setWindow(UserInterface userWindow)
	{
		this.window = userWindow;
	}
	
	//Gets the reference the the Maze
	public Maze getMaze()
	{
		return map;
	}
	
	//Called to play opening sound
	public void playOpening()
	{
		media = new MediaPair(Character.Narrator, MediaType.Opening);
		Platform.runLater(playEffect);
	}
	
	//Called to begin game
	public void startGame()
	{
		
		player = new Location(1, 1);
		window.mazeupdate(map, player, player);
	}
	
	//Called to make a move
	//This class takes a direction, checks what is in that direction and 
	//asks a question, moves the player, and does nothing as necessary
	//Direction direction: used to indicated the direction of travel
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
						Platform.runLater(playEffect);
						return;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				media = new MediaPair(playerCharacter, MediaType.Success);
				Platform.runLater(playEffect);
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
		if(player.convertToCondensed().getColumn() == mapSize - 1 && player.convertToCondensed().getRow() == mapSize - 1)
		{
			JOptionPane.showMessageDialog(null, "You Win!", "Congradulations", JOptionPane.INFORMATION_MESSAGE);
			window.NewGame();
		}
	}

}
