/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import entities.Reclamation;
import entities.Reponse;
import interfaces.IserviceReponse;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import utils.MyDB;

/**
 *
 * @author bochra
 */
public class serviceReponse implements IserviceReponse<Reponse>{
	
    Connection connection;
    Statement ste;

    public serviceReponse() {
        
        connection = MyDB.getInstance().getCon();
    }
    
    
    



    @Override
    public void ajouter(Reponse t) {
    try {
    String req = "INSERT INTO reponse (fk_id_reclamation, message_rep, fk_id_admin, etat) VALUES (?, ?, ?, ?)";
    PreparedStatement pst = connection.prepareStatement(req);
    pst.setInt(1, t.getFk_id_reclamation());
    pst.setString(2, t.getMessage_rep());
    pst.setInt(3, t.getFk_id_admin());
    pst.setString(4, t.getEtat());
    pst.executeUpdate();
    } catch (SQLException ex) {
    System.out.println("Exception: " + ex.getMessage());
    }
    }

    /*@Override
   /* public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
   public void supprimer(int id_reponse){
     try{ 
         String req = "DELETE FROM reponse WHERE id_reponse="+id_reponse;
       ste = connection.createStatement();
       ste.executeUpdate(req);
        Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
        a.showAndWait();
   }
     catch (SQLException ex) {
              
             }
              }
   
 
   
    
        

    @Override 
    public ArrayList<Reponse> afficher() {
        ArrayList<Reponse> list_rep = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM reponse";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int fk_id_reclamation= res.getInt("fk_id_reclamation");
            
            String message_rep = res.getString("message_rep");
            int fk_id_admin= res.getInt("fk_id_admin");
            String etat = res.getString("etat");
          

            Reponse rec = new Reponse(fk_id_reclamation,message_rep,etat);
            list_rep.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return list_rep;
    } 

 

    @Override
    public void modifier(Reponse t) {
      try {
            String requete = "UPDATE reponse SET message_rep=?,fk_id_admin=?, etat=? where id_reponse=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(4, t.getId_reponse());
        
            pst.setString(1, t.getMessage_rep());
            
            pst.setInt(2, t.getFk_id_admin());
            pst.setString(3, t.getEtat());
        
            pst.executeUpdate();
            System.out.println(" reponse Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }

    public Reponse Onerec(int fk_id_reclamation) {
        Reponse u = new Reponse();
     try {
         String req = "select * from reclamation where fk_id_reclamation= "+fk_id_reclamation;
         Statement st = connection.createStatement();
         ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
             u.setFk_id_reclamation(rs.getInt("fk_id_reclamation"));
             
             u.setMessage_rep(rs.getString("message_rep"));
             u.setFk_id_admin(rs.getInt("fk_id_admin"));
             u.setEtat(rs.getString("etat"));
            ;
            
             System.out.println(u);
           
         }

     } catch (SQLException ex) {
         System.out.println(ex.getMessage());
     }
     return u ;
 }




	public ObservableList<Reponse> getall() {
		// TODO Auto-generated method stub
		return null;
	}





    @Override
    public void ajouter2(Reponse t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO reclamation (fk_id_reclamation,message_rep,fk_id_admin,etat) VALUES (?,?,?,?)");

        pre.setInt(1, (int) t.getFk_id_reclamation());
        pre.setString(2, t.getMessage_rep());
        pre.setInt(3, (int) t.getFk_id_admin());
        pre.setString(4, t.getEtat());
      

        pre.executeUpdate();

    }


	  	
}

 