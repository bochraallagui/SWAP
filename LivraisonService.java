/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Livraison;
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
public  class LivraisonService  implements IService<Livraison> {

    Connection cnx;

    public LivraisonService() {
        cnx = MyDB.getInstance().getCnx();
    }

        

    @Override
    public void ajouter(Livraison t) throws SQLException {
        String req = "INSERT INTO livraison(date_livraison,prix_livraison,adresse_livraison,fk_id_livreur) VALUES("
                + "'" +  t.getDate_livraison() + "'," +  t.getPrix_livraison() + ",'" +  t.getAdresse_livraison() + "'," +  t.getFk_id_livreur()+ ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Livraison t) throws SQLException {
         String req = "UPDATE livraison SET date_livraison = ?, prix_livraison = ?,adresse_livraison =?,fk_id_livreur = ? where id_livraison = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,  t.getDate_livraison());
        ps.setInt(2, t.getPrix_livraison());
        ps.setString(3, t.getAdresse_livraison());
        ps.setInt(4, t.getFk_id_livreur());
        ps.setInt(5, t.getId_livraison());
        ps.executeUpdate();
    
    }

    @Override
    public void supprimer(Livraison t) throws SQLException {
        try {
            PreparedStatement req = cnx.prepareStatement("delete from livraison where id_livraison = ? ");
            req.setInt(1, t.getId_livraison());
            req.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
    }
    }

     @Override
    public List<Livraison> recuperer() throws SQLException {
         List<Livraison> livraisons = new ArrayList<>();
        String s = "select * from livraison";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Livraison l = new Livraison();
            l.setPrix_livraison(rs.getInt("prix_livraison"));
            l.setDate_livraison(rs.getString("date_livraison"));
            l.setFk_id_livreur(rs.getInt("fk_id_livreur"));
            l.setAdresse_livraison(rs.getString("adresse_livraison"));
            l.setId_livraison(rs.getInt("id_livraison"));

            livraisons.add(l);

        }
        return livraisons;
        
    }
}
    