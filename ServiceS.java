/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Service;
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
public class ServiceS implements IService<Service> {

    Connection cnx;

    public ServiceS() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Service t) throws SQLException {
    String req = "INSERT INTO service (description_service,date_service,prix_service, type_paiement_service,fk_id_categorie) VALUES ("
                + "'" + t.getDescription_service() +  "','" + t.getDate_service() + "'," + t.getPrix_service() + ",'" + t.getType_paiement_service() + "'," + t.getFk_id_categorie() + ")";
    Statement st = cnx.createStatement();
        st.executeUpdate(req);
    
}

    @Override
    public void modifier(Service t) throws SQLException {
        String req = "UPDATE service SET description_service = ?,date_service = ?,prix_service = ?,type_paiement_service = ?,fk_id_categorie = ? where id_service = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, t.getDescription_service());
        ps.setString(2, t.getDate_service());
        ps.setInt(3, t.getPrix_service());
        ps.setString(4, t.getType_paiement_service());
        ps.setInt(5, t.getFk_id_categorie());
        ps.setInt(6, t.getId_service());
        ps.executeUpdate();
        
    }

    @Override
    public void  supprimer(Service t) throws SQLException {
 
        try {
            PreparedStatement req = cnx.prepareStatement("delete from service where id_service = ? ");
            req.setInt(1, t.getId_service());
            req.executeUpdate();
           
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
    }

    @Override
    public List<Service> recuperer() throws SQLException {
        List<Service> service = new ArrayList<>();
        String s = "select * from service";
        Statement st = cnx.createStatement();
        ResultSet rs =  st.executeQuery(s);
        while(rs.next()){
            Service p = new Service();
            p.setDescription_service(rs.getString("description_service"));
            p.setDate_service(rs.getString("date_service"));
            p.setPrix_service(rs.getInt("prix_service"));
            p.setType_paiement_service(rs.getString("type_paiement_service"));
            p.setFk_id_categorie(rs.getInt("fk_id_categorie"));
            p.setId_service(rs.getInt("id_service"));
            service.add(p);
            
        }
        return service;
    }



}
