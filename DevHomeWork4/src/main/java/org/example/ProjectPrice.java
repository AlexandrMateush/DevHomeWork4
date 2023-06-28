package org.example;

public class ProjectPrice {
    private String id;
    private int price;

    public ProjectPrice(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
