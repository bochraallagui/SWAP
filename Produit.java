/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Produit {
    private int id_produit,prix_produit,fk_id_commande;
    private String type_paiement,type_produit,description_produit;

    public Produit() {
    }

    
    public Produit(int id_produit, int prix_produit, int fk_id_commande, String type_paiement, String type_produit, String description_produit) {
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
        this.fk_id_commande = fk_id_commande;
        this.type_paiement = type_paiement;
        this.type_produit = type_produit;
        this.description_produit = description_produit;
    }

    public Produit(int prix_produit, int fk_id_commande, String type_paiement, String type_produit, String description_produit) {
        this.prix_produit = prix_produit;
        this.fk_id_commande = fk_id_commande;
        this.type_paiement = type_paiement;
        this.type_produit = type_produit;
        this.description_produit = description_produit;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(int prix_produit) {
        this.prix_produit = prix_produit;
    }

    public int getFk_id_commande() {
        return fk_id_commande;
    }

    public void setFk_id_commande(int fk_id_commande) {
        this.fk_id_commande = fk_id_commande;
    }

    public String getType_paiement() {
        return type_paiement;
    }

    public void setType_paiement(String type_paiement) {
        this.type_paiement = type_paiement;
    }

    public String getType_produit() {
        return type_produit;
    }

    public void setType_produit(String type_produit) {
        this.type_produit = type_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", prix_produit=" + prix_produit + ", fk_id_commande=" + fk_id_commande + ", type_paiement=" + type_paiement + ", type_produit=" + type_produit + ", description_produit=" + description_produit + '}';
    }
    
    
}
