package graphe.values;


import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class GrapheDraw extends JPanel {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public GrapheDraw() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
    }
    
	public int getNbNodes() {
		return nodes.size();
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}
    public void addNode(String name, String type) { 
		//add a node at pixel (x,y)
		int x = 500,y = 500;
		while (!this.isValid(x,y)) {
			x = getRandomNumber(50, GUI.getCanvas().getWidth() - 50);
			y = getRandomNumber(50, GUI.getCanvas().getHeight() - 50);
		}
		nodes.add(new Node(name,type, x,y));
		this.repaint();
    }

	//pythagore
	public boolean isValid(int x, int y) {
		for (Node n : this.nodes) {
			if (Math.sqrt(Math.pow(n.x - x, 2) + Math.pow(n.y - y, 2)) < 100) {
				return false;
			}
		}
		return true;
	}

    public void addEdge(String type, double val, int i, int j) {
		//add an edge between nodes i and j
		edges.add(new Edge(type, val, i,j));
		this.repaint();
    }
    
    public void paint(Graphics g) { // draw the nodes and edges
		//clear g
		g.clearRect(0,0,1920,1080);
		// int nodeHeight = Math.max(height, f.getHeight());
		g.setFont(new Font("Arial", Font.BOLD, 20));
		FontMetrics f = g.getFontMetrics();
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
			int x = 100;
			int y = 100;
			//increase the width of the line
			g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y, nodes.get(e.j).x, nodes.get(e.j).y);
			//get middle of edge with pos of nodes
			x = (nodes.get(e.i).x + nodes.get(e.j).x)/2;
			y = (nodes.get(e.i).y + nodes.get(e.j).y)/2;
			g.setColor(Color.BLACK);
			//convert e.val to string
			String val = Double.toString(e.val);
			//bigger font
			g.drawString(val, x,y);
		}
		g.setFont(new Font("Arial", Font.BOLD, 10));
		f = g.getFontMetrics();
		for (Node n : this.nodes) {
			// int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
			//normal font
			if (n.type.equals("V")){
				g.setColor(Color.GREEN);
			}
			else if (n.type.equals("R")){
				g.setColor(Color.RED);
			}
			else{
				g.setColor(Color.YELLOW);
			}

			g.fillOval(n.x-n.width/2, n.y-n.height/2, 
				n.width, n.height);
			g.setColor(Color.black);
			g.drawOval(n.x-n.width/2, n.y-n.height/2, 
				n.width, n.height);
			g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
				n.y+f.getHeight()/2);
		}
	}

	//change all positions of nodes depending on GUI.getCanvas().getWidth() and GUI.getCanvas().getHeight()
	public void changePos() {
		for (int i = 0; i < this.nodes.size(); i++) {
			int x = 500, y = 500;
			while(!this.isValid(x, y)) {
				x = getRandomNumber(50, GUI.getCanvas().getWidth() - 50);
				y = getRandomNumber(50, GUI.getCanvas().getHeight() - 50);
			}
			this.nodes.get(i).x = x;
			this.nodes.get(i).y = y;
		}
	}

	//clear canvas with white color
	public void clear() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		Graphics g = GUI.getCanvas().getGraphics();
		g.setColor(Color.white);
		g.fillRect(0,0,GUI.getCanvas().getWidth(),GUI.getCanvas().getHeight());
	}
	
	public void drawGraph(Graphe graphe){
        //draw nodes
        for(int i = 0; i < graphe.getMatVal().colonnes(); i++){
			if(canAddNode(graphe.getNoeuds().get(i)[0])){
				this.addNode(graphe.getNoeuds().get(i)[1],graphe.getNoeuds().get(i)[0]);
			}
        }
        for(int i = 0; i < this.nodes.size(); i++){
            for(int j = 0; j < this.nodes.size(); j++){
				int x,y;
				x = this.indexOfEdge(graphe, i, j)[0];
				y = this.indexOfEdge(graphe, i, j)[1];
                if(graphe.getMatVal().matrice[x][y] != 999){
					if(canAddEdge(graphe.getMatLiens().matrice[x][y])){
                    	this.addEdge(graphe.getMatLiens().matrice[x][y], graphe.getMatVal().matrice[x][y],i,j);
					}
                }
            }
        }
    }
	
	public boolean canAddNode(String type){
		if(type.equals("V")){
			return GUI.getCb_ville().isSelected();
		}
		else if(type.equals("L")){
			return GUI.getCb_loisirs().isSelected();
		}
		else{
			return GUI.getCb_restaurant().isSelected();
		}
	} 

	public boolean canAddEdge(String type){
		if(type.equals("A")){
			return GUI.getCb_autoroute().isSelected();
		}
		else if(type.equals("N")){
			return GUI.getCb_nationale().isSelected();
		}
		else{
			return GUI.getCb_departementale().isSelected();
		}
	}

	public int[] indexOfEdge(Graphe graphe, int i, int j){
		//create String[] with type of node and name of this.nodes.get(i) and this.nodes.get(j)
		String[] node1 = new String[2];
		node1[0] = this.nodes.get(i).type;
		node1[1] = this.nodes.get(i).name;
		String[] node2 = new String[2];
		node2[0] = this.nodes.get(j).type;
		node2[1] = this.nodes.get(j).name;
		//browse graphe.getNoeuds() when node1 is found x is the index
		int x = 0;
		for(int k = 0; k < graphe.getNoeuds().size(); k++){
			//check is node1.name and node1.type is equal to graphe.getNoeuds().get(k)[0] and graphe.getNoeuds().get(k)[1]
			if(node1[0].equals(graphe.getNoeuds().get(k)[0]) && node1[1].equals(graphe.getNoeuds().get(k)[1])){
				x = k;
				break;
			}
		}
		//same for y
		int y = 0;
		for(int k = 0; k < graphe.getNoeuds().size(); k++){
			if(node2[0].equals(graphe.getNoeuds().get(k)[0]) && node2[1].equals(graphe.getNoeuds().get(k)[1])){
				y = k;
				break;
			}
		}
		return new int[]{x,y};
	}
	
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
