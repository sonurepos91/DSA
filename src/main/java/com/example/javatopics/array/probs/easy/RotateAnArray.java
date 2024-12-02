package com.example.javatopics.array.probs.easy;

import java.util.Arrays;

/*
* 1) Rotate an array Left Wise
* 2) Rotate an array Right Wise
* 3) Reverse an array
* */
public class RotateAnArray {

    private static void rotateArrayByKGivenPositions (int[] arr, int pos) {

        int k=0;
        pos = pos % arr.length;
        while(k<pos){
            int temp= arr[arr.length-1];
            for(int i =arr.length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;
            k++;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverseArray (int[] arr) {
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    /*
     * For Right Rotate :
     * a) First reverse the array from 0 to n-pos-1
     * b) Second Reverse array from n-pos to n-1
     * c) Reverse Array from 0 to n-1
     * */
    private static void rotateArrayByKGivenPositionsApproach2TowardsRight (int[] arr, int pos) {

        pos =pos% arr.length;
        reverseElements(arr,0,arr.length-pos-1);
        reverseElements(arr, arr.length-pos,arr.length-1);
        reverseElements(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
    }

    /*
     * For Left Rotate :
     * a) First reverse the array from 0 to pos-1
     * b) Second Reverse array from pos to n-1
     * c) Reverse Array from 0 to n-1
     * */
    private static void rotateArrayByKGivenPositionsApproach2TowardsLeft (int[] arr, int pos){
        pos = pos % arr.length;

        reverseElements(arr,0,pos-1);
        reverseElements(arr,pos,arr.length-1);
        reverseElements(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(e-> System.out.print(e + " "));
    }

    private static void reverseElements (int[] arr, int start, int end) {
        for(int i=start,j=end;i<=j;i++,j--){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]= temp;
        }
    }

    public static void main(String[] args){
        int arr[]={1, 2, 3, 4, 5, 6, 7};
        int pos =3;

        // Time Complexity : O(n^2)
        rotateArrayByKGivenPositions(arr,pos);
        System.out.println();
        // Time Complexity : O(n)
        rotateArrayByKGivenPositionsApproach2TowardsRight(arr,pos);
        System.out.println();
        // Time Complexity : O(n)
        rotateArrayByKGivenPositionsApproach2TowardsLeft(arr,pos);

        System.out.println();
        reverseArray(arr);
        System.out.println();
    }

}
