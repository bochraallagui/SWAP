/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Service;
import java.sql.Connection;
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
public class ServiceS implements IService<Service>{
    Connection cnx;

    public ServiceS() {
        cnx = MyDB.getInstance().getCnx();
    }
    
     @Override
    public List<Service> recuperer() throws SQLException {
        List<Service> services = new ArrayList<>();
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
            services.add(p);
            
        }
        return services;
    }


 

    @Override
    public void ajouter(Service t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(Service t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(Service t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
