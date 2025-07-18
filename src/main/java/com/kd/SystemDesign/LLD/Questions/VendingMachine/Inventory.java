package com.kd.SystemDesign.LLD.Questions.VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(String code, Product product) {
        products.put(code, product);
    }

    public Product getProduct(String code) {
        return products.get(code);
    }

    public boolean containsProduct(String code) {
        return products.containsKey(code);
    }
}
