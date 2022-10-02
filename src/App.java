package src;

import src.data.Cart;
import src.data.Item;
import src.store.CsvBasedItemStore;
import src.store.ItemStore;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ItemStore store = new CsvBasedItemStore();
        Cart cart = new Cart(store);

        // Add some items
        Item item1 = cart.addItem(10, "item1");
        Item item2 = cart.addItem(20, "item2");

        // List items
        List<Item> items = cart.listItems();

        // Remove non-existant item
        int numRemoved = cart.removeItem(999);

        // Remove item
        // numRemoved = cart.removeItem(item1.getId());

        // Re-check items
        items = cart.listItems();
    }
}
