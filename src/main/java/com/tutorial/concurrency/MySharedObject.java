package com.tutorial.concurrency;

public class MySharedObject {
    // static variable pointing to the instance of MySharedObject
    public static final MySharedObject sharedInstance = new MySharedObject();

    // member variables pointing to two objects on the heap
    public Integer object2 = new Integer(22);
    public Integer object4 = new Integer(44);

    public long member1 = 12345;
    public long member2 = 67890;

    @Override
    public String toString() {
        return "MySharedObject{" +
                "object2=" + object2 +
                ", object4=" + object4 +
                ", member1=" + member1 +
                ", member2=" + member2 +
                '}';
    }
}

class TestMySharedObject{
    public static void main(String[] args) {
        System.out.println(MySharedObject.sharedInstance);
        MySharedObject obj1 = new MySharedObject();
        MySharedObject obj2 = new MySharedObject();
        System.out.println("obj1: " + obj1);
        obj1.member1 = 12346;
        System.out.println("obj2: " + obj2);
        System.out.println("obj1: " + obj1);
    }
}
