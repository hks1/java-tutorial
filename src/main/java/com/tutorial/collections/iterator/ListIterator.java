package com.tutorial.collections.iterator;

// Implement the iterator interface in your own class

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator <T> implements Iterator<T> {

    private List<T> source = null;
    private int index = 0;

    public ListIterator(List<T> source){
        this.source = source;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.source.size();
    }

    @Override
    public T next() {
        return this.source.get(this.index++);
    }
}

class ListIteratorExample{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        ListIterator<String> iterator = new ListIterator<>(list);
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
