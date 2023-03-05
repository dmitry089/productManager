package ru.netology.productManager;

public class Smartphone extends Product {
    private String performance;


    public Smartphone(int id, String name, int price, String performance) {
        super(id, name, price);
        this.performance = performance;

    }
}
