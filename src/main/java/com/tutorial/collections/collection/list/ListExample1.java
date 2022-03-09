package com.tutorial.collections.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample1 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("object 1");
        list.add("Object 2");
        list.add("Object 3");
        System.out.println(list.get(1));

        list.remove("object 3");
        list.remove(0);

        list.add("object 4");
        System.out.println(list.get(0));

        Object o = list.get(0); // returns Object

        String str = (String) list.get(0);

        int size = list.size();

        System.out.println(size);

        // iterate a list
        System.out.println("iterate a list:::");

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            //System.out.println(iterator.next());
        }

        for (Object next :
                list) {
            System.out.println(next);
        }

        for (int i = 0; i < list.size(); i++){
            Object next = list.get(i);
        }

        // clear()
        System.out.println("clear():::");
        list.clear();

        list.add(new Integer(3)); // works because list is not typed.

        List<String> stringList = new ArrayList<>();

        //stringList.add(new Integer(3)); // doesn't work if List is typed
        stringList.add("Object 1");
        stringList.add("Object 2");
        stringList.add("Object 3");

        Iterator<String> iterator1 = stringList.iterator();

        while(iterator1.hasNext()){
            String next = iterator1.next();
        }

        for (String next :
                stringList) {
            System.out.println(next);
        }


    }
}
