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
public  class LivraisonService implements IService<Livraison> {

    Connection cnx;

    public LivraisonService() {
        cnx = MyDB.getInstance().getCnx();
    }

    /**
     *
     * @param t
     * @throws SQLException
     */
    @Override
    public void AjouterLivraison(Livraison t) throws SQLException {
        String req = "INSERT INTO livraison(nom_client,prenom_client,numero_client,prix_livraison,date_livraison,adresse_livraison,fk_id_livreur,fk_id_pointrelais) VALUES("
    
                
                
                + "'" +  t.getNom_client() + "','" + t.getPrenom_client() + "'," + t.getNumero_client() + "," +  t.getPrix_livraison() + ",'" +  t.getDate_livraison() + "','" +  t.getAdresse_livraison() + "'," +  t.getFk_id_livreur()+ "," + t.getFk_id_pointrelais() +")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void ModifierLivraison(Livraison t) throws SQLException {
        String req = "UPDATE livraison SET nom_client = ?,prenom_client = ?,numero_client = ?,prix_livraison = ?,adresse_livraison =?,fk_id_livreur = ?,fk_id_pointrelais = ? where id_livraison = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, (String) t.getNom_client());
        ps.setString(2, (String) t.getPrenom_client());
        ps.setInt(3, (int) t.getNumero_client());
        ps.setInt(4, (int) t.getPrix_livraison());
        ps.setString(5, t.getAdresse_livraison());
        ps.setInt(6, t.getFk_id_livreur());
        ps.setInt(7, t.getFk_id_pointrelais());
        ps.setInt(8, t.getId_livraison());
        ps.executeUpdate();

    }

    @Override
    public void SupprimerLivraison(Livraison t) throws SQLException {
        try {
            String req;
            req = "delete from livraison where id_livraison =?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,t.getId_livraison());
            ps.executeUpdate();
        } catch (SQLException ex) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            l.setNom_client(rs.getString("nom_client"));
            l.setPrenom_client(rs.getString("prenom_client"));
            l.setNumero_client(rs.getInt("numero_client"));
            l.setPrix_livraison(rs.getInt("prix_livraison"));
            l.setDate_livraison(rs.getString("date_livraison"));
            l.setFk_id_livreur(rs.getInt("fk_id_livreur"));
            l.setFk_id_pointrelais(rs.getInt("fk_id_pointrelais"));
            l.setAdresse_livraison(rs.getString("adresse_livraison"));
            l.setId_livraison(rs.getInt("id_livraison"));

            livraisons.add(l);

        }
        return livraisons;
    }

    @Override
    public void AjouterPointrelais(Livraison p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void ModifierPointrelais(Livraison p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SupprimerPointrelais(Livraison p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Livraison> recupererPointrelais() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
