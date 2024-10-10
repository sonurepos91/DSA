package com.example.javatopics.binSearch.probs.easy;

public class BinarySearch {

    private static int findElementPosition (int[] arr, int x) {
        int beg = 0;
        int end = arr.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                beg = mid + 1;
            else
                end = mid - 1;
        }
        return -22;
    }

    public static void main (String[] args) {
        int[] arr = {-5, -2, 0, 1, 2, 4, 6, 7, 10};
        int x = -5;
        System.out.println(findElementPosition(arr, x));
    }
}
