package com.example.javatopics.maps;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MatchingWordFromDictionary {

    public static void main(String[] args){
        List<String> list = new ArrayList<>(Arrays.asList("act", "action","dog","cat"));
        String wordCombination = "nitonbcta";

        System.out.println(LongestWordFromDictionary(list,wordCombination));
    }

    private static String LongestWordFromDictionary (List<String> list, String word) {

        Collections.sort(list,(s1,s2)-> s2.length()-s1.length());
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<word.length();i++){
            map.put(word.charAt(i),map.get(word.charAt(i))!=null?map.get(word.charAt(i))+1:1);
        }

        AtomicInteger count = new AtomicInteger(0);
        AtomicBoolean isExists = new AtomicBoolean(true);
        String maxWord ="";
        for(String dictWord : list){
            HashMap<Character,Integer> map1 = new HashMap<>();
            while(count.get()<dictWord.length()){
                map1.put(dictWord.charAt(count.get()),map1.get(dictWord.charAt(count.get()))!=null?map1.get(dictWord.charAt(count.get()))+1:1);
                count.incrementAndGet();
            }
            count.set(0);
            map1.forEach((k,v)->{
                if(!(map1.get(k) <= map.get(k))){
                    isExists.set(false);
                }
            });
            if(isExists.get()){
                maxWord=dictWord;
                break;
            }
        }
        return maxWord;
    }
}
