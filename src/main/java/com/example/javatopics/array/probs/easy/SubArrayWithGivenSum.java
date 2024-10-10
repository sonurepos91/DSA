package com.example.javatopics.array.probs.easy;

public class SubArrayWithGivenSum {

    private static void subarraySum (int[] arr, int sum) {
        int curr_sum=0;
        int start =0,end=0;
        for(int i=0;i<arr.length;i++){
            curr_sum=arr[i];
            for(int j=i+1;j<arr.length;j++){
                curr_sum=curr_sum+arr[j];
                if(curr_sum== sum){
                    start=i;
                    end=j;
                }
            }
        }

        for(int i=start;i<=end;i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args){
        int[] arr = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int sum = 23;

        subarraySum(arr, sum);
    }
}
