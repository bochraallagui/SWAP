/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Maissa
 */
public class Categorie {
    
     private int id_categorie;
     private String type_categorie;

     public Categorie() {
    }

    public Categorie(int id_categorie, String type_categorie ) {
        this.id_categorie= id_categorie;
        this.type_categorie = type_categorie;
    }
    
    public Categorie(String type_categorie) {
        this.type_categorie = type_categorie;
    }
    
    public Categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getType_categorie() {
        return type_categorie;
    }

    public void setType_categorie(String type_categorie) {
        if(!"".equals(type_categorie))
        this.type_categorie = type_categorie;
         else {
            System.out.println("type de categorie est null");
        }
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_categorie=" + id_categorie + ", type_categorie=" + type_categorie + '}';
    }
    
    
}