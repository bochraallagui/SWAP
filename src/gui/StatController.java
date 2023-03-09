/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import services.ProduitService;

/**
 * FXML Controller class
 *
 * @author ZeroS TF
 */
public class StatController implements Initializable {

    @FXML
    private BarChart<String, Number> chart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private Label averagePrice;

    private ProduitService produitService;
    private Map<String, Double> averagePrices;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        produitService = new ProduitService();
        averagePrices = produitService.getAveragePriceByType();
        showChart();
        showAveragePrice();
    }

    private void showChart() {
        x.setLabel("Type of Product");
        y.setLabel("Average Price");

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (String type : averagePrices.keySet()) {
            series.getData().add(new XYChart.Data<>(type, averagePrices.get(type)));
        }

        chart.getData().add(series);
    }

    private void showAveragePrice() {
        List<String> types = new ArrayList<>(averagePrices.keySet());
        double totalPrice = 0;
        for (String type : types) {
            totalPrice += averagePrices.get(type);
        }
        double average = totalPrice / types.size();
        averagePrice.setText(String.format("Average Price of all Products: %.2f", average));
    }
}
