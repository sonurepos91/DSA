package com.example.javatopics.ImmutableClasses;

import com.example.javatopics.records.TestRecord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestImmutability {

    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String, String> map = new HashMap<>();
        map.put("Code1","HR");
        Employee employee =
                new Employee("Sonu",13, Arrays.asList("99399786","9883124")
                        ,map,new Address("Sector-8","Bokaro"));

        System.out.println(employee);
        System.out.println("::::::::::::::::::::::::::::::::;;");

        // This violates immutability : So , should perform deep Copy
        employee.getMetadata().remove("Code1");
        // This also violates Immutability : So , should perform Clone on Address class
        employee.getAddress().setCity("Bengalore");
        // String Classes are already Immutable
        //employee.getPhoneNumbers().add("90890");

        System.out.println(employee);
        System.out.println("::::::::::::::::::Record in JAVA 14 ::::::::::::::;;");

        // Test Record in Java 14
        Map<String, String> map1 = new HashMap<>();
        map1.put("Code1","HR");
        TestRecord testRecord = new TestRecord("Megha",19,map1);
        System.out.println(testRecord);

        testRecord.metadata().put("Code2","CS");
        System.out.println(testRecord);
    }
}
