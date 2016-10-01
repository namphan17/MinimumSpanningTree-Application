package Maze_Generator.src;
import edu.princeton.cs.algs4.*;

public class TestPath {
	public static void main(String[] args) {
		Graph G = new Graph(new In(args[0]));
		int s = 2;
		Search search = new BreadthFirstSearch(G, s);
		
		System.out.println("Vertices: " + G.V() + "; Edges: " + G.E());
		
		
		for (int v = 0; v < G.V(); v++) {
			System.out.print(s + " to " + v + ": ");
			
			if (search.hasPathTo(v)) {
				for (int x : search.pathTo(v)) {
					if ( x == s) System.out.print(s);
					else System.out.print("-" + x);
				}
			}
			System.out.println();
		}
	}
}
