/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Product;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import com.esprit.services.ProductCRUD;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class AddProductFormController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addProduct(ActionEvent event) {
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        Product p = new Product(nom, 20, nom, nom);
        ProductCRUD pcrud = new ProductCRUD();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            pcrud.addProduct(p);
            alert.setTitle("Success");
            alert.setHeaderText("added");
            alert.setContentText("product added successfully");

            alert.setOnCloseRequest((evn) -> {
                try {
                    URL fxURL = getClass().getResource("ShowProducts.fxml");
                    FXMLLoader loader = new FXMLLoader(fxURL);
                    Parent root = loader.load();
                    ShowProductsController spc = loader.getController();
                    spc.setNom(tfNom.getText());
                    spc.setPrenom(tfPrenom.getText());
                    tfNom.getScene().setRoot(root);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            });
        } catch (SQLException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("not addedd");
            alert.setContentText("product isn't added");
            System.out.println(ex.getMessage());
        } finally {
            alert.showAndWait();
        }
    }

}
