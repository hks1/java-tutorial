package com.tutorial.collections.collection;

import java.util.*;

public class MyCollectionUtil {
    public static void print(Collection collection){
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object.toString());
        }
    }

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("one");
        collection.add("two");
        print(collection);
        System.out.println("===============");
        MyCollectionUtil.print(collection);
        Set set = new HashSet();
        set.add("three");
        set.add("four");
        System.out.println("================");
        MyCollectionUtil.print(set);
        Collection collection1 = new HashSet();
        collection1.add("five");
        collection1.add("six");
        System.out.println("==========");
        MyCollectionUtil.print(collection1);

        String element = "an element";
        Collection collection2 = new HashSet();

        boolean didCollectionChange = collection2.add(element);
        System.out.println("==========add()=========");
        System.out.println(didCollectionChange);

        didCollectionChange = collection2.add(element);
        System.out.println(didCollectionChange);

        Collection collection3 = new ArrayList();

        didCollectionChange = collection3.add(element);
        System.out.println(didCollectionChange);
        System.out.println("==========remove()=============");

        boolean wasElementRemoved = collection2.remove(element);
        System.out.println(wasElementRemoved);

        wasElementRemoved = collection2.remove(element);
        System.out.println(wasElementRemoved);

        wasElementRemoved = collection3.remove(element);
        System.out.println(wasElementRemoved);
    }
}
