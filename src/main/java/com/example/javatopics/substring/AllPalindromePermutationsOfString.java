package com.example.javatopics.substring;

import java.util.HashSet;
import java.util.Set;

/*
All Pallindrome Permutations Of String Of Given Length
*/
public class AllPalindromePermutationsOfString {

    public static void main(String[] args) {
        String str = "aabbcadad";
        System.out.println("All palindrome permutations of "+ str);
        Set<String> set = new HashSet<>();

        printAllPossiblePalindromes(str,"",set);

        set.stream().forEach(k-> System.out.println(k));
    }

    private static void printAllPossiblePalindromes (String str, String result,Set<String> set) {
        if(str.length()==0){
            if(checkIfPallindrome(result)){
               set.add(result);
            }
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            String res = str.substring(0,i) + str.substring(i+1);
            printAllPossiblePalindromes(res,result+ch,set);
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
