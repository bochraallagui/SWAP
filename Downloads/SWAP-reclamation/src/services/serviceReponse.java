/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import entities.Reponse;
import interfaces.IserviceReponse;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            ste = connection.createStatement();
            String req ="INSERT INTO reponse (`message_rep`,`etat`) VALUES ('"+t.getMessage_rep()+"',"+t.getEtat()+");";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
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
    public void ajouter2(Reponse t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO reponse (message_rep,etat) VALUES (?,?)");
     
        pre.setString(1, t.getMessage_rep());
         pre.setString(2, t.getEtat());
         
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Reponse> afficher() {
        ArrayList<Reponse> list_rep = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM reponse";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_reponse = res.getInt(1);
            
            String message_rep = res.getString("message_rep");
            String etat = res.getString("etat");
          

            Reponse rec = new Reponse(id_reponse,message_rep,etat);
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
            String requete = "UPDATE reponse SET message_rep=?, etat=? where id_reponse=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(3, t.getId_reponse());
        
            pst.setString(1, t.getMessage_rep());
            
            pst.setString(2, t.getEtat());
        
            pst.executeUpdate();
            System.out.println(" reponse Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }

    public Reponse Onerec(int id_reponse) {
        Reponse u = new Reponse();
     try {
         String req = "select * from reclamation where id= "+id_reponse;
         Statement st = connection.createStatement();
         ResultSet rs = st.executeQuery(req);
         while (rs.next()) {
             u.setId_reponse(rs.getInt(1));
             u.setMessage_rep(rs.getString("message_rep"));
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


	
}

 