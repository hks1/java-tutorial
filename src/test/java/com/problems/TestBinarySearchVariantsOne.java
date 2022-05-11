package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestBinarySearchVariantsOne {
    BinarySearchVariantsOne obj;
    @BeforeEach
    public void setUp(){
        obj = new BinarySearchVariantsOne();
    }
    @Test
    public void testBinarySearch(){
        Assertions.assertEquals(3, obj.binarySearch(new int[]{1,2,3,4,5,6,7}, 4));
        Assertions.assertEquals(-1, obj.binarySearch(new int[]{1,2,3,5,5,6,7}, 4));
        Assertions.assertEquals(3, obj.recBinarySearch(new int[]{1,2,3,4,5,6,7}, 4));
        Assertions.assertEquals(-1, obj.recBinarySearch(new int[]{1,2,3,5,5,6,7}, 4));
    }
    @Test
    public void testFirstBad(){
        Assertions.assertEquals(3, obj.firstBad(new char[]{'G','G','G','B','B'}));
        Assertions.assertEquals(0, obj.firstBad(new char[]{'B','B','B','B','B'}));
        Assertions.assertEquals(5, obj.firstBad(new char[]{'G','G','G','G','G'}));
    }
    @Test
    public void testInsertSearch(){
        //Example 1:
        //
        //Input: nums = [1,3,5,6], target = 5
        //Output: 2
        //Example 2:
        //
        //Input: nums = [1,3,5,6], target = 2
        //Output: 1
        //Example 3:
        //
        //Input: nums = [1,3,5,6], target = 7
        //Output: 4

        Assertions.assertEquals(2, obj.insertSearch(new int[]{1,3,5,6}, 5));
        Assertions.assertEquals(1, obj.insertSearch(new int[]{1,3,5,6}, 2));
        Assertions.assertEquals(4, obj.insertSearch(new int[]{1,3,5,6}, 7));
    }
    @Test
    public void testNextGreatestLetter(){
        //Example 1:
        //
        //Input: letters = ["c","f","j"], target = "a"
        //Output: "c"
        //Example 2:
        //
        //Input: letters = ["c","f","j"], target = "c"
        //Output: "f"
        //Example 3:
        //
        //Input: letters = ["c","f","j"], target = "d"
        //Output: "f"
        Assertions.assertEquals('c', obj.nextGreatestLetter(new char[]{'c','f','j'}, 'a'));
        Assertions.assertEquals('f', obj.nextGreatestLetter(new char[]{'c','f','j'}, 'c'));
        Assertions.assertEquals('f', obj.nextGreatestLetter(new char[]{'c','f','j'}, 'd'));
    }
    @Test
    public void testSearchRange(){
        //Example 1:
        //
        //Input: nums = [5,7,7,8,8,10], target = 8
        //Output: [3,4]
        //Example 2:
        //
        //Input: nums = [5,7,7,8,8,10], target = 6
        //Output: [-1,-1]
        //Example 3:
        //
        //Input: nums = [], target = 0
        //Output: [-1,-1]
        Assertions.assertArrayEquals(new int[]{3,4}, obj.searchRange(new int[]{5,7,7,8,8,10}, 8));
        Assertions.assertArrayEquals(new int[]{-1,-1}, obj.searchRange(new int[]{5,7,7,8,8,10}, 6));
        Assertions.assertArrayEquals(new int[]{-1,-1}, obj.searchRange(new int[]{}, 8));
    }
    @Test
    public void testisMajorityElement(){
        // Example 1:
        //
        //Input: nums = [2,4,5,5,5,5,5,6,6], target = 5
        //Output: true
        //Explanation: The value 5 appears 5 times and the length of the array is 9.
        //Thus, 5 is a majority element because 5 > 9/2 is true.
        //Example 2:
        //
        //Input: nums = [10,100,101,101], target = 101
        //Output: false
        //Explanation: The value 101 appears 2 times and the length of the array is 4.
        //Thus, 101 is not a majority element because 2 > 4/2 is false.
        Assertions.assertTrue(obj.isMajorityElement(new int[]{2,4,5,5,5,5,5,6,6,}, 5));
        Assertions.assertFalse(obj.isMajorityElement(new int[]{10,100,101,101}, 101));
    }
    @Test
    public void testSearchMatrix(){
        // Example 1:
        //
        //
        //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        //Output: true
        //Example 2:
        //
        //
        //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        //Output: false
        Assertions.assertTrue(obj.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        Assertions.assertFalse(obj.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }
    @Test
    public void testFixedPoint(){
        //Example 1:
        //
        //Input: arr = [-10,-5,0,3,7]
        //Output: 3
        //Explanation: For the given array, arr[0] = -10, arr[1] = -5, arr[2] = 0, arr[3] = 3, thus the output is 3.
        //Example 2:
        //
        //Input: arr = [0,2,5,8,17]
        //Output: 0
        //Explanation: arr[0] = 0, thus the output is 0.
        //Example 3:
        //
        //Input: arr = [-10,-5,3,4,7,9]
        //Output: -1
        //Explanation: There is no such i that arr[i] == i, thus the output is -1.
        Assertions.assertEquals(3, obj.fixedPoint(new int[]{-10,-5,0,3,7}));
        Assertions.assertEquals(0, obj.fixedPoint(new int[]{0,2,5,8,17}));
        Assertions.assertEquals(-1, obj.fixedPoint(new int[]{-10,-5,3,4,7,9}));
    }
    @Test
    public void testSingleNonDuplicate(){
        //Example 1:
        //
        //Input: nums = [1,1,2,3,3,4,4,8,8]
        //Output: 2
        //Example 2:
        //
        //Input: nums = [3,3,7,7,10,11,11]
        //Output: 10
        Assertions.assertEquals(2, obj.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        Assertions.assertEquals(10, obj.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
    @Test
    public void testMissingNumber(){
        //Example 1:
        //
        //Input: arr = [5,7,11,13]
        //Output: 9
        //Explanation: The previous array was [5,7,9,11,13].
        //Example 2:
        //
        //Input: arr = [15,13,12]
        //Output: 14
        //Explanation: The previous array was [15,14,13,12].
        Assertions.assertEquals(9, obj.missingNumber(new int[]{5,7,11,13}));
        Assertions.assertEquals(14, obj.missingNumber(new int[]{15,13,12}));
    }
    @Test
    public void testMissingElement(){
        //Example 1:
        //
        //Input: nums = [4,7,9,10], k = 1
        //Output: 5
        //Explanation: The first missing number is 5.
        //Example 2:
        //
        //Input: nums = [4,7,9,10], k = 3
        //Output: 8
        //Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
        //Example 3:
        //
        //Input: nums = [1,2,4], k = 3
        //Output: 6
        //Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
        Assertions.assertEquals(5, obj.missingElement(new int[]{4,7,9,10}, 1));
        Assertions.assertEquals(8, obj.missingElement(new int[]{4,7,9,10}, 3));
        Assertions.assertEquals(6, obj.missingElement(new int[]{1,2,4}, 3));
    }
    @Test
    public void testSearch(){
        //Example 1:
        //
        //Input: secret = [-1,0,3,5,9,12], target = 9
        //Output: 4
        //Explanation: 9 exists in secret and its index is 4.
        //Example 2:
        //
        //Input: secret = [-1,0,3,5,9,12], target = 2
        //Output: -1
        //Explanation: 2 does not exist in secret so return -1.
    }
}
