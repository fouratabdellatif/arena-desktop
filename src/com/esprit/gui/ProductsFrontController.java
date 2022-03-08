/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Product;
import com.esprit.services.ProductCRUD;
import com.esprit.utils.MyListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class ProductsFrontController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Product> productsList = new ArrayList<>();

    private MyListener myListener;
    @FXML
    private TextField searchBar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            ProductCRUD pcrud = new ProductCRUD();
            List products = pcrud.showAllProducts();
            System.out.println(products);
            productsList.addAll(products);
            if (productsList.size() > 0) {
                setChosenProduct(productsList.get(0));
                myListener = new MyListener() {
                    @Override
                    public void onClickListener(Product p) {
                        setChosenProduct(p);
                    }
                };
            }
            int column = 0;
            int row = 1;
            for (int i = 0; i < productsList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemProduct.fxml"));
                AnchorPane anchorPane;
                anchorPane = fxmlLoader.load();

                ItemProductController itemController = fxmlLoader.getController();
                itemController.setData(productsList.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void setChosenProduct(Product p) {
//        fruitNameLable.setText(fruit.getName());
//        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
//        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
//        fruitImg.setImage(image);
//        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n"
//                + "    -fx-background-radius: 30;");
    }
    
    public List<Product> filteredSearch = new ArrayList<>();
    private List<Product> productss = new ArrayList<>();

    @FXML
    private void onClickSearch(ActionEvent event) {
        filteredSearch = new ArrayList<>();
        if (searchBar.getText().equals("")) {
            filteredSearch = productss;
        } else {
            for (Product p : productss) {
                if (p.getName().toLowerCase().contains(searchBar.getText().toLowerCase())) {
                    filteredSearch.add(p);
                }
            }

        }

        System.out.println(filteredSearch);

        int column = 0;
        int row = 1;
        grid.getChildren().clear();

        try {
            for (int i = 0; i < filteredSearch.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemProduct.fxml"));
                AnchorPane anchorPane = (AnchorPane) fxmlLoader.load();

                ItemProductController itemController = fxmlLoader.getController();
                itemController.setData(filteredSearch.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}