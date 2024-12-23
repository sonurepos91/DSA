package com.example.javatopics.tree;

import java.util.*;

import static com.example.javatopics.tree.BinaryTreeImpl.inOrderTraversal;

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

    private static int diameterOfTree (Node root) {
        if(root==null)
            return 0;
        // Compute the longest Path that goes through left and right subtree through root
        int l = heightOfTree(root.left);
        int r = heightOfTree(root.right);

        int lD = diameterOfTree(root.left);
        int rD = diameterOfTree(root.right);

        return Math.max(l+r+1,Math.max(lD,rD));

    }

    private static int heightOfTree (Node root) {
        if(root == null)
            return 0;
        return Math.max(heightOfTree(root.left),heightOfTree(root.right)) +1;
    }

    private static Node deleteGivenNode (Node root, int element) {
        if(root == null)
            return null;
        if(element< root.data)
            root.left=deleteGivenNode(root.left,element);
        else if(element>root.data){
            root.right=deleteGivenNode(root.right,element);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }
            if(root.right!=null && root.left==null ){
                Node temp = root.right;
                return temp;
            }
            if(root.left!=null && root.right==null ){
                Node temp = root.left;
                return temp;
            }
            if(root.left!=null && root.right!=null){
                // Get the smallest node after Moving One Node To the Right ::
                Node temp = getLowestNodeFromOneRightNode(root);
                root.data= temp.data;
                root.right= deleteGivenNode(root.right,temp.data);
            }
        }
        return root;
    }

    private static Node getLowestNodeFromOneRightNode (Node root) {
        Node temp = root.right;
        while(temp!=null && temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }


    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.right.right= new Node(20);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.left.right.left = new Node(7);
        root.left.right.left.left = new Node(6);

        System.out.println("Top View Of Tree ");
        topViewOfTree(root);
        System.out.println();
        System.out.println("Left View Of Tree ");
        leftViewOfTree(root);
        System.out.println();
        System.out.println("Right View Of Tree ");
        rightViewOfTree(root);
        System.out.println();
        System.out.println("Diameter Of Tree : ");
        System.out.println(diameterOfTree(root));
        System.out.println();
        System.out.println("Deletion In Binary Tree :");
        if(deleteGivenNode(root,5)!= null){
            System.out.println();
            System.out.println("InOrder Traversal : ");
            inOrderTraversal(root);
        }else{
            System.out.println("Node with Data : " + 20 + " does not exist :");
        }

    }

}
