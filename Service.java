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
public class Service {
    
    private int id_service, prix_service , fk_id_categorie;
    private String description_service, type_paiement_service;
    private String date_service;

    public Service() {
    }

    public Service(int id_service, int prix_service , int fk_id_categorie, String description_service, String type_paiement_service , String date_service) {
        this.id_service = id_service;
        this.prix_service = prix_service;
        this.fk_id_categorie = fk_id_categorie;
        this.description_service = description_service;
        this.type_paiement_service = type_paiement_service;
        this.date_service = date_service ; 
    }
    public Service(String description_service, String date_service , int prix_service, String type_paiement_service , int fk_id_categorie) {
        this.prix_service = prix_service;
        this.fk_id_categorie = fk_id_categorie;
        this.description_service = description_service;
        this.type_paiement_service = type_paiement_service;
        this.date_service = date_service ; 
    }
    
    public Service(int id_service) {
        this.id_service = id_service;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getPrix_service() {
        return prix_service;
    }

    public void setPrix_service(int prix_service) {
        this.prix_service = prix_service;
    }

    public int getFk_id_categorie() {
        return fk_id_categorie;
    }
    public void setFk_id_categorie(int fk_id_categorie) {
        this.fk_id_categorie = fk_id_categorie;
    }


    public String getDescription_service() {
        return description_service;
    }

    public void setDescription_service(String description_service) {
        if(!"".equals(description_service))
        this.description_service = description_service;
        else {
                System.out.println("description est null");
                }
    }

    public String getType_paiement_service() {
        return type_paiement_service;
    }

    public void setType_paiement_service(String type_paiement_service) {
        if(!"".equals(type_paiement_service))
        this.type_paiement_service = type_paiement_service;
        else {
            System.out.println("type de paiement est null");
        }
    }

    public String getDate_service() {
        return date_service;
    }

    public void setDate_service(String date_service) {
        this.date_service = date_service;
    }

    @Override
    public String toString() {
        return "Service{" + "id_service=" + id_service + ", prix_service=" + prix_service + ", fk_id_categorie=" + fk_id_categorie + ", description_service=" + description_service + ", type_paiement_service=" + type_paiement_service + ", date_service=" + date_service + '}';
    }



    
    
}