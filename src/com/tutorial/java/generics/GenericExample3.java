package com.tutorial.java.generics;

import com.tutorial.Example6;

public class GenericExample3 {
    // Java Generics - Class Objects as Type Literals

    public static <T> T read(Class<T> theClass, String sql)
            throws IllegalAccessException, InstantiationException {

        //execute SQL.

        T o = theClass.newInstance();
        //set properties via reflection.

        return o;
    }

    public static void main(String[] args) {
        try{
            Driver employee   = read(Driver.class, "select * from drivers where id=1");
        } catch (Exception e){
            e.printStackTrace();
        }

        try{
            Example6.Vehicle vehicle   = read(Example6.Vehicle.class, "select * from vehicles where id=1");
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}

class Driver{

}
