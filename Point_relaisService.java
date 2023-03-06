/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Point_relais;
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
 * @author ASUS
 */
public class Point_relaisService implements IService<Point_relais>{
    
    Connection cnx;

    public Point_relaisService () {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Point_relais t) throws SQLException {
          String req = "INSERT INTO pointderelais ( adresse_pointderelais,fk_id_livraisonp) VALUES("
                + "'" +  t.getAdresse_pointderelais()+ "'," +  t.getFk_id_livraisonp()+ ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);
    }

    @Override
    public void modifier(Point_relais t) throws SQLException {
        String req = "UPDATE pointderelais SET adresse_pointderelais = ? where id_pointderelais = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1,  t.getAdresse_pointderelais());
        ps.setInt(2, t.getId_pointderelais());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(Point_relais t) throws SQLException {
           try {
            PreparedStatement req = cnx.prepareStatement("delete from pointderelais where id_pointderelais = ? ");
            req.setInt(1, t.getId_pointderelais());
            req.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
    }
    }

    @Override
    public List<Point_relais> recuperer() throws SQLException {
         List<Point_relais> points = new ArrayList<>();
        String s = "select * from pointderelais";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Point_relais l = new Point_relais();
            l.setAdresse_pointderelais(rs.getString("adresse_pointderelais"));
            l.setFk_id_livraisonp(rs.getInt("fk_id_livraisonp"));
            l.setId_pointderelais(rs.getInt("id_pointderelais"));
            points.add(l);

        }
        return points;
        
    }
    }
    

