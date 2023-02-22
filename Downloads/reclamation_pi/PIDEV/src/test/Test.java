/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Personne;
import java.sql.SQLException;
import services.PersonneService;


/**
 *
 * @author Skander
 */
public class Test {
    
    
    public static void main(String[] args) {
       
        try {
            Personne p = new Personne( 1,25, "Ala", "Ali");
            PersonneService ps = new PersonneService();
            ps.ajouter(p);
            ps.modifier(p);
            System.out.println(ps.recuperer());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
