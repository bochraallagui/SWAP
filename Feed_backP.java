/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Feed_backP {
    
    private int id_feedbackP, fk_id_userP,fk_id_produit;
    private boolean favorisP;

    public Feed_backP() {
    }

   
    public Feed_backP(int id_feedbackP, boolean favorisP, int fk_id_userP,  int fk_id_produit) {
        this.id_feedbackP = id_feedbackP;
        this.fk_id_userP = fk_id_userP;
        this.fk_id_produit = fk_id_produit;
        this.favorisP = favorisP;
    }

    public Feed_backP(boolean favorisP,int fk_id_userP,  int fk_id_produit) {
        this.fk_id_userP = fk_id_userP;
        this.fk_id_produit = fk_id_produit;
        this.favorisP = favorisP;
    }

    public Feed_backP(int id_feedbackP, boolean favorisP) {
        this.id_feedbackP = id_feedbackP;
        this.favorisP = favorisP;
    }

    public Feed_backP(int id_feedbackP) {
        this.id_feedbackP = id_feedbackP;
    }
    

    public int getId_feedbackP() {
        return id_feedbackP;
    }

    public void setId_feedbackP(int id_feedbackP) {
        this.id_feedbackP = id_feedbackP;
    }

    public int getFk_id_userP() {
        return fk_id_userP;
    }

    public void setFk_id_userP(int fk_id_userP) {
        this.fk_id_userP = fk_id_userP;
    }


    public int getFk_id_produit() {
        return fk_id_produit;
    }

    public void setFk_id_produit(int fk_id_produit) {
        this.fk_id_produit = fk_id_produit;
    }

    public boolean isFavorisP() {
        return favorisP;
    }

    public void setFavorisP(boolean favorisP) {
        this.favorisP = favorisP;
    }

    @Override
    public String toString() {
        return "Feed_backP{" + "id_feedbackP=" + id_feedbackP + ", fk_id_userP=" + fk_id_userP +  ", fk_id_produit=" + fk_id_produit + ", favorisP=" + favorisP + '}';
    }
    
    
}
