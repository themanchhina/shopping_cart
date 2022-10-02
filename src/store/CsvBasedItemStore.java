package src.store;

import src.data.Item;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class CsvBasedItemStore implements ItemStore {
    private File file;

    public CsvBasedItemStore(String path) {
        // Need to close resources
        this.file = new File(path);
    }

    @Override
    public Item addItem(int price, String content) {
        return null;
    }

    @Override
    public int removeItem(int id) {
        return 0;
    }

    @Override
    public List<Item> listItems() {
        return Collections.emptyList();
    }
}
