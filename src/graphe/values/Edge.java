package graphe.values;


/**
 * La Classe qui permet de définir une arête dans le graphe
 * @author Remi
 * @version 1.0
 */
public class Edge {
    int i,j;
    double val;
    String type;
    
    /**
     * Constructeur de la classe Edge
     * @param myType Type de l'arête
     * @param MyVal Valeur de l'arête
     * @param i Numéro du premier sommet
     * @param j Numéro du second sommet
     */
    public Edge(String myType, double MyVal, int i, int j) {
        this.i = i;
        this.j = j;
        this.type = myType;
        this.val = MyVal;
    }
}
