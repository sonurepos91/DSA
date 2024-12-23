package com.example.javatopics.binSearch.probs.easy;

public class CountOccurrenceOfGivenElement {

    private static int countOccurenceOfGivenElement (int[] arr, int x) {
        int beg =0;
        int end = arr.length-1;
        int mid =0;
        while (beg<=end){
            mid = (beg+end)/2;
            if(mid == arr.length-1 || mid ==0 || arr[mid] == x && arr[mid-1]< x)
                return mid;
            if(arr[mid] < x)
                beg=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    private static int countLastOccurenceOfGivenElement (int[] arr, int x) {

        int beg =0;
        int end = arr.length-1;
        int mid =0;
        while (beg<=end){
            mid = (beg+end)/2;
            if(mid == arr.length-1 || mid ==0 || arr[mid] == x && arr[mid+1] > x)
                return mid;
            if(arr[mid] > x )
                end=mid-1;
            else
                beg=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {1, 1, 1, 4, 4, 4,4, 5, 6, 7, 7};
        // first occurence of 0 to find : returned by mid
        int index = countOccurenceOfGivenElement(arr, 7);
        int lastIndex = countLastOccurenceOfGivenElement(arr, 7);
        System.out.println(lastIndex-index +1);

    }

}
