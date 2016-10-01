package Maze_Generator.src;
import java.util.Stack;


public class DepthFirstSearch extends Search{
	
	public DepthFirstSearch(Graph G, int s) {
		super(G, s);
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int u : G.adjV(v)) {
			if (!marked[u]){
				edgeTo[u] = v;
				dfs(G, u);
			}
		}
		count++;
	}
	@Override	
	public Iterable<Integer> pathTo(int v) {
			if (!hasPathTo(v)) return null;
			else {
				Stack<Integer> path = new Stack<>();
				for (int x = v; x != s; x = edgeTo[x]) {
					path.push(x);
				}
				path.push(s);
				return path;
			}
	}
}
