package com.trackunit.cart.data.extension;

import com.trackunit.cart.model.Cart;
import com.trackunit.cart.model.Item;

import javax.persistence.*;

@Entity
public class ItemEntity extends Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
