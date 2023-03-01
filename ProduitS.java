/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Produit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author ASUS
 */
public class ProduitS implements IService<Produit>{
    Connection cnx;

    public ProduitS() {
        cnx = MyDB.getInstance().getCnx();
    }
    
     @Override
    public List<Produit> recuperer() throws SQLException {
        List<Produit> Produits = new ArrayList<>();
        String s = "select * from Produit";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Produit p = new Produit();
            p.setDescription_produit(rs.getString("description_Produit"));
            p.setPrix_produit(rs.getInt("prix_produit"));
            p.setId_produit(rs.getInt("id_produit"));
            Produits.add(p);
            
        }
        return Produits;
    }


 

    @Override
    public void ajouter(Produit t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(Produit t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Produit t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
