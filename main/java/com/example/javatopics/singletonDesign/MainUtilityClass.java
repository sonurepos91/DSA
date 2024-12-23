package com.example.javatopics.singletonDesign;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class MainUtilityClass {

    public static void main (String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
        SingletonDesign obj1 = SingletonDesign.getInstance();
        SingletonDesign obj2 = SingletonDesign.getInstance();

        System.out.println(obj1.hashCode() == obj2.hashCode());

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        switch (input) {
            case "Reflection":
                breakSingletonViaReflection();
                break;
            case "Serialization":
                breakViaSerialization();
                break;
            case  "Cloneable":
                breakViaClone();
                break;
            default:
        }
    }

    private static void breakViaClone () throws CloneNotSupportedException {
        SingletonDesign obj1 = SingletonDesign.getInstance();
        Object obj2 = obj1.clone();
        System.out.println(obj1.hashCode()==obj2.hashCode());
    }

    private static void breakViaSerialization () throws IOException, ClassNotFoundException {


        SingletonDesign instanceOne = SingletonDesign.getInstance();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(instanceOne);
            byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);

        ObjectInputStream in = new ObjectInputStream(bis);
        SingletonDesign test22 = (SingletonDesign)in.readObject();

        System.out.println("hashCode of instance 1 is - " + instanceOne.hashCode());
        System.out.println("hashCode of instance 2 is - " + test22.hashCode());

        System.out.println(instanceOne.hashCode() == test22.hashCode());
    }

    private static void breakSingletonViaReflection () throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        SingletonDesign obj3 = SingletonDesign.getInstance();
        SingletonDesign obj4 = null;

        Constructor<SingletonDesign> constructor = SingletonDesign.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        obj4 = constructor.newInstance();

        System.out.println(obj3.hashCode() == obj4.hashCode());
    }
}
