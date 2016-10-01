package Maze_Generator.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * href = http://en.wikipedia.org/wiki/Maze_generation_algorithm
 * @author HoangNam
 *
 */

public class MazeGenerator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Giving the size of this N by N maze:");
		int N = scanner.nextInt();
		Maze maze = new Maze(N);
		maze.drawMaze();
		maze.findPath();
		
		scanner.close();
	}
}
