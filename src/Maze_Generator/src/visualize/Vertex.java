package Maze_Generator.src.visualize;

public class Vertex {
    private static int numberOfVertices;
    private final int id;
    private final double x;
    private final double y ;
    
    public Vertex( double x, double y ) {
        this.id = Vertex.numberOfVertices;
        Vertex.numberOfVertices++;
        this.x = x;
        this.y = y;
    } // Vertex( double, double )

    public int getId() {
        return this.id;
    } // getId()

    public double getX() {
        return this.x;
    } // getX()

    public double getY() {
        return this.y;
    } // getY()
    
    public double distanceTo( Vertex v ) {
        double deltaX = this.getX() - v.getX();
        double deltaY = this.getY() - v.getY();
        return Math.sqrt( deltaX * deltaX + deltaY * deltaY );
    } // distanceTo( Vertex )
    
    public double distanceTo( double x, double y ) {
        double deltaX = this.getX() - x;
        double deltaY = this.getY() - y;
        return Math.sqrt( deltaX * deltaX + deltaY * deltaY );
    } // distanceTo( double, double )
    
    @Override
    public String toString() {
        return String.format( "(%6.2f,%6.2f)", this.getX(), this.getY());
    } // toString()
} // Vertex
