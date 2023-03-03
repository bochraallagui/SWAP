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
    
    
    private int id_livraison,numero_client,prix_livraison, fk_id_livreur,fk_id_pointrelais;
    private String nom_client ,prenom_client,date_livraison,adresse_livraison;
   
    
    
    public Livraison() {
    }

    public Livraison(int id_livraison,String nom_client,String prenom_client,int numero_client,int prix_livraison,String date_livraison, String adresse_livraison, int fk_id_livreur,int fk_id_pointrelais) {
        this.id_livraison = id_livraison;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.numero_client = numero_client;
        this.prix_livraison= prix_livraison;
        this.date_livraison= date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.fk_id_livreur = fk_id_livreur;
        this.fk_id_pointrelais= fk_id_pointrelais;
        
    }

    public Livraison(String nom_client,String prenom_client,int numero_client,int prix_livraison,String date_livraison, String adresse_livraison, int fk_id_livreur,int fk_id_pointrelais) {
        
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.numero_client = numero_client;
        this.prix_livraison= prix_livraison;
        this.date_livraison= date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.fk_id_livreur = fk_id_livreur;
        this.fk_id_pointrelais= fk_id_pointrelais;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public int getNumero_client() {
        return numero_client;
    }

    public void setNumero_client(int numero_client) {
        this.numero_client = numero_client;
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

    public int getFk_id_pointrelais() {
        return fk_id_pointrelais;
    }

    public void setFk_id_pointrelais(int fk_id_pointrelais) {
        this.fk_id_pointrelais = fk_id_pointrelais;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
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
        return "Livraison{" + "id_livraison=" + id_livraison + ", numero_client=" + numero_client + ", prix_livraison=" + prix_livraison + ", fk_id_livreur=" + fk_id_livreur + ", fk_id_pointrelais=" + fk_id_pointrelais + ", nom_client=" + nom_client + ", prenom_client=" + prenom_client + ", date_livraison=" + date_livraison + ", adresse_livraison=" + adresse_livraison + '}';
    }

   
}
