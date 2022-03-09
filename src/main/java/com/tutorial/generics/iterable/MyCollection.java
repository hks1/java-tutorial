package com.tutorial.generics.iterable;

import java.util.Iterator;

public class MyCollection<E> implements Iterable<E>{

    public Iterator<E> iterator(){
        return new MyIterator<E>();
    }
}

class MyClass<T> extends MyCollection{
    Class myClass = null;

    public T createInstance()
        throws IllegalAccessException, InstantiationException{
        return (T) this.myClass.newInstance();
    }
}

class Main{
    public static void main(String[] args) {
        MyCollection<String> stringMyCollection = new MyClass<String>();


        for (String string :
                stringMyCollection) {
            System.out.println(string);
        }
    }
}

class MyIterator<T> implements Iterator<T>{

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
