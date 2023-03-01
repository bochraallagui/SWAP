/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Categorie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Skander
 */
public class CategorieS implements IService<Categorie> {

    Connection cnx;

    public CategorieS() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Categorie t) throws SQLException {
        String req = "INSERT INTO categorie(type_categorie) VALUES("
                + "'" + t.getType_categorie() +  "')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("done");
        
        
    }

    @Override
    public void modifier(Categorie t) throws SQLException {
        String req = "UPDATE categorie SET type_categorie = ? where id_categorie = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getType_categorie());
        ps.setInt(2, t.getId_categorie());
        ps.executeUpdate();
        
    }

    @Override
    public void  supprimer(Categorie t) throws SQLException {
   
        try {
            PreparedStatement req = cnx.prepareStatement("delete from categorie where id_categorie = ? ");
            req.setInt(1, t.getId_categorie());
            req.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
       
    }

    @Override
    public List<Categorie> recuperer() throws SQLException {
        List<Categorie> categories = new ArrayList<>();
        String s = "select * from categorie";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Categorie p = new Categorie();
            p.setType_categorie(rs.getString("type_categorie"));
            p.setId_categorie(rs.getInt("id_categorie"));
            categories.add(p);
            
        }
        return categories;
    }



}
