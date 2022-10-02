package src.store;

import src.data.Item;

public interface ItemStore {
    Item addItem(int price, String content);
    int removeItem(int id);
}
