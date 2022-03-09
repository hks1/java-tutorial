package com.tutorial.collections.collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapExample1 {
    public static void main(String[] args) {
        Map<String, Customer> map = new HashMap<>();

        Customer customer = new Customer("123", "John Afternoon");
        Customer customer1 = new Customer("456", "Kane Siverstone");

        map.put(customer.getCustomerId(), customer);
        map.put(customer1.customerId, customer1);

        Order order = new Order("123");

        Customer customerForOrder = map.get(order.getCustomerId());

        System.out.println(customerForOrder);
    }
}

