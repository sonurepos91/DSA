package com.example.javatopics.slidingWindow.variableSizeWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){
        String s = "aabaab!bb";


        int l=0 ,r=0;
        int start =0, end =0;
        int maxLength =0;

        Map<Character,Integer> map = new HashMap<>();

        while(r< s.length()){

            if(map.containsKey(s.charAt(r))){
                if(map.get(s.charAt(r))>= l){
                    l = map.get(s.charAt(r)) +1;
                }
                map.put(s.charAt(r),r);
            }else{
                map.put(s.charAt(r),r);
            }
            maxLength = Math.max(maxLength, r-l+1);
          //  System.out.println(s.substring(l,l+maxLength));
            System.out.println("l is : " + l + " and r is : " + r);
            System.out.println(maxLength);
            r++;
        }


    }
}
