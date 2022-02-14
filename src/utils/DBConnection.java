/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ayadi
 */
public class DBConnection {

    String URL = "jdbc:mysql://localhost:3306/arena";
    String LOGIN = "root";
    String PWD = "";
    public static DBConnection db;
    public Connection con;

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("connexion etablie");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConnection() {
        return con;
    }

    public static DBConnection getInstance() {
        if (db == null) {
            db = new DBConnection();
        }
        return db;
    }
}
