package com.tutorial.lambda;


// Instance Method References
interface Deserializer{
    public int deserialize(String v1);
}

class StringConverter{
    public int convertToInt(String v1){
        return Integer.valueOf(v1);
    }
}
public class MethodReferencesEx3 {
    public static void main(String[] args) {
        // The convertToInt() method has the same signature as the deserialize() method of the Deserializer.
        // Because of that, we can create an instance of StringConverter and
        // reference its convertToInt() method from a Java lambda expression, like this:
        StringConverter stringConverter = new StringConverter();
        Deserializer deserializer = stringConverter::convertToInt;
        int val = deserializer.deserialize("51");
        System.out.println(val);
    }
}
