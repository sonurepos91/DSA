package com.example.javatopics.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl {

    private static Node insertNode (Node root, int element) {

        if(root == null){
            return new Node(element);
        }
        if(element<root.data){
            root.left=insertNode(root.left,element);
        }else{
            root.right=insertNode(root.right,element);
        }
        // Always point to the top root element
        return root;
    }
    static void preOrderTraversal (Node root) {
        if(root== null)
            return;
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
    }
    private static void postOrderTraversal (Node root) {
        if(root!=null){
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
    static void inOrderTraversal (Node root) {
        if(root!=null){
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args){
        Node root =null;

        int[] arr = {50,30,40,70};
        for(int i=0;i<arr.length;i++){
            root = insertNode(root,arr[i]);
        }
        // root is always the top root element
        // DFS (Depth First Traversal includes : PreOrder , PostOrder and InOrder Traversals )
        System.out.println("preOrderTraversal");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("postOrderTraversal");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("inOrderTraversal Always Gives Binary Tree In Sorted Order :: ");
        inOrderTraversal(root);
        System.out.println();
    }


}

