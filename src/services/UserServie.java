/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.User;
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
public class UserServie implements IService<User> {

    Connection cnx;

    public UserServie() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(User t) throws SQLException {
    String req = "INSERT INTO user (nom, prenom, role, adresse, num_tel, email, password, date_naissance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement st = cnx.prepareStatement(req);
    st.setString(1, t.getNom());
    st.setString(2, t.getPrenom());
    st.setString(3, t.getRole());
    st.setString(4, t.getAdresse());
    st.setInt(5, t.getNum_tel());
    st.setString(6, t.getEmail());
    st.setString(7, t.getPassword());
    st.setString(8, t.getDate_naissance());
    st.executeUpdate();
}

    @Override
    public void modifier(User t) throws SQLException {
        String req = "UPDATE user SET nom = ?,prenom = ?,adresse = ?,num_tel = ?,password = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getNom());
        ps.setString(2, t.getPrenom());
        ps.setString(3, t.getAdresse());
        ps.setInt(4, t.getNum_tel());
        ps.setString(5, t.getPassword());
        ps.setInt(6, t.getId());
        ps.executeUpdate();
        
    }

    @Override
    public void supprimer(User t) throws SQLException {
        
        try {
            String req;
            req = "delete from user where id =?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,t.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
    }

  
   
   
    @Override
    public List<User> recuperer() throws SQLException {
        List<User> users = new ArrayList<>();
        String s = "select * from user";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            User p = new User();
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setRole(rs.getString("role"));
            p.setAdresse(rs.getString("adresse"));
            p.setNum_tel(rs.getInt("num_tel"));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));
            p.setDate_naissance(rs.getString("date_naissance"));
            p.setId(rs.getInt("id"));
            
            
            users.add(p);
            
        }
        return users;
    }
    
     public List<User> afficher(List<User> t) throws SQLException {
         List<User> users = new ArrayList<>();
         for(User u:t)
         {
        String s = "select * from user where id = "+ u.getId();
        PreparedStatement pss=cnx.prepareStatement(s);
        //pss.setInt(1,t.getId());
        ResultSet rs =  pss.executeQuery(s);
        while(rs.next()){
            User p = new User();
             p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setRole(rs.getString("role"));
            p.setAdresse(rs.getString("adresse"));
            p.setNum_tel(rs.getInt("num_tel"));
            p.setEmail(rs.getString("email"));
            p.setPassword(rs.getString("password"));
            p.setDate_naissance(rs.getString("date_naissance"));
            p.setId(rs.getInt("id"));
          users.add(p);
            
        }}
        return users;
    }

}