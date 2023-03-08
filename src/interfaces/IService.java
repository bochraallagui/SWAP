/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

/**
 *
 * @author bochra
 */
public interface IService<T> {
    
    public void ajouter(T  t) throws SQLException;
    public void ajouter2(T  t) throws SQLException;
    public void supprimer(int t)throws SQLException; 
    public void modifier(T t)throws SQLException;
    public ArrayList<T> afficher();
   
    
    
}
