# Constructors
<!-- https://howtodoinjava.com/java/oops/java-constructors/ -->


**Default and Parameterized Constructors**

[Object Initialization](https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html)

> Java memory model
- instances are created inside the heap

- if you want to use super(), i.e. parent class constructor, then it must be the first statement inside the constructor. 

## Constructor chaining with _this()_ and _super()_
### calling same class's constructors with _this()_
```java
public class Employee{
    public Employee(){
    }
    public Employee(String firstName){
        this(); // calling default constructor
    }
    public Employee(String firstName, String lastName){
        this(firstName); // calling constructor with single argument of String type
    }
}
```
### calling parent class's constructors with _super()_
```java
public class Parent{
    public Parent(){
        //...
    }
}
public class Child extends Parent{
    public Child(){
        super(); // invokes Parent's constructor
    }
}
```

### private constructor
- used in `Singleton Pattern`

A common singleton class definition looks like this:

```java
import java.io.Serializable;

public class DemoSingleton implements Serializable{
    private static final long serialVersionUID = 1L;
    private DemoSingleton(){
        // private constructor
    }
    private static class DemoSingletonHolder{
        public static final DemoSingleton INSTANCE = new DemoSingleton();
    }
    public static DemoSingleton getInstance(){
        return DemoSingletonHolder.INSTANCE;
    }
    protected Object readResolve(){
        return getInstance();
    }
}
```


<!--
[Java Memory Model - Structure and Components](https://howtodoinjava.com/java/garbage-collection/java-memory-model/)
-->

<!-- 
[Singleton Pattern](https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/) 
-->
