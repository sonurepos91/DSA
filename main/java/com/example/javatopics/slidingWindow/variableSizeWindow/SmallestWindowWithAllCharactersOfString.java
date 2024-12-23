package com.example.javatopics.slidingWindow.variableSizeWindow;

import java.util.*;
import java.util.stream.Collectors;

public class SmallestWindowWithAllCharactersOfString {


    // When the map size is = set size we sort out on basis of Map , Value as it contains the index of Key
    public static void main(String[] args){
        String str =  "aabcbcdbca";


        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        int k = set.size();

        int l=0,r=0;
        int start =0,end=0;

        while(r< str.length()){

                map.put(str.charAt(r),r);
                if(map.size()==k){
                    List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
                    start = collect.get(0).getValue();
                    end = collect.get(collect.size()-1).getValue();
                }
                r++;
        }

        System.out.println("start is : " + start + " end is : " + end);
        System.out.println("Smallest Window is : " + (end -start + 1) + " and substring is " + str.substring(start,end+1));
    }
}
