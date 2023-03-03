/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author hp
 */
public class Pointrelais {
    
    private int id_pointrelais, horaire;
    private String adresse_pointrelais,region;
   
    
    
    public Pointrelais() {
    }

    public Pointrelais(int id_pointrelais,String adresse_pointrelais,String region, int horaire) {
        
        this.id_pointrelais = id_pointrelais;
        this.adresse_pointrelais= adresse_pointrelais;
        this.region = region;
        this.horaire = horaire;
        
         

        
        
    }

    public Pointrelais(String adresse_pointrelais,String region, int horaire) {
        
        this.adresse_pointrelais= adresse_pointrelais;
        this.region = region;
        this.horaire = horaire;
        
    }  

    public int getId_pointrelais() {
        return id_pointrelais;
    }

    public void setId_pointrelais(int id_pointrelais) {
        this.id_pointrelais = id_pointrelais;
    }

    public int getHoraire() {
        return horaire;
    }

    public void setHoraire(int horaire) {
        this.horaire = horaire;
    }

    public String getAdresse_pointrelais() {
        return adresse_pointrelais;
    }

    public void setAdresse_pointrelais(String adresse_pointrelais) {
        this.adresse_pointrelais = adresse_pointrelais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Pointrelais{" + "id_pointrelais=" + id_pointrelais + ", horaire=" + horaire + ", adresse_pointrelais=" + adresse_pointrelais + ", region=" + region + '}';
    }

   
    
    
    
}
