package com.example.javatopics.binSearch.probs.hard;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args){

        int[] arr1 = { -5, 3, 6, 12, 15 };
        int[] arr2 = { -12, -10, -6, -3, 4, 10 };
        System.out.println(medianOf2(arr1, arr2));
    }

    private static int medianOf2 (int[] arr1, int[] arr2) {

        int arr3[] = new int[arr1.length+arr2.length];

        System.arraycopy(arr1,0,arr3,0,arr1.length);
        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);

        Arrays.sort(arr3);

        if(arr3.length% 2== 0){
            return (arr3[arr3.length/2] + arr3[arr3.length/2 +1])/2;
        }else
            return arr3[arr3.length/2];
    }



}
