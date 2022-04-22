package com.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParentheses {
    public List<String> generateAllBalancedParentheses(int n){
        List<String> result = new ArrayList<>();
        // left - n, right - n
        //generateAllBalancedParenthesesHelper(n, 0, 0, result, new StringBuilder());
        helper(n, n, result, new StringBuilder());
        return result;
    }
    public void generateAllBalancedParenthesesHelper(int n, int left, int right, List<String> result, StringBuilder sb){
        // base
        if(n == left && left == right){
            result.add(sb.toString());
        }
        // backtracking
        if(right > left || left > n) return;
        // recursive
        // add left
        sb.append("(");
        generateAllBalancedParenthesesHelper(n, left+1, right, result, sb);
        sb.deleteCharAt(sb.length()-1);
        // add right
        sb.append(")");
        generateAllBalancedParenthesesHelper(n, left, right+1, result, sb);
        sb.deleteCharAt(sb.length()-1);
    }
    // another implementation
    public void helper(int left, int right, List<String> result, StringBuilder sb){
        // base
        if(left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }
        // recursion
        if(left != 0){
            sb.append("(");
            helper(left-1, right, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right > left){
            sb.append(")");
            helper(left, right-1, result, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
