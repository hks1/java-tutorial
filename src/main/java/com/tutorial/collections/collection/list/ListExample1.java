package com.tutorial.collections.collection.list;

import java.util.*;

public class ListExample1 {
    public static void main(String[] args) {
        List list = new ArrayList(Arrays.asList("Object 1", "Object 2", "Object 3"));

        list.remove("object 3");
        list.remove(0);

        list.add("object 4");
        System.out.println(list.get(0));

        Object o = list.get(0); // returns Object

        String str = (String) list.get(0);


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

        // clear()
        System.out.println("clear():::");
        list.clear();

        list.add(new Integer(3)); // works because list is not typed.

        List<String> stringList = new ArrayList<>();

        //stringList.add(new Integer(3)); // doesn't work if List is typed
        stringList.addAll(Arrays.asList("Object 1", "Object 2", "Object 3"));

        Iterator<String> iterator1 = stringList.iterator();

        while(iterator1.hasNext()){
            String next = iterator1.next();
        }

        // Adding elements of sub types of the declared types
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Integer(123));
        numbers.add(new Float(3.1415));
        numbers.add(new Double(299.988));
        numbers.add(new Long(67000));

        System.out.println(numbers);
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        numbers.addAll(1,integers);
        Collections.sort(integers, Collections.reverseOrder());
        System.out.println("reversed: " + integers);
        Collections.sort(integers, Comparator.reverseOrder());
        System.out.println("reversed: " + integers);
        System.out.println("numbers : " + numbers);

        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);

        //Collections.sort(numbers);
        // https://stackoverflow.com/questions/52042899/no-instance-of-type-variables-t-exist-so-that-id-conforms-to-comparable-supe



    }
}
