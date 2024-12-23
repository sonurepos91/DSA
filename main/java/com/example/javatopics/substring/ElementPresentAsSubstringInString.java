package com.example.javatopics.substring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
Print all strings in the given array that occur as the substring in the given string
*/
public class ElementPresentAsSubstringInString {

    private static void isSubstr (String str, List<String> list) {

        boolean isPresent = false;

        for(int i=0;i< list.size();i++){
            if(str.contains(list.get(i))){ // contains check in O(n) time // is implemented with the help of index() function
                System.out.println(list.get(i));
                isPresent=true;
            }
        }
        if(!isPresent){
            System.out.println(-1);
        }
    }


    public static void main(String[] args){

        List<String> list = new ArrayList<>(Arrays.asList("aa", "bb", "cc"));
        String Str = "abcd";

        isSubstr(Str, list);
    }

}
