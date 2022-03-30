/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Remi
 */
public class GrapheApp {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //open input.txt file
        // File f = new File("."+File.separator+"input.txt");
        // System.out.println(f.getAbsolutePath());
        // System.out.println(f.getCanonicalFile().getAbsolutePath());
        try{
            FileInputStream fstream = new FileInputStream("input.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //read file line by line
            while ((strLine = br.readLine()) != null)   {
                //print the content on the console
                //System.out.println (strLine);
            }
            //close the input stream
            in.close();
        }
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        int inf = 999;
        int[][] matval = {
            {inf,10,inf,inf,5},
            {inf,inf,1,inf,2},
            {inf,inf,inf,4,inf},
            {7,inf,6,inf,inf},
            {inf,3,9,2,inf}
        };
        int[][] matbool = {
            {0,1,0,0,1},
            {0,0,1,0,1},
            {0,0,0,1,0},
            {1,0,1,0,0},
            {0,1,1,1,0}
        };
        String[][] lies = {
            {"","A","","","N"},
            {"","","N","","D"},
            {"","","","D",""},
            {"A","","D","",""},
            {"","A","D","N",""}
        };
        Matrice matriceBool = new Matrice(matbool);
        Matrice matriceVal = new Matrice(matval);
        MatriceString Liens = new MatriceString(lies);

        ArrayList<String[]> noeuds = new ArrayList<String[]>();
        String[] A = {"V", "A"};
        noeuds.add(A);
        String[] B = {"R", "B"};
        noeuds.add(B);
        String[] C = {"L", "C"};
        noeuds.add(C);
        String[] D = {"V", "D"};
        noeuds.add(D);
        String[] E = {"V", "E"};
        noeuds.add(E);
        Graphe graphe = new Graphe(matriceBool, matriceVal, Liens, noeuds);
        

    }
    
}
