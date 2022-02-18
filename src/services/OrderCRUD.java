/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Order;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author Foura
 */
public class OrderCRUD {

    private Connection con;
    private Statement ste;

    public OrderCRUD() {
        con = DBConnection.getInstance().getConnection();
    }

    public void addOrder(Order o) throws SQLException {
        PreparedStatement pre = con.prepareStatement("INSERT INTO orders (idProduct,idUser,productQty,createdAt)VALUES (?,?,?,?);");
        pre.setInt(1, o.getIdProduct());
        pre.setInt(2, o.getIdUser());
        pre.setInt(3, o.getProductQty());
        pre.setDate(4, o.getCreatedAt());

        pre.executeUpdate();
    }

    public boolean updateOrder(int idProduct, int idUser, int productQty, int id) {
        try {
            PreparedStatement pre = con.prepareStatement("update orders set idProduct=?, idUser=?, productQty=? where id=? ;");

            pre.setInt(1, idProduct);
            pre.setInt(2, idUser);
            pre.setInt(3, productQty);
            pre.setInt(4, id);

            if (pre.executeUpdate() != 0) {
                System.out.println("order updated");
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("id not found!");
        return false;
    }

    public boolean deleteOrder(int id) throws SQLException {

        PreparedStatement pre = con.prepareStatement("Delete from orders where id=? ;");
        pre.setInt(1, id);
        if (pre.executeUpdate() != 0) {
            System.out.println("Order Deleted");
            return true;
        }
        System.out.println("id Order not found!");
        return false;

    }

    public List<Order> showAllOrders() throws SQLException {

        List<Order> listOfOrders = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("SELECT "
                + "orders.id AS order_id, "
                + "idProduct AS product_id, "
                + "products.name AS product_name, "
                + "products.description AS product_desc, "
                + "idUser AS user_id, "
                + "users.name AS user_name, "
                + "users.email AS user_email, "
                + "users.role AS user_role, "
                + "orders.productQty AS order_qantity, "
                + "orders.createdAt AS order_date "
                + "from orders "
                + "INNER JOIN users ON orders.idUser=users.id "
                + "INNER JOIN products ON orders.idProduct=products.id");
        while (rs.next()) {
            int id = rs.getInt("order_id");
            int idProduct = rs.getInt("product_id");
            String productName = rs.getString("product_name");
            String productDesc = rs.getString("product_desc");
            String userName = rs.getString("user_name");
            String userEmail = rs.getString("user_email");
            String userRole = rs.getString("user_role");
            int idUser = rs.getInt("user_id");
            int productQty = rs.getInt("order_qantity");
            Date createdAt = rs.getDate("order_date");
            Order o = new Order(id, idProduct, idUser, productQty, createdAt, productName, productDesc, userName, userEmail, userRole);
            listOfOrders.add(o);
        }
        return listOfOrders;
    }

}
