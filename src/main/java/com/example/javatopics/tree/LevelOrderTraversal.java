package com.example.javatopics.tree;


import java.util.LinkedList;
import java.util.Queue;

import static com.example.javatopics.tree.BinaryTreeImpl.preOrderTraversal;

public class LevelOrderTraversal {

    protected static Node insertNewNode (Node root, int element) {
        if(root == null){
            return new Node(element);
        }
        if(element< root.data)
            root.left= insertNewNode(root.left,element);
        else
            root.right= insertNewNode(root.right,element);
        return root;
    }

    private static void levelOrderTraversal (Node root) {
        if(root== null)
            return;
            Queue<Node>  queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if(curr.left!=null){
                    queue.add(curr.left);
                }if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
    }


    public static void main(String[] args){

        Node root = null;
        root = insertNewNode(root,50);
        root = insertNewNode(root,40);
        root = insertNewNode(root,30);
        root = insertNewNode(root,45);
        root = insertNewNode(root,48);
        root = insertNewNode(root,70);
        root = insertNewNode(root,80);
        root = insertNewNode(root,75);

        System.out.println("PreOrder Traversal :  ");
        preOrderTraversal(root);

        System.out.println();
        System.out.println("Level  Traversal :  ");
        levelOrderTraversal(root);
    }
}
