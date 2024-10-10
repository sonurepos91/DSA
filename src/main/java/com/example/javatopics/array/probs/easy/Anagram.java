package com.example.javatopics.array.probs.easy;

import java.util.*;

public class Anagram {

    private static void findAllAnagrams (String[] arr) {

        Map<String, Set<String>> map = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            char ch[] = arr[i].toLowerCase().toCharArray();
            Set<String> set = new HashSet<>();
            for(int j=i+1;j< arr.length;j++){
               char ch1[] = arr[j].toLowerCase().toCharArray();
               if(ch.length!=ch1.length)
                   continue;
               else{
                   Arrays.sort(ch);
                   Arrays.sort(ch1);
                   if(Arrays.equals(ch,ch1)){
                        set.add(arr[i]);
                        set.add(arr[j]);
                        map.put(arr[i],set);
                   }
               }
            }
        }
        map.forEach((k,v)-> System.out.println(v) );
    }

    private static boolean checkAnagram (String str1, String str2) {

        if(str1.length()!=str2.length())
            return false;

        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1,arr2)){
            return true;
        }else
            return false;
    }

    public static void main(String[] args){
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(checkAnagram(str1,str2));
        System.out.println();

        String arr[] = {"geeksquiz", "geeksforgeeks",
                "abcd", "forgeeksgeeks",
                "zuiqkeegs"};
        findAllAnagrams(arr);

    }
}
