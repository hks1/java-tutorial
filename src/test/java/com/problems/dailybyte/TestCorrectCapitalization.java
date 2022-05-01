package com.problems.dailybyte;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCorrectCapitalization {
    CorrectCapitalization obj;
    @BeforeEach
    public void setUp(){
        obj = new CorrectCapitalization();
    }
    @Test
    public void testCorrectCapitalization(){
        Assertions.assertTrue( obj.correctCapitalization("Abcdef"));
        Assertions.assertTrue( obj.correctCapitalization("abcdef"));
        Assertions.assertTrue( obj.correctCapitalization("ABCDEF"));
        Assertions.assertFalse( obj.correctCapitalization("abCdef"));
        Assertions.assertFalse( obj.correctCapitalization("AbCdef"));
        Assertions.assertFalse( obj.correctCapitalization("aBcdef"));
        Assertions.assertFalse( obj.correctCapitalization("ABCDef"));
        Assertions.assertTrue( obj.correctCapitalization("a"));
        Assertions.assertTrue( obj.correctCapitalization("A"));
    }
}
