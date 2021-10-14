package com.test;

public class Test<T, S, U, V> {
    T t;
    S s;
    U u;
    V v;

    Test(T t, S s, U u, V v){
        this.t = t;
        this.s = s;
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Test{" +
                "t=" + t +
                ", s=" + s +
                ", u=" + u +
                ", v=" + v +
                '}';
    }
}

class Main{
    public static void main(String[] args) {
        GenericDemo<String> genericDemo = new GenericDemo<>();
        genericDemo.setT("generic demo");
        //Test<Integer, String, String, GenericDemo> test = new Test<>(1, "demo", "generic", new GenericDemo());
        Test<Integer, String, String, GenericDemo> test = new Test<>(1, "demo", "generic", genericDemo);

        System.out.println(test);

        Test test1 = new Test(1, "2", "test", "another one");
        System.out.println(test1);

    }
}

class GenericDemo<T> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "GenericDemo{" +
                "t=" + t +
                '}';
    }
}