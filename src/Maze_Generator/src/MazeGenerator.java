package Maze_Generator.src;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * href = http://en.wikipedia.org/wiki/Maze_generation_algorithm
 * @author HoangNam
 *
 */

public class MazeGenerator {

	public static void main(String[] args) {
		int N = 100;
		Maze maze = new Maze(N);
		maze.drawMaze();
		maze.findPath();
		
	}
}
