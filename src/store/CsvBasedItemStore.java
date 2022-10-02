package src.store;

import src.data.Item;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.APPEND;

public class CsvBasedItemStore implements ItemStore {
    private File file;
    private AtomicInteger runningId;

    private static String SEPARATOR = ",";

    public CsvBasedItemStore(String path) {
        this.file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int maxIndex = 0;
            while ((line = reader.readLine()) != null) {
                Item item = readItem(line);
                maxIndex = Math.max(maxIndex, item.getId());
            }
            this.runningId = new AtomicInteger(maxIndex);
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize CSV based store");
        }
    }

    @Override
    public Item addItem(int price, String content) {
        Item item = new Item(getId(), price, content);
        try {
            Files.writeString(file.toPath(), toCsv(item, true), APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Failed to add item");
        }
        return item;
    }

    @Override
    public int removeItem(int id) {
        Item toRemove = null;
        boolean isActive = false;
        int removed = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = reader.readLine()) != null) {
                Item item = readItem(line);
                if (item.getId() == id) {
                    toRemove = item;
                    isActive = isActive(line);
                    break;
                }
            }

            if (isActive) {
                Files.writeString(file.toPath(), toCsv(toRemove, false), APPEND);
                removed++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to remove item");
        }
        return removed;
    }

    @Override
    public List<Item> listItems() {
        return new ArrayList();
    }

    private int getId() {
        return runningId.incrementAndGet();
    }

    private String toCsv(Item item, boolean active) {
        StringBuilder b = new StringBuilder();
        b.append(item.getId());
        b.append(SEPARATOR);
        b.append(item.getPrice());
        b.append(SEPARATOR);
        b.append(item.getContent());
        b.append(SEPARATOR);
        b.append(active);
        b.append("\n");
        return b.toString();
    }

    private Item readItem(String row) {
        String[] cells = row.split(SEPARATOR);
        return new Item(
                Integer.parseInt(cells[0]),
                Integer.parseInt(cells[1]),
                escape(cells[2])
        );
    }

    private boolean isActive(String row) {
        return Boolean.parseBoolean(row.split(SEPARATOR)[3]);
    }

    private String escape(String unescaped) {
        return unescaped.replaceAll(SEPARATOR, String.format("\\%s", SEPARATOR));
    }

    private String unescape(String escaped) {
        return escaped.replaceAll(String.format("\\%s", SEPARATOR), SEPARATOR);
    }
}
