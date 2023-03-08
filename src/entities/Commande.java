/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;



/**
 *
 * @author ichra
 */
public class Commande {
    private int id_commande, nbr_produit,fk_id_livraison;
    private float total;
  
    
    public Commande(){
         
    }
    
    public Commande(int id_commande, int nbr_produit, float total, int fk_id_livraison) {
        this.id_commande = id_commande;
        this.nbr_produit = nbr_produit;
        this.total = total;
        this.fk_id_livraison = fk_id_livraison;
    }

       public Commande( int nbr_produit, float total, int fk_id_livraison) {
        this.nbr_produit = nbr_produit;
        this.total = total;
        this.fk_id_livraison = fk_id_livraison;
    }

    public int getId_commande() {
        return id_commande;
    }

    public int getNbr_produit() {
        return nbr_produit;
    }

    public float getTotal() {
        return total;
    }

    public int getFk_id_livraison() {
        return fk_id_livraison;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public void setNbr_produit(int nbr_produit) {
        this.nbr_produit = nbr_produit;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setFk_id_livraison(int fk_id_livraison) {
        this.fk_id_livraison = fk_id_livraison;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", nbr_produit=" + nbr_produit + ", fk_id_livraison=" + fk_id_livraison + ", total=" + total + '}';
    }

    
    
    
     
}
