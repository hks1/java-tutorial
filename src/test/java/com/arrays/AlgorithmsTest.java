package com.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {
    Algorithms obj;

    @BeforeEach
    void setup(){
        obj = new Algorithms();
    }



    @Test
    void findEvenNums() {
        int[] arr1 = {-9, 2, 3, -8, 12, 16};
        int[] arr2 = {0, 3, -8,  -35, -40, 20, 7};
        int[] result = new int[]{2, -8, 12, 16, 0, -8, -40, 20};
        assertArrayEquals(result, obj.findEvenNums(arr1, arr2));

    }

    @Test
    void findEvenNum2() {
        int[] arr1 = {-9, 2, 3, -8, 12, 16};
        int[] arr2 = {0, 3, -8,  -35, -40, 20, 7};
        int[] result = new int[]{2, -8, 12, 16, 0, -8, -40, 20};
        assertArrayEquals(result, obj.findEvenNum2(arr1, arr2));
    }

    @Test
    void rotateLeft() {
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] result = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            arr = obj.rotateLeft(arr);
        }
        assertArrayEquals(result, arr);

        obj.rotateLeft(arr);
        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(result));
        // converting left rotation to right rotation
        int leftRotate = 1;
        int rightRotate = arr.length - leftRotate;

        for (int i = 0; i < arr.length; i++) {
            int j = (i + rightRotate) % arr.length;
            //System.out.println(i + " " + j + " " + arr[i] + " " + result[j]);
            assertEquals(result[i], arr[j]);
        }

    }
}