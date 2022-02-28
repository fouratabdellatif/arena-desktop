/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.esprit.utils.DBConnection;

/**
 *
 * @author Foura
 */
public class ProductCRUD {

    private Connection con;
    private Statement ste;

    public ProductCRUD() {
        con = DBConnection.getInstance().getConnection();
    }

    public void addProduct(Product p) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO products (name,qty,description,image,idCat)VALUES (?,?,?,?,?);");
        pre.setString(1, p.getName());
        pre.setInt(2, p.getQty());
        pre.setString(3, p.getDesc());
        pre.setString(4, p.getImage());
        pre.setInt(5, p.getIdCategory());

        pre.executeUpdate();
    }

    public boolean updateProduct(String name, int qty, String desc, String image, int idCat, int id) {
        try {
            PreparedStatement pre = con.prepareStatement("update products set name=?, qty=?, description=?, image=?, idCat=? where id=? ;");

            pre.setString(1, name);
            pre.setInt(2, qty);
            pre.setString(3, desc);
            pre.setString(4, image);
            pre.setInt(5, idCat);
            pre.setInt(6, id);

            if (pre.executeUpdate() != 0) {
                System.out.println("product updated");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id not found!");
        return false;
    }

    public boolean deleteProduct(int id) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from products where id=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("Product Deleted");
            return true;
        }
        System.out.println("id Product not found!");
        return false;

    }

    public List<Product> showAllProducts() throws SQLException {

        List<Product> listOfProducts = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT "
                + "products.id AS product_id,"
                + "products.name AS product_name,"
                + "products.qty AS product_qty,"
                + "products.description AS product_description,"
                + "products.image AS product_image,"
                + "idCat AS category_id, "
                + "categories.name AS category_name, "
                + "categories.description AS category_desc"
                + " from products JOIN categories ON products.idCat=categories.id");
        while (rs.next()) {
            int id = rs.getInt("product_id");
            String name = rs.getString("product_name");
            int qty = rs.getInt("product_qty");
            String desc = rs.getString("product_description");
            String image = rs.getString("product_image");
            int idCat = rs.getInt("category_id");
            String catName = rs.getString("category_name");
            String catDesc = rs.getString("category_desc");
            Product p = new Product(id, name, qty, desc, image, idCat, catName, catDesc);
            listOfProducts.add(p);
        }
        return listOfProducts;
    }
}
