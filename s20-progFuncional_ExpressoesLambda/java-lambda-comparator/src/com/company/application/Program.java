package com.company.application;

import com.company.entities.Products;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Products> list = new ArrayList<>();

        list.add(new Products("TV", 900.00));
        list.add(new Products("Notebook", 1200.00));
        list.add(new Products("Tablet", 450.00));

        // Comparator<Products> comparator = (o1, o2) -> o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
        Comparator<Products> comparator = Comparator.comparing(o -> o.getName().toUpperCase());

        list.sort(comparator);

        for (Products p : list) {
            System.out.println(p);
        }
    }
}
