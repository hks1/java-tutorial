package com.tutorial.java.collections.collection.queue;

import java.util.Objects;

public class Customer implements Comparable<Customer>{
    String name;
    String firstName;
    String lastName;

    Customer(String name){
        this.name = name;
    }

    Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = firstName + " " + lastName;
    }

    public String getName() {
        return name;
    }

    /*@Override
    public int compareTo(Object o) {
        Customer customer = (Customer) o;
        return this.name.compareTo(customer.getName());
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getName(), customer.getName());
    }

    //Here are two rules that are good to know about implementing the hashCode() method in your own classes,
    // if the hashtables in the Java Collections API are to work correctly:
    //
    //If object1 and object2 are equal according to their equals() method, they must also have the same hash code.
    //If object1 and object2 have the same hash code, they do NOT have to be equal too.

    //In shorter words:
    //
    //If equal, then same hash codes too.
    //Same hash codes no guarantee of being equal.
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public int compareTo(Customer o) {
        return this.name.compareTo(o.name);
    }

    // Sample hashCode() implementations
    /*public class Employee {
        protected long   employeeId;
        protected String firstName;
        protected String lastName;

        public int hashCode(){
            return (int) employeeId;
        }
    }*/
    /*public class Employee {
        protected long   employeeId;
        protected String firstName;
        protected String lastName;

        public int hashCode(){
            return (int) employeeId *
                    firstName.hashCode() *
                    lastName.hashCode();
        }
    }*/
}
