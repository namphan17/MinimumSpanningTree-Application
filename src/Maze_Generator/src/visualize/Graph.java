package Maze_Generator.src.visualize;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Graph {
    private static final double MINIMUM_SEPARATION = 0.2;
    private final Random rng;
    private final List<Vertex> vertices;
    private final List<Edge> edges;
    
    public Graph( int numberOfVertices ) {
        this.rng = new Random();
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        
        int count = 0;
        while( count < numberOfVertices ) {
            double x = 2 * rng.nextDouble() - 1;
            double y = 2 * rng.nextDouble() - 1;
            
            boolean accept = true;
            for( Vertex v : this.vertices ) {
                accept = accept && v.distanceTo(x, y) > MINIMUM_SEPARATION;
            } // for
            
            if( accept ) {
                Vertex v = new Vertex( x, y );
                this.vertices.add( v );
                count++;
            } // if

        } // while
        
        for (int i = 0; i < this.vertices.size(); i++) {
            for (int j = i + 1; j < this.vertices.size(); j++) {   
                Vertex v0 = vertices.get(i);
                Vertex v1 = vertices.get(j);
                
                boolean accept = true;
                for( Edge e : this.getEdges()) {
                    accept = accept && !e.intersects(v0, v1);
                } // for
                if( accept ) {
                    Edge e = new Edge( v0, v1 );
                    this.edges.add( e );
                } // if                   
            } // for
        } // for
        
    } // Graph( int )
    
    public List<Vertex> getVertices() {
        return this.vertices;
    } // getVertices()
    
    public List<Edge> getEdges() {
        return this.edges;
    } // getEdges()
} // Graph
