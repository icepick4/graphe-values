package graphe.values;
import java.util.Arrays;
/**
*
* @author Rémi
*/
public class MatriceDouble {
   private int colonnes;
   private int lignes;
   public double[][] matrice = new double[lignes][colonnes];
   MatriceDouble(double[][] matrice){
       this.matrice = matrice;
       this.colonnes = matrice[0].length;
       this.lignes = matrice.length;
       int max = this.colonnes;
       for(int i = 0; i < this.lignes; i++){ 
           if(matrice[i].length > max || matrice[i].length < max){
               throw new IllegalArgumentException("Matrice non valide");
           }
       }
   }
   public int colonnes(){
       return this.colonnes;
   }
   
   public int lignes(){
       return this.lignes;
   }    

   public void afficher(){
       for(int i = 0; i < this.lignes(); i++){
           System.out.println(Arrays.toString(this.matrice[i]));
       }
       System.out.println();
       
   }

   public boolean estCarre(){
       return this.lignes == this.colonnes;
   }
   
   public boolean estSymetrique(){
       if(!(this.estCarre())){
           return false;
       }
       for(int i = 0; i < this.lignes(); i++){
           for(int j = 0 ; j < this.colonnes(); j++){
               if (this.matrice[i][j] != this.matrice[j][i]){
                   return false;
               }
           }
       }
       return true;
   }
   
   public boolean estVide(){
       for (int i = 0; i < this.lignes(); i++) {
           for (int j = 0; j < this.colonnes(); j++) {
               if (this.matrice[i][j] != 0) {
                   return false;
               }
           }
       }
       return true;
   }
   
}
