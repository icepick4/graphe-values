package graphe.values;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GrapheDraw extends JPanel {
    private int width;
    private int height;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public GrapheDraw(String name) {
		// this.setTitle(name);
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		width = 50;
		height = 50;
    }
    
    public void addNode(String name, String type, int x, int y) { 
		//add a node at pixel (x,y)
		nodes.add(new Node(name,type, x,y));
		this.repaint();
    }

    public void addEdge(String type, double val, int i, int j) {
		//add an edge between nodes i and j
		edges.add(new Edge(type, val, i,j));
		this.repaint();
    }
    
    public void paint(Graphics g) { // draw the nodes and edges
		FontMetrics f = g.getFontMetrics();
		int nodeHeight = Math.max(height, f.getHeight());
		for (Edge e : this.edges) {
			if (e.type.equals("A")){
				g.setColor(Color.black);
			}
			else if (e.type.equals("N")){
				g.setColor(Color.red);
			}
			else{
				g.setColor(Color.blue);
			}
			g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
				nodes.get(e.j).x, nodes.get(e.j).y);
			//get middle of edge with pos of nodes
			int x = (nodes.get(e.i).x + nodes.get(e.j).x)/2;
			int y = (nodes.get(e.i).y + nodes.get(e.j).y)/2;
			g.setColor(Color.BLACK);
			//convert e.val to string
			String val = Double.toString(e.val);
			//g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
			g.drawString(val, x,y);
		}

		for (Node n : this.nodes) {
			//g.setFont(new Font("TimesRoman", Font.PLAIN, 15)); 
			int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
			if (n.type.equals("V")){
				g.setColor(Color.GREEN);
			}
			else if (n.type.equals("R")){
				g.setColor(Color.RED);
			}
			else{
				g.setColor(Color.YELLOW);
			}
			
			g.fillOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
				nodeWidth, nodeHeight);
			g.setColor(Color.black);
			g.drawOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
				nodeWidth, nodeHeight);
			
			g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
				n.y+f.getHeight()/2);
		}
	}
	public void drawGraph(Graphe graphe){
        //draw nodes
        for(int i = 0; i < graphe.getMatVal().colonnes(); i++){
            int x;
            int y;
            int nbNoeuds = graphe.getMatVal().colonnes();
            if (i < nbNoeuds / 3){
                //random between 100 and 200

                y = getRandomNumber(50, 150);
            }
            else if(i >= nbNoeuds / 3 && i < nbNoeuds / 3 * 2){
                //random between 1080/2 - 150 and 1080/2
                y = getRandomNumber(1080/2 - 275, 1080/2 - 125);
            }
            else{
                y = getRandomNumber(1080 - 300, 1080 - 500);
            }
            x = (i % 10) * 150+ 75;
            this.addNode(graphe.getNoeuds().get(i)[1],graphe.getNoeuds().get(i)[0], x,y);
        }
        for(int i = 0; i < graphe.getMatVal().colonnes(); i++){
            for(int j = 0; j < graphe.getMatVal().colonnes(); j++){
                if(graphe.getMatVal().matrice[i][j] != 999){
                    this.addEdge(graphe.getMatLiens().matrice[i][j], graphe.getMatVal().matrice[i][j],i,j);
                }
            }
        }
    }
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
