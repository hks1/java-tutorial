package com.tutorial.java.generics;

public class GenericExample2 {
    public static <T> T getInstance(Class<T> theClass)
        throws IllegalAccessException, InstantiationException{
        return theClass.newInstance();
    }

    public static void main(String[] args) {
        try{
            String str = getInstance(String.class);
            System.out.println(str.getClass().getName());
            DemoClass demoClass = getInstance(DemoClass.class);
            System.out.println(demoClass);
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}

class DemoClass{
    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DemoClass{" +
                "value='" + value + '\'' +
                '}';
    }
}
