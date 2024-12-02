package com.example.javatopics.substring;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumLengthPalindromeInString {

    public static void main(String[] args)
    {
        String str = "abcbab";
        Set<String> set = new HashSet<>();
        numberOfPossiblePalindrome(str, "",set);
        AtomicInteger maxLength = new AtomicInteger(0);

        set.stream().forEach(k-> System.out.println(k));
    }

    private static void numberOfPossiblePalindrome (String str, String result, Set<String> set) {

        if(str.length()==0){
            if(checkIfPallindrome(result)){
               set.add(result);
            }
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            String res = str.substring(0,i) + str.substring(i+1);
            numberOfPossiblePalindrome(res,result+ch,set);
        }
    }

    private static boolean checkIfPallindrome (String result) {

        for(int i=0,j=result.length()-1;i<j;i++,j--){
            if(!(result.charAt(i)==result.charAt(j))){{
                return false;
            }}
        }
        return true;
    }
}
