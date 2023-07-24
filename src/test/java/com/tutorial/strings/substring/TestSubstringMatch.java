package com.tutorial.strings.substring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSubstringMatch {
    SubstringMatch obj;
    @BeforeEach
    public void setUp(){
        obj = new SubstringMatch();
    }
    @Test
    @DisplayName("substring match - success")
    public void testSubstringMatchSuccess(){
        Assertions.assertEquals(true, obj.matchSubstring("abc", "babcccd"));
    }
    @Test
    @DisplayName("substring match - fail")
    public void testSubstringMatchFail(){
        Assertions.assertEquals(false, obj.matchSubstring("yuul", "yulsoft"));
    }
}
