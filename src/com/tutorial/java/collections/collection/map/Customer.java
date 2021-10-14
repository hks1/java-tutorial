package com.tutorial.java.collections.collection.map;

class Customer {
    String customerId;
    String customerName;

    Customer(String id, String name) {
        this.customerId = id;
        this.customerName = name;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public String toString() {
        return "{ " + customerId + " : " + customerName + " } ";
    }
}
