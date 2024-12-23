package com.example.javatopics.slidingWindow.fixedSizeWindow;

public class LongestSubarrayWithSumDivisibleByK {

    public static void main (String[] args) {
        int[] arr = {2, 7, 6, 1, 4, 5};
        int k = 3;

        System.out.println("Brute Force : Taking Out all Possible subArrays combination and then deciding");
        System.out.println("Length = "
                + longestSubarrWthSumDivByK(arr, k));

        System.out.println("Using Concept of Sliding window and left and right pointers");
        System.out.println("Length = "
                + longestSubarrWthSumDivByKApproach2(arr, k));

    }

    private static String longestSubarrWthSumDivByKApproach2 (int[] arr, int k) {
        int l=0,r=0;
        int start =0,end =0;
        int curr_sum =0;
        while(r< arr.length){
            curr_sum= curr_sum+ arr[r];
            if(curr_sum% k !=0){

            }
            if(curr_sum % k==0){
                if(end-start < r-l){
                    start=l;
                    end=r;
                }
            }
            r++;
        }
        System.out.println("start "+ start + " end " + end);
        return String.valueOf(end-start +1);
    }

    private static String longestSubarrWthSumDivByK (int[] arr, int k) {

        int curr_sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < arr.length; i++) {
            curr_sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                curr_sum = curr_sum + arr[j];
                if (curr_sum % k == 0) {
                    if (end - start < j - i) {
                        start = i;
                        end = j;
                    }
                }
            }
        }
        System.out.println("start "+ start + " end " + end);
        return String.valueOf(end-start +1);
    }
}
