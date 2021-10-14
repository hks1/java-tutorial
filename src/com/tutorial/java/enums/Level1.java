package com.tutorial.java.enums;

public enum Level1 {
    HIGH(1){
        @Override
        public String normalize() {
            return HIGH.toString().toLowerCase();
        }
    },
    MEDIUM(2){
        @Override
        public String normalize() {
            return MEDIUM.toString().toLowerCase() + MEDIUM.toString().toUpperCase();
        }
    },
    LOW(3) {
        @Override
        public String normalize() {
            return LOW.toString().toUpperCase() + LOW.toString().toLowerCase();
        }
    };

    private int intValue;

    private Level1(int intValue){
        this.intValue = intValue;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public abstract String normalize();
}
