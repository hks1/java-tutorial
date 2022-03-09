package com.tutorial.lambda;

// Constructor References

// it is possible to reference a constructor of a class.
// You do that by writing the class name followed by ::new, like this:
// MyClass::new

interface Factory{
    public String create(char[] val);
}

// The create() method of this interface matches the signature of one of the constructors in the String class.
// Therefore this constructor can be used as a lambda.

public class MethodReferenceEx4 {

    public static void main(String[] args) {
        Factory factory = String::new;

        // This is equivalent to this java lambda expression:
        Factory factory1 = chars -> new String(chars);
    }
}
