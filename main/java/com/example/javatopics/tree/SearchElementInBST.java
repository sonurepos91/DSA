package com.example.javatopics.tree;

import static com.example.javatopics.tree.LevelOrderTraversal.insertNewNode;

public class SearchElementInBST {

    private static void findElementInBST (Node root, int element) {

        if(root == null)
            return;
            if (root.data == element) {
                System.out.println(root.data);
            }
            if (element < root.data) {
                findElementInBST(root.left, element);
            } else
                findElementInBST(root.right, element);

    }

    private static int HeightOfTree (Node root) {
        if (root == null)
            return 0;
        int l = HeightOfTree(root.left);
        int r = HeightOfTree(root.right);
        return Math.max(l,r) + 1;
        //return Math.max(HeightOfTree(root.left), HeightOfTree(root.right)) + 1;
    }

    public static void main (String[] args) {
        Node root = null;
        root = insertNewNode(root, 50);
        root = insertNewNode(root, 40);
        root = insertNewNode(root, 30);
        root = insertNewNode(root, 35);
        root = insertNewNode(root, 20);
        root = insertNewNode(root, 10);
        root = insertNewNode(root, 32);
        root = insertNewNode(root, 70);
        root = insertNewNode(root, 80);
        root = insertNewNode(root, 75);

        findElementInBST(root, 80);
        System.out.println("Height of Tree : ");
        System.out.println(HeightOfTree(root));
    }


}
