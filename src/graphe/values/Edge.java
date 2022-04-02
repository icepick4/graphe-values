package graphe.values;

public class Edge {
    int i,j;
    double val;
    String type;
    
    public Edge(String myType, double MyVal, int i, int j) {
        this.i = i;
        this.j = j;	 
        this.type = myType; 
        this.val = MyVal;  
    }
}
