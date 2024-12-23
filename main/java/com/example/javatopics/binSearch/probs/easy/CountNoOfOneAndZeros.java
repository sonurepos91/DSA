package com.example.javatopics.binSearch.probs.easy;

public class CountNoOfOneAndZeros {

    private static int countZeroes (int[] arr, int element) {
        int beg =0;
        int end= arr.length-1;
        int mid =0;

        while(beg<=end){
            mid = (beg+end)/2;
            if(mid == 0 || arr[mid] == element && arr[mid-1] ==1)
                return mid;
            if(arr[mid]==1)
                beg = mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = {1, 1, 0, 0, 0, 0, 0, 0};
        // first occurence of 0 to find : returned by mid
        int index = countZeroes(arr,0);
        if(index !=-1){
            System.out.println(arr.length-index);
        }
    }
}
