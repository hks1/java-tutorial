package com.sort;

public class InsertionSort implements ISort{

    @Override
    public int[] sort(int[] A) {
        for(int i = 0; i < A.length; i++){
            int temp = A[i];
            int j = i-1;

            while(j >= 0 && A[j] > temp){
                A[j+1] = A[j];
                j--;
            }

//            for (; j > 0; j--){
//                if(temp < A[j-1]){
//                    A[j] = A[j-1];
//                }
//            }
            A[j+1] = temp;

        }
        return A;
    }
}
