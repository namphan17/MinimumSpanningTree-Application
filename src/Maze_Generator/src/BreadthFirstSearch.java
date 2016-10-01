package Maze_Generator.src;

import java.util.Stack;

import edu.princeton.cs.*;

public class BreadthFirstSearch extends Search{
	
	public BreadthFirstSearch(Graph G, int s) {
		super(G, s);
		bfs(G, s);
	}
	
	private void bfs(Graph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while ( !queue.isEmpty() ) {
			int v = queue.dequeue();
			for ( int w : G.adjV(v)) {
				if (!marked[w]) {
				marked[w] = true;
				edgeTo[w] = v;
				queue.enqueue(w);
				}
			}
		}
	}
	@Override
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v)) return null;
		else {
			Stack<Integer> path0 = new Stack<>();
			for (int x = v; x != this.s; x = edgeTo[x]) {
				path0.push(x);
			}
			path0.push(this.s);
			Stack<Integer> path = new Stack<>();
			while(!path0.isEmpty()){
				path.push(path0.pop());
			}
			return path;
		}
	}
}
