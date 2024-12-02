package com.example.javatopics.array.probs.easy;

import java.util.Arrays;

public class MinimumPlatformsRequired {

    public static void main (String[] args) {
        int arr[] = { 100, 300, 500 };
        int dep[] = { 900, 400, 600 };
        System.out.println(findPlatform(arr, dep));
    }

    private static int findPlatform (int[] arr, int[] dep) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int current_min_platforms_required = 0;
        int max_platforms=0;
        int i = 0, j = 0;

        while (i < arr.length && j < dep.length) {
            if (arr[i] < dep[j]) {
                current_min_platforms_required++;
                i++;

            } else {
                current_min_platforms_required--;
                j++;
            }
            max_platforms= Math.max(current_min_platforms_required,max_platforms);

        }
        return max_platforms;
    }
}
