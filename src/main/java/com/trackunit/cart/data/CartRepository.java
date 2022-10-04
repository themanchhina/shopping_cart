package com.trackunit.cart.data;

import java.util.List;
import com.trackunit.cart.model.Item;

public interface CartRepository {
    int createCart();
    List<Item> listItems(int dartId);
    int addItem(int cartId);
    Item updateItem(int itemId);
}
