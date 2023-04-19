/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL
 */
public class CartObj implements Serializable {

    private Map<String, Integer> cart;

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void addProductToCart(String productId, int quantity) {
        // 1. Check existed cart
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }

        // 2. Check existed book
        if (this.cart.containsKey(productId)) {
            quantity = this.cart.get(productId) + quantity;
        }

        // 3. Update cart
        this.cart.put(productId, quantity);
    }

    public void removeProductFromCart(String productId) {
        // 1. Check existed cart
        if (this.cart == null) {
            return;
        }

        // 2. Check existed book
        if (this.cart.containsKey(productId)) {
            this.cart.remove(productId);
            if (this.cart.isEmpty()) {
                this.cart = null;
            }
        }
    }
}
