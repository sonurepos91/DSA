package com.example.javatopics.stack;

import java.util.Stack;
/*
 Approach 1 : Implement a Stack Using Linked List and the reverse By Using Iteration
 */
public class ReverseStackWithoutUsingStack {

    Node head ;

    ReverseStackWithoutUsingStack(){
        this.head=null;
    }
    private void push (int element) {
        Node newNode = new Node<>(element);

        newNode.next=this.head;
        this.head=newNode;
    }
    private  void reverseStack () {
        Node curr = this.head;
        Node prev =null;
        Node next = null;

        while(curr!=null){
            next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

    }


    public static void main(String[] args) {
        ReverseStackWithoutUsingStack obj = new ReverseStackWithoutUsingStack();

        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);

        obj.reverseStack();

        System.out.println(obj.peek());
    }

    private int peek () {
        return (int)this.head.data;
    }


}


