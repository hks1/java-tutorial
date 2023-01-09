package com.tutorial.reflection;

import java.lang.reflect.Method;

public class DumpMethods {
    public static void main(String[] args) {
        try{
            Class c = Class.forName(args[0]);
            Method[] m = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e){
            System.err.println(e);
        }
    }
}

/*
/c/users/hshukla/.jdks/corretto-15.0.2/bin/java -classpath ./target/classes/ --enable-preview com.tutorial.reflection.DumpMethods java.util.Stack
public boolean java.util.Stack.empty()
public synchronized java.lang.Object java.util.Stack.peek()
public synchronized int java.util.Stack.search(java.lang.Object)
public java.lang.Object java.util.Stack.push(java.lang.Object)
public synchronized java.lang.Object java.util.Stack.pop()

 */
