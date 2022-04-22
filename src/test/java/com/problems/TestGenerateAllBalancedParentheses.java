package com.problems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGenerateAllBalancedParentheses {
    GenerateAllBalancedParentheses obj;
    @BeforeEach
    public void setUp(){
        obj = new GenerateAllBalancedParentheses();
    }
    @Test@DisplayName("test generate all valid parenthesis")
    public void testGenerateAllBalancedParentheses(){
        System.out.println(obj.generateAllBalancedParentheses(3));
        System.out.println(obj.generateAllBalancedParentheses(5).size());
    }
}
