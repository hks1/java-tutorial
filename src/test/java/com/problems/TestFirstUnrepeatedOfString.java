package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFirstUnrepeatedOfString {
    FirstUnrepeatedOfString obj;
    @BeforeEach
    public void setUP(){
        obj = new FirstUnrepeatedOfString();
    }
    @Test
    public void testFirstUnrepeated(){
        Assertions.assertEquals('c', obj.firstUnrepeated("abcbadd"));
        Assertions.assertEquals('\0', obj.firstUnrepeated("abcbaddc"));
        Assertions.assertEquals('c', obj.firstUnrepeated("abcbaddefgf"));
    }
}
