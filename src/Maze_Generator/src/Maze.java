package Maze_Generator.src;
import java.util.ArrayList;
import java.util.List;
import edu.princeton.cs.algs4.*;

public class Maze {
	private int size;
	private int vertices;
	private Queue<Edge> edges;
	private Graph G;

	public Maze(int size) {
		this.size = size;
		vertices = size * size;
		Graph grid = new Graph(vertices);

		for (int i = 0; i < (vertices - 1); i++) {
			if (i >= vertices - size) {
				Edge e0 = new Edge(i, i + 1);
				grid.addEdge(e0);
			} else {
				Edge e1 = new Edge(i, i + size);
				grid.addEdge(e1);
				if ((i + 1) % size != 0) {
					Edge e0 = new Edge(i, i + 1);
					grid.addEdge(e0);
				}
			}
		}
		RandomKruskalMST tree = new RandomKruskalMST(grid);
		Queue<Edge> queue = new Queue<>();
		this.edges = queue;
		Graph G = new Graph(vertices);
		for (Edge x : tree.edges()) {
			this.edges.enqueue(x);
			G.addEdge(x);
		}
		this.G = G;
	}

	private void setCanvas() {
		double half = size / 2.0;
		double ratio = size / 50.0;
		int length = (int) Math.round(512 * ratio);
		StdDraw.setCanvasSize(length, length);
		StdDraw.setXscale(-0.5, size - 0.5);
		StdDraw.setYscale(-0.5, size - 0.5);
		StdDraw.filledSquare(half - 0.5, half - 0.5, half);
	}

	public void draw(Edge e) {
		int v = e.either();
		int w = e.other(v);

		StdDraw.line(v % size, v / size, w % size, w / size);
	}

	public void drawMaze() {
		setCanvas();
		double ratio = size / 10.0;
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setPenRadius(0.05 / ratio);
		for (Edge e : edges) {
			draw(e);
		}

		StdDraw.setPenColor();
		StdDraw.setPenRadius();
	}

	public void findPath() {
		Search search = new DepthFirstSearch(this.G, (vertices - size));
		List<Integer> list = new ArrayList<>();
		for (int x : search.pathTo(size - 1)) {
			list.add(x);
		}
		double ratio = size / 10.0;
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.025 / ratio);
		for (int i = 0; i < list.size() - 1; i++) {
			Edge e = new Edge(list.get(i), list.get(i + 1));
			draw(e);
		}
		StdDraw.setPenColor();
		StdDraw.setPenRadius();
	}
}


