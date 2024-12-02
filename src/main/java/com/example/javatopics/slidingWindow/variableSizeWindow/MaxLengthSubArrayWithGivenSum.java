package com.example.javatopics.slidingWindow.variableSizeWindow;

public class MaxLengthSubArrayWithGivenSum {

    private static void subarraySum (int[] arr, int sum) {
        int curr_sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                curr_sum = curr_sum + arr[j];
                if (curr_sum == sum) {
                    start = i;
                    end = j;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static void main (String[] args) {
        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int sum = 23;

        // Longest SubArray with Given Sum
        System.out.println("Using Brute Force Taking out all subarrays : ");
        subarraySum(arr, sum);
        System.out.println();
        //Does Not Work for array with negative Numbers
        System.out.println("Using Concept of Left and Right Pointers and Sliding Window ");
        subarraySumApproach2(arr, sum);
        // Prefix Sum Solution with HashMap
    }

    private static void subarraySumApproach2 (int[] arr, int sum) {

        int l = 0, r = 0;
        int start = 0, end = 0;
        int curr_sum = 0;

        while (r < arr.length && l < arr.length) {

            curr_sum = curr_sum + arr[r];

            if (curr_sum > sum) {
                curr_sum = curr_sum - arr[l];
                l++;
            }

            if (curr_sum == sum) {
                start = Math.max(start, l);
                end = Math.max(end, r);
            }
            r++;
        }
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
