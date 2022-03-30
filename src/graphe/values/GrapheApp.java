/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;
import java.io.*;
import java.util.Arrays;
import javax.swing.*;

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
                System.out.println (strLine);
            }
            //close the input stream
            in.close();
        }
        catch (Exception e){//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }
    
}
