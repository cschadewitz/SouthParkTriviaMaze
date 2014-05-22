package southparktriviamaze;

public class MazeTester {

	public static void main(String[] args) throws Exception {
		
		Maze maze = new Maze(3, 3);
		MazeConversion mC = new MazeConversion(maze);

		mC.printCharMaze();
	}//end main

}//end class
