# Prototype Pattern

<!-- https://www.educative.io/courses/software-design-patterns-best-practices/prototype-pattern -->

```java
package com.hks.design.patterns.prototype;

public interface IAircraftPrototype {
    void fly();
    IAircraftPrototype clone();
    void setEngine(F16Engine f16Engine);
}

```

```java
package com.hks.design.patterns.prototype;

public class F16 implements IAircraftPrototype{
    // default engine
    F16Engine engine = new F16Engine();

    @Override
    public void fly() {
        System.out.println("F-16 flying...");
    }

    @Override
    public IAircraftPrototype clone() {
        // deep clone self and return the product
        return new F16();
    }

    @Override
    public void setEngine(F16Engine engine) {
        this.engine = engine;
    }
}

```

```java
package com.hks.design.patterns.prototype;

public class Client {
    public static void main(String[] args) {
        IAircraftPrototype prototype = new F16();

        // create F16-A
        IAircraftPrototype f16A = prototype.clone();
        f16A.setEngine(new F16AEngine());

        // create F16-B
        IAircraftPrototype f16B = prototype.clone();
        f16B.setEngine(new F16BEngine());
    }

}

class F16AEngine extends F16Engine {
    
}

class F16BEngine extends F16Engine {

}

```

Note that the interface `IAircraftPrototype` clone method returns an abstract type. 
The client doesn't know the concrete subclasses. 
The `Boeing747` class can just as well implement the same interface and be on its way to produce copies of prototypes. 
The client if passed in the prototype as `IAircraftPrototype` wouldn't know whether the clone's concrete subclass is an F16 or a Boeing747.

The prototype pattern helps eliminate subclassing as the behavior of prototype objects can be varied by composing them with subparts.

## Shallow vs Deep Copy
The prototype pattern requires that the prototype class or interface implements the `clone()` method.

In a deep copy, the cloned object would get a copy of its own engine object as well as any of the nested objects within it. 
There will be no sharing of any fields, nested or otherwise between the prototype and the clone.

## Dynamic Loading
The prototype pattern also helps with dynamic loading of classes. 
Language frameworks which allow dynamic loading will create an instance of the loaded class and register it in a managing entity. 
The application can at runtime request the object of the loaded class from the manager. 
Note, the application can't access the class's constructor statically.

## notes
In Java the root Object class exposes a `clone` method. 
The class implements the interface `java.lang.Cloneable`.

**Caveats:** Implementing the `clone` method can be challenging because of circular references.


////////// TODO
