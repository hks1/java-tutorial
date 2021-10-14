package com.tutorial;

public class SwitchOnEnum {
    private static enum Size{
        SMALL, MEDIUM, LARGE, X_LARGE
    }

    private static void switchOnEnum(Size size){
        switch (size){
            case SMALL:{
                System.out.println("size is small");
                break;
            }
            case MEDIUM:{
                System.out.println("size is medium");
                break;
            }
            case LARGE:{
                System.out.println("size is large");
                break;
            }
            case X_LARGE:{
                System.out.println("size is X-large");
                break;
            }
            default:{
                System.out.println("size is not S, M, L or XL: " + size);
            }
        }
    }

    private static char numericSwitchExpression(int digitInDecimal){
        char digitInHex =
                switch (digitInDecimal){
                    case 0 -> '0';
                    case 1 -> '1';
                    case 2 -> '2';
                    case 3 -> '3';
                    case 4 -> '4';
                    case 5 -> '5';
                    case 6 -> '6';
                    case 7 -> '7';
                    case 8 -> '8';
                    case 9 -> '9';
                    case 10 -> 'A';
                    case 11 -> 'B';
                    case 12 -> 'C';
                    case 13 -> 'D';
                    case 14 -> 'E';
                    case 15 -> 'F';
                    default -> '?';
                };
        return digitInHex;
    }

    private static int stringSwitchExpression(String token){
        int tokenType = switch (token){
            case "123" -> 0;
            case "abc" -> 1;
            default -> -1;
        };
        return tokenType;
    }

    public static void main(String[] args) {
        switchOnEnum(Size.SMALL);

        char key = '\t';
        switch (key) {
            case ' ', '\t':{
                System.out.println("white space character");
                break;
            }
            default:
                System.out.println("char is something else: " + key);
        }

        int digitInDecimal = 12;


        System.out.println(" here is digit in hex: " + numericSwitchExpression(digitInDecimal));
        System.out.println(stringSwitchExpression("abc"));

        //Java switch yield instruction
        String token = "123";

        int tokenType = switch (token){
            case "123" : yield 0;
            case "abc" : yield 1;
            default: yield -1;
        };

        System.out.println(tokenType);
    }
}
