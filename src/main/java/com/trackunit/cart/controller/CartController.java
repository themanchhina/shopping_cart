package com.trackunit.cart.controller;

import com.trackunit.cart.api.CartApi;
import com.trackunit.cart.data.CartRepository;
import com.trackunit.cart.data.ItemRepository;
import com.trackunit.cart.model.Cart;
import com.trackunit.cart.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class CartController implements CartApi {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public ResponseEntity<Integer> createCart() {
        Cart cart = cartRepository.save(new Cart());
        return new ResponseEntity(cart.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity addItem(Integer cartId, Item item) {
        return cartRepository.findById(cartId)
                .map(cart -> {cart.addItemsItem(item); return new ResponseEntity(cart, HttpStatus.OK);})
                .orElseThrow(IllegalArgumentException::new);
    }
}
