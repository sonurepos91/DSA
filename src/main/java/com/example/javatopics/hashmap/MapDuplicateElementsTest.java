package com.example.javatopics.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MapDuplicateElementsTest {

    public static void main (String[] args) {
        int[] nums = {1, 3, 4, 2, 2};

        Map<Integer, Integer> map1 = new HashMap<>();

        map1.put(nums[0], 1);

        for (int i = 1; i < nums.length; i++) {
            map1.put(nums[i], map1.get(nums[i]) != null ? map1.get(nums[i]) + 1 : 1);
        }

        AtomicInteger keys = new AtomicInteger();
        map1.forEach((key, value) -> {
            if (value > 1)
                keys.set(key);
        });

        System.out.println(keys.get());

    }
}
