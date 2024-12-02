package com.example.javatopics.slidingWindow.variableSizeWindow;

public class MinimumSizeSubarrayWithGreaterThanOrEqualToGivenSum {


    private static int minSubArrayLen (int[] nums, int target) {
        int l=0,r=0;
        int curr_sum=0;
        int minLen = Integer.MAX_VALUE;

        while(r<nums.length){
            curr_sum=curr_sum+nums[r];

            while(curr_sum>=target){
                minLen= Math.min(minLen,r-l+1);
                curr_sum= curr_sum-nums[l];
                l++;
            }
            r++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }

    public static void main(String[] args){
       int  target = 7;
       int []nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(nums,target));
    }
}
