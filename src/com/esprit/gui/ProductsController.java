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
import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class ProductsController implements Initializable {

    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Product, String> nameCol;
    @FXML
    private TableColumn<Product, Integer> qtyCol;
    @FXML
    private TableColumn<Product, String> descCol;
    @FXML
    private TableColumn<Product, String> catCol;

    ObservableList<Product> ProductsList = FXCollections.observableArrayList();
    ObservableList<Category> CategoriesList = FXCollections.observableArrayList();
    private Product productItem;

    @FXML
    private JFXTextField nameFld;
    @FXML
    private JFXTextField qtyFld;
    @FXML
    private JFXTextField descFld;
    @FXML
    private JFXTextField imageFld;
    @FXML
    private JFXComboBox<Category> catFld;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            loadData();
            CategoryCRUD ccrud = new CategoryCRUD();

            List<Category> categories = ccrud.showAllCategories();
            CategoriesList.setAll(categories);
            catFld.setItems(CategoriesList);
//            for (int i = 0; i < categories.size(); i++) {
//                catFld.getItems().add(categories.get(i).getName());
//            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void refreshTable() {
        try {
            ProductsList.clear();
            ProductCRUD pcrud = new ProductCRUD();

            List<Product> products = pcrud.showAllProducts();
            ProductsList.setAll(products);
            productsTable.setItems(ProductsList);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void loadData() {
        refreshTable();

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("qty"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("catName"));
    }

    private void clean() {
        nameFld.setText(null);
        qtyFld.setText(null);
        descFld.setText(null);
        imageFld.setText(null);
        catFld.setValue(null);
    }

    @FXML
    private void addProduct(ActionEvent event) {
        String name = nameFld.getText();
        int qty = Integer.parseInt(qtyFld.getText());
        String desc = descFld.getText();
        String image = imageFld.getText();
        int idCat = catFld.getValue().getId();

        Product p = new Product(name, qty, desc, image, idCat);

        ProductCRUD pcrud = new ProductCRUD();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            pcrud.addProduct(p);
            alert.setTitle("Success");
            alert.setHeaderText("added");
            alert.setContentText("product added successfully");
            clean();
            refreshTable();
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

    @FXML
    private void updateProduct(ActionEvent event) {
        String name = nameFld.getText();
        String desc = descFld.getText();
        int qty = Integer.parseInt(qtyFld.getText());
        String image = imageFld.getText();
        int idCat = productItem.getIdCategory();
        int id = productItem.getId();

        ProductCRUD pcrud = new ProductCRUD();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        pcrud.updateProduct(name, qty, desc, image, idCat, id);
        alert.setTitle("Success");
        alert.setHeaderText("updated");
        alert.setContentText("product updated successfully");
        clean();
        refreshTable();
        alert.showAndWait();
    }

    @FXML
    private void deleteProduct(ActionEvent event) {

        int id = productItem.getId();
        ProductCRUD pcrud = new ProductCRUD();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        try {
            pcrud.deleteProduct(id);
            alert.setTitle("Success");
            alert.setHeaderText("deleted");
            alert.setContentText("product deleted successfully");
            clean();
            refreshTable();
        } catch (SQLException ex) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("not deleted");
            alert.setContentText("product isn't deleted");
            System.out.println(ex.getMessage());
        } finally {
            alert.showAndWait();
        }
    }

    @FXML
    private void selectProduct(MouseEvent event) {
        productItem = productsTable.getSelectionModel().getSelectedItem();
        nameFld.setText(productItem.getName());
        descFld.setText(productItem.getDesc());
        qtyFld.setText(Integer.toString(productItem.getQty()));
        imageFld.setText(productItem.getImage());
//        catFld.getSelectionModel().select(productItem);
    }

}
