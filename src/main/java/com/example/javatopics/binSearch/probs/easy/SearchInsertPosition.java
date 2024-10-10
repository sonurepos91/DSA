package com.example.javatopics.binSearch.probs.easy;

public class SearchInsertPosition {

    /*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
    return the index where it would be if it were inserted in order.*/

    public static void main(String[] args){
        int nums[] ={1,3,5,8};
        int target = 0;

        System.out.println(searchInsert(nums,target));
    }

    private static int searchInsert (int[] nums, int target) {
        int beg=0;
        int end = nums.length-1;
        int mid = 0;
        while(beg<=end){
            mid = (beg+end)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]< target)
                beg =mid+1;
            else
                end= mid-1;
        }
        if(target >nums[mid])
            return mid+1;
        return mid;
    }
}
