package com.tutorial.collections.iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableImpl implements Iterable<String>{

    private List<String> elements = new ArrayList<>();

    public void add(String element) { this.elements.add(element); } // not part of iterable interface

    @Override
    public Iterator<String> iterator() {
        return this.elements.iterator();
    }
}
