/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Personne;
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
public class PersonneService implements IService<Personne> {

    Connection cnx;

    public PersonneService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Personne t) throws SQLException {
        String req = "INSERT INTO personne(nom,prenom,age) VALUES("
                + "'" + t.getNom() + "','" + t.getPrenom() + "'," + t.getAge() + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Personne t) throws SQLException {
        String req = "UPDATE personne SET nom = ?,prenom = ?,age = ? where id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getNom());
        ps.setString(2, t.getPrenom());
        ps.setInt(3, t.getAge());
        ps.setInt(4, t.getId());
        ps.executeUpdate();

    }

    @Override
    public void supprimer(Personne t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Personne> recuperer() throws SQLException {
        List<Personne> personnes = new ArrayList<>();
        String s = "select * from personne";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Personne p = new Personne();
            p.setAge(rs.getInt("age"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setId(rs.getInt("id"));

            personnes.add(p);

        }
        return personnes;
    }

}
