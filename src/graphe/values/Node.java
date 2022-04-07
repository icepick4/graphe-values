package graphe.values;

public class Node {
    int x, y;
    String name;
    String type;
    
    public Node(String name, String type, int x, int y) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.name = name;
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
}
