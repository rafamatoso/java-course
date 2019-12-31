package com.company.application;

import com.company.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // remover qualquer elemento da lista que tenha preço maior que 100.00

        list.removeIf(p -> p.getPrice() >= 100.00);

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
