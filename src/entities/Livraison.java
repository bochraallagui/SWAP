/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author Skander
 */
public class Livraison {
    
    
    private int id_livraison,prix_livraison, fk_id_livreur;
    private String date_livraison,adresse_livraison;

    public Livraison() {
    }

    public Livraison(int id_livraison, int prix_livraison, int fk_id_livreur, String date_livraison, String adresse_livraison) {
        this.id_livraison = id_livraison;
        this.prix_livraison = prix_livraison;
        this.fk_id_livreur = fk_id_livreur;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
    }

    public Livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getPrix_livraison() {
        return prix_livraison;
    }

    public void setPrix_livraison(int prix_livraison) {
        this.prix_livraison = prix_livraison;
    }

    public int getFk_id_livreur() {
        return fk_id_livreur;
    }

    public void setFk_id_livreur(int fk_id_livreur) {
        this.fk_id_livreur = fk_id_livreur;
    }

    public String getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(String date_livraison) {
        this.date_livraison = date_livraison;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(String adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", prix_livraison=" + prix_livraison + ", fk_id_livreur=" + fk_id_livreur + ", date_livraison=" + date_livraison + ", adresse_livraison=" + adresse_livraison + '}';
    }
   
   
}