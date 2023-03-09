/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Affectation;
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
 * @author ZeroS TF
 */
public class AffectationService {
    
    Connection connection;
    Statement ste;

    public AffectationService() {
        connection = MyDB.getInstance().getCon();
    }
    
    public void ajouter(Affectation a) throws SQLException {
        String req = "INSERT INTO affectation (fk_id_produit, fk_id_commande) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, a.getFk_id_produit());
        ps.setInt(2, a.getFk_id_commande());
        ps.executeUpdate();
        System.out.println("Affectation ajoutée avec succès");
    }

    // Read
    public List<Affectation> getAllAffectations() throws SQLException {
        String req = "SELECT * FROM affectation";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(req);
        List<Affectation> affectations = new ArrayList<>();
        while (rs.next()) {
            Affectation a = new Affectation();
            a.setId_affectation(rs.getInt("id_affectation"));
            a.setFk_id_produit(rs.getInt("fk_id_produit"));
            a.setFk_id_commande(rs.getInt("fk_id_commande"));
            affectations.add(a);
        }
        return affectations;
    }

    public Affectation getAffectationById(int id) throws SQLException {
        String req = "SELECT * FROM affectation WHERE id_affectation=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Affectation a = new Affectation();
            a.setId_affectation(rs.getInt("id_affectation"));
            a.setFk_id_produit(rs.getInt("fk_id_produit"));
            a.setFk_id_commande(rs.getInt("fk_id_commande"));
            return a;
        } else {
            return null;
        }
    }

    // Update
    public void modifier(Affectation a) throws SQLException {
        String req = "UPDATE affectation SET fk_id_produit=?, fk_id_commande=? WHERE id_affectation=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, a.getFk_id_produit());
        ps.setInt(2, a.getFk_id_commande());
        ps.setInt(3, a.getId_affectation());
        ps.executeUpdate();
        System.out.println("Affectation modifiée avec succès");
    }

    // Delete
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM affectation WHERE id_affectation=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Affectation supprimée avec succès");
    }
    
    
}
