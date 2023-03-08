/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package services;

import entities.Commande;
import interfaces.IServiceCommande;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import utils.MyDB;

/**
 *
 * @author Skander
 */
public class CommandeService implements IServiceCommande <Commande> {

    Connection connection;
    Statement ste;

    public CommandeService() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Commande c) throws SQLException {
        try{
        ste = connection.createStatement();
        String req = "INSERT INTO Commande(nbr_produit,total,date_commande) VALUES("
                + "'" + c.getNbr_produit() + "','" + c.getTotal() + "'," + c.getDate_commande() + ")";
        
        ste.executeUpdate(req);
    } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());}
    }

    @Override
    public void modifier(Commande c) throws SQLException {
        try{
        String req = "UPDATE Commande SET nbr_produit = ?,total = ?,date_commande = ? where id_commande = ?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setFloat(1, c.getNbr_produit());
        ps.setDate(2, c.getDate_commande());
        ps.setFloat(3, c.getTotal());
        ps.setInt(4, c.getId_commande());
        ps.executeUpdate();
        
          System.out.println(" commande Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }    
    }
    
         public Commande Onerec(int id_commande) {
           Commande u = new Commande();
        try {
            String req = "select * from commande where id_produit= "+id_commande;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setId_commande(rs.getInt(1));
                u.setNbr_produit(rs.getInt(2));
                u.setTotal(rs.getFloat("total"));
                u.setDate_commande(rs.getDate("date commande"));
                
               
               
                System.out.println(u);
              
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u ;
    }

    
/*
    @Override
    public List<Commande> recuperer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

*/
        
    

    
    /**
    public void supprimer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.}
     * @param id_commande          
     * @throws java.sql.SQLException          
    */
    @Override
     public void supprimer(int id_commande) throws SQLException{
      try{ 
        String req = "DELETE FROM commande WHERE id_commande ="+id_commande;
        ste = connection.createStatement();
        ste.executeUpdate(req);
         Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
         a.showAndWait();
    }
      catch (SQLException ex) {
               
              }
               }
    
    

/*
    @Override
    public List<Commande> recuperer(Commande c) throws SQLException {
        List<Commande> personnes = new ArrayList<>();
        String s = "select * from commande";
        Statement st = connection.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Commande o = new Commande();
            o.setNbr_produit(rs.getInt("Nbr_produit"));
            o.setTotal(rs.getFloat("Total"));
            o.setDate_commande(rs.getDate("Date_commande"));
            o.setId_commande(rs.getInt("Id_commande"));
            
            
            personnes.add(o);
            
        }
        return personnes;
    }
*/

    
    @Override
    public void ajouter2(Commande c) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO commande (nbr_produit,total,date_commande) VALUES (?,?,?)");
     
        pre.setInt(1,(int) c.getNbr_produit());
        pre.setFloat(2, c.getTotal());
        pre.setDate(3, c.getDate_commande());
         
        pre.executeUpdate();
        
    }


@Override
    public ArrayList<Commande> afficher() {
        ArrayList<Commande> list_commande = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM commande";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_commande = res.getInt(1);
            int nbr_produit = res.getInt(2);
            
            Float total = res.getFloat(3);
            Date date_commande = res.getDate(4);
            
             

            Commande rec = new Commande(id_commande,nbr_produit,total,date_commande);
            list_commande.add(rec);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return list_commande;
    }
    
    public ObservableList<Commande> getall() {
        ObservableList<Commande> Commandes = FXCollections.observableArrayList();
        try {
            String req = "select * from commande";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Commande c = new Commande();
                c.setId_commande(rs.getInt(1));
                c.setNbr_produit(rs.getInt(2));
                
                c.setTotal(rs.getFloat(3));
                c.setDate_commande(rs.getDate(4));
                
              
               Commandes.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Commandes;
    }


    
}   

   
/*
    @Override
    public ArrayList<Commande> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  */  
/*
    @Override
    public void supprimer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Commande> recuperer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}*/
