/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Feed_back {
    
    private int id_feedback, fk_id_user,fk_id_service;
    private boolean favoris;

    public Feed_back() {
    }

   
    public Feed_back(int id_feedback, boolean favoris, int fk_id_user, int fk_id_service) {
        this.id_feedback = id_feedback;
        this.fk_id_user = fk_id_user;
        this.fk_id_service = fk_id_service;
        this.favoris = favoris;
    }

    public Feed_back(boolean favoris,int fk_id_user, int fk_id_service) {
        this.fk_id_user = fk_id_user;
        this.fk_id_service = fk_id_service;
        this.favoris = favoris;
    }

    public Feed_back(int id_feedback, boolean favoris) {
        this.id_feedback = id_feedback;
        this.favoris = favoris;
    }

    public Feed_back(int id_feedback) {
        this.id_feedback = id_feedback;
    }
    

    public int getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public int getFk_id_user() {
        return fk_id_user;
    }

    public void setFk_id_user(int fk_id_user) {
        this.fk_id_user = fk_id_user;
    }

    public int getFk_id_service() {
        return fk_id_service;
    }

    public void setFk_id_service(int fk_id_service) {
        this.fk_id_service = fk_id_service;
    }


    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    @Override
    public String toString() {
        return "Feed_back{" + "id_feedback=" + id_feedback + ", fk_id_user=" + fk_id_user + ", fk_id_service=" + fk_id_service  + ", favoris=" + favoris + '}';
    }
    
    
}
