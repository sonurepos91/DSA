package com.example.javatopics.array.probs.easy;

public class Segregrate0And1InArray {

    private static void segregate0and1 (int[] arr) {
        int count =0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]== 0){
                count++;
            }
        }
       for(int i=0;i<arr.length;i++){
           if(count>0){
               arr[i]=0;
               count--;
           }else{
               arr[i]=1;
           }
       }
       for(int i=0;i<arr.length;i++){
           System.out.print(arr[i] + " ");
       }
    }

    private static void segregate0and1Approach2 (int[] arr) {

        int left =0;
        int right = arr.length-1;

        while(left<right){

            while(arr[left]== 0 && left<right)
                left++;
            while(arr[right]== 1 && left<right)
                right--;
            if(left<right){
                arr[left]=0;
                arr[right]=1;
                left++;
                right--;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){

        int arr[] = new int[]{ 0, 1, 0, 1, 1, 0 };
        // 2*O(n)
        segregate0and1(arr);
        System.out.println();
        // Follow Two Pointer Approach ::
        // O(n)
        segregate0and1Approach2(arr);
    }
}
