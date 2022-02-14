/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;
import java.time.Instant;

/**
 *
 * @author Foura
 */
public class Order {

    private int id;
    private int idProduct;
    private int idUser;
    private int productQty;
    private Date createdAt;

    public Order(int id, int idProduct, int idUser, int productQty) {
        this.id = id;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.productQty = productQty;
        long millis = System.currentTimeMillis();
        this.createdAt = new Date(millis);
    }

    public Order(int id, int idProduct, int idUser, int productQty, Date createdAt) {
        this.id = id;
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.productQty = productQty;
        this.createdAt = createdAt;
    }

    public Order(int idProduct, int idUser, int productQty) {
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.productQty = productQty;
        long millis = System.currentTimeMillis();
        this.createdAt = new Date(millis);
    }

    public Order(int idProduct, int idUser, int productQty, Date createdAt) {
        this.idProduct = idProduct;
        this.idUser = idUser;
        this.productQty = productQty;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getProductQty() {
        return productQty;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", idProduct=" + idProduct + ", idUser=" + idUser + ", productQty=" + productQty + ", createdAt=" + createdAt + '}';
    }

}
