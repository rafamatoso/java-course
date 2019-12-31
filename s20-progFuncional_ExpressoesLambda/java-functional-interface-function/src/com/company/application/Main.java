package com.company.application;

import com.company.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        // O método .map só pode ser usado em estruturas do tipo stream
        // Como a interface funcional Function exige um tipo de retorno, neste exemplo usaremos uma String como tipo de retorno.
        // Dessa forma, será usado o método .collect(Collectors.toList()) para tratar a conversão da stream para String.

        List<String> names = list.stream().map(p-> p.getName().toUpperCase()).collect(Collectors.toList());

        names.forEach(System.out::println);
    }
}
