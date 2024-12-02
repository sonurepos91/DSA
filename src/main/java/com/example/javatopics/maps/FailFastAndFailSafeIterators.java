package com.example.javatopics.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastAndFailSafeIterators {

    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);

        // This will concurrentModification Exception , and this is fail-fast Iterator
        map.forEach((k,v)->{
            map.remove(k);
        });

        Map<Integer,Integer> map1= new ConcurrentHashMap<>();

        map1.put(1,2);
        map1.put(2,2);
        map1.put(3,2);

        // This will Not give  concurrentModification Exception , and this is fail-safe Iterator
        map1.forEach((k,v)->{
            map1.remove(k);
        });

    }
}
