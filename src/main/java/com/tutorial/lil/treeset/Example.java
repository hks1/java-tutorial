package com.tutorial.lil.treeset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Example {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(44);
        treeSet.add(396);
        treeSet.add(202);
        treeSet.add(101);
        System.out.println(treeSet);
        treeSet.add(101);
        System.out.println(treeSet);


        Set<String> wordSet = new TreeSet<>(Comparator.comparing(String::length));
        wordSet.add("tiger");
        wordSet.add("giraffe");
        wordSet.add("bear");
        System.out.println(wordSet);
        wordSet.add("wolf");
        System.out.println(wordSet);
        wordSet.remove("giraffe");
        System.out.println(wordSet);
    }
}
