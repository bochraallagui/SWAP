/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.IService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import utils.MyDB;
import javafx.collections.ObservableList;
import java.io.FileOutputStream;
import java.io.IOException;
import entities.Commande;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Skander
 */
public class CommandeService implements IService<Commande> {

    Connection connection;
    Statement ste;

    public CommandeService() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Commande c) throws SQLException {
        try {
            ste = connection.createStatement();
            String req = "INSERT INTO commande(nbr_produit,total,fk_id_livraison) VALUES("
                    + "'" + c.getNbr_produit() + "','" + c.getTotal() + "'," + c.getFk_id_livraison() + ")";

            ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void modifier(Commande c) throws SQLException {
        try {
            String req = "UPDATE commande SET nbr_produit = ?,total = ?,fk_id_livraison = ? where id_commande = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setFloat(1, c.getNbr_produit());

            ps.setFloat(2, c.getTotal());
            ps.setInt(3, c.getId_commande());
            ps.setInt(4, c.getFk_id_livraison());
            ps.executeUpdate();

            System.out.println(" commande Modifiée! ");
        } catch (SQLException ex) {
            System.out.println(" erreur de modification! ");
            System.err.println(ex.getMessage());
        }
    }

    public Commande Onerec(int id_commande) {
        Commande u = new Commande();
        try {
            String req = "select * from commande where id_commande= " + id_commande;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                u.setId_commande(rs.getInt(1));
                u.setNbr_produit(rs.getInt(2));
                u.setTotal(rs.getFloat("total"));
                u.setFk_id_livraison(rs.getInt(1));

                System.out.println(u);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    /*
    @Override
    public List<Commande> recuperer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
         
     */
 /*
    public void supprimer(Commande c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.}
     * @param id_commande          
     * @throws java.sql.SQLException          
     */
    @Override
    public void supprimer(int id_commande) throws SQLException {
        try {
            String req = "DELETE FROM commande WHERE id_commande =" + id_commande;
            ste = connection.createStatement();
            ste.executeUpdate(req);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Suppression effectuée", ButtonType.OK);
            a.showAndWait();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void ajouter2(Commande c) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO commande (nbr_produit,total,fk_id_livraison) VALUES (?,?,?)");

        pre.setInt(1, (int) c.getNbr_produit());
        pre.setFloat(2, c.getTotal());
        pre.setInt(3, c.getFk_id_livraison());

        pre.executeUpdate();

    }

    @Override
    public ArrayList<Commande> afficher() {
        ArrayList<Commande> list_commande = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM commande";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id_commande = res.getInt(1);
                int nbr_produit = res.getInt(2);

                Float total = res.getFloat(3);
                int fk_id_livraison = res.getInt(4);

                Commande rec = new Commande(id_commande, nbr_produit, total, fk_id_livraison);
                list_commande.add(rec);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return list_commande;
    }

    public ObservableList<Commande> getall() {
        ObservableList<Commande> Commandes = FXCollections.observableArrayList();
        try {
            String req = "select * from commande";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Commande c = new Commande();
                c.setId_commande(rs.getInt(1));
                c.setNbr_produit(rs.getInt(2));

                c.setTotal(rs.getFloat(3));
                c.setFk_id_livraison(rs.getInt(4));

                Commandes.add(c);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Commandes;
    }

    public void exportToExcel() throws IOException {
    Workbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet("Commandes");

    // Create the header row
    Row headerRow = sheet.createRow(0);
    headerRow.createCell(0).setCellValue("ID");
    headerRow.createCell(1).setCellValue("Nombre de produit");
    headerRow.createCell(2).setCellValue("Total");
    headerRow.createCell(3).setCellValue("ID de la livraison");

    // Retrieve the data and create the data rows
    ArrayList<Commande> commandes = afficher();
    int rowIndex = 1;
    for (Commande commande : commandes) {
        Row dataRow = sheet.createRow(rowIndex++);
        dataRow.createCell(0).setCellValue(commande.getId_commande());
        dataRow.createCell(1).setCellValue(commande.getNbr_produit());
        dataRow.createCell(2).setCellValue(commande.getTotal());
        dataRow.createCell(3).setCellValue(commande.getFk_id_livraison());
    }

    // Autosize the columns
    for (int i = 0; i < 4; i++) {
        sheet.autoSizeColumn(i);
    }

    // Write the workbook to a file
    FileOutputStream fileOut = new FileOutputStream("Commandes.xlsx");
    workbook.write(fileOut);
    fileOut.close();

    // Show a success message
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Export to Excel");
    alert.setHeaderText("Export to Excel");
    alert.setContentText("The data has been exported to an Excel file.");
    alert.showAndWait();
}

}
