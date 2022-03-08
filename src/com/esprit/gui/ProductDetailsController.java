/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.entities.Product;
import com.esprit.utils.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author Foura
 */
public class ProductDetailsController implements Initializable {

    private MyListener myListener;
    private Product p;
    @FXML
    private Label nameLbl;
    @FXML
    private Label descLbl;
    @FXML
    private ImageView imageLbl;
    @FXML
    private Label priceLbl;
    @FXML
    private Label closeIcon;
    @FXML
    private Rating rating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void close(MouseEvent event) {
        Stage stage = (Stage) closeIcon.getScene().getWindow();
        stage.close();
    }

    public void setData(Product p, MyListener myListener) {
        this.p = p;
        this.myListener = myListener;
        nameLbl.setText(p.getName());
        descLbl.setText(p.getDesc());
        priceLbl.setText(p.getPrice() + "DT");
//        Image image = new Image(getClass().getResourceAsStream(p.getImage() + ""));
//        img.setImage(image);
    }

    @FXML
    private void addToCart(ActionEvent event) {
    }

    @FXML
    private void rate(ActionEvent event) {
    }

}
