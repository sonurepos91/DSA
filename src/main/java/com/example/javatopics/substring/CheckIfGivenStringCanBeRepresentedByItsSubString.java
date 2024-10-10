package com.example.javatopics.substring;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class CheckIfGivenStringCanBeRepresentedByItsSubString {

    private static boolean checkSubString (String str) {

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.get(str.charAt(i))!=null?map.get(str.charAt(i))+1 : 1);
        }

        int value = map.get(str.charAt(0));
        AtomicBoolean isValid = new AtomicBoolean(true);

        map.forEach((k,v)->{
            if(value !=v){
                isValid.set(false);
            }
        });
        return isValid.get();
    }

    public static void main(String[] args) {
        String str1 = "abcabcabc";


        System.out.println(checkSubString(str1));
    }
}
