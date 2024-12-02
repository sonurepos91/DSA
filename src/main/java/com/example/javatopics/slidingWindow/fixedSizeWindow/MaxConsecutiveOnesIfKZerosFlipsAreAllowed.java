package com.example.javatopics.slidingWindow.fixedSizeWindow;

public class MaxConsecutiveOnesIfKZerosFlipsAreAllowed {

    public static void main (String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        // Question Transforms to Subarray with max 2 zeros

        int l = 0, r = 0;
        int maxlen = 0;
        int zeroCount = 0;

        while (r < arr.length) {

            if (arr[r] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (arr[l] == 0) {
                    zeroCount--;
                }
                l++;
            }
            if (zeroCount <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        System.out.println(maxlen);
    }
}
