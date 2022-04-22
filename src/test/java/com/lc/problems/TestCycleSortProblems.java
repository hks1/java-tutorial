package com.lc.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestCycleSortProblems {
    CycleSortProblems obj;
    @BeforeEach
    public void setUp(){
        obj = new CycleSortProblems();
    }
    // 645. St Mismatch
    @Test
    public void testFindErrNumTC1(){
        Assertions.assertArrayEquals(new int[]{2,3}, obj.findErrorNums(new int[]{1,2,2,4}));
        Assertions.assertArrayEquals(new int[]{1,2}, obj.findErrorNums(new int[]{1,1}));
    }
    // 268. Missing Number
    @Test
    public void testMissingNumber(){
        Assertions.assertEquals(2, obj.missingNumber(new int[]{3,0,1}));
        Assertions.assertEquals(4, obj.missingNumberGaussFormula(new int[]{3,0,1,2}));
        Assertions.assertEquals(0, obj.missingNumberGaussFormula(new int[]{3,1,2}));
    }
    @Test
    public void testMissingNumberGaussFormula(){
        Assertions.assertEquals(2, obj.missingNumberGaussFormula(new int[]{3,0,1}));
        Assertions.assertEquals(4, obj.missingNumberGaussFormula(new int[]{3,0,1,2}));
        Assertions.assertEquals(0, obj.missingNumberGaussFormula(new int[]{3,1,2}));
    }
    // 287. Find the Duplicate Number
    @Test
    public void testFindDuplicateTC1(){
        Assertions.assertEquals(2, obj.findDuplicate(new int[] {1,3,4,2,2}));
        Assertions.assertEquals(3, obj.findDuplicate(new int[] {3,1,3,4,2}));
        Assertions.assertEquals(1, obj.findDuplicate(new int[] {1,1}));
    }
    @Test
    public void testFindDuplicateWithCycleSortTC1(){
        Assertions.assertEquals(2, obj.findDuplicateCycleSort(new int[] {1,3,4,2,2}));
        Assertions.assertEquals(3, obj.findDuplicateCycleSort(new int[] {3,1,3,4,2}));
        Assertions.assertEquals(1, obj.findDuplicateCycleSort(new int[] {1,1}));
    }
    // 448. Find All Numbers Disappeared in an Array
    @Test
    public void testFindDisappearingNumbers(){
        int[] arr = {4,3,2,7,8,2,3,1};
        //List<Integer> result = new ArrayList<>();
        List<Integer> result = Arrays.asList(5,6);
        Assertions.assertEquals(result, obj.findDisappearedNumbers(arr));
    }
    // 41. First MissingPositive
    @Test
    public void testFirstMissingPositive(){
        Assertions.assertEquals(3, obj.firstMissingPositive(new int[]{1,2,0}));
        Assertions.assertEquals(2, obj.firstMissingPositive(new int[]{3,4,-1,1}));
        Assertions.assertEquals(1, obj.firstMissingPositive(new int[]{7,8,9,11,12}));
        Assertions.assertEquals(5, obj.firstMissingPositive(new int[]{1,2,3,4}));
        Assertions.assertEquals(5, obj.firstMissingPositive(new int[]{1,2,3,4,0}));
        int[] arr = new int[(int) Math.pow(10,5)];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
        Assertions.assertEquals((int) Math.pow(10,5) + 1, obj.firstMissingPositive(arr));
    }
    // 765. Couples Holding Hands
    @Test
    public void testMinSwapCouples(){

    }
}
