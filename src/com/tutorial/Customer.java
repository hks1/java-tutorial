package com.tutorial;

public class Customer {
    // The private access modifier means that
        // only code inside the class itself can access this Java field.
    private String email;
    // The package access modifier means that only code inside the class itself,
        // or other classes in the same package, can access the field.
        // You don't actually write the package modifier.
        // By leaving out any access modifier, the access modifier defaults to package scope.
            String position; //no modiifier = 'package' access modifier
    // The protected access modifier is like the package modifier,
        // except subclasses of the class can also access the field,
        // even if the subclass is not located in the same package.
    protected String name;
    // The public access modifier means that the field can be accessed by all classes in your application.
    public String city;

    final String str = "FINAL";
    final int[] arr = {1,2,3,4,5,6};

    public void changeStr(String str1, String str2){
        System.out.println("changeStr():: str1 is " + str1 + ", and str2 is " + str2);
        str1 = "new value 1";
        str2 = "new value 2";
        System.out.println("changeStr():: str1 is " + str1 + ", and str2 is " + str2);

    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        System.out.println(customer.str);
        System.out.println(customer.arr[1]);
        customer.arr[1] = 22;
        System.out.println(customer.arr[1]);
        String str1 = "Old value 1";
        String str2 = "Old value 2";

        customer.changeStr(str1, str2);
        System.out.println("main():: str1 is " + str1 + ", and str2 is " + str2);

    }
}
