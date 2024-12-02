package com.example.javatopics.array.probs.easy;

import java.util.Arrays;

public class MaximumCarsParkingAllowed {

    public static void main(String[] args)
    {

        int arr[] = { 1012,1317, 1015};
        int dep[]={1136,1412, 1020};

        maxCars(arr,dep);
    }

    private static void maxCars (int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int minParing =0;
        int maxPark=0;

        int i=0,j=0;
        while(i<arr.length && j<dep.length){
            if(arr[i]<dep[j]){
                minParing++;
                i++;
            }else{
                minParing--;
                j++;
            }
            maxPark = Math.max(maxPark,minParing);
        }
        System.out.println(maxPark);
    }
}
