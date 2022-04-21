/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;

import com.formdev.flatlaf.FlatDarkLaf;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;

/**
 *
 * @author Remi
 */
public class GrapheApp {
    static GUI gui;
    // static GrapheDraw frame;
    private static Matrice matriceBool;
    private static MatriceDouble matriceVal;
    private static MatriceString liens;
    private static Graphe graphe;

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        FlatDarkLaf.setup();
        gui = new GUI();
        gui.setVisible(true);
    }

    public static void initApp() throws IOException {
        String file = null;
        while (!gui.opened) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.opened = false;
        file = gui.getFileName();
        // get only the title of the file
        String filename = file.substring(file.lastIndexOf("\\") + 1, file.length());
        gui.setTitle(filename);
        FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String strLine;

        // arraylist with nodes
        ArrayList<String[]> noeud = new ArrayList<String[]>();
        int nbLines = 0;
        String[] text;
        String lines = "";
        // reading the txt file
        while ((strLine = br.readLine()) != null) {
            lines = lines + strLine;
            nbLines++;
        }

        text = lines.split(";;");
        for (int i = 0; i < nbLines; i++) {
            int n = 0;
            char c = getCharFromString(text[i], n);
            text[i] = text[i].substring(2);
            String[] sommet = { Character.toString(c), null };
            String nomSommet = "";
            while (c != ':') {
                c = getCharFromString(text[i], n);
                if (c != ':') {
                    nomSommet = nomSommet + c;
                }
                n++;
            }
            sommet[1] = nomSommet;
            noeud.add(sommet);
            text[i] = text[i].substring(n);
        }
        // init matricebool matricevaluations matriceliens to put them in graphe
        // constructor
        int[][] matricebool = new int[noeud.size()][noeud.size()];
        double[][] matricevaluations = new double[noeud.size()][noeud.size()];
        String[][] matriceliens = new String[noeud.size()][noeud.size()];

        ArrayList<String[]> links = new ArrayList<String[]>();
        // put lines into an array list
        for (int i = 0; i < nbLines; i++) {
            links.add(text[i].split(";"));
        }
        // parse those lines into respectives arrays.
        for (int i = 0; i < links.size(); i++) {
            for (int j = 0; j < links.get(i).length; j++) {
                for (int k = 0; k < noeud.size(); k++) {
                    if (links.get(i)[j].split("::")[1].substring(2).toString().equals(noeud.get(k)[1]) && k != i) {
                        matricebool[i][k] = 1;
                        matricevaluations[i][k] = Double.parseDouble(links.get(i)[j].split("::")[0].split(",")[1]);
                        matriceliens[i][k] = links.get(i)[j].split("::")[0].split(",")[0];
                    }
                }
            }
        }
        // browse matriceliens and replace 0 by 999
        for (int i = 0; i < matricevaluations.length; i++) {
            for (int j = 0; j < matricevaluations.length; j++) {
                if (matricevaluations[i][j] == 0.00) {
                    matricevaluations[i][j] = 999;
                }
            }
        }
        in.close();
        setMatriceBool(new Matrice(matricebool));
        setMatriceVal(new MatriceDouble(matricevaluations));
        setLiens(new MatriceString(matriceliens));
        setGraphe(noeud);
        graphe = GrapheApp.getGraphe();
        // print result of graphe.floydWarshallPredecesseurs()
        // graphe.floydWarshallPredesseceurs().afficher();
        // System.out.print(graphe.floydWarshallPredesseceurs().matrice[21][7]);

        // System.out.println(graphe.floydWarshallChemin(21,7));

        GrapheDraw Canvas = GUI.getCanvas();
        Canvas.clear();
        Canvas.drawGraph(graphe);
    }

    // setters
    public static void setMatriceBool(Matrice matriceBool) {
        GrapheApp.matriceBool = matriceBool;
    }

    public static void setMatriceVal(MatriceDouble matriceVal) {
        GrapheApp.matriceVal = matriceVal;
    }

    public static void setLiens(MatriceString liens) {
        GrapheApp.liens = liens;
    }

    public static void setGraphe(ArrayList<String[]> noeud) {
        GrapheApp.graphe = new Graphe(getMatriceBool(), getMatriceVal(), getLiens(), noeud);
    }

    // getters
    public static Matrice getMatriceBool() {
        return GrapheApp.matriceBool;
    }

    public static MatriceDouble getMatriceVal() {
        return GrapheApp.matriceVal;
    }

    public static MatriceString getLiens() {
        return GrapheApp.liens;
    }

    public static Graphe getGraphe() {
        return GrapheApp.graphe;
    }

    public static char getCharFromString(String str, int index) {
        return str.charAt(index);
    }

}
