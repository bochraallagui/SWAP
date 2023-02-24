/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Pointrelais;
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
 * @author hp
 */
public  class PointrelaisService implements IService<Pointrelais> {

    Connection cnx;

    public PointrelaisService() {
        
        cnx = MyDB.getInstance().getCnx();
    }

    /**
     *
     * @param p
     * @throws SQLException
     */
    @Override
    public void AjouterPointrelais(Pointrelais p) throws SQLException {
        String req = "INSERT INTO pointrelais(adresse_pointrelais,prix_pointrelais) VALUES("
    
                
                
                + "'" +  p.getAdresse_pointrelais() + "','" + p.getPrix_pointrelais()  +"')";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void ModifierPointrelais(Pointrelais p) throws SQLException {
        String req = "UPDATE pointrelais SET adresse_pointrelais = ?,prix_pointrelais = ? where id_pointrelais = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, (String) p.getAdresse_pointrelais());
        ps.setInt(2, (int) p.getPrix_pointrelais());
        ps.setInt(3, p.getId_pointrelais());
        ps.executeUpdate();

    }

    @Override
    public void SupprimerPointrelais(Pointrelais p) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pointrelais> recuperer() throws SQLException {
        List<Pointrelais> pointrelais = new ArrayList<>();
        String s = "select * from pointrelais";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Pointrelais p = new Pointrelais();
            p.setAdresse_pointrelais(rs.getString("adresse_pointrelais"));
            p.setPrix_pointrelais(rs.getInt("prix_pointrelais"));
            p.setId_pointrelais(rs.getInt("id_pointrelais"));

            pointrelais.add(p);

        }
        return pointrelais;
    }

    @Override
    public void AjouterLivraison(Pointrelais t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(Pointrelais t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Pointrelais t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pointrelais> recupererPointrelais() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}

