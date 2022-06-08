package graphe.values.model;

import java.awt.FontMetrics;
import java.awt.Graphics;

import graphe.values.view.GUI;

/**
 * La Classe qui permet de définir un sommet dans le graphe
 * 
 * @author Remi
 * @version 1.0
 */
public class Node {
    private int x, y, height, width;
    private String name;
    private String type;
    private boolean selected;
    private GUI gui;

    /**
     * Constructeur de la classe Node
     * 
     * @param name Nom du sommet
     * @param type Type du sommet
     * @param x    Abscisse du sommet
     * @param y    Ordonnée du sommet
     */
    public Node(GUI gui, String name, String type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
        this.selected = false;
        this.gui = gui;
        Graphics g = this.gui.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name) + 50 / 2;
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
     * Reset la taille du noeud visuellement
     */
    public void resetSize() {
        Graphics g = this.gui.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name) + 50 / 2;
    }

    // get type
    public String getType() {
        return type;
    }

    // isselected
    public boolean isSelected() {
        return selected;
    }

    // get height
    public int getHeight() {
        return height;
    }

    // set height
    public void setHeight(int height) {
        this.height = height;
    }

    // get width
    public int getWidth() {
        return width;
    }

    // set width
    public void setWidth(int width) {
        this.width = width;
    }

    // get x
    public int getX() {
        return x;
    }

    // get y
    public int getY() {
        return y;
    }

    // set x
    public void setX(int x) {
        this.x = x;
    }

    // set y
    public void setY(int y) {
        this.y = y;
    }
}
