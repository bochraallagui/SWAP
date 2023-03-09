/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author ASUS
 */
public class Point_relais {
    int id_pointderelais,fk_id_livraisonp,horaire;
    String adresse_pointderelais,region;

    public Point_relais() {
    }

    public Point_relais(int id_pointderelais, int fk_id_livraisonp, String adresse_pointderelais,int horaire,String region) {
        this.id_pointderelais = id_pointderelais;
        this.fk_id_livraisonp = fk_id_livraisonp;
        this.adresse_pointderelais = adresse_pointderelais;
        this.region = region;
        this.horaire = horaire;
    }

    public Point_relais(int fk_id_livraisonp, String adresse_pointderelais,int horaire,String region) {
        this.fk_id_livraisonp = fk_id_livraisonp;
        this.adresse_pointderelais = adresse_pointderelais;
        this.region = region;
        this.horaire = horaire;
    }

    public int getId_pointderelais() {
        return id_pointderelais;
    }

    public void setId_pointderelais(int id_pointderelais) {
        this.id_pointderelais = id_pointderelais;
    }

    public int getFk_id_livraisonp() {
        return fk_id_livraisonp;
    }

    public void setFk_id_livraisonp(int fk_id_livraisonp) {
        this.fk_id_livraisonp = fk_id_livraisonp;
    }

    public String getAdresse_pointderelais() {
        return adresse_pointderelais;
    }

    public void setAdresse_pointderelais(String adresse_pointderelais) {
        this.adresse_pointderelais = adresse_pointderelais;
    }

    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Point_relais{" + "id_pointderelais=" + id_pointderelais + ", fk_id_livraisonp=" + fk_id_livraisonp + ", horaire=" + horaire + ", adresse_pointderelais=" + adresse_pointderelais + ", region=" + region + '}';
    }

    
    
}
