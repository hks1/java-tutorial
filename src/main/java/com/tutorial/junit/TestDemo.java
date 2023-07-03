package com.tutorial.junit;

//import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestDemo {
    public int divide(int x, int y){
        return x/y;
    }

    BiFunction<Integer, Integer, Integer> divide = (x,y) -> x/y;


    public int testDivide(){
        int result = divide.andThen(x -> x+5).apply(10, 5);
        System.out.println(result);
        return result;
    }
}

class TestDemoMain{
    public static void main(String[] args) {
        TestDemo obj = new TestDemo();
        obj.testDivide();
        List<Integer> list = List.of(1,2,3,4);
        System.out.println(list);
    }
}
