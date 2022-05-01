package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestValidPalindrome {
    ValidPalindrome obj;
    @BeforeEach
    public void setUp(){
        obj = new ValidPalindrome();
    }
    @Test
    public void testValidPalindrome(){
        Assertions.assertFalse(obj.isValidPalindrome("algorithm"));
        Assertions.assertTrue(obj.isValidPalindrome("level"));
        Assertions.assertTrue(obj.isValidPalindrome("A man, a plan, a canal: Panama."));
    }
}
