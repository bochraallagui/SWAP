/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Produit;
import interfaces.IService;
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
 * @author ichrak
 */
public class ProduitService implements IService<Produit>{
    Connection connection;
    Statement ste;

    public ProduitService() {
        
        connection = MyDB.getInstance().getCon(); 
    }
    
    
    

   @Override
    public void ajouter(Produit t) {
        try {
            
            ste = connection.createStatement();
            String req ="INSERT INTO produit(prix_produit`,type_paiement,`type_produit`,description_produit) VALUES ('"+t.getPrix_produit()+"',"+t.getType_paiement()+"',"+t.getType_produit()+"',"+t.getDescription_produit()+");";
            ste.executeUpdate(req);
            
            
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());}
        
        
        
       
    }

    
   /* public void supprimer(Produit t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 
 
     @Override
    public void supprimer(int id_produit) throws SQLException{
      try{ 
          String req = "DELETE FROM produit WHERE id_produit ="+id_produit;
        ste = connection.createStatement();
        ste.executeUpdate(req);
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
         a.showAndWait();
    }
      catch (SQLException ex) {
               
              }
               }
    

   @Override
    public void ajouter2(Produit t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO produit (prix_produit,type_paiement,type_produit,description_produit) VALUES (?,?,?,?)");
     
        pre.setInt(1,(int) t.getPrix_produit());
         pre.setString(2, t.getType_paiement());
         pre.setString(3, t.getType_produit());
         pre.setString(4, t.getDescription_produit());
        
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<Produit> afficher() {
        ArrayList<Produit> list_produit = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM produit";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_produit = res.getInt(1);
            int prix_produit = res.getInt(2);
            
            String type_paiement = res.getString("type paiement");
            String type_produit = res.getString("type produit");
            String description_produit = res.getString("description produit");
             

            Produit rec = new Produit(id_produit,prix_produit,type_paiement,type_produit,description_produit);
            list_produit.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return list_produit;
    }
    public ObservableList<Produit> getall() {
        ObservableList<Produit> Produits = FXCollections.observableArrayList();
        try {
            String req = "select * from produit";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Produit p = new Produit();
                p.setId_produit(rs.getInt(1));
                p.setPrix_produit(rs.getInt(2));
                
                p.setType_paiement(rs.getString("type paiement"));
                p.setType_produit(rs.getString("type produit"));
                p.setDescription_produit(rs.getString("description"));
              
               Produits.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Produits;
    }

 

    @Override
    public void modifier(Produit t) {
      try {
            String requete = "UPDATE produit SET prix_produit=?, type_paiement=?, type_produit=?, description_produit=?  where id_produit=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(5, t.getId_produit());
            pst.setInt(1, t.getPrix_produit());
            pst.setString(2, t.getType_paiement());
            
            pst.setString(3, t.getType_produit());
            pst.setString(4, t.getDescription_produit());
           
            pst.executeUpdate();
            System.out.println(" Produit Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
     public Produit Onerec(int id_produit) {
           Produit u = new Produit();
        try {
            String req = "select * from produit where id_produit= "+id_produit;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setId_produit(rs.getInt(1));
                u.setPrix_produit(rs.getInt(2));
                u.setType_paiement(rs.getString("type paiement"));
                u.setType_produit(rs.getString("type produit"));
                u.setDescription_produit(rs.getString("description produit"));
               
               
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }
     
     
   
     }
     
     


 