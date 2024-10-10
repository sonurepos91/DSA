package com.example.javatopics.tree;

import java.util.*;

public class ViewOfTree {

    private static void topViewOfTree (Node root) {

        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        if(root==null)
            return;
        else
            queue.add(new QueueObj(root,0));
        while(!queue.isEmpty()){
            QueueObj tmpNode = queue.poll();
            if(!topViewMap.containsKey(tmpNode.hd)){
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }
            if(tmpNode.node.left!=null){
                queue.add(new QueueObj(tmpNode.node.left,tmpNode.hd-1));
            }
            if(tmpNode.node.right!=null){
                queue.add(new QueueObj(tmpNode.node.right,tmpNode.hd+1));
            }
        }
        topViewMap.forEach((k,v) -> System.out.print(v.data + " "));

    }

    private static void leftViewOfTree (Node root){

        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer,Node> leftViewMap = new HashMap<>();

        if(root==null)
            return;
        else
            queue.add(new QueueObj(root,0));
        while(!queue.isEmpty()){
            QueueObj tempNode1 =   queue.poll();
            if(!leftViewMap.containsKey(tempNode1.hd)){
                leftViewMap.put(tempNode1.hd,tempNode1.node);
            }
            if(tempNode1.node.left !=null){
                queue.add(new QueueObj(tempNode1.node.left,tempNode1.hd+1));
            }
            if(tempNode1.node.right !=null){
                queue.add(new QueueObj(tempNode1.node.right,tempNode1.hd+1));
            }
        }

        leftViewMap.forEach((k,v)-> System.out.print(v.data + " "));
    }

    private static void rightViewOfTree(Node root){

        Queue<QueueObj> queue = new LinkedList<>();
        Map<Integer,Node> rightViewMap = new HashMap<>();

        if(root== null)
            return;
        else
            queue.add(new QueueObj(root,0));
        while(!queue.isEmpty()){
            QueueObj tempNode = queue.poll( );
            if(!rightViewMap.containsKey(tempNode.hd)){
                rightViewMap.put(tempNode.hd, tempNode.node);
            }
            if(tempNode.node.right!=null){
                queue.add(new QueueObj(tempNode.node.right,tempNode.hd+1));
            }if(tempNode.node.left!=null){
                queue.add(new QueueObj(tempNode.node.left,tempNode.hd+1));
            }
        }
        rightViewMap.forEach((k,v)-> System.out.print(v.data + " "));
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);




        System.out.println("Top View Of Tree ");
        topViewOfTree(root);
        System.out.println();
        System.out.println("Left View Of Tree ");
        leftViewOfTree(root);
        System.out.println();
        System.out.println("Right View Of Tree ");
        rightViewOfTree(root);
    }
}
