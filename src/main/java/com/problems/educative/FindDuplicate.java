package com.problems.educative;

import java.util.Arrays;

public class FindDuplicate {

    public int findDuplicate(int[] nums){
        // initialize the fast and slow pointers and make them point to the first element of the array
        int fast = nums[0];
        int slow = nums[0];
        // PART #1
        // traverse in array until the intersection point is found
        while (true){
            // move the slow pointer using th enums[slow] flow
            slow = nums[slow];
            // move fast pointer two times fast as the slow pointer using the nums[nums[fast]] flow
            fast = nums[nums[fast]];
            // break the loop when slow pointer becomes equal to th fast pointer, i.e., if the intersection is found
            if(slow == fast)
                break;
        }
        // PART #2
        // make the slow pointer point to the starting position of an array again, i.e.,
        // start the slow pointer from starting position
        slow = nums[0];
        // traverse the array until the  slow pointer becomes equal to th fast pointer
        while (slow != fast){
            // move the slow pointer using the nums[slow] flow
            slow = nums[slow];
            // move the fast pointer slower than before, i.e., move it using the nums[fast] flow
            fast = nums[fast];
        }
        // Return the fast pointer as it points the duplicate number of the array
        return fast;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 2, 3, 5, 4},
                {2, 4, 5, 4, 1, 3},
                {1, 6, 3, 5, 1, 2, 7, 4},
                {1, 2, 2, 4, 3},
                {3, 1, 3, 5, 6, 4, 2}
        };
        FindDuplicate obj = new FindDuplicate();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + 1);
            System.out.println(".\tnums = " + Arrays.toString(nums[i]));
            System.out.println("\tDuplicate number = " + obj.findDuplicate(nums[i]));
            System.out.println(new String(new char[100]).replaceAll("\0", "-"));
        }
    }
}
