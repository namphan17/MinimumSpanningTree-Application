package Maze_Generator.src;
import java.util.Collections;
import java.util.Stack;

public class RandomKruskalMST {
    private double weight;  // weight of MST
    private Queue<Edge> mst = new Queue<Edge>();  // edges in MST

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public RandomKruskalMST(Graph G) {

        Stack<Edge> stack = new Stack<Edge>();
        for (Edge e : G.edges()) {
            stack.push(e);
        }
        Collections.shuffle(stack);
        // run greedy algorithm
        UF uf = new UFWeightedQuickUnion(G.V());
        while (!stack.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = stack.pop();
            int v = e.either();
            int w = e.other(v);
            if (!uf.isConnected(v, w)) { // adding v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }
}

