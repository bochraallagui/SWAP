/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Skander
 */
public class Livraison {
    
    
    private int id_livraison,prix_livraison, fk_id_livreur;
    private String adresse_livraison,date_livraison;
   
    
    
    public Livraison() {
    }

    public Livraison(int id_livraison,String date_livraison, int prix_livraison, String adresse_livraison, int fk_id_livreur) {
        this.id_livraison = id_livraison;
        this.date_livraison= date_livraison;
        this.prix_livraison= prix_livraison;
        this.adresse_livraison = adresse_livraison;
        this.fk_id_livreur = fk_id_livreur;
    }

    public Livraison(String date_livraison,int prix_livraison,String adresse_livraison,int fk_id_livreur) {
        
        this.date_livraison= date_livraison;
        this.prix_livraison = prix_livraison;
        this.adresse_livraison = adresse_livraison;
        this.fk_id_livreur = fk_id_livreur;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }
   
     public String getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(String date_livraison) {
        this.date_livraison = date_livraison;
    }
    
    public long getPrix_livraison() {
        return prix_livraison;
    }

    public void setPrix_livraison(int prix_livraison) {
        this.prix_livraison = prix_livraison;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }
 
    public int getFk_id_livreur() {
        return fk_id_livreur;
    }

    public void setFk_id_livreur(int fk_id_livreur) {
        this.fk_id_livreur = fk_id_livreur;
    }
    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", date_livraison=" + date_livraison + ", prix_livraison=" + prix_livraison + ", adresse_livraison=" + adresse_livraison +", fk_id_livreur=" + fk_id_livreur +'}';
    }

}
