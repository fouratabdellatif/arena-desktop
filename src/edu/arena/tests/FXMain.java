/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arena.tests;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Foura
 */
public class FXMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.initStyle(StageStyle.UNDECORATED);
            URL fxURL = getClass().getResource("../gui/BackofficeHome.fxml");
            FXMLLoader loader = new FXMLLoader(fxURL);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        Scene scene = new Scene(new Group());
//        primaryStage.setTitle("Imported Fruits");
//        primaryStage.setWidth(500);
//        primaryStage.setHeight(500);
// 
//        ObservableList<PieChart.Data> pieChartData =
//                FXCollections.observableArrayList(
//                new PieChart.Data("Grapefruit", 13),
//                new PieChart.Data("Oranges", 25),
//                new PieChart.Data("Plums", 10),
//                new PieChart.Data("Pears", 22),
//                new PieChart.Data("Apples", 30));
//        final PieChart chart = new PieChart(pieChartData);
//        chart.setTitle("Imported Fruits");
//
//        ((Group) scene.getRoot()).getChildren().add(chart);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
