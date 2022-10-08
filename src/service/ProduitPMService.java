/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connectionpck.MyConnection;
import entities.ProduitPM;
import iservice.IserviceProduit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


/**
 *
 * @author elbootic.com
 */
public class ProduitPMService  {
    
    
    private Connection cnx;
   

    public ProduitPMService() {
        cnx =  MyConnection.getMyCnx().getConnection();
        
        
        

      }

    
    public void ajouterProduit(ProduitPM produit) throws SQLException {
       try {
            String req = "INSERT INTO ProduitPM( NomProd,referenceP,quantiteP,type,prixPM)values(?,?,?,?,?)";
            PreparedStatement pst =  cnx.prepareStatement(req);
         
            pst.setString(1, produit.getNomProd());
            pst.setInt(2, produit.getReferenceP());
            pst.setInt(3, produit.getQuantiteP());
            pst.setString(4,produit.getType());
            pst.setFloat(5,produit.getPrixPM());
            
            pst.executeUpdate();
            System.out.println("Produit added !");
            //JOptionPane.showMessageDialog(null, "Exercice Add ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            
            
        }
    }
   
    public List<ProduitPM> getProduits()throws SQLException {
        List ProduitsList = new ArrayList(); 
            
        
            String req = "Select * from produitPM";
            Statement st = (Statement) cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                ProduitsList.add(new ProduitPM(
                          rs.getInt("IDProd")  ,
                    rs.getString("NomProd") ,
                    rs.getInt("referenceP"),
                    rs.getInt("quantiteP"),
                    rs.getString("type"),
                    rs.getFloat("prixPM")));
                

            
        }
        return ProduitsList;
    }
  public void supprimerProduitPM(int IDProd) throws SQLException {

        String req = "DELETE FROM ProduitPM WHERE IDProd=?";
        try {
            PreparedStatement pst = (PreparedStatement) cnx.prepareStatement(req);
            pst.setInt(1, IDProd);
            pst.executeUpdate();
        } catch (SQLException ex) {
                        System.out.println(ex);
        }

    }
  public  Boolean chercher(int id) {
        String req = "select * from ProduitPM";
        List<Integer> list = new ArrayList<>();
        try {
            java.sql.Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                list.add(rs.getInt(1));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProduitPM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.contains(id);
    }
     
    public boolean modifierProduit(ProduitPM E,int id) throws SQLException {
         if (chercher(id)) {
            try {
                String req = "UPDATE ProduitPM SET NomProd=?,referenceP=?,quantiteP=?,type=? WHERE IDProd = "+id;
            PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, E.getNomProd());
            pst.setInt(2, E.getReferenceP());
            pst.setInt(3, E.getQuantiteP());
            pst.setString(4, E.getType());
            //pst.setInt(5, id);
            pst.executeUpdate (); 

            } catch (SQLException ex) {
                Logger.getLogger(ProduitPM.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("update valide");
            return true;
        }
        System.out.println("update invalid: produit nexiste pas");
        return false;
    }

    public boolean modifierProduit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<ProduitPM> afficherProduit() {
        List<ProduitPM> myList = new ArrayList<>();
        try {

            String requete3 = "SELECT * FROM produit";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete3);
            while (rs.next()) {
                ProduitPM p = new ProduitPM();
                p.setIDProd(rs.getInt(1));
                p.setNomProd(rs.getString("NomProd"));
                p.setReferenceP(rs.getInt("referenceP"));
                p.setQuantiteP(rs.getInt("quantiteP"));
                p.setType(rs.getString("type"));
                p.setPrixPM(rs.getFloat("prixPM"));
                myList.add(p);
            }

        } catch (SQLException ex) {
            System.err.println("ex.getMessage()");
        }
        return myList;
    }

}
