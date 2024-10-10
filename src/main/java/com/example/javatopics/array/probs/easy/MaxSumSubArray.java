package com.example.javatopics.array.probs.easy;

public class MaxSumSubArray {

    private static int maxSubArraySumApproach2 (int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];

        for (int i = 0; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;
    }

    private static int  maxSubarraySum (int[] arr) {
        int current_sum = 0;
        int max_sum = arr[0];
        int start =0, end=0;

        for (int i = 0; i < arr.length; i++) {
            current_sum=0;
            for(int j=i;j<arr.length;j++){
                current_sum=current_sum+arr[j];
                if(current_sum>max_sum){
                    max_sum=current_sum;
                    start=i;
                    end=j;
                }
            }
        }
        for(int i=start;i<=end;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return max_sum;
    }

    public static void main(String[] args){
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println();
        // O(n^2)
        System.out.println(maxSubarraySum(arr));
        System.out.println();
        // O(n)
        System.out.println(maxSubArraySumApproach2(arr));
    }
}
