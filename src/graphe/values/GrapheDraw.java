package graphe.values;


import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.RenderingHints;

/**
 *  La Classe qui permet de définir l'UI d'un {@link Graphe}
 * @author Rémi JARA
 * @version 1.0
 */
public class GrapheDraw extends JPanel {
    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;
	private GUI gui;
	private Color bgColor;
	/**
	 * Constructeur de la classe GrapheDraw
	 */
    public GrapheDraw(GUI gui) {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		this.gui = gui;
		this.bgColor = Color.WHITE;
    }
    
	public int getNbNodes() {
		return nodes.size();
	}

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public int getNbEdges() {
		return edges.size();
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	/**
	 * Permet de modifier la liste des noeuds
	 * @param nodes
	 */
	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Permet d'ajouter un noeud à la liste des noeuds
	 * @param name Nom du noeud
	 * @param type Type du noeud
	 */
    public void addNode(String name, String type) { 
		//add a node at pixel (x,y)
		int x = 500,y = 500;
		while (!this.isValid(x,y)) {
			x = getRandomNumber(50, this.gui.getCanvas().getWidth() - 50);
			y = getRandomNumber(50, this.gui.getCanvas().getHeight() - 50);
		}
		nodes.add(new Node(this.gui, name,type, x,y));
		this.repaint();
    }

	/**
	 * Vérifie si la position d'un nouveau noeud est valide
	 * @param x position en x
	 * @param y position en y
	 * @return {@code true} si la position est valide, {@code false} sinon
	 */
	public boolean isValid(int x, int y) {
		for (Node n : this.nodes) {
			if (Math.sqrt(Math.pow(n.x - x, 2) + Math.pow(n.y - y, 2)) < 100) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  Permet d'ajouter une arête entre deux noeuds
	 * @param type Type de l'arête
	 * @param val Valeur de l'arête
	 * @param i Numéro du premier noeud
	 * @param j Numéro du second noeud
	 */
    public void addEdge(String type, double val, int i, int j) {
		//add an edge between nodes i and j
		edges.add(new Edge(type, val, i, j, nodes.get(i).x-nodes.get(i).width/2, nodes.get(i).y-nodes.get(i).width/2, nodes.get(j).x-nodes.get(j).width/2, nodes.get(j).y-nodes.get(j).width/2));
		this.repaint();
    }
    
	/**
	 * Permet de peindre tous les composants du graphe
	 */
    public void paint(Graphics g) { // draw the nodes and edges
		//clear g
		g.clearRect(0,0,1920,1080);
		//paint the background with this.bgColor
		g.setColor(this.bgColor);
		g.fillRect(0,0,1920,1080);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// int nodeHeight = Math.max(height, f.getHeight());
		g2d.setFont(new Font("Arial", Font.BOLD, 20));
		FontMetrics f = g2d.getFontMetrics();
		for (Edge e : this.edges) {
			if (e.type.equals("A")){
				g2d.setColor(Color.MAGENTA);
			}
			else if (e.type.equals("N")){
				g2d.setColor(Color.cyan);
			}
			else{
				g2d.setColor(Color.blue);
			}
			int x = 100;
			int y = 100;
			//increase the width of the line
			g2d.setStroke(new java.awt.BasicStroke(e.getWidth(), java.awt.BasicStroke.CAP_ROUND, java.awt.BasicStroke.JOIN_ROUND));
			g2d.drawLine(nodes.get(e.getNodeI()).x, nodes.get(e.getNodeI()).y, nodes.get(e.getNodeJ()).x, nodes.get(e.getNodeJ()).y);
			e.setPos(nodes.get(e.getNodeI()).x, nodes.get(e.getNodeI()).y, nodes.get(e.getNodeJ()).x, nodes.get(e.getNodeJ()).y);

			//get middle of edge with pos of nodes
			x = (nodes.get(e.getNodeI()).x + nodes.get(e.getNodeJ()).x)/2;
			y = (nodes.get(e.getNodeI()).y + nodes.get(e.getNodeJ()).y)/2;
			g2d.setColor(Color.BLACK);
			//convert e.val to string
			String val = Double.toString(e.val);
			//if val ends with .0 remove it
			if (val.endsWith(".0")) {
				val = val.substring(0, val.length() - 2);
			}
			//bigger font
			g2d.drawString(val, x,y);
		}
		g2d.setFont(new Font("Arial", Font.BOLD, 10));
		f = g2d.getFontMetrics();
		for (Node n : this.nodes) {
			// int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
			//normal font
			if (n.type.equals("V")){
				g2d.setColor(Color.GREEN);
			}
			else if (n.type.equals("R")){
				g2d.setColor(Color.RED);
			}
			else{
				g2d.setColor(Color.YELLOW);
			}

			g2d.fillOval(n.x-n.width/2, n.y-n.height/2, 
				n.width, n.height);
			g2d.setColor(Color.black);
			if(n.selected){
				((Graphics2D) g2d).setStroke(new java.awt.BasicStroke(3));
			}
			else{
				((Graphics2D) g2d).setStroke(new java.awt.BasicStroke(1));
			}
			g2d.drawOval(n.x-n.width/2, n.y-n.height/2, 
				n.width, n.height);
			g2d.drawString(n.name, n.x-f.stringWidth(n.name)/2,
				n.y+f.getHeight()/2);
		}
	}

	/**
	 * Permet de changer la positions des noeuds pour pas qu'ils ne se touchent
	 */
	public void changePos() {
		for (int i = 0; i < this.nodes.size(); i++) {
			int x = 500, y = 500;
			while(!this.isValid(x, y)) {
				x = getRandomNumber(50, this.gui.getCanvas().getWidth() - 50);
				y = getRandomNumber(50, this.gui.getCanvas().getHeight() - 50);
			}
			this.nodes.get(i).x = x;
			this.nodes.get(i).y = y;
		}
	}

	/**
	 * Permet de nettoyer le canvas
	 */
	public void clear() {
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		Graphics g = this.gui.getCanvas().getGraphics();
		g.setColor(Color.white);
		g.fillRect(0,0,this.gui.getCanvas().getWidth(),this.gui.getCanvas().getHeight());
	}
	
	/**
	 * Permet de dessiner tous les noeuds et arêtes du graphe contenu dans le fichier donné dans {@link #GraphApp} au lancement
	 * @param graphe
	 */
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
			return this.gui.getCb_ville().isSelected();
		}
		else if(type.equals("L")){
			return this.gui.getCb_loisirs().isSelected();
		}
		else{
			return this.gui.getCb_restaurant().isSelected();
		}
	} 

	public boolean canAddEdge(String type){
		if(type.equals("A")){
			return this.gui.getCb_autoroute().isSelected();
		}
		else if(type.equals("N")){
			return this.gui.getCb_nationale().isSelected();
		}
		else{
			return this.gui.getCb_departementale().isSelected();
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

	public void setBackground(Color c) {
		this.bgColor = c;
		this.repaint();
	}

}
