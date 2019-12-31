package com.course.application;

import com.course.entities.Client;
import com.course.entities.Order;
import com.course.entities.OrderItem;
import com.course.entities.Product;
import com.course.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.printf("\nEnter a Client Data: \nName: ");

        String clientName = sc.nextLine();
        System.out.printf("Email: ");
        String clientEmail = sc.next();
        System.out.printf("Birth Day (DD/MM/YYYY): ");
        Date clientBirthday = sdf.parse(sc.next());

        System.out.printf("\nEnter Order Data: \nStatus: ");
        String orderStatus = sc.next();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus),
                             new Client(clientName, clientEmail, clientBirthday));

        System.out.printf("How many items to this Order: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("\nEnter %d Item Data: ",(i+1));
            System.out.printf("\nProduct Name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.printf("Product Price: $ ");
            Double productPrice = sc.nextDouble();
            System.out.printf("Quantify: ");
            int productQty = sc.nextInt();
            order.addItem(new OrderItem(productQty,productPrice, new Product(productName, productPrice)));
        }

        System.out.println("\nORDER SUMMARY:\n"+order);
        sc.close();
    }
}
