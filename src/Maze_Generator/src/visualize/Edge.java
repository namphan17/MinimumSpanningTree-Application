package Maze_Generator.src.visualize;

public class Edge {

    private static int numberOfEdges;
    private final int id;
    private final Vertex endPoint0;
    private final Vertex endPoint1;

    public Edge(Vertex endPoint0, Vertex endPoint1) {
        this.id = Edge.numberOfEdges;
        Edge.numberOfEdges++;
        this.endPoint0 = endPoint0;
        this.endPoint1 = endPoint1;
    } // Edge( Vertex, Vertex )

    public Vertex getEndPoint0() {
        return this.endPoint0;
    } // getEndPoint0()

    public Vertex getEndPoint1() {
        return this.endPoint1;
    } // getEndPoint1()

    public boolean intersects( Edge e ) {
        return intersects( e.getEndPoint0(), e.getEndPoint1());
    } // intersects( Edge )
    
    public boolean intersects( Vertex v0, Vertex v1 ) {
        
        double x0 = this.getEndPoint0().getX();
        double y0 = this.getEndPoint0().getY();
        
        double x1 = this.getEndPoint1().getX();
        double y1 = this.getEndPoint1().getY();
        
        double x2 = v0.getX();
        double y2 = v0.getY();
        
        double x3 = v1.getX();
        double y3 = v1.getY();
        
        double a = (x2 - x3);
        double b = (x1 - x0);
        
        double c = (y2 - y3);
        double d = (y1 - y0);
        
        double rhs0 = (x2 - x0);
        double rhs1 = (y2 - y0);
        
        double determinant = a * d - b * c;
        double s = (d * rhs0 - b * rhs1)/determinant;
        double t = (-c * rhs0 + a * rhs1)/determinant;
        
        boolean sInBounds = (0 < s) && (s < 1);
        boolean tInBounds = (0 < t) && (t < 1);
        return sInBounds && tInBounds;
    } // intersects( Vertex v0, Vertex v1 )
    

    @Override
    public String toString() {
        return "Edge";
    } // toString()
} // Edge
