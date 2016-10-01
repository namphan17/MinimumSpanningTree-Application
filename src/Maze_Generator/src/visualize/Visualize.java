package Maze_Generator.src.visualize;

import java.awt.Container;
import javax.swing.JFrame;

public class Visualize extends JFrame {

    private final int FRAME_WIDTH = 512;
    private final int FRAME_HEIGHT = 512;
    private final String FRAME_TITLE = "Visualize Graph";
    private final int NUMBER_OF_VERTICES = 8;

    public Visualize() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle( FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();
        Graph graph = new Graph( NUMBER_OF_VERTICES );
        VisualizePanel panel = new VisualizePanel( graph );
        pane.add( panel );
        this.setVisible(true);
    } // Visualize()

    public static void main(String[] args) {
        Visualize visualize = new Visualize();
    } // main( String [] )

} // Visualize
