/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Feed_back;
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
public class Feed_backServie implements IService<Feed_back>{

    Connection cnx;

    public Feed_backServie() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override   
    public void ajouter(Feed_back t) throws SQLException {
    String req = "INSERT INTO feedback (favoris,fk_id_user,fk_id_service) VALUES (" 
                 + t.isFavoris() + "," + t.getFk_id_user() + "," + t.getFk_id_service() +  ")";
    Statement st = cnx.createStatement();
    st.executeUpdate(req);
}

    @Override
    public void modifier(Feed_back t) throws SQLException {
        String req = "UPDATE feedback SET favoris =" + t.isFavoris()+" where id_feedback = "+ t.getId_feedback();
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.executeUpdate();
        
    }

    @Override
    public void supprimer(Feed_back t) throws SQLException {
        
        try {
            String req;
            req = "delete from feedback where id_feedback=?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,t.getId_feedback()) ;
            ps.executeUpdate();
        } catch (SQLException ex) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
    }

    @Override
    public List<Feed_back> recuperer() throws SQLException {
        List<Feed_back> feed_backs = new ArrayList<>();
        String s = "select * from feedback";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Feed_back p = new Feed_back();
            p.setFavoris(rs.getBoolean("favoris"));
            p.setId_feedback(rs.getInt("id_feedback"));
            p.setFk_id_user(rs.getInt("fk_id_user"));
            p.setFk_id_service(rs.getInt("fk_id_service"));
            
            
            feed_backs.add(p);
            
        }
        return feed_backs;
    }
      public List<Feed_back> afficher(List<Feed_back> t) throws SQLException {
         List<Feed_back> feed_backs = new ArrayList<>();
         for(Feed_back f:t)
         {
        String s = "select * from feedback where id_feedback = "+ f.getId_feedback();
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Feed_back p = new Feed_back();
            p.setFavoris(rs.getBoolean("favoris"));
            p.setId_feedback(rs.getInt("id_feedback"));
            p.setFk_id_user(rs.getInt("fk_id_user"));
            p.setFk_id_service(rs.getInt("fk_id_service"));
            
            
            feed_backs.add(p);
            
        }}
        return feed_backs;
    }

}

    

