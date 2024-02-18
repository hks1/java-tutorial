package com.tutorial.enums;

public class EnumToString {
    private enum Weekdays{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    private enum ColdDrink{
        PEPSI("Pepsi"), COKE("Coke"), SPRITE("Sprite");
        private String brandname;
        private ColdDrink(String brandname){
            this.brandname = brandname;
        }

        @Override
        public String toString() {
            return brandname;
        }
    }

    public static void main(String[] args) {
        // converting Enum to String by using name() method
        // by default print method calls toString() of enum
        ColdDrink[] drinks = ColdDrink.values();
        for (ColdDrink drink :
                drinks) {
            System.out.printf("String to Enum example using name : %s%n", drink.name());
        }

        // converting Enum to String using toString() method
        for (ColdDrink drink :
                drinks) {
            System.out.println("String to enum conversion using toString() : " + drink);
        }
    }
}
