package com.tutorial.collections.collection;

import java.util.*;

public class CollectionExample1 {

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("alpha");
        set.add("beta");
        set.add("gama");

        Collection collection = new HashSet();
        //Collection collection = new ArrayList();
        collection.addAll(set);

        List list = new ArrayList();
        list.add("alpha1");
        list.add("beta1");
        list.add("gama1");

        System.out.println("================addAll()==========");
        collection.addAll(list);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("================removeAll()==========");
        collection.removeAll(list);
        iterator = collection.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("==============retainAll()================");
        Collection coll1 = new ArrayList();
        Collection coll2 = new ArrayList();

        coll1.add("A");
        coll1.add("B");
        coll1.add("C");

        coll2.add("1");
        coll2.add("2");
        coll2.add("3");

        Collection target = new HashSet();

        target.addAll(coll1);  // target now contains [A,B,C]
        target.addAll(coll2);  // target now contains [A,B,C,1,2,3]

        target.retainAll(coll2);  // target now contains [1,2,3]

        Iterator iterator1 = target.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("=======contains(), and containsAll()=========");
        System.out.println(target.contains("1"));
        System.out.println(target.containsAll(coll2));
        System.out.println(target.containsAll(coll1));

        System.out.println("collection size(): " + target.size());

        System.out.println("iterate using the Java for-each loop:");
        for (Object object :
                target) {
            System.out.println(object);
        }
    }
}
