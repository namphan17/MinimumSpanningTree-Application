package Maze_Generator.src;
public class Edge {
	private final int v; // one vertex
	private final int w; // the other vertex

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	public int either() {
		return v;
	}

	public int other(int vertex) {
		if (vertex == v)
			return w;
		else if (vertex == w)
			return v;
		else
			throw new RuntimeException("Inconsistent edge");
	}

	public String toString() {
		return String.format("%d-%d", v, w);
	}
}