package com.example.javatopics.records;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record TestRecord(String name , int id , Map<String,String> metadata){

    public TestRecord(String name , int id){
        this(name,id,null);
    }

    public Map<String,String> metadata(){
        return new HashMap<>(metadata);
    }
    public static void main(String[] args){
        TestRecord t1 = new TestRecord("jj",3);
        System.out.println(t1.name);

        String t21 = "test" +
                "test"+
                "'test'"+
                "\"test\"";
        System.out.println(t21);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        numbers.stream().filter(n->n%2==0).mapToInt(Integer::intValue).summaryStatistics().getMin();

        // Program To Print Even and Odd Numbers Using Stream

        Stream.iterate(2, i->i+1).limit(10).forEach(t->{
            System.out.println(t);
        });


    }

}
