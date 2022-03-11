/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.arena.utils;

import edu.arena.entities.Order;
import edu.arena.entities.Product;

/**
 *
 * @author Foura
 */
public interface MyListener {

    public void onClickListener(Product p);
    public void onClickOrderListener(Order o);

}
