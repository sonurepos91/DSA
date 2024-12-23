package com.example.javatopics.binSearch.probs.easy;

public class FindIfPeekElementIsPresent {

    private static int findPeak (int[] arr) {

        int beg = 0;
        int end = arr.length-1;
        int mid=0;

        while(beg<=end){
            mid = (beg +end)/2;
            if(mid==0 || mid == arr.length-1 || arr[mid] >= arr[mid-1] && arr[mid]>= arr[mid+1])
                return mid;
            if(arr[mid+1]>arr[mid])
                beg=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args){

        int arr[] = { 10, 20, 15, 2, 23, 90, 90 };
        // Output : 20
        int index = findPeak(arr);
        if(index!=-1){
            System.out.println( "Index of a peak point is " + arr[index]);
        }else{
            System.out.println("No Index : ");
        }

    }


}
