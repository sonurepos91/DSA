package com.example.javatopics.queue;

public class QueueImpl {

    Node front;
    Node rear;

    QueueImpl(){
        this.front=null;
        this.rear=null;
    }

    private void enQueue (int element) {
        Node newnode = new Node(element);

        if(front == null && rear==null){
            front =newnode;
            rear= newnode;
            return;
        }
       rear.next= newnode;
        rear = newnode;
    }

    private boolean isEmpty () {
        return front == null ? true:false;
    }

    private int getFront () {
        if(isEmpty()){
            System.out.println("Queue is Empty : ");
            return Integer.MIN_VALUE;
        }
        return this.front.data;
    }

    private void deQueue () {

        if(isEmpty()){
            System.out.println("Queue is Empty : ");
            return;
        }
        Node temp = front;
        front = temp.next;
        temp = null;
    }



    public static void main(String[] args){
        QueueImpl obj = new QueueImpl();
        obj.enQueue(5);
        obj.enQueue(15);
        obj.enQueue(55);
        obj.enQueue(552);

        System.out.println(obj.isEmpty());

        System.out.println(obj.getFront());

        obj.deQueue();
        obj.deQueue();
        obj.deQueue();

        System.out.println(obj.isEmpty());

        System.out.println(obj.getFront());
    }


}
