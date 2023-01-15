# Adapter Design Pattern
<!-- https://www.digitalocean.com/community/tutorials/adapter-design-pattern-java -->


- __structural design pattern__
- used so that two unrelated interfaces can work together
- object that joins these unrelated interface is called and __Adapter__

## Two Way Adapter Pattern
While implementing adapter pattern, there are two approaches - class adapter and object adapter - however both these approaches produce same result.
1. __Class Adaper__ - uses [Java Inheritence](https://www.digitalocean.com/community/tutorials/inheritance-java-example) and extends the source interface.
2. __Object Adapter__ - used [Java Composition](https://www.digitalocean.com/community/tutorials/composition-in-java-example) and adapter contains the source object.

## Example

Mobile battery needs 3 volts to charge but the normal socket produces either 120V or 240V. So the __mobile charger__ works as an adapter between mobile charging socket and the wall socket.

Implement multi-adapter using adapter design pattern.

1. `Volt` (to measure volts)

```java
package com.hks.design.patterns.adapter;

public class Volt {
    private int volts;

    public Volt(int v){
        this.volts = v;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}

```

2. `Socket` (producing constant volts of 120V)

```java
package com.hks.design.patterns.adapter;

public class Socket {
    public Volt getVolts(){
        return new Volt(120);
    }
}

```

3. interface for the adapter that can produce 3 volts, 12 volts, and default 120 volts.

```java
package com.hks.design.patterns.adapter;

public interface SocketAdapter {
    public Volt get120Volt();
    public Volt get12Volt();
    public Volt get3Volt();
}

```

### Adapter Design Pattern - Class Adapter

```java
package com.hks.design.patterns.adapter;

// Using inheritance for adapter pattern
public class SocketClassAdapterImpl extends Socket implements SocketAdapter{
    @Override
    public Volt get120Volt() {
        return getVolts();
    }

    @Override
    public Volt get12Volt() {
        Volt v = getVolts();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = getVolts();
        return convertVolt(v, 40);
    }
    public Volt convertVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}

```

### Adapter Design Pattern - Object Adapter Implementation

```java
package com.hks.design.patterns.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter{
    //Using composition for Adapter Pattern
    private Socket socket ;
    public SocketObjectAdapterImpl(){
        socket = new Socket();
    }
    public SocketObjectAdapterImpl(Socket s){
        this.socket = s;
    }
    @Override
    public Volt get120Volt() {
        return socket.getVolts();
    }

    @Override
    public Volt get12Volt() {
        Volt v = socket.getVolts();
        return convertVolt(v, 10);
    }

    @Override
    public Volt get3Volt() {
        Volt v = socket.getVolts();
        return convertVolt(v, 40);
    }

    public Volt convertVolt(Volt v, int i){
        return new Volt(v.getVolts()/i);
    }
}

```

- test

```java
package com.hks.design.patterns.adapter;

public class AdapterPatternTest {
    public static void main(String[] args) {
        testClassAdapter();
        testObjectAdapter();

    }

    private static void testClassAdapter(){
        SocketAdapter socketAdapter = new SocketClassAdapterImpl();
        Volt v3 = getVolt(socketAdapter, 3);
        Volt v12 = getVolt(socketAdapter, 12);
        Volt v120 = getVolt(socketAdapter, 120);
        System.out.println("v3 volts using class adapter="+v3.getVolts());
        System.out.println("v12 volts using class adapter="+v12.getVolts());
        System.out.println("v120 volts using class adapter="+v120.getVolts());

    }
    private static void testObjectAdapter(){
        SocketAdapter socketAdapter = new SocketObjectAdapterImpl();
        Volt v3 = getVolt(socketAdapter, 3);
        Volt v12 = getVolt(socketAdapter, 12);
        Volt v120 = getVolt(socketAdapter, 120);
        System.out.println("v3 volts using object adapter="+v3.getVolts());
        System.out.println("v12 volts using object adapter="+v12.getVolts());
        System.out.println("v120 volts using object adapter="+v120.getVolts());
    }

    private static Volt getVolt(SocketAdapter socketAdapter, int i){
        switch (i){
            case 3: return socketAdapter.get3Volt();
            case 12: return socketAdapter.get12Volt();
            case 120: return socketAdapter.get120Volt();
            default: return socketAdapter.get120Volt();
        }
    }
}

```

## Class Diagram

