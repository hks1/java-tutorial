package com.tutorial.collections.comparator;

import com.tutorial.collections.comparable.Rectangle;

import java.util.Comparator;

public class RectangleComparator implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle o1, Rectangle o2) {
        /*if(o1.length == o2.length && o1.width == o2.width) return 0;
        return o1.length*o1.width - o2.length*o2.width;*/
        return o1.compareTo(o2); //we can use this because compareTo() is defined in Rectangle class
    }
}
