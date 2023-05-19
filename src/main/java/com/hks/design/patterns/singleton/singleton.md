# Singleton Design Pattern

- creational
- one instance per JVM

## singleton with eager initialization
```java
public class EagerSingleton{
    private static volatile EagerSingleton instance = new EagerSingleton();
    
    // private constructor
    private EagerSingleton(){
        
    }
    public static EagerSingleton getInstance(){
        return instance;
    }
}
```

> instance is created irrespective of it is required at runtime or not

## singleton with lazy initialization
- delaying the creation of object until the first time it's needed
```java
public final class LazySingleton{
    private static volatile LazySingleton instance = null;
    // private constructor
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                instance = new LazySingleton();
            }
        }
        return instance;
    }
}
```

**drawback in above method:**
>Suppose there are two threads T1 and T2. Both come to create the instance and check if “instance==null”. Now both threads have identified instance variable as null thus they both assume they must create an instance. They sequentially go into a synchronized block and create the instances. In the end, we have two instances in our application.

this can be solved by `double-checked locking` 
> recheck the instance variable again in a synchronized block
```java
public class LazySingleton{
    private static volatile LazySingleton instance = null;
    // private constructor
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(instance == null){
            synchronized (LazySingleton.class){
                // Double check
                if (instance == null){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
```

> Please be sure to use “volatile” keyword with instance variable otherwise you can run into an out of order write error scenario, where reference of an instance is returned before actually the object is constructed i.e. JVM has only allocated the memory and constructor code is still not executed. In this case, your other thread, which refers to the uninitialized object may throw null pointer exception and can even crash the whole application.

## singleton with static block initialization
**class loading sequence**
> static blocks are executed during the loading of the class even before constructors are called.

```java
public class StaticBlockSingleton {
    private static final StaticBlockSingleton INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception: ", e);
        }
    }

    public static StaticBlockSingleton getINSTANCE() {
        return INSTANCE;
    }
    
    private StaticBlockSingleton(){
        // ...
    }
}
```

**Drawback**
>Suppose there are 5 static fields in a class and the application code needs to access only 2 or 3, for which instance creation is not required at all. So, if we use this static initialization, we will have one instance created though it is required or not.

- next section will overcome this problem

## singleton with bill pugh solution

- java memory model
- initialization-on-demand holder idiom 

<!-- https://en.wikipedia.org/wiki/Java_memory_model -->
<!-- https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom -->

> this also uses the static block idea but by implementing a static inner class

```java
public class BillPughSingleton{
    private BillPughSingleton(){}
    
    private static class LazyHolder{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }
}
```

**Note:** LazyHolder class will not be initialized until required and we can still use other static members of BillPughSingleton.

## singleton using Enum

- implicit support for thread safety
- only one instance is guaranteed

```java
public enum EnumSingleton {
    INSTANCE;
    public void someMethod(String param){
        // some class member
    }
}
```
## add readResolve() to Singleton objects
Let’s say your application is distributed and it frequently serializes objects into the file system, only to read them later when required. 

>Note: de-serialization always creates a new instance.
### example
singleton class:

```java
import java.io.Serializable;

public class DemoSingleton implements Serializable {
    private volatile static DemoSingleton instance = null;

    public static DemoSingleton getInstance() {
        if(instance == null){
            instance = new DemoSingleton();
        }
        return instance;
    }
    private int i = 10;
    public int getI(){
        return i;
    }
    public void setI(int i){
        this.i = i;
    }
}
```

serialize above class and de-serialize it after making some changes

```java
import java.io.*;

public class SerializationTest {
    static DemoSingleton instanceOne = DemoSingleton.getInstance();

    public static void main(String[] args) {
        try {
            // Serialize to a file
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instanceOne);
            out.close();

            instanceOne.setI(20);

            //
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
            in.close();

            System.out.println(instanceOne.getI());
            System.out.println(instanceTwo.getI());
        } catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
// output:
// 20
// 10
```

Here both variables have different values of the variable `i`. Clearly, there are two instances of our class.

> To solve this issue, we need to include a **`readResolve()`** method in the **DemoSingleton** class. This method will be invoked when we'll de-serialize the object. Inside this method, you must return the existing instance to ensure a single instance application wide.

```java
import java.io.Serializable;

public class DemoSingleton implements Serializable {
    public static volatile DemoSingleton instance = null;

    private DemoSingleton() {
    }

    public static DemoSingleton getInstance() {
        if (instance == null) {
            instance = new DemoSingleton();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    private int i = 10;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
```

> Now running SerializationTest will output
```
20
20
```

## add serialVersionUid to singleton objects
> this is required in cases where class structure changes between serialization and deserialization
- A changed class structure will cause the JVM to give an exception in the de-serializing process.
- This problem can be solved only by adding a unique serial version id to the class. It will prevent the compiler from throwing the exception by telling it that both classes are same, and will load the available instance variables only.

## template

```java
import java.io.Serializable;

public class DemoSingleton implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private DemoSingleton(){} // private constructor
    
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





<!-- https://howtodoinjava.com/design-patterns/creational/singleton-design-pattern-in-java/-->
