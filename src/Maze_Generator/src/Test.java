package Maze_Generator.src;
import edu.princeton.cs.algs4.*;

public class Test {
	public static void main(String[] args) {
		
		double half = 100 / 2.0;
		double ratio = 100 / 50.0;
		int length = (int) Math.round(512 * ratio);
		StdDraw.setCanvasSize(length, length);
		StdDraw.setXscale(-0.5, 100 - 0.5);
		StdDraw.setYscale(-0.5, 100 - 0.5);
		StdDraw.filledSquare(half - 0.5, half - 0.5, half);
	}
}
