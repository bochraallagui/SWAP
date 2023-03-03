/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author Skander
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
        String req = "INSERT INTO pointrelais (adresse_pointrelais,region,horaire) VALUES("
    
                
                
                + "'" +  p.getAdresse_pointrelais() + "','" +p.getRegion() + "'," + p.getHoraire() + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void ModifierPointrelais(Pointrelais p) throws SQLException {
        String req = "UPDATE pointrelais SET adresse_pointrelais = ?,region = ?,horaire = ? where id_pointrelais = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, (String) p.getAdresse_pointrelais());
        ps.setString(2, (String) p.getRegion());
        ps.setInt(3, (int) p.getHoraire());
        ps.setInt(4, p.getId_pointrelais());
        ps.executeUpdate();

    }

    @Override
    public void SupprimerPointrelais(Pointrelais p) throws SQLException {
        try {
            String req;
            req = "delete from pointrelais where id_pointrelais =?";
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setInt(1,p.getId_pointrelais());
            ps.executeUpdate();
        } catch (SQLException ex) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
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
            p.setRegion(rs.getString("region"));
            p.setHoraire(rs.getInt("horaire"));
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
    public void ModifierLivraison(Pointrelais t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void SupprimerLivraison(Pointrelais t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pointrelais> recupererPointrelais() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

}
