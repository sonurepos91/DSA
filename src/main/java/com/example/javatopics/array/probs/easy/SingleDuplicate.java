package com.example.javatopics.array.probs.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleDuplicate {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        Arrays.sort(nums);
        int count = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == nums[i])
                break;
            else
                count = nums[i];
        }
        System.out.println(count);

        /*
        * 2 Way : Using Set
        * */

        Set<Integer> set1  = new HashSet<>();
        for(int n : nums){
            if(!set1.add(n)){
                System.out.println(n);
                break;
            }
        }

    }
}
