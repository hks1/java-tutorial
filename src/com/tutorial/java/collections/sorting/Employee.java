package com.tutorial.java.collections.sorting;

import java.util.Objects;

public class Employee {
    protected long   employeeId;
    protected String firstName;
    protected String lastName;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, long employeeId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
