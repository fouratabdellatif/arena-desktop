/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Product;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.esprit.services.ProductCRUD;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class ShowProductsController implements Initializable {

    @FXML
    private Label lblNom;
    @FXML
    private Label lblPrenom;
    @FXML
    private Label lblList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void showAllProducts(ActionEvent event) {
        ProductCRUD pcrud = new ProductCRUD();
        try {
            List<Product> list = pcrud.showAllProducts();
            String res = "";
            for (Product p : list) {
                res += p.getName() + " " + p.getName() + "\n";
            }
            this.lblList.setText(res);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setNom(String lblNom) {
        this.lblNom.setText(lblNom);
    }

    public void setPrenom(String lblPrenom) {
        this.lblNom.setText(lblPrenom);
    }

}
