/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Feed_backP;
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
 * @author ASUS
 */
public class Feed_backPServie implements IService<Feed_backP>{

    Connection cnx;

    public Feed_backPServie() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override   
    public void ajouter(Feed_backP t) throws SQLException {
    String req = "INSERT INTO feedbackp (favorisP,fk_id_userP,fk_id_produit) VALUES (" 
                 + t.isFavorisP() + "," + t.getFk_id_userP() +  "," + t.getFk_id_produit() + ")";
    Statement st = cnx.createStatement();
    st.executeUpdate(req);
}

    @Override
    public void modifier(Feed_backP t) throws SQLException {
        String req = "UPDATE feedbackp SET favorisP =" + t.isFavorisP()+" where id_feedbackP = "+ t.getId_feedbackP();
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.executeUpdate();
        
    }

    @Override
    public void supprimer(Feed_backP t) throws SQLException {
        
        try {
            String req;
            req = "delete from feedbackp where id_feedbackP=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,t.getId_feedbackP()) ;
            ps.executeUpdate();
        } catch (SQLException ex) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
    }

    @Override
    public List<Feed_backP> recuperer() throws SQLException {
        List<Feed_backP> feed_backPs = new ArrayList<>();
        String s = "select * from feedbackp";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Feed_backP p = new Feed_backP();
            p.setFavorisP(rs.getBoolean("favorisP"));
            p.setId_feedbackP(rs.getInt("id_feedbackP"));
            p.setFk_id_userP(rs.getInt("fk_id_userP"));
            p.setFk_id_produit(rs.getInt("fk_id_produit"));
            
            
            feed_backPs.add(p);
            
        }
        return feed_backPs;
    }
      public List<Feed_backP> afficher(List<Feed_backP> t) throws SQLException {
         List<Feed_backP> feed_backPs = new ArrayList<>();
         for(Feed_backP f:t)
         {
        String s = "select * from feedbackp where id_feedbackP = "+ f.getId_feedbackP();
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Feed_backP p = new Feed_backP();
            p.setFavorisP(rs.getBoolean("favorisP"));
            p.setId_feedbackP(rs.getInt("id_feedbackP"));
            p.setFk_id_userP(rs.getInt("fk_id_userP"));
            p.setFk_id_produit(rs.getInt("fk_id_produit"));
            
            
            feed_backPs.add(p);
            
        }}
        return feed_backPs;
    }

}

    

