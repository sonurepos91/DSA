package com.example.javatopics.slidingWindow.fixedSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctCharacters {

    public static void main (String[] args) {
        String s = "aaabbccd";
        int k = 2;

        int l = 0, r = 0;
        int maxLen = 0;
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {

            if (map.size() > k) {
                int temp = map.get(s.charAt(l));
                map.remove(s.charAt(l));
                l = temp;

            } else {
                map.put(s.charAt(r), map.get(s.charAt(r)) != null ? map.get(s.charAt(r)) + 1 : 1);
            }
            if (map.size() <= k) {
                if (end - start < r - l) {
                    start = l;
                    end = r;
                    maxLen = Math.max(maxLen, r - l + 1);
                }
            }
            r++;
        }
        for (int i = start; i <= end; i++) {
            System.out.print(s.charAt(i));
        }
        System.out.println();
        System.out.println(end - start + 1);
    }
}
