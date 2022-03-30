/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package graphe.values;
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
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("../../../input.txt");
        Scanner sc = new Scanner(input);
    
        while (sc.hasNextLine()){
        System.out.println(sc.nextLine());
        }
    }
    
}
