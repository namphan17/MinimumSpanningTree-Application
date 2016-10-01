package Maze_Generator.src;
public abstract class Search {
	protected final boolean[] marked;
	protected int count;
	protected final int[] edgeTo;
	protected final int s;
	
	public Search(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		count = 0;
	}
	
	public boolean hasPathTo(int u) {
		return marked[u];
	}
	
	public int count() {
		return count;
	}
	
	public abstract Iterable<Integer> pathTo(int v);
}
