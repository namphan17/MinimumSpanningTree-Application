package Maze_Generator.src.visualize;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Collections;
import javax.swing.JPanel;

public class VisualizePanel extends JPanel {

    private static final double HORIZONTAL_MARGIN = 0.1;
    private static final double VERTICAL_MARGIN = 0.1;
    private static final double DOT_RADIUS = 0.02;
    private Graph graph;

    public VisualizePanel(Graph graph) {
        this.graph = graph;
    } // VisualizePanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(1.0, 1.0);

        AffineTransform scaleToMargins = new AffineTransform();
        double xFactor = 1.0 - HORIZONTAL_MARGIN;
        double yFactor = 1.0 - VERTICAL_MARGIN;
        scaleToMargins.setToScale(xFactor, yFactor);

        AffineTransform scaleToWindow = new AffineTransform();
        scaleToWindow.setToScale(this.getWidth() / 2, this.getHeight() / 2);

        AffineTransform transform = new AffineTransform();
        transform.concatenate(scaleToWindow);
        transform.concatenate(translate);
        transform.concatenate(scaleToMargins);

//        Rectangle2D rectangle
//                = new Rectangle2D.Double(-0.5, -0.5, 1.0, 1.0);
//
//        g2D.draw(transform.createTransformedShape(rectangle));
        for (Vertex v : this.graph.getVertices()) {
            Shape dot = this.makeDot(v);
            g2D.fill(transform.createTransformedShape(dot));
        } // for
        
        Collections.shuffle( this.graph.getEdges() );
        
        for (Edge e : this.graph.getEdges()) {
            Vertex v0 = e.getEndPoint0();
            Vertex v1 = e.getEndPoint1();
            double x0 = v0.getX();
            double y0 = v0.getY();
            double x1 = v1.getX();
            double y1 = v1.getY();
            Line2D line = new Line2D.Double(x0, y0, x1, y1);
            g2D.draw(transform.createTransformedShape(line));
        }
//        Vertex v0 = new Vertex(-0.5, -0.5);
//        Vertex v1 = new Vertex(0.5, 0.5);
//        Vertex v2 = new Vertex(-0.5, 0.5);
//        Vertex v3 = new Vertex(0.5, -0.5);
//        Edge e0 = new Edge(v0, v1);
//        Edge e1 = new Edge(v2, v3);
//
//        double x0 = v0.getX();
//        double y0 = v0.getY();
//        double x1 = v1.getX();
//        double y1 = v1.getY();
//        Line2D line0 = new Line2D.Double(x0, y0, x1, y1);
//        g2D.draw(transform.createTransformedShape(line0));
//
//        double x2 = v2.getX();
//        double y2 = v2.getY();
//        double x3 = v3.getX();
//        double y3 = v3.getY();
//        Line2D line1 = new Line2D.Double(x2, y2, x3, y3);
//        g2D.draw(transform.createTransformedShape(line1));
//        
//        System.out.println( e0.intersects(e1));
    } // paintComponent( Graphics )

    private Shape makeDot(Vertex v) {
        double ulx = v.getX() - DOT_RADIUS;
        double uly = v.getY() - DOT_RADIUS;
        double diameter = 2 * DOT_RADIUS;
        Ellipse2D dot
                = new Ellipse2D.Double(ulx, uly, diameter, diameter);
        return dot;
    } // makeDot( Vertex )
} // VisualizePanel
