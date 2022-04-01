/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 *
 * @author Remi
 */
public class GrapheApp {
    static GUI gui = new GUI();
    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //open input.txt file
         File f = new File("."+File.separator+"input.txt");
         System.out.println(f.getAbsolutePath());
         System.out.println(f.getCanonicalFile().getAbsolutePath());
         java.awt.EventQueue.invokeLater(() -> {
             gui.setVisible(true);
         });
         String file = null;
         while (!gui.opened){
             try {
                 Thread.sleep(10);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         file = gui.getFileName();
        FileInputStream fstream = new FileInputStream(file);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
        String strLine;

        //arraylist with nodes
        ArrayList<String[]> noeud = new ArrayList<String[]>();
        int nbLines = 0;
        String[] text;
        String lines = "";
        //reading the txt file
        while ((strLine = br.readLine()) != null){
            lines = lines + strLine;
            nbLines++;
        }

        text = lines.split(";;");
        for(int i = 0; i < nbLines ; i++){
            int n = 0;
            char c = getCharFromString(text[i], n);
            text[i] = text[i].substring(2);
            String[] sommet = {Character.toString(c),null};
            String nomSommet = "";
            while(c != ':'){
                c = getCharFromString(text[i], n);
                if (c != ':'){
                    nomSommet = nomSommet + c;
                }
                n++;
            }
            sommet[1] = nomSommet;
            noeud.add(sommet);
            text[i] = text[i].substring(n);
        }
        //init matricebool matricevaluations matriceliens to put them in graphe constructor
        int[][] matricebool = new int[noeud.size()][noeud.size()];
        double[][] matricevaluations = new double[noeud.size()][noeud.size()];
        String[][] matriceliens = new String[noeud.size()][noeud.size()];
        
        ArrayList<String[]> links = new ArrayList<String[]>();
        //put lines into an array list
        for(int i = 0; i < nbLines; i++){
            links.add(text[i].split(";"));
        }
        //parse those lines into respectives arrays.
        for(int i = 0; i < links.size(); i++){
            for(int j = 0; j < links.get(i).length; j++){
                for(int k = 0; k < noeud.size(); k++){
                    if(links.get(i)[j].split("::")[1].substring(2).toString().equals(noeud.get(k)[1]) && k != i){
                        matricebool[i][k] = 1;
                        matricevaluations[i][k] = Double.parseDouble(links.get(i)[j].split("::")[0].split(",")[1]);
                        matriceliens[i][k] = links.get(i)[j].split("::")[0].split(",")[0];
                    }
                }
            }
        }
        //browse matriceliens and replace 0 by 999
        for(int i = 0; i < matricevaluations.length; i++){
            for(int j = 0; j < matricevaluations.length; j++){
                if(matricevaluations[i][j] == 0.00){
                    matricevaluations[i][j] = 999;
                }
            }
        }
        in.close();
        Matrice matriceBool = new Matrice(matricebool);
        MatriceDouble matriceVal = new MatriceDouble(matricevaluations);
        MatriceString Liens = new MatriceString(matriceliens);
        Graphe graphe = new Graphe(matriceBool, matriceVal, Liens, noeud);
        // System.out.println(graphe.getNbAutoroutes());
        // System.out.println(Arrays.deepToString(graphe.getVille().toArray()));
        //graphe.getMatVal().afficher();
        // System.out.println(graphe.getNbVille());
        // System.out.println(graphe.getNbRestaurant());
        // System.out.println(graphe.getNbLoisir());
        //graphe.floydWarshall().afficher();
        System.out.print(graphe.Vdistance1("Aquarium de Lyon"));
        // graphe.getMatVal().afficher();

    }
    public static char getCharFromString(String str, int index){
        return str.charAt(index);
    }
    
}

        // int inf = 999;
        // int[][] matval = {
        //     {inf,10,inf,inf,5},
        //     {inf,inf,1,inf,2},
        //     {inf,inf,inf,4,inf},
        //     {7,inf,6,inf,inf},
        //     {inf,3,9,2,inf}
        // };
        // int[][] matbool = {
        //     {0,1,0,0,1},
        //     {0,0,1,0,1},
        //     {0,0,0,1,0},
        //     {1,0,1,0,0},
        //     {0,1,1,1,0}
        // };
        // String[][] lies = {
        //     {"","A","","","N"},
        //     {"","","N","","D"},
        //     {"","","","D",""},
        //     {"A","","D","",""},
        //     {"","A","D","N",""}
        // };

        // ArrayList<String[]> noeuds = new ArrayList<String[]>();
        // String[] A = {"V", "A"};
        // noeuds.add(A);
        // String[] B = {"R", "B"};
        // noeuds.add(B);
        // String[] C = {"L", "C"};
        // noeuds.add(C);
        // String[] D = {"V", "D"};
        // noeuds.add(D);
        // String[] E = {"V", "E"};
        // noeuds.add(E);
        //print matricebool
        // for(int i = 0; i < noeud.size(); i++){
        //     for(int j = 0; j < noeud.size(); j++){
        //         //System.out.print(matricebool[i][j] + " ");
        //     }
        //     //System.out.println();
        // }
        // //print matricevaluations
        // for(int i = 0; i < noeud.size(); i++){
        //     for(int j = 0; j < noeud.size(); j++){
        //         // System.out.print(matricevaluations[i][j] + " ");
        //     }
        //     // System.out.println();
        // }
        // //print matriceliens
        // for(int i = 0; i < noeud.size(); i++){
        //     for(int j = 0; j < noeud.size(); j++){
        //         // System.out.print(matriceliens[i][j] + " ");
        //     }
        //     // System.out.println();
        // }
