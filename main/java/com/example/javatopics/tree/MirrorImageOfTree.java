package com.example.javatopics.tree;

import static com.example.javatopics.tree.BinaryTreeImpl.inOrderTraversal;

public class MirrorImageOfTree {

    private static Node mirrorImageOfTree(Node root){

        if(root ==null){
            return null;
        }
        Node left = mirrorImageOfTree(root.left);
        Node right = mirrorImageOfTree((root.right));

        root.left=right;
        root.right=left;
        return root;

    }

    public static void main(String[] args){


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder Traversal :");
        inOrderTraversal(root);

        System.out.println("Mirror Image Of Tree :");
        root = mirrorImageOfTree(root);

        System.out.println("Inorder Traversal :");
        inOrderTraversal(root);
    }
}
