/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;

import com.formdev.flatlaf.FlatDarkLaf;

import graphe.values.model.Graphe;
import graphe.values.model.Matrice;
import graphe.values.model.MatriceDouble;
import graphe.values.model.MatriceString;
import graphe.values.view.GUI;
import graphe.values.view.GrapheDraw;

import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.DataInputStream;

/**
 * Classe principale de l'application qui permet d'ouvrir un fichier et de
 * l'afficher (.txt) (.csv)
 * 
 * @author Remi
 * @version 1.0
 */
public class GrapheApp {
    private GUI gui;
    private Matrice matriceBool;
    private MatriceDouble matriceVal;
    private MatriceString liens;
    public Graphe graphe;

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new GrapheApp();
    }

    public GrapheApp() {
        FlatDarkLaf.setup();
        gui = new GUI(this);
        gui.setVisible(true);
    }

    /**
     * Permet d'ouvrir un fichier et de l'afficher
     */
    public void initApp() throws IOException {
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
        // if file ends with .csv
        boolean checkCsv = false;
        if (file.endsWith(".csv")) {
            checkCsv = true;
        }

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
            if (checkCsv) {
                // remove the " at the beginning
                // create a char "
                char c = '"';
                if (strLine.charAt(0) == c && strLine.charAt(strLine.length() - 1) == c) {
                    strLine = strLine.substring(1, strLine.length() - 1);
                }
                // remove all spaces
                strLine = strLine.replaceAll(" ", "");
            }
            lines = lines + strLine;
            nbLines++;
        }

        // get the nodes names
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
        // print result of graphe.floydWarshallPredecesseurs()
        // graphe.floydWarshallPredesseceurs().afficher();
        // System.out.print(graphe.floydWarshallPredesseceurs().matrice[21][7]);

        // System.out.println(graphe.floydWarshallChemin(21,7));

        GrapheDraw Canvas = this.gui.getCanvas();
        Canvas.clear();
        Canvas.drawGraph(this.graphe);
    }

    // setters
    public void setMatriceBool(Matrice matriceBool) {
        this.matriceBool = matriceBool;
    }

    public void setMatriceVal(MatriceDouble matriceVal) {
        this.matriceVal = matriceVal;
    }

    public void setLiens(MatriceString liens) {
        this.liens = liens;
    }

    public void setGraphe(ArrayList<String[]> noeud) {
        this.graphe = new Graphe(getMatriceBool(), getMatriceVal(), getLiens(), noeud);
    }

    // getters
    public Matrice getMatriceBool() {
        return this.matriceBool;
    }

    public MatriceDouble getMatriceVal() {
        return this.matriceVal;
    }

    public MatriceString getLiens() {
        return this.liens;
    }

    public Graphe getGraphe() {
        return this.graphe;
    }

    /**
     * Permet de récupérer le caractère à l'index passé en argument à partir d'une
     * chaine de caractère
     * 
     * @param str
     * @param index
     * @return le caractère à l'index passé en argument
     */
    public static char getCharFromString(String str, int index) {
        return str.charAt(index);
    }

}
