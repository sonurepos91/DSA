package com.example.javatopics.hashmap;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private int rollNo;
    private String name;

    public Student (int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo==student.rollNo && name.equals(student.name);
    }

    @Override
    public int hashCode () {
        Object a[]={rollNo,name};
        if( a== null)
            return 0;
        int result =1;
        for(Object element : a){
            result = result * 29 + (element==null?0: element.hashCode());
        }
        return result;
    }

    public static void main(String[] args){
        Map<Student,Integer> map = new HashMap<>();
        Student obj1 = new Student(1, "Sonu");
        Student obj2 = new Student(2,"Sonu");
        map.put(obj1,1);
        map.put(obj2,2);

        System.out.println(map.size());
        System.out.println(map.get(obj1));


    }
}
