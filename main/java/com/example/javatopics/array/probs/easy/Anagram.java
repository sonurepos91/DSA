package com.example.javatopics.array.probs.easy;

import java.util.*;

public class Anagram {

    private static void findAllAnagrams (String[] arr) {
        Map<String,Set<String>> map = new HashMap<>();
        for(int i=0;i< arr.length;i++){
            String str = arr[i];
            Set<String> set = new HashSet<>();
            for(int j=i+1;j<arr.length;j++){
                if(str.length() == arr[j].length()){
                    char[] arr1= arr[j].toLowerCase().toCharArray();
                    char[] arr2= str.toLowerCase().toCharArray();
                    Arrays.sort(arr1);
                    Arrays.sort(arr2);
                    if(Arrays.equals(arr1,arr2)){
                        set.add(arr[i]);
                        set.add(arr[j]);
                        map.put(str,set);
                    }
                }
            }
        }
        map.forEach((k,v)-> System.out.println( k + " : " + v));
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
