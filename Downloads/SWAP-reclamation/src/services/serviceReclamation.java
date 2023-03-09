/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import interfaces.IserviceReclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import utils.MyDB;

/**
 *
 * @author bochra
 */
public class serviceReclamation implements IserviceReclamation<Reclamation>{
    Connection connection;
    Statement ste;

    public serviceReclamation() {
        
        connection = MyDB.getInstance().getCon(); 
    }
    
    
    

   @Override
    public void ajouter(Reclamation t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO reclamation(fk_id_utilisateur,objectif`,`text`) VALUES ('"+t.getfk_id_utilisateur()+",'"+t.getobjectif()+"','"+t.gettext()+"');";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
        
       
    }

    
   /* public void supprimer(Reclamation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 
 
     @Override
    public void supprimer(int id_rec) throws SQLException{
      try{ 
          String req = "DELETE FROM reclamation WHERE id_rec ="+id_rec;
        ste = connection.createStatement();
        ste.executeUpdate(req);
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
         a.showAndWait();
    }
      catch (SQLException ex) {
               
              }
               }
    
 
   @Override
    public void ajouter2(Reclamation t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO reclamation (`objectif`,`text`) VALUES (?,?)");
     
        pre.setString(1, t.getobjectif());
         pre.setString(2, t.gettext());
         
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Reclamation> afficher() {
        ArrayList<Reclamation> listrec = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM reclamation";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int fk_id_utilisateur = res.getInt("fk_id_reclamation");
            
            String objectif = res.getString("objectif");
            String text = res.getString("text");
             

            Reclamation rec = new Reclamation(fk_id_utilisateur,objectif,text);
            listrec.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listrec;
    }
    public ObservableList<Reclamation> getall() {
        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
        try {
            String req = "select * from reclamation";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setfk_id_utilisateur(rs.getInt("fk_id_utilisateur"));
                p.setId_rec(rs.getInt("id_rec"));
                p.setobjectif(rs.getString("objectif"));
                p.settext(rs.getString("text"));
              
               reclamations.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamations;
    }

 

    @Override
    public void modifier(Reclamation t) {
      try {
            String requete = "UPDATE reclamation SET objectif=?, text=? where id_rec=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(3, t.getId_rec());
        
            pst.setString(1, t.getobjectif());
            
            pst.setString(2, t.gettext());
           
            pst.executeUpdate();
            System.out.println(" Reclamation Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
     public Reclamation Onerec(int fk_id_utilisateur) {
           Reclamation u = new Reclamation();
        try {
            String req = "select * from reclamation where fk_id_utilisateur= "+fk_id_utilisateur;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setfk_id_utilisateur(rs.getInt("fk_id_utilisateur"));
                u.setobjectif(rs.getString("objectif"));
                u.settext(rs.getString("text"));
               ;
               
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }
     public List<Reclamation> rechercherParobjectif(String objectif) throws SQLException {
    	    List<Reclamation> reclamations = new ArrayList<>();
    	    String s = "select * from reclamation where objectif like ?";
    	    PreparedStatement ps = connection.prepareStatement(s);
    	    ps.setString(1, "%" + objectif+ "%");
    	    ResultSet rs = ps.executeQuery();
    	    while(rs.next()){
    	        Reclamation p = new Reclamation();
    	       
    	        p.setobjectif(rs.getString("objectif"));
    	        p.settext(rs.getString("text"));
    	        
    	        p.setfk_id_utilisateur(rs.getInt("fk_id_utilisateur"));
    	        reclamations.add(p);
    	    }
    	    return reclamations;
    	}
     
     //public Reclamation rechercher (int id) {
       //  Reclamation p = new Reclamation();
       //  try {
         //    Statement stmt = connection.createStatement();
           //  ResultSet result = stmt.executeQuery("SELECT * FROM reclamation  where id ="+id);
             //while(result.next()) {
               //  p.setId(result.getInt(1));
                 //p.setobjectif(result.getString(2));
                 //p.settext(result.getString(3));
                
             //}
         //} catch (SQLException ex) {
         //    System.out.println(ex.getMessage());
         //}

         //return p;
     }
     
     


 