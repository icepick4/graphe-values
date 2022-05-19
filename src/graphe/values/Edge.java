package graphe.values;


/**
 * La Classe qui permet de définir une arête dans le graphe
 * @author Remi
 * @version 1.0
 */
public class Edge {
    private int i,j, width;
    private int[] pos1;
    private int[] pos2;
    private double val;
    private String type;
    
    /**
     * Constructeur de la classe Edge
     * @param myType Type de l'arête
     * @param MyVal Valeur de l'arête
     * @param i Numéro du premier sommet
     * @param j Numéro du second sommet
     */
    public Edge(String myType, double MyVal, int i, int j, int pos1x, int pos1y, int pos2x, int pos2y){ 
        this.i = i;
        this.j = j;
        this.pos1 = new int[2];
        this.pos2 = new int[2];
        this.type = myType;
        this.val = MyVal;
        this.setPos(pos1x, pos1y, pos2x, pos2y);
        this.width = 1;
    }

    /**
     * Retourne le numéro du premier sommet
     * @return Numéro du premier sommet
     */
    public int getNodeI() {
        return i;
    }

    /**
     * Retourne le numéro du second sommet
     * @return Numéro du second sommet
     */
    public int getNodeJ() {
        return j;
    }

    public int getWidth(){
        return this.width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setPos(int x1, int y1, int x2, int y2) {
        this.pos1[0] = x1;
        this.pos1[1] = y1;
        this.pos2[0] = x2;
        this.pos2[1] = y2;
    }

    public int getPos1X() {
        return pos1[0];
    }

    public int getPos1Y() {
        return pos1[1];
    }

    public int getPos2X() {
        return pos2[0];
    }

    public int getPos2Y() {
        return pos2[1];
    }

    public double getVal() {
        return val;
    }

    public String getType() {
        return type;
    }
    
}
