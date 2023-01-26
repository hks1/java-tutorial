# Builder

Creational design pattern

Introduced to solve some of the problems with Factory and Abstract Factory design patterns where the Object contains a lot of attributes.

Three major issues with Factory and Abstract Factory design patterns when the Object contains a lot of attributes.
1. Too many arguments to pass from client program to the Factory class.
2. Some of the parameters might be optional but in Factory pattern we are forced to send all the parameters and optional parameters need to send as NULL.
3. If the object is heavy and it's creation is complex, then all that complexity will be part of the Factory classes.

<!--
We can solve the issues with large number of parameters by providing a constructor with required parameters and then different setter methods to set the optional parameters. The problem with this approach is that the Object state will be inconsistent until unless all the attributes are set explicitly. Builder pattern solves the issue with large number of optional parameters and inconsistent state by providing a way to build the object step-by-step and provide a method that will actually return the final Object.
-->

## steps
1. create [static nested class](https://www.digitalocean.com/community/tutorials/java-inner-class), copy all the arguments from the outer class to the Builder class.
2. Java Builder class should have a public constructor with all the required attributes as parameters
3. Java Builder class should have methods to set the optional parameters and it should return the same Builder object after setting the optional attribute.
4. Provide a `build()` method in the builder class that will return the Object needed by the client program. For this we need to have a private constructor in the Class with Builder class as argument.

## Example
Computer class and ComputerBuild class to build it.

```java
package com.hks.design.patterns.builder;

public class Computer {

    // required parameters
    private String HDD;
    private String RAM;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    private Computer(ComputerBuilder builder){
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Builder Class
    public static class ComputerBuilder{
        // required parameters
        private String HDD;
        private String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram){
            this.HDD = hdd;
            this.RAM = ram;
        }
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled){
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled){
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}

```
Note: Computer class has only getter methods and no public constructor. So the only way to get a Computer object is through the ComputerBuilder class.

Test

```java
package com.hks.design.patterns.builder;

public class TestBuilderPattern {
    public static void main(String[] args) {
        // Using builder to get the object,
        // without any inconsistent state or arguments management issues
        Computer computer = new Computer.ComputerBuilder("500 GB", "2 GB")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(true)
                .build();
    }
}

```

Some of the builder pattern examples in Java classes are:
- java.lang.StringBuilder#append() (unsyncronized)
- java.lang.StringBuffer#append() (syncronized)
