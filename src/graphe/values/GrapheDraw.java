package graphe.values;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GrapheDraw extends JFrame {
    private int width;
    private int height;
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public GrapheDraw(String name) {
		this.setTitle(name);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		System.out.print(g);
		//clear g
		g.clearRect(0,0,1920,1080);
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
			int x = (int)Math.floor(Math.random()*(1920-0+1)+0);
			System.out.println(x);
			g.fillOval(x-nodeWidth/2, n.y-nodeHeight/2, 
				nodeWidth, nodeHeight);
			g.setColor(Color.black);
			g.drawOval(x-nodeWidth/2, n.y-nodeHeight/2, 
				nodeWidth, nodeHeight);
			
			g.drawString(n.name, x-f.stringWidth(n.name)/2,
				n.y+f.getHeight()/2);
		}
	}
}
