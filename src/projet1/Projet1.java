/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet1;

import connectionpck.MyConnection;
import entities.ProduitPM;
import java.sql.SQLException;
import service.ProduitPMService;

/**
 *
 * @author elbootic.com
 */
public class Projet1 {

   /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
      MyConnection.getMyCnx();
      ProduitPMService es = new ProduitPMService();
      ProduitPM p = new ProduitPM(2,"p",11,11, "malek", (float) 2.2);
      //System.out.println( es.chercher(55));
     // es.supprimerProduitPM(1);
      /*es.ajouterProduit(p);
     
      */
       //es.modifierProduit(p,8 );
       System.out.println(es.afficherProduit());
     
                // System.out.println(es.getExercices());

     
    }
}
    
