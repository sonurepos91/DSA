package com.example.javatopics.slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaximumOfAllSubArraysOfSizeK {

    private static void printKMax (int[] arr, int k) {

        int curr_max=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i< arr.length-k;i++){
             curr_max=arr[i];
             for(int j=1;j<k;j++){
                 if(arr[i+j]>curr_max){
                     curr_max=arr[i+j];
                 }
             }
             list.add(curr_max);
        }
        list.stream().forEach(item-> System.out.print(item + " "));

    }
    public static void main(String[] args){
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int K = 3;

        printKMax(arr, K);
    }
}
