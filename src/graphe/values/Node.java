package graphe.values;

import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 * La Classe qui permet de définir un sommet dans le graphe
 * @author Remi
 * @version 1.0
 */
public class Node {
    int x, y, height, width;
    String name;
    String type;
    boolean selected;
    
    /**
     * Constructeur de la classe Node
     * @param name Nom du sommet
     * @param type Type du sommet
     * @param x Abscisse du sommet
     * @param y Ordonnée du sommet
     */
    public Node(String name, String type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
        this.selected = false;
        Graphics g = GUI.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name)+50/2;
    }

    public String getName() {
        return name;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setPosX(int x) {
        this.x = x;
    }

    public void setPosY(int y) {
        this.y = y;
    }

    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public int getSize() {
        return name.length();
    }

    /**
     * Reset la taille du noeud
     */
    public void resetSize(){
        Graphics g = GUI.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name)+50/2;
    }
}
