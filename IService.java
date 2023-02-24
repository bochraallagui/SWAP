/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Skander
 * @param <T>
 */
public interface IService<T> {
    
    public void AjouterLivraison(T t) throws SQLException;
    public void AjouterPointrelais(T p) throws SQLException;
    public void modifier(T t) throws SQLException;
    public void ModifierPointrelais(T p) throws SQLException;
    public void supprimer(T t) throws SQLException;
    public void SupprimerPointrelais(T p) throws SQLException;
    public List<T> recuperer() throws SQLException;
    public List<T> recupererPointrelais() throws SQLException;
    
}
