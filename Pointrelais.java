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
    
    private int id_pointrelais, prix_pointrelais;
    private String adresse_pointrelais;
   
    
    
    public Pointrelais() {
    }

    public Pointrelais(int id_pointrelais,String adresse_pointrelais, int prix_pointrelais) {
        
        this.id_pointrelais = id_pointrelais;
        this.adresse_pointrelais= adresse_pointrelais;
        this.prix_pointrelais= prix_pointrelais;
        
    }

    public Pointrelais(String adresse_pointrelais,int prix_pointrelais) {
        
        this.adresse_pointrelais = adresse_pointrelais;
        this.prix_pointrelais = prix_pointrelais;
        
    }  

    public int getId_pointrelais() {
        return id_pointrelais;
    }

    public void setId_pointrelais(int id_pointrelais) {
        this.id_pointrelais = id_pointrelais;
    }

    public int getPrix_pointrelais() {
        return prix_pointrelais;
    }

    public void setPrix_pointrelais(int prix_pointrelais) {
        this.prix_pointrelais = prix_pointrelais;
    }

    public String getAdresse_pointrelais() {
        return adresse_pointrelais;
    }

    public void setAdresse_pointrelais(String adresse_pointrelais) {
        this.adresse_pointrelais = adresse_pointrelais;
    }

    @Override
    public String toString() {
        return "Pointrelais{" + "id_pointrelais=" + id_pointrelais + ", adresse_pointrelais=" + adresse_pointrelais + ", prix_pointrelais=" + prix_pointrelais + '}';
    }
    
    
    
}
