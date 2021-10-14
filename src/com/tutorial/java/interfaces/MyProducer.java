package com.tutorial.java.interfaces;

import com.tutorial.Example6;

public interface MyProducer {

    // Since the return value of produce() is Object, it can return any Java Object.
    public Object produce();
}

class CarProducer implements MyProducer{

    @Override
    public Object produce() {
        return new Example6.Car();
    }

    public static void main(String[] args) {
        MyProducer carProducer = new CarProducer();
        // the object returned from the carProducer.produce() method call has to be cast to a Car instance,
        // because the produce() method return type is Object.
        Example6.Car car = (Example6.Car) carProducer.produce();

        // Using Java Generics you can type the MyProducer interface so you can specify what type of object it produces when you use it.

    }
}

// Using Java Generics you can type the MyProducer interface
    // so you can specify what type of object it produces when you use it.
// Here is a generic version of MyProducer interface
interface MyProducerGeneric<T>{
    public T produce();
}

// While implementing the MyProducerGeneric interface in the CarProducer(Generic) class,
    // include the generic type declaration too.
class CarProducerGeneric<T> implements MyProducerGeneric{

    @Override
    public T produce() {
        return (T) new Example6.Car();
    }

    public static void main(String[] args) {
        // when creating a CarProducer(Generic),
            // specify its generic interface type
        MyProducerGeneric<Example6.Car> myCarProducer = new CarProducerGeneric<Example6.Car>();
        Example6.Car produce = myCarProducer.produce();
        // Since generic type for the myCarProducer instance is set to Car,
            // it is no longer necessary to cast the object returned from the produce() method,
            // since the original method declaration in the MyProducer interface states,
            // that this method returns the same type as is specified in the generic type when used.


        // But - now it is actually possible to specify another generic type for a CarProducer instance
            // than the type it actually returns from it's produce() method implementation.
        // So, the following declaration is possible, but would return in a ClassCastException when executed:
        MyProducerGeneric<String> stringMyProducerGeneric = new CarProducerGeneric<String>();
        String produce1 = stringMyProducerGeneric.produce();

        // Instead, you can lock down the generic type of the MyProducer interface already when you implement it,
            // in the CarProducer class.

        // Here is an example of specifying the generic type of a generic interface when implementing it:
        // Implemented in CarProducer1 class below
        /*public class CarProducer implements MyProducer<Car>{

            @Override
            public Car produce() {
                return new Car();
            }
        }*/
    }
}

class CarProducer1 implements MyProducerGeneric<Example6.Car>{

    @Override
    public Example6.Car produce() {
        return new Example6.Car();
    }

    // Now you cannot specify the generic type of the CarProducer when using it.
        // It is already typed to Car.

    public static void main(String[] args) {
        // Here is how using the CarProducer1 looks:
        MyProducerGeneric<Example6.Car> myCarProducer = new CarProducer1();
        Example6.Car produce = myCarProducer.produce();
    }
}
