package com.example.javatopics.array.probs.easy;

/*
Dutch National Flag Algorithm
arr[mid] = 0, then swap arr[lo] and arr[mid] and increment lo by 1 because all the zeros are till index lo – 1 and move to the next element so increment mid by 1.
arr[mid] = 1, then move to the next element so increment mid by 1.
arr[mid] = 2, then swap arr[mid] and arr[hi] and decrement hi by 1 because all the twos are from index hi + 1 to n – 1.
* */
public class SortAnArrayOfZeroOneAndTwos {

    public static void main(String[] args){
        int[] arr = { 0, 1, 2, 0, 1, 2 };
        sort012(arr);

        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void sort012 (int[] arr) {
        int low =0;
        int mid =0;
        int high = arr.length-1;

        while(mid<=high){
            if( arr[mid]== 0){
                swapNumber(arr,mid,low);
                low++;
                mid++;
            }else if (arr[mid]==1){
                mid++;
            }else{
                swapNumber(arr,mid,high);
                high--;
            }
        }
    }

    private static void swapNumber (int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]= temp;
    }
}
