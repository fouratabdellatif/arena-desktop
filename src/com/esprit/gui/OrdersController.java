/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Order;
import com.esprit.entities.Product;
import com.esprit.services.OrderCRUD;
import com.esprit.services.ProductCRUD;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class OrdersController implements Initializable {
    
    @FXML
    private TableView<Order> ordersTable;
    @FXML
    private TableColumn<Order, String> productCol;
    @FXML
    private TableColumn<Order, String> userCol;
    @FXML
    private TableColumn<Order, Integer> qtyCol;
    @FXML
    private TableColumn<Order, Date> dateCol;
    
    ObservableList<Order> OrdersList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadData();
    }
    
    private void refreshTable() {
        try {
            OrdersList.clear();
            OrderCRUD ocrud = new OrderCRUD();
            
            List<Order> orders = ocrud.showAllOrders();
            System.out.print(orders);
            OrdersList.setAll(orders);
            ordersTable.setItems(OrdersList);
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void loadData() {
        refreshTable();
        
        productCol.setCellValueFactory(new PropertyValueFactory<>("productName"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        qtyCol.setCellValueFactory(new PropertyValueFactory<>("productQty"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("createdAt"));
    }
}
