package com.example.javatopics.stack;
/*
    Implement Stack Using Linked List
 */
public class StackImpl<T> {

    Node head;

    StackImpl(){
        this.head=null;
    }

    private boolean isEmpty () {
        return this.head==null? true:false;
    }

    private void push (T element) {
        Node newNode = new Node(element);
        if(newNode== null){
            throw new memoryAllocationException("Stack OverFLow Error");
        }
        newNode.next=this.head;
        this.head=newNode;
    }

    private T pop () {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Stack UnderFlow error ");
        }
        Node temp = this.head;
        Object data = temp.data;
        this.head= temp.next;
        temp= null;
        return (T) data;
    }
    private T peek () {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Stack UnderFlow error ");
        }
        return (T) this.head.data;
    }

    public static void main(String[] args){

        StackImpl stack = new StackImpl();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
