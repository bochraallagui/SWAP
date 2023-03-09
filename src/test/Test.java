/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Livraison;
import java.sql.SQLException;
import services.LivraisonService;


/**
 *
 * @author Skander
 */
public class Test {
    
    
    public static void main(String[] args) {
       
        try {
            Livraison p = new Livraison(1,20,2,"07/02/2023","ariana");
            LivraisonService ps = new LivraisonService();
            ps.ajouter(p);
            ps.modifier(p);
            System.out.println(ps.recuperer());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
