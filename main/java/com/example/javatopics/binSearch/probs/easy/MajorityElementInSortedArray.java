package com.example.javatopics.binSearch.probs.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MajorityElementInSortedArray {

    private static int majorityElementInSortedArray (int[] arr) {
       Map<Integer,Integer> map = new HashMap<>();
       for(int i=0;i< arr.length;i++){
           map.put(arr[i],map.get(arr[i])!=null?map.get(arr[i])+1:1);
       }

        Stream<Map.Entry<Integer, Integer>> limit = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).limit(1);
        limit.forEach(k-> System.out.println(k.getKey()));
        return -1;
    }

    private static int majorityElementInSortedArrayApproach2 (int[] arr, int element) {
        int beg=0;
        int end = arr.length-1;
        int mid =0;

        while(beg<=end){
              mid = (beg + end)/2;
            if(mid ==0 || arr[mid-1] < element && arr[mid]== element)
                return mid;
            if(arr[mid]<element)
                beg=mid+1;
            else
                end =mid-1;
        }
        return -1;
    }


    public static void main(String[] args){

        int arr[] = {3, 3, 3, 3, 3, 3, 4};

        System.out.println(majorityElementInSortedArray(arr));
        int x=3;

        // Find the leftmost Index
        int index = majorityElementInSortedArrayApproach2(arr, x);
        System.out.println(index);

        if(index ==-1){
            System.out.println("false");
        }else{
            if((index +arr.length/2) <= arr.length-1 && arr[index+arr.length/2]== x){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }

}
