package com.example.javatopics.singletonDesign;

import java.io.Serializable;

public class SingletonDesign implements Serializable ,Cloneable{

    private static volatile SingletonDesign instance = null;

    private SingletonDesign () {
        // Ensure Reflection Does Not Break Singleton Class Design
        if (instance != null) {
            throw new IllegalStateException("Instance of Singleton Class Already exists");
        }
    }

    public static SingletonDesign getInstance () {
        if (instance == null) {
            synchronized (SingletonDesign.class) {
                if (instance == null) {
                    instance = new SingletonDesign();
                }
            }
        }
        return instance;
    }

    // Ensure that deserialization does not create a new instance
    public Object readResolve () {
        return instance;
    }

    //To Ensure clone method does not crete a new Object for Singleton Object
    public Object clone () throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
