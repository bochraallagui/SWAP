/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ZeroS TF
 */
public class Affectation {
    
    private int id_affectation;
    private int fk_id_produit;
    private int fk_id_commande;

    public Affectation() {
    }

    public Affectation(int fk_id_produit, int fk_id_commande) {
        this.fk_id_produit = fk_id_produit;
        this.fk_id_commande = fk_id_commande;
    }
    
    public Affectation(int id_affectation, int fk_id_produit, int fk_id_commande) {
        this.id_affectation = id_affectation;
        this.fk_id_produit = fk_id_produit;
        this.fk_id_commande = fk_id_commande;
    }
    
    public int getId_affectation() {
        return id_affectation;
    }
    
    public void setId_affectation(int id_affectation) {
        this.id_affectation = id_affectation;
    }
    
    public int getFk_id_produit() {
        return fk_id_produit;
    }
    
    public void setFk_id_produit(int fk_id_produit) {
        this.fk_id_produit = fk_id_produit;
    }
    
    public int getFk_id_commande() {
        return fk_id_commande;
    }
    
    public void setFk_id_commande(int fk_id_commande) {
        this.fk_id_commande = fk_id_commande;
    }
    
    @Override
    public String toString() {
        return "Affectation [id_affectation=" + id_affectation + ", fk_id_produit=" + fk_id_produit + ", fk_id_commande=" + fk_id_commande + "]";
    }
}
    

