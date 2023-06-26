package com.tutorial.immutable;

import java.util.ArrayList;
import java.util.List;

public class Immutable {
    public void testImmutableObjects(){

    }
    public static void main(String[] args) {
        /*String name = "Immutable";
        name = "mutable";*/

        final String name = "Immutable";
        //name = "mutable"; // compiler error

        final List<String> strings = new ArrayList<>();

        ImmutableClass obj = new ImmutableClass();
        obj.anInt = 1;
        obj.string = "str1";
        System.out.println(obj);
        obj.string = "str2";
        System.out.println(obj);

        // final with class means that it can't be inherited

    }
}

final class ImmutableClass {  // can change the variables
    String string;
    int anInt;

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "strVar='" + string + '\'' +
                ", anInt=" + anInt +
                '}';
    }
}

class ImmutableClassWithFinalAttributes{
    final String string;
    final int anInt;
    Currency currency;

    public ImmutableClassWithFinalAttributes(String string, int anInt){
        this.string = string;
        this.anInt = anInt;
    }
    // only getters and no setters to comply with immutability requirement
}

class Currency{
    String description;
    String country;
    int code;
}
