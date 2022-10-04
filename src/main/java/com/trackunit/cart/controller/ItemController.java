package com.trackunit.cart.controller;

import com.trackunit.cart.api.ItemApi;
import com.trackunit.cart.data.CartRepository;
import com.trackunit.cart.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController implements ItemApi {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartRepository cartRepository;

    public ResponseEntity removeItem(Integer itemId) {
        return itemRepository.findById(itemId)
                .map(item -> {
                    itemRepository.save(item.active(false));
                    return new ResponseEntity(HttpStatus.OK);
                })
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
