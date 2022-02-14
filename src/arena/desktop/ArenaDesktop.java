/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.desktop;

import entities.Category;
import entities.Order;
import entities.Product;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.Arrays;
import services.CategoryCRUD;
import services.OrderCRUD;
import services.ProductCRUD;

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
//        System.out.println(pcrud.showAllProducts());
//        Category c1 = new Category("Games", "This category is about games");
//        Category c2 = new Category("Equipments", "This category is about gaming equipments");
//        ccrud.addCategory(c1);
//        ccrud.addCategory(c2);
////
//        Product p1 = new Product("FIFA22 Game", 50, "Play soccer against your friends", "/imageFifa22.jpg", 17);
//        Product p2 = new Product("PS5", 20, "PlayStation 5 Gaming Console", "/imagePS5.jpg", 18);
//        Product p3 = new Product(2, "Joystick", 80, "The best joystick ever", "/imageJoystick.jpg", 18);
//        pcrud.addProduct(p1);
//        pcrud.addProduct(p2);
//        pcrud.addProduct(p3);
//
//        Order o1 = new Order(p1.getId(), 2145, 4);
//        Order o2 = new Order(p2.getId(), 2145, 2);
//        Order o3 = new Order(p2.getId(), 2121, 1);
//        Order o4 = new Order(p2.getId(), 2140, 1);
//        ocrud.addOrder(o1);
//        ocrud.addOrder(o2);
//        ocrud.addOrder(o3);
//        ocrud.addOrder(o4);

//        pcrud.updateProduct("God Of War", 60, "Play God Of War", "/imageGOW", c1.getId(), 9);
//        pcrud.deleteProduct(9);
//        System.out.println(pcrud.showAllProducts());
//        System.out.println(ccrud.showAllCategories());
//        System.out.println(ccrud.showCategory(14));
//        System.out.println(ocrud.showAllOrders());
//        pcrud.addProduct(p1);
//        pcrud.addProduct(p2);
//        pcrud.updateProduct("God Of War", 60, "Play God Of War", "/imageGOW", c1.getId(), 9);
//        pcrud.deleteProduct(9);
//        System.out.println(pcrud.showAllProducts());
    }
}
