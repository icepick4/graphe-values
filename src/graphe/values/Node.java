package graphe.values;

import java.awt.FontMetrics;
import java.awt.Graphics;

public class Node {
    int x, y, height, width;
    String name;
    String type;
    
    public Node(String name, String type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
        Graphics g = GUI.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name)+50/2;
    }

    public String getName() {
        return name;
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

    public void resetSize(){
        Graphics g = GUI.getCanvas().getGraphics();
        FontMetrics f = g.getFontMetrics();
        this.height = 50;
        this.width = f.stringWidth(this.name)+50/2;
    }
}
