package com.lc;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringToIntegerTest {

    StringToInteger obj;

    @BeforeEach
    public void setUp(){
         obj = new StringToInteger();
    }

    @Test
    void myAtoi() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        /*Assertions.assertEquals(123, obj.myAtoi("123"));
        Assertions.assertEquals(123, obj.myAtoi("  00123"));
        Assertions.assertEquals(-123, obj.myAtoi("-123"));
        Assertions.assertEquals(-123, obj.myAtoi("-00123"));
        Assertions.assertEquals(-123, obj.myAtoi("   -00123"));
        Assertions.assertEquals(-123, obj.myAtoi("   -00123   "));
        Assertions.assertEquals(-123, obj.myAtoi("   -00123a456"));*/
        Assertions.assertEquals(-2147483648, obj.myAtoi("-2147483649"));
        Assertions.assertEquals(2147483647, obj.myAtoi("2147483649"));
    }
}