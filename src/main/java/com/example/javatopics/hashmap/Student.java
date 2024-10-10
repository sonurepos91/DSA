package com.example.javatopics.hashmap;

public class Student {

    private Long rollNo;
    private String name;

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNo.equals(student.rollNo) && name.equals(student.name);
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
}
