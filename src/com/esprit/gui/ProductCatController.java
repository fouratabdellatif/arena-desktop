/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Category;
import com.esprit.entities.Product;
import com.esprit.services.CategoryCRUD;
import com.esprit.services.ProductCRUD;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class ProductCatController implements Initializable {

    @FXML
    private JFXTextField catNameFld;
    @FXML
    private JFXTextField catDescFld;
    @FXML
    private TableView<Category> productsTable;
    @FXML
    private TableColumn<Category, String> catNameCol;
    @FXML
    private TableColumn<Category, String> catDescCol;

    ObservableList<Category> CategoriesList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }

    private void refreshTable() {
        try {
            CategoriesList.clear();
            CategoryCRUD ccrud = new CategoryCRUD();

            List<Category> categories = ccrud.showAllCategories();
            CategoriesList.setAll(categories);
            productsTable.setItems(CategoriesList);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadData() {
        refreshTable();

        catNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        catDescCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
    }

    private void clean() {
        catNameFld.setText(null);
        catDescFld.setText(null);
    }

    @FXML
    private void addCategory(ActionEvent event) {
        String name = catNameFld.getText();
        String desc = catDescFld.getText();

        Category c = new Category(name, desc);

        CategoryCRUD ccrud = new CategoryCRUD();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            ccrud.addCategory(c);
            alert.setTitle("Success");
            alert.setHeaderText("added");
            alert.setContentText("category added successfully");
            clean();
            refreshTable();
        } catch (SQLException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("not addedd");
            alert.setContentText("category isn't added");
            System.out.println(ex.getMessage());
        } finally {
            alert.showAndWait();
        }
    }

    @FXML
    private void updateCategory(ActionEvent event) {
    }

    @FXML
    private void deleteCategory(ActionEvent event) {
    }

}
