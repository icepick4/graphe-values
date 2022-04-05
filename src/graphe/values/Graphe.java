/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphe.values;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
/**
 *
 * @author Remi
 */
public class Graphe{
    private final int sommets;
    private int aretes;
    private final Matrice matBool;
    private final MatriceDouble matVal;
    private final MatriceString matLiens;
    private final ArrayList<String[]> noeuds;
    Graphe(Matrice matriceBool, MatriceDouble matriceValuations, MatriceString matriceLiens, ArrayList<String[]> noeuds){
        this.matVal = matriceValuations;
        this.matBool = matriceBool;
        this.matLiens = matriceLiens;
        this.sommets = matriceValuations.lignes();
        this.aretes = 0;
        for(int[] ligne : this.matBool.matrice){
            for(int colonne : ligne){
                this.aretes+=colonne;
            }
        }

        if(this.matBool.estSymetrique()){
            this.aretes /= 2;
        }

        Random r1 = new Random();
        for (int i = noeuds.size() - 1; i >= 1; i--) {
            Collections.swap(noeuds, i, r1.nextInt(i + 1));
        }
        this.noeuds = noeuds;

        if(matriceBool.lignes() != matriceBool.colonnes()){
            throw new IllegalArgumentException("Graphe non valide : colonnes!=lignes");
        }
    }
    
    public MatriceDouble getMatVal(){
        return this.matVal;
    }
    public MatriceString getMatLiens(){
        return this.matLiens;
    }
    public ArrayList<String[]> getNoeuds(){
        return this.noeuds;
    }
    public ArrayList<String[]> getVille(){
        ArrayList<String[]> villes = new ArrayList<String[]>();
        for(String[] noeud : this.noeuds){
            if(Objects.equals(noeud[0],"V")){
                villes.add(noeud);
            }
        }
        return villes;
    }

    public ArrayList<String[]> getLoisir(){
        ArrayList<String[]> loisirs = new ArrayList<String[]>();
        for(String[] noeud : this.noeuds){
            if(Objects.equals(noeud[0],"L")){
                loisirs.add(noeud);
            }
        }
        return loisirs;
    }

    public ArrayList<String[]> getRestaurant(){
        ArrayList<String[]> restaurants = new ArrayList<String[]>();
        for(String[] noeud : this.noeuds){
            if(Objects.equals(noeud[0],"R")){
                restaurants.add(noeud);
            }
        }
        return restaurants;
    }

    public ArrayList<String[]> sortNoeuds(){
        //sort noeuds by "R" "V" "L"
        ArrayList<String[]> noeuds = new ArrayList<String[]>();
        noeuds.addAll(this.getRestaurant());
        noeuds.addAll(this.getVille());
        noeuds.addAll(this.getLoisir());
        return noeuds;
    }
        
    public int getNbVille(){
        return getVille().size();
    }

    public int getNbLoisir(){
        return getLoisir().size();
    }

    public int getNbRestaurant(){
        return getRestaurant().size();
    }

    public int getNbAutoroutes(){
        int ctr = 0;
        for(int i = 0; i < this.matLiens.lignes(); i++){
            for(int j = 0; j < this.matLiens.colonnes(); j++){                
                if(Objects.equals(this.matLiens.matrice[i][j],"A")){
                    ctr++;
                }
            }
        }
        return ctr / 2;
    }

    public int getNbDepartementales(){
        int ctr = 0;
        for(int i = 0; i < this.matLiens.lignes(); i++){
            for(int j = 0; j < this.matLiens.colonnes(); j++){
                if(Objects.equals(this.matLiens.matrice[i][j],"D")){
                    ctr++;
                }
            }
        }
        return ctr/2;
    }

    public int getNbNationnales(){
        int ctr = 0;
        for(int i = 0; i < this.matLiens.lignes(); i++){
            for(int j = 0; j < this.matLiens.colonnes(); j++){
                if(Objects.equals(this.matLiens.matrice[i][j],"N")){
                    ctr++;
                }
            }
        }
        return ctr/2;
    }

    public MatriceString getAutoroutes(){
        MatriceString autoroutes = new MatriceString(this.matLiens.matrice);
        for(int i = 0; i < autoroutes.lignes(); i++){
            for(int j = 0; j < autoroutes.colonnes(); j++){

                if(autoroutes.matrice[i][j] != "A"){
                    autoroutes.matrice[i][j] = "";
                }
            }
        }
        return autoroutes;
    }
    
    public MatriceString getDepartementales(){
        MatriceString departementales = new MatriceString(this.matLiens.matrice);
        for(int i = 0; i < departementales.lignes(); i++){
            for(int j = 0; j < departementales.colonnes(); j++){
                if(departementales.matrice[i][j] != "A"){
                    departementales.matrice[i][j] = "";
                }
            }
        }
        return departementales;
    }

    public MatriceString getNationales(){
        MatriceString nationales = new MatriceString(this.matLiens.matrice);
        for(int i = 0; i < nationales.lignes(); i++){
            for(int j = 0; j < nationales.colonnes(); j++){
                if(nationales.matrice[i][j] != "A"){
                    nationales.matrice[i][j] = "";
                }
            }
        }
        return nationales;
    }

    /**
     * 
     * @param a
     * @param b
     * @return true si a est plus ouverte que b, sinon false
     */
    public boolean plusOuverte(String a, String b){
        int nbVillesA = 0;
        int nbVillesB = 0;
        int indexSommetA = -1;
        int indexSommetB = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(a)){
                indexSommetA = i;
            }
            else if (this.noeuds.get(i)[1].equals(b)){
                indexSommetB = i;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetA, i) && this.noeuds.get(i)[0] == "V"){
                nbVillesA++;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetB, i) && this.noeuds.get(i)[0] == "V"){
                nbVillesB++;
            }
        }
        if (nbVillesB < nbVillesA){
            return false;
        }
        return true;
    }

    public boolean plusGastronomique(String a, String b){
        int nbVillesA = 0;
        int nbVillesB = 0;
        int indexSommetA = -1;
        int indexSommetB = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(a)){
                indexSommetA = i;
            }
            else if (this.noeuds.get(i)[1].equals(b)){
                indexSommetB = i;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetA, i) && this.noeuds.get(i)[0] == "R"){
                nbVillesA++;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetB, i) && this.noeuds.get(i)[0] == "R"){
                nbVillesB++;
            }
        }
        if (nbVillesB < nbVillesA){
            return false;
        }
        return true;
    }

    public boolean plusCulturelle(String a, String b){
        int nbVillesA = 0;
        int nbVillesB = 0;
        int indexSommetA = -1;
        int indexSommetB = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(a)){
                indexSommetA = i;
            }
            else if (this.noeuds.get(i)[1].equals(b)){
                indexSommetB = i;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetA, i) && this.noeuds.get(i)[0] == "L"){
                nbVillesA++;
            }
        }
        for(int i = 0; i < this.matBool.lignes(); i++){
            if (existeChemin(2, indexSommetB, i) && this.noeuds.get(i)[0] == "L"){
                nbVillesB++;
            }
        }
        if (nbVillesB < nbVillesA){
            return false;
        }
        return true;
    }
    //stocker le predeceur du chemin de floydwarshall

    public MatriceDouble floydWarshall() {
        int n = this.matVal.matrice.length;
        double[][] temp = new double[n][n];
        for(int h = 0; h < n; h++){
            for(int j = 0; j < n; j++){
                temp[h][j] = this.matVal.matrice[h][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (temp[i][k] + temp[k][j] < temp[i][j] && i != j) {
                        temp[i][j] = temp[i][k] + temp[k][j];
                    }
                }
            }
        }
        MatriceDouble finalMat = new MatriceDouble(temp);
        return finalMat;
    }

    public double plusCourtChemin(int a, int b){
        return this.floydWarshall().matrice[a][b];
    }
    /**
     * 
     * @param sommet
     * @return tous les sommets qui sont voisins de sommet
     */
    public ArrayList<String> distance1(String sommet){
        
        ArrayList<String> liste = new ArrayList<String>();
        int indexSommet = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(sommet)){
                indexSommet = i;
            }
        }
        for(int k = 0; k < this.noeuds.size(); k++){
            if(this.existeChemin(1, indexSommet, k)){
                liste.add(this.noeuds.get(k)[1]);
            }
        }
        return liste;
    }

    /**
     * 
     * @param sommet
     * @return tous les sommets qui sont des restaurants et qui sont voisins de sommet
     */
    public ArrayList<String> Rdistance1(String sommet){
        ArrayList<String> liste = new ArrayList<String>();
        int indexSommet = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(sommet)){
                indexSommet = i;
            }
        }
        for(int k = 0; k < this.noeuds.size(); k++){
            if(this.existeChemin(1, indexSommet, k) && this.noeuds.get(k)[0].equals("R")){
                liste.add(this.noeuds.get(k)[1]);
            }
        }
        return liste;
    }

    /**
     * 
     * @param sommet
     * @return tous les sommets qui sont des Villes et qui sont voisins de sommet
     */
    public ArrayList<String> Vdistance1(String sommet){
        ArrayList<String> liste = new ArrayList<String>();
        int indexSommet = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(sommet)){
                indexSommet = i;
            }
        }
        for(int k = 0; k < this.noeuds.size(); k++){
            if(this.existeChemin(1, indexSommet, k) && this.noeuds.get(k)[0].equals("V")){
                liste.add(this.noeuds.get(k)[1]);
            }
        }
        return liste;
    }

    /**
     * 
     * @param sommet
     * @return tous les sommets qui sont des Lieux de loisirs et qui sont voisins de sommet
     */
    public ArrayList<String> Ldistance1(String sommet){
        ArrayList<String> liste = new ArrayList<String>();
        int indexSommet = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(sommet)){
                indexSommet = i;
            }
        }
        for(int k = 0; k < this.noeuds.size(); k++){
            if(this.existeChemin(1, indexSommet, k) && this.noeuds.get(k)[0] == "L"){
                liste.add(this.noeuds.get(k)[1]);
            }
        }
        return liste;
    }

    public boolean distance2(String a, String b){
        int indexSommetA = -1;
        int indexSommetB = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(a)){
                indexSommetA = i;
            }
            else if (this.noeuds.get(i)[1].equals(b)){
                indexSommetB = i;
            }
        }
        if (existeChemin(2, indexSommetA, indexSommetB)){
            return true;
        }
        return false;
    }

    public boolean distance2(int a, int b){
        return existeChemin(2,a,b);
    }

    public int ordre(){
        return this.sommets;
    }
    
    public int taille(){
        return this.aretes;
    }
    
    public String type(){
        String check = "";
        if(!(this.matBool.estSymetrique())){
            check = "non-";
        }
        if (this.estSimple()){
            return "Ce graphe est simple et "+check+"orienté";
        }
        else if(this.estElementaire()){
            return "Ce graphe est un 1-graphe élémentaire"+check+"orienté";
        }
        return "Ce graphe est un 1-graphe"+check+"orienté";
    }
    
    public boolean estElementaire(){
        for(int i = 0; i < this.ordre(); i++){
            for(int j = 0; j < this.ordre(); j++){
                if(i == j && this.matBool.matrice[i][j] == 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean estSimple(){
        //on suppose qu'on travaille qu'avec des 1-graphe pour cette sae
        return this.estElementaire();
    }
    /**
     * 
     * @param sommet sommet auquel on récupère le ou les degrés (si orienté et non simple)
     * @return un tableau de int correspondant au 
     * degre du sommet, respectivement le degré simple, le demi-degré extérieur puis demi-degré intérieur
     * (si orienté et non simple)
     */
    public int[] degre(int sommet){
        int checkOriente;
        if (this.matBool.estSymetrique()){
            checkOriente = 1;
        } 
        else{
            checkOriente = 3;
        }
        int[] degres = new int[checkOriente];
        for(int i = 0; i<this.ordre(); i++){
            if (this.matBool.matrice[sommet][i] != 0){
                degres[0]+=this.matBool.matrice[sommet][i];
                if(degres.length > 1){
                    degres[1]+=this.matBool.matrice[sommet][i];
                }
                
            }
            if (this.matBool.matrice[i][sommet] != 0){
                if(degres.length > 1){
                    degres[0]+=this.matBool.matrice[i][sommet];
                    degres[2]+=this.matBool.matrice[i][sommet];
                }
            }
        }
        return degres;
    }

    public int[] degre(String sommet){
        int checkOriente;
        if (this.matBool.estSymetrique()){
            checkOriente = 1;
        } 
        else{
            checkOriente = 3;
        }
        int indexSommet = -1;
        for(int i = 0; i < this.noeuds.size(); i++){
            if (this.noeuds.get(i)[1].equals(sommet)){
                indexSommet = i;
            }
        }
        int[] degres = new int[checkOriente];
        for(int i = 0; i<this.ordre(); i++){
            if (this.matBool.matrice[indexSommet][i] != 0){
                degres[0]+=this.matBool.matrice[indexSommet][i];
                if(degres.length > 1){
                    degres[1]+=this.matBool.matrice[indexSommet][i];
                }
                
            }
            if (this.matBool.matrice[i][indexSommet] != 0){
                if(degres.length > 1){
                    degres[0]+=this.matBool.matrice[i][indexSommet];
                    degres[2]+=this.matBool.matrice[i][indexSommet];
                }
            }
        }
        return degres;
    }
    
    public void afficherListeDegres(){
        System.out.print("              Sommet : ");
        for(int i = 0; i < this.ordre(); i++){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i = 0; i < 3; i++){
            switch (i) {
                case 0 : {
                    System.out.print("               Degré : ");
                    for(int j = 0; j < this.ordre(); j++){
                        System.out.print(this.degre(j)[0]+" ");
                    }
                    System.out.println();
                }
                case 1 : {
                    System.out.print("Demi-degré extérieur : ");
                    for(int j = 0; j < this.ordre(); j++){
                        System.out.print(this.degre(j)[1]+" ");
                    }
                    System.out.println();
                }
                default : {
                        System.out.print("Demi-degré intérieur : ");
                        for(int j = 0; j < this.ordre(); j++){
                                System.out.print(this.degre(j)[2]+" ");
                                }
                        System.out.println();
                }
            } 
        }
    }

    public int sommeDegre(){
        return this.aretes*2;
    }

    public int poidMinim(int sommet1, int sommet2){
        // return le poid minim entre deux sommet s'il existe un chemin sinon + infini
        return 0;
    }
    /**
     * 
     * @param sommet sommet auquel on récupère les successeurs
     * @return un tableau de int correspondant aux sommets successeurs de sommet
     */
    public int[] suivants(int sommet){
        int checkOriente;
        if (this.matBool.estSymetrique()){
            checkOriente = 0;
        } 
        else{
            checkOriente = 1;
        }
        int[] suivants = new int[this.degre(sommet)[checkOriente]];
        int ctr = 0;
        for(int i = 0; i < this.ordre(); i++){
            if(this.matBool.matrice[sommet][i] != 0){
                suivants[ctr] = i;
                ctr+=1;
            }
        }
        return suivants;
    }
    /**
     * 
     * @param sommet sommet auquel on récupère les predecesseurs
     * @return un tableau de int correspondant aux sommets predecesseurs de sommet
     */
    public int[] precedents(int sommet){
        int checkOriente;
        if (this.matBool.estSymetrique()){
            checkOriente = 0;
        } 
        else{
            checkOriente = 2;
        }
        int[] precedents = new int[this.degre(sommet)[checkOriente]];
        int ctr = 0;
        for(int i = 0; i < this.ordre(); i++){
            if(this.matBool.matrice[i][sommet] != 0){
                precedents[ctr] = i;
                ctr+=1;
            }
        }
        return precedents;
    }
    /**
     * 
     * @param sommet1 
     * @param sommet2 
     * @return true si sommet1 est un predecesseur de sommet2, sinon false
     */
    public boolean verifPredecesseur(int sommet1, int sommet2){
        int[] precedents = this.precedents(sommet2);
        for(int i = 0; i < precedents.length; i++){
            if(precedents[i] == sommet1){
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @param sommet1 
     * @param sommet2 
     * @return true si sommet1 est un successeur de sommet2, sinon false
     */
    public boolean verifSuccesseur(int sommet1, int sommet2){
        int[] suivants = this.suivants(sommet2);
        for(int i = 0; i < suivants.length; i++){
            if(suivants[i] == sommet1){
                return true;
            }
        }
        return false;
    }
    
    public boolean estComplet(){
        for(int i = 0; i < this.ordre(); i++){
            for(int j = 0; j < this.ordre(); j++){
                if(i != j && this.matBool.matrice[i][j] != 1){
                    return false;
                }
            }
        }
        return true;
    } 

    @Override
    public String toString(){
        return "Nombre de sommets : "+this.ordre()+"\nNombre d'arc(s)/arrête(s) : "+this.taille()+
                "\nSomme des degrés : "+this.sommeDegre()+"\nType du graphe : "+this.type();
    }
    
    public int[] welshPowell(){
        int[] SommetsColores = new int[this.sommets];
        int[] Sommets = initWelshPowell();
        if(!(this.matBool.estSymetrique()) || !(this.estSimple())){
            return SommetsColores;
        }
        int ctr = 1;
        int couleur;
        while (listeNonRempli(SommetsColores)) {
            couleur = ctr;     
            for (int i : Sommets) {
                if(SommetsColores[i] == 0){
                    ArrayList <Integer> tab;
                    tab = this.couleursRelies(i, SommetsColores);
                    if(!(tab.contains(couleur))){ 
                        SommetsColores[i] = couleur;
                    } 
                }
            }
            ctr+=1;
        }
        int max = 0;
        for(int i = 0; i < SommetsColores.length; i++){
            if(max < SommetsColores[i]){
                max = SommetsColores[i];
            }
        }
        return SommetsColores;
    }
    public int maxWelshPowell(){
        if(this.estComplet()){
            return this.sommets;
        }
        int [] SommetsColores = this.welshPowell();
        int max = 0;
        for(int i = 0; i < SommetsColores.length; i++){
            if(max < SommetsColores[i]){
                max = SommetsColores[i];
            }
        }
        return max;
    }
    public int[] initWelshPowell(){
        int[][] NonColores = new int[this.sommets][2];
        for(int i = 0; i < this.sommets; i++){
            NonColores[i][0] = this.degre(i)[0];
            NonColores[i][1] = i;
        }
        NonColores = trier(NonColores,NonColores.length);
        int [] Sommets;
        Sommets = new int[this.sommets];
        for(int i = 0; i < this.sommets; i++){
            Sommets[i] = NonColores[i][1];
        }
        return Sommets;
    }
    public int[][] trier( int tab_arg[][], int nb_case ){
        int i, j; 
        int[] tmp;

        for(i=0; i<=nb_case-2; i++) /* nombre de remontée des bulles */
        {
            for(j=0; j<nb_case-1-i; j++) /* les cases dans ]nb_case-1-i;nb_case-1] sont triées */
            {
                if(tab_arg[j][0] < tab_arg[j+1][0])
                {
                    tmp = tab_arg[j+1];
                    tab_arg[j+1] = tab_arg[j];
                    tab_arg[j] = tmp;
                }
            }
        }
        return tab_arg;
    }
    public static void afficherListe(int[] tab){
        System.out.print("[");
        for(int i = 0; i < tab.length; i++){
            System.out.print(tab[i]);
            if (i + 1 != tab.length){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void afficherListe(int[][] tab){
        System.out.print("[");
        for(int i = 0; i < tab.length; i++){
            System.out.print("[");
            for(int j = 0; j < tab[0].length; j++){
                System.out.print(tab[i][j]);
                System.out.print(", ");
            }
            System.out.println("]");
            
        }
        System.out.println("]");
    }

    public boolean listeNonRempli(int[] tab){
        for(int i = 0; i < tab.length; i++){
            if (tab[i] == 0){
                return true;
            }
        }
        return false;
    }
    public int nombreOccurences(int[] tab, int valeur){
        int ctr = 0;
        for(int i = 0;i < tab.length; i++){
            if(tab[i] == valeur){
                ctr+=1;
            }
        }
        return ctr;
    }
    public boolean valeurVerif (int[] tab,int valeur){
        for(int i = 0; i < tab.length; i++){
            if(tab[i] == valeur){
                return true;
            }
        }
        return false;
    }

    public int nbClique(){
        if (!this.estSimple()){
            return -1;
        }
        int nbClique= 0;
        int tempNb;
            for (int i=0; i<this.ordre();i++) {
                tempNb = this.clique(i).size();
                if (nbClique < tempNb){
                    nbClique = tempNb;
                }
            }
        return nbClique;
    }
    public ArrayList<Integer> clique(int sommet){
        ArrayList<Integer> clique = new ArrayList<>();
        clique.add(sommet);
        int valid = 0;     
        for(int j = sommet+1 ; j < this.ordre(); j++){
            for(int i = 0; i < clique.size(); i++){
                if (this.verifSuccesseur(clique.get(i), j) && this.verifSuccesseur(j, clique.get(i)) && !(clique.contains(j))){
                    valid++;
                }
            }
            if(valid == clique.size()){
                clique.add(j);
            }
            valid = 0;
        }
        return clique;
    }
    public int[][] dsat(){
        int[][] dsatTable;
        dsatTable = this.initDsat();
        int dsatMax = dsatMax(dsatTable);
        while(listeNonRempli(dsatTable)){
            for(int i=0; i<dsatTable.length; i++){
                if (dsatTable[i][2]==dsatMax && dsatTable[i][1]==0){
                    setColor(i,dsatTable);
                    actuDsat(i, dsatTable);
                    dsatMax=dsatMax(dsatTable);
                    break;
                }
            }
        }
        return dsatTable;
    }
    public int[][] initDsat(){
        int[][] dsatTable = new int[this.sommets][3];
        for(int i=0; i<dsatTable.length; i++){
            dsatTable[i][0] = i;
            dsatTable[i][1] = 0;
            dsatTable[i][2] = this.degre(i)[0];
        }
        return dsatTable;
    }
    public int degMax(){
        int degMax = 0;
        int tempDeg;
        for(int i = 0; i < this.sommets; i++){
            tempDeg = this.degre(i)[0];
            if(tempDeg > degMax){
                degMax = tempDeg;
            }
        }
        return degMax;
    }
    public int dsatMax(int[][] dTable){
        int dsatMax = 0;
        int tempDeg;
        for (int[] dTable1 : dTable) {
            tempDeg = dTable1[2];
            if(tempDeg > dsatMax){
                dsatMax = tempDeg;
            }
        }
        return dsatMax;
    }
    public boolean listeNonRempli(int[][] tab){
        for (int[] tab1 : tab) {
            if (tab1[1] == 0) {
                return true;
            }
        }
        return false;
    }
    public void setColor(int sommet, int[][] dtable){
        ArrayList<Integer> couleursRelies;
        couleursRelies = couleursRelies(sommet, dtable);
        for(int couleur = 1; couleur < dtable.length; couleur++){
            if(!(couleursRelies.contains(couleur))){
                dtable[sommet][1]=couleur;
                break;
            }
        }
        
        // System.out.println("couleur set successfull");
    }
    public void actuDsat(int sommet,int[][] dtable){
        dtable[sommet][2]= -1;
        ArrayList<Integer> comCouleurs;
        for (int i = 0; i < dtable.length; i++){
            comCouleurs = couleursRelies(i, dtable);
            // System.out.println(i+" : "+comCouleurs);

            if(dtable[i][2]!= -1 && !comCouleurs.isEmpty()){
                dtable[i][2] = comCouleurs.size();
            }
        }
        
            // System.out.println("Actualisation dsat de "+i+" à : "+dtable[i][2]);
    }
    public boolean relies(int sommet1, int sommet2) {
        return (this.verifSuccesseur(sommet1, sommet2) && this.verifSuccesseur(sommet2, sommet1));
    }
    public ArrayList<Integer> couleursRelies(int sommet,int[][] dtable){
        ArrayList<Integer> couleurs = new ArrayList<>();
        for(int i = 0; i < dtable.length; i++){
           if(this.relies(sommet, i) && dtable[i][1]!=0 && !(couleurs.contains(dtable[i][1])) ){
                couleurs.add(dtable[i][1]); 
            }
        }
        return couleurs;
    }
    public ArrayList<Integer> couleursRelies(int sommet,int[] dtable){
        ArrayList<Integer> couleurs = new ArrayList<>();
        for(int i = 0; i < dtable.length; i++){
           if(this.relies(sommet, i) && dtable[i]!=0 && !(couleurs.contains(dtable[i])) ){
                couleurs.add(dtable[i]); 
            }
        }
        return couleurs;
    }
    public int maxDsat(){
        if(this.estComplet()){
            return this.sommets;
        }
        int dsatNb = 0;
        int tempNb;
        int[][] dTable = this.dsat();
        for (int[] i : dTable) {
            tempNb = i[1];
            if(tempNb > dsatNb){
                dsatNb = tempNb;
            }
        }
        return dsatNb;
    }    
    public void afficher(){
        for(int i = 0; i < this.matBool.lignes(); i++){
            System.out.println(Arrays.toString(this.matBool.matrice[i]));
        }
        System.out.println();
    }
    
    
    /**
     * 
     * @param sommet1
     * @param sommet2
     * @return la longueur du chemin le plus court entre deux sommets, 0 s'il y en a pas.
     */
    public int cheminMinim(int sommet1, int sommet2){
        if (this.matBool.estVide()){
            return 0;
        }
        for(int i = 1; i < this.ordre()-1; i++){
            Matrice matrice = this.matBool.powMat(i);
            if (matrice.matrice[sommet1][sommet2] != 0){
                return i;
            }
        }
        return 0;
    }

    public boolean existeChemin(int longueur,int sommet1, int sommet2){
        if (this.matBool.estVide()){
            return false;
        }
        Matrice matrice = this.matBool.powMat(longueur);
        ArrayList<String[]> noeuds = new ArrayList<String[]>();
        Graphe graphe = new Graphe(matrice,this.matVal, this.matLiens,noeuds);
        return graphe.relies(sommet1, sommet2);
    }

    public boolean estConnexe(){
        if(this.matBool.estVide() && this.ordre() > 1){
            return false;
        }
        int[][] sommet = new int[(this.ordre()*(this.ordre()-1)/2)][2];
        int ctr = 0;
        for(int i = 0; i < sommet.length - 1; i++){
            for(int j = i+1; j < sommet.length ; j++){
                sommet[ctr][1] = j;    
                sommet[ctr][0] = i;
                ctr++;
            }   
        }
        for (int[] i : sommet) {
            if (this.cheminMinim(i[0], i[1]) == 0 && this.cheminMinim(i[1], i[0]) == 0) {
                return false;
            }
        }
        return true;
    }
}
