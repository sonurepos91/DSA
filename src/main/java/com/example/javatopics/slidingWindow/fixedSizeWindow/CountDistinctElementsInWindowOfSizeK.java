package com.example.javatopics.slidingWindow.fixedSizeWindow;

import java.util.HashSet;

public class CountDistinctElementsInWindowOfSizeK {

    public static void main(String arg[])
    {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int K = 4;

        int l=0,r=0;
        countDistinct(arr, K);
    }

    private static void countDistinct (int[] arr, int k) {

        HashSet<Integer> set = null;

        for(int i=0;i<=arr.length-k;i++){
            set = new HashSet<>();
            //set.add(arr[i]);
            for(int j=0;j<k;j++){
                set.add(arr[i+j]);
            }
            System.out.println(set.size());
        }
    }
}
