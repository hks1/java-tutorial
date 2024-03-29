<!-- https://www.educative.io/answers/what-is-the-supplier-functional-interface-in-java -->

> `Supplier` is a functional interface that produces output without accepting any input

> The interface contains one method `get()`

https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html

**Syntax:**

T get()

```java
import java.util.Random;
import java.util.function.*;

public class Main{
    public static void main(String[] args) {
        // Supplier interface implementation that generates random integer value
        Supplier<Integer> randomSupplier = () -> new Random().nextInt();
        int count = 5;

        // Calling get method to get the random value
        while(count-- > 0) System.out.println(randomSupplier.get());

    }
}
```

```java
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

```