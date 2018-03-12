import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Homework 3 Problems - multiple choice & fix error
 *
 * 1. B
 * 2. A
 * 3. D
 * 4. C
 * 5. B? --couldn't find anything in book but online pretty much said they were identical and it was preference on what to use.
 * 6. B
 * 7. A
 * 8. 10
 * 9. num<10 is the base case
 * 10. direct recursion
 * 11. **added a condition to stop the recursion because it called itself infinitely
 * 	public class FindTheError{
 		public static void main(String[] args){
 		myMethod(0);
 		}

 		public static void myMethod(int num) {
 			if (num < 100){
 				System.out.print(num+ “ ”);
 				myMethod(num+1);
 			}
 		}
 	}
 *
 *
 *
 *
 *
 *
 * This program simulates a robot getting through a maze.
 *	Unlike tic-tac-toe, where the user is the player, the robot moves 
	autonomously through the maze.
 * 	We intentionally share the memory location of the maze with the robot.
	Otherwise the robot would not know how to plan and make its moves.
	
	The maze is stored in a text file that will be entered at runtime.  
	The layout of each maze file will contain:
�	In the first line:  two integers (the number of rows and columns, respectively,  in the maze)  
�	In the second line:  two integers (the row and column locations, respectively, of the Start cell
�	In the third line:  two integers (the row and column locations, respectively, of the Exit cell
�	Each line thereafter will contain characters appearing in one row of the maze.  

 * Created by Sherri Harms
 * built on top of Eddy's UW-Parkside solution
 */

public class MazeDriver {

	/**
	 * Main method which consists of a robot who traverses a maze
	 * One robot decides his direction randomly
	 * Another robot traverses the maze as if his right hand is on the right wall
	 * @param args
	 * @throws IOException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {
		File inputFile = getFile();  //sample: testmaze.txt
		Maze maze = new Maze(inputFile);
		System.out.println(maze);

		//Robot bot = new RandomRobot(maze);
		//Robot bot = new LookAheadRobot(maze);
		//Robot bot = new JumpingRobot(maze); //Extra Credit
		Robot bot = new RightHandRobot(maze);//this ties the robot to the maze it is in
		for (int k = 0; k < 1000000 && !bot.solved(); k++) 
		//this limits the robot's moves, in case it takes too long to find the exit.
		{
			int direction = bot.chooseMoveDirection();
			if (direction >=0)  //invalid direction is -1
			{bot.move(direction);
			System.out.println(maze);}
			System.out.println("\n");
		}
		System.out.println("Owner: Jared Zwiener");
	}
	
	/**
	 * Get the file that has the maze specifications.
	 * @return File chosen by user.
	 */
	public static File getFile()
	{
		JFileChooser chooser;
		try{

			// Get the filename.
			chooser = new JFileChooser();
			int status = chooser.showOpenDialog(null);
			if (status != JFileChooser.APPROVE_OPTION)
			{
				System.out.println("No File Chosen");
				System.exit(0);
			}
			return chooser.getSelectedFile();
		} catch (Exception e)
		{
			System.out.println("Exception: " + e.getMessage());
			System.exit(0);

		}
		return null; //should never get here, but makes compiler happy
	}

}
