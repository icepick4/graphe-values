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
}
