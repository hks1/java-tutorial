    package com.tutorial.arrays;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.function.IntPredicate;
    import java.util.stream.Stream;

    public class Algorithms {
        /**
         * @param arr1
         * @param arr2
         * @return array with even numbers from given two arrays
         */
        public int[] findEvenNums(int[] arr1, int[] arr2){
            ArrayList<Integer> result = new ArrayList<>();

            for (int num :
                    arr1) {
                if(num % 2 == 0){
                    result.add(num);
                }
            }
            for (int num :
                    arr2) {
                if(num %2 == 0){
                    result.add(num);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }

        /**
         * @param arr1
         * @param arr2
         * @return new array with even numbers in the two input arrays
         */
        public int[] findEvenNum2(int[] arr1, int[] arr2){
            IntPredicate isEvenPred = num -> num % 2 == 0;
            return Stream.of(arr1, arr2)
                    .flatMapToInt(Arrays::stream)
                    .filter(isEvenPred)
                    .toArray();

        }

        public int[] rotateLeft(int[] arr){
            if(arr.length == 0){
                return arr;
            }
            int first = arr[0];
            for(int i = 1; i < arr.length; i++){
                arr[i-1] = arr[i];
            }
            arr[arr.length-1] = first;
            return arr;
        }

        /*public int[] rotateLeft(int[] arr, int leftShift){
            int rightShift = arr.length - leftShift;
            int first = arr[0];
            for (int i = 0; i < arr.length; i++) {

            }
            return arr;
        }*/
    }
