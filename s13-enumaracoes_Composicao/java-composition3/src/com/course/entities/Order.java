package com.course.entities;

import com.course.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private OrderStatus status;

    private Client client;

    List<OrderItem> items = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    /*public void removeItem(OrderItem orderItem) {
        items.remove(orderItem);
    } Will be implemented in the future*/

    public double total() {
        double sum = 0;
        for (OrderItem o : items
             ) {
            sum += o.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment: ");
        sb.append(sdf1.format(moment) + "\n");
        sb.append("Order Status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order Items:\n");
        for (OrderItem item : items) {
            sb.append(item + "\n");
        }
        sb.append("Total Price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
