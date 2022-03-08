/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import com.esprit.entities.Category;
import com.esprit.entities.Order;
import com.esprit.entities.Product;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.Arrays;
import java.util.List;
import com.esprit.services.CategoryCRUD;
import com.esprit.services.OrderCRUD;
import com.esprit.services.ProductCRUD;

/**
 *
 * @author Foura
 */
public class ArenaDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        ProductCRUD pcrud = new ProductCRUD();
        CategoryCRUD ccrud = new CategoryCRUD();
        OrderCRUD ocrud = new OrderCRUD();

        /*int[] products = new int[2];
        products[0] = 0;
        products[1] = 1;

        Order o1 = new Order(0, Arrays.toString(products), 21, Date.from(Instant.now()));

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(o1.toString());*/
//        pcrud.addProduct(p1);
//        pcrud.addProduct(p2);
//        pcrud.updateProduct("God Of War", 60, "Play God Of War", "/imageGOW", c1.getId(), 9);
//        pcrud.deleteProduct(9);
        System.out.println(pcrud.showAllProducts());
//        Category c1 = new Category("Games", "This category is about games");
//        Category c2 = new Category("Equipments", "This category is about gaming equipments");
//        ccrud.addCategory(c1);
//        ccrud.addCategory(c2);
////
//        List<Category> categories = ccrud.showAllCategories();
//        Product p1 = new Product("FIFA22 Game", 50, "Play soccer against your friends", "/imageFifa22.jpg", categories.get(0).getId());
//        Product p2 = new Product("PS5", 20, "PlayStation 5 Gaming Console", "/imagePS5.jpg", categories.get(1).getId());
//        Product p3 = new Product(2, "Joystick", 80, "The best joystick ever", "/imageJoystick.jpg", categories.get(1).getId());
//        pcrud.addProduct(p1);
//        pcrud.addProduct(p2);
//        pcrud.addProduct(p3);
//
//        List<Product> products = pcrud.showAllProducts();
//        System.out.println(products);
//        Order o1 = new Order(products.get(0).getId(), 1, 2);
//        Order o2 = new Order(products.get(1).getId(), 1, 3);
//        Order o3 = new Order(products.get(1).getId(), 2, 4);
//        Order o4 = new Order(products.get(2).getId(), 3, 4);
//        ocrud.addOrder(o1);
//        ocrud.addOrder(o2);
//        ocrud.addOrder(o3);
//        ocrud.addOrder(o4);
//        pcrud.updateProduct("God Of War", 60, "Play God Of War", "/imageGOW", c1.getId(), 9);
//        pcrud.deleteProduct(9);
//        List<Product> products = pcrud.showAllProducts();
//        System.out.println(categories.get(0).getId());
//        System.out.println(products.get(0));
//        System.out.println(ccrud.showAllCategories());
//        System.out.println(ccrud.showCategory(14));
//        System.out.println(ocrud.showAllOrders());
//        pcrud.addProduct(p1);
//        pcrud.addProduct(p2);
//        pcrud.addProduct(p3);
//        pcrud.updateProduct("God Of War", 60, "Play God Of War", "/imageGOW", c1.getId(), 9);
//        pcrud.deleteProduct(9);
//        System.out.println(pcrud.showAllProducts());
    }
}
