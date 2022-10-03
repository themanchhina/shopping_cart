package src.store;

import src.data.Item;

import java.util.List;

public interface ItemStore {
    Item addItem(int price, String content);
    int removeItem(int id);
    List<Item> listItems();
}
