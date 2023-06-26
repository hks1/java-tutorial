package com.tutorial.localclasses;

public class LocalClassExample {
    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(
            String phoneNumber1,
            String phoneNumber2
    ){
        final int numberLength = 10;
        // int numberLength = 10;

        class PhoneNumber{
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                // numberLength = 7; // local variables referenced from an inner class must be final or effectively final
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if(currentNumber.length() == numberLength){
                    formattedPhoneNumber = currentNumber;
                }else
                    formattedPhoneNumber = null;
            }

            public String getFormattedPhoneNumber(){
                return formattedPhoneNumber;
            }

            // valid in JDK 8 and later
            public void printOriginalNumbers(){
                System.out.println("Original numbers are: " + phoneNumber1 + " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // valid in JDK 8 and later
        myNumber1.printOriginalNumbers();

        if(myNumber1.getFormattedPhoneNumber() == null){
            System.out.println("First Number is invalid");
        }else {
            System.out.println("First number is: " + myNumber1.getFormattedPhoneNumber());
        }if(myNumber2.getFormattedPhoneNumber() == null){
            System.out.println("Second number is invalid");
        }else {
            System.out.println("Second number is: " + myNumber2.getFormattedPhoneNumber());
        }
    }

    public static void main(String[] args) {
        validatePhoneNumber("123-456-7890", "456-7890");
    }
}
