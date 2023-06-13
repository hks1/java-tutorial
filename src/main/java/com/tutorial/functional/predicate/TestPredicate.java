package com.tutorial.functional.predicate;

import java.util.function.Predicate;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestPredicate {
    public static final  Logger logger = Logger.getLogger(TestPredicate.class.getName());
    private static final String TAG = "TestPredicate";


    public static void main(String[] args) {

        logger.setLevel(Level.INFO);
        // test(T t)
        Predicate<Integer> greater_than = x -> (x > 10);

        System.out.println(greater_than.test(11));

        // isEqual(Object t)
        Predicate<String> equality_check = Predicate.isEqual("CompareString");
        System.out.println(equality_check.test("comparestring"));
        System.out.println(equality_check.test("CompareString"));

        // and(Predicate p)
        Predicate<Integer> grt_10 = x -> (x > 10);
        Predicate<Integer> less_100 = x -> (x < 100);

        System.out.println(grt_10.and(less_100).test(60));



        // or(Predicate p)
        Predicate<Integer> eq_5 = x -> (x == 5);
        System.out.println(grt_10.or(eq_5).test(9));

        // negate
        System.out.println(grt_10.negate().test(5));
        System.out.println(grt_10.test(5));
    }
}
