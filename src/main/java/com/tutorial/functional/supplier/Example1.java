package com.tutorial.functional.supplier;

import com.tutorial.def.Example6;
import org.jsoup.Jsoup;
import org.w3c.dom.ls.LSOutput;

import java.util.function.Supplier;

public class Example1 {

    public static void main(String[] args) {
        Supplier<Employee> getEmployee = () -> new Employee(1, "John Dow", "HR");
        System.out.println(getEmployee.get());
    }


}

class Employee{
    int id;
    String name;
    String dept;
    Employee(int id, String name, String dept){
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
