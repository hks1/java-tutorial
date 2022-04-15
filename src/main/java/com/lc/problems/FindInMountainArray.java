package com.lc.problems;

import java.util.Arrays;

public class FindInMountainArray {
    public int findInMountainArray(MountainArray mountainArr, int target){
        int n = mountainArr.length();
        int start = 0;
        int end = n - 1;
        int peakIdx = 0;
        //int mid = 0;
        // BS1 : find the peak
        while(start <= end){
            int mid = start + (end-start)/2;
            if((mid != 0) && (mid != n-1) && (mountainArr.get(mid-1) < mountainArr.get(mid)) && (mountainArr.get(mid) > mountainArr.get(mid+1))){
                peakIdx = mid;
                break;
            } else if(mid == 0 || mountainArr.get(mid-1) < mountainArr.get(mid)){
                start = mid + 1;
            } else { // mid == n-1 || mountainArr.get(mid) > mountainArr.get(mid+1)
                end = mid - 1;
            }
        }
        //if(peakIdx == 0) return -1;
        // BS2 : find target in left array
        start = 0;
        end = peakIdx;
        while(start <= end){
            int mid = start + (end-start)/2;
            int number = mountainArr.get(mid);
            // return if found in left array as this would be the mi index
            if(number == target) return mid;
            else if(number < target){
                start = mid + 1;
            } else{
                end = mid -1;
            }
        }
        // BS3 : find target in right array
        start = peakIdx + 1;
        end = n - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int number = mountainArr.get(mid);
            if(number == target) return mid;
            else if(number > target){
                start = mid+1;
            } else{
                end = mid - 1;
            }
        }
        return -1;
    }
    public int findPeakInMountainArray(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid == 0 || arr[mid-1] < arr[mid]){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return arr[end];
    }
}

class MountainArray{
    int[] arr;
    int length;
    public MountainArray(int[] arr){
        length = arr.length;
        this.arr = Arrays.copyOf(arr, length);
    }

    public int getLength() {
        return length;
    }
    public int length(){
        return length;
    }
    public int get(int i){
        return arr[i];
    }
}

class TestDriveMountainArray{
    public static void main(String[] args) {
        FindInMountainArray obj = new FindInMountainArray();
        //int[] arr = new int[]{1,2,3,4,5,6,7,6,5,4,2,1,0};
        int[] arr = new int[] {3,5,3,2,0};
        MountainArray mountainArr = new MountainArray(arr);
        System.out.println(obj.findPeakInMountainArray(arr));
        System.out.println(obj.findInMountainArray(mountainArr, 3));


    }
}
