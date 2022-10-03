package src.data;

public class Item {
    private int id;
    private int price;
    private String content;

    public Item(int id, int price, String content) {
        this.id = id;
        this.price = price;
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public String getContent() {
        return this.content;
    }
}
