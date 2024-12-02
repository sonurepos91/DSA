package com.example.javatopics.slidingWindow.variableSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingAllCharactersOfOtherString {

    public static void main(String[] args){

        String s = "ddaaabbca";
        String p = "abc";

        String result = findSmallestSubstring(s, p);

        if (!result.isEmpty()) {
            System.out.println(result);
        }
        else {
            System.out.println(-1);
        }
    }

    private static String findSmallestSubstring (String str1, String str2) {

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i< str2.length();i++){
            map.put(str2.charAt(i),map.get(str2.charAt(i))!=null?map.get(str2.charAt(i))+1:1);
        }

        int k = str2.length();
        int count =0;
        int minLength = Integer.MAX_VALUE;
        int l = 0,r=0;
        int start=0;

        while(r< str1.length()) {


            if (map.containsKey(str1.charAt(r))  && map.get(str1.charAt(r))>0) {
                map.put(str1.charAt(r),map.get(str1.charAt(r))-1);
                count++;
            } else {
                map.put(str1.charAt(r), map.get(str1.charAt(r)) != null ? map.get(str1.charAt(r)) - 1 : -1);
            }

            while(count== k){
                minLength= Math.min(minLength,r-l+1);
                if(map.containsKey(str1.charAt(l))){
                    map.put(str1.charAt(l), map.get(str1.charAt(l)) + 1);
                    if(map.get(str1.charAt(l))>0){
                        count--;
                    }
                }else {
                    map.put(str1.charAt(l), map.get(str1.charAt(l)) -1);
                }
                start=l;
                l++;

            }
            r++;
        }



        return str1.substring(start,start+minLength);
    }
}
