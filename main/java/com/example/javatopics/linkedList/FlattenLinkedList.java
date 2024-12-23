package com.example.javatopics.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.javatopics.linkedList.LinkedListImpl.linkedListCreation;
import static com.example.javatopics.linkedList.LinkedListImpl.linkedListTraversal;

public class FlattenLinkedList {

    static class Node{
        int data;
        Node next;
        Node bottom;

        Node(int data){
            this.data=data;
            this.next=null;
            this.bottom=null;
        }
    }

    private static com.example.javatopics.linkedList.Node flattenList (Node head) {
        if(head==null)
            return null;
        List<Integer> list = new ArrayList<>();
        com.example.javatopics.linkedList.Node newNode = null;
        Node temp = head;

        while(temp!=null){

            list.add(temp.data);
            Node temp2 = temp.bottom;

            while(temp2!=null){
                list.add(temp2.data);
                temp2= temp2.bottom;
            }
            temp=temp.next;
        }
        Collections.sort(list);
        for(Integer element : list){
            newNode = linkedListCreation(newNode,element);
        }
        return newNode;
    }

    public static void main(String[] args){

        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);

        com.example.javatopics.linkedList.Node head1 =null;
        head1 = flattenList(head);

        System.out.println();
        System.out.println("Linked List Traversal : ");
        linkedListTraversal(head1);

        System.out.println();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);

        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }
}
