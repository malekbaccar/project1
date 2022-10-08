/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.util.Objects;


/**
 *
 * @author elbootic.com
 */
public class ProduitPM {
    private int IDProd ;
    private String NomProd ;
    private int referenceP;
    private int quantiteP;
    private  String type;
    private float  prixPM ;

    public ProduitPM(int aInt, String string, int string0, int string1, String string2,float prix) {
        this.IDProd = aInt;
        this.NomProd = string;
        this.referenceP = string0;
        this.quantiteP = string1;
        this.type = string2;
        this.prixPM = prix;
    
       
    }

    public int getIDProd() {
        return IDProd;
    }

    public void setIDProd(int IDProd) {
        this.IDProd = IDProd;
    }

    public String getNomProd() {
        return NomProd;
    }

    public void setNomProd(String NomProd) {
        this.NomProd = NomProd;
    }

    public int getReferenceP() {
        return referenceP;
    }

    public void setReferenceP(int referenceP) {
        this.referenceP = referenceP;
    }

    public int getQuantiteP() {
        return quantiteP;
    }

    public void setQuantiteP(int quantiteP) {
        this.quantiteP = quantiteP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrixPM() {
        return prixPM;
    }

    public void setPrixPM(float prixPM) {
        this.prixPM = prixPM;
    }

    

    public ProduitPM() {
        
    }

    
    

  

   

 
   

   
    
    
   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}















