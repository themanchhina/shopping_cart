package src.data;

import src.store.ItemStore;

import java.util.List;

public class Cart {
    ItemStore itemStore;

    public Cart(ItemStore itemStore) {
        this.itemStore = itemStore;
    }

    public List<Item> listItems() {
        return null;
    }

    public Item addItem(int price, String content) {
        return null;
    }

    public int removeItem(int id) {
        return 0;
    }
}
