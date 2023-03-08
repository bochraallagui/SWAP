/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author ichra
 */
public class Commande {
    private int id_commande, nbr_produit;
    private float total;
    private Date date_commande;
    
    public Commande(){
         
    }
    
    public Commande(int id_commande, int nbr_produit, float total, Date date_commande) {
        this.id_commande = id_commande;
        this.nbr_produit = nbr_produit;
        this.total = total;
        this.date_commande = date_commande;
    }

       public Commande( int nbr_produit, float total, Date date_commande) {
        this.nbr_produit = nbr_produit;
        this.total = total;
        this.date_commande = date_commande;
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

    public Date getDate_commande() {
        return date_commande;
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

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", nbr_produit=" + nbr_produit + ", total=" + total + ", date_commande=" + date_commande + '}';
    }
    
    
    
    
    
    
    
}
