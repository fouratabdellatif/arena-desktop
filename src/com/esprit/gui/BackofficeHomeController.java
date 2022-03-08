/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class BackofficeHomeController implements Initializable {

    @FXML
    private StackPane contentArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("users.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void switchUsers(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("users.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchProducts(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("products.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchOrders(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("orders.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchTournaments(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("tournaments.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchGameCat(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("gamecat.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    private void switchProductCat(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("productcat.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

}
