package com.example.javatopics.stack;

public class Node<T> {
    T data;
    Node next;

    Node (T data){
        this.data=data;
        this.next=null;
    }
}
