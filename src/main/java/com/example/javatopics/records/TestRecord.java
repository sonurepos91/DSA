package com.example.javatopics.records;

import java.util.HashMap;
import java.util.Map;

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

    }

}
