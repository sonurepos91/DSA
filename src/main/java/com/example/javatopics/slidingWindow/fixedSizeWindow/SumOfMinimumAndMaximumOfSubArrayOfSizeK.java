package com.example.javatopics.slidingWindow.fixedSizeWindow;

public class SumOfMinimumAndMaximumOfSubArrayOfSizeK {

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(SumOfKsubArray(arr, k));
    }

    private static int SumOfKsubArray (int[] arr, int k) {
       int curr_max =0;
       int curr_min =0;
       int result =0;

       for(int i=0;i<= arr.length-k;i++){
           curr_max= arr[i];
           curr_min = arr[i];
           for(int j=1;j<k;j++){
               curr_min= Math.min(curr_min,arr[i+j]);
               curr_max= Math.max(curr_max,arr[i+j]);
           }
           result= result+ curr_max+curr_min;
       }
       return result;
    }
}
