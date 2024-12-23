package com.example.javatopics.tree;

import static com.example.javatopics.tree.BinaryTreeImpl.inOrderTraversal;

public class GreaterSumTree {

    private static  int currentSum;
    private static int nodesSum;
    private static int smallerTreeSum;

    static{
        currentSum=0;
        nodesSum=0;
        smallerTreeSum=0;
    }

    private static void greaterSumTree (Node root, int sum) {
        if (root != null) {
            greaterSumTree(root.left, sum);
            if (root.data == sum) {
                root.data = 0;
            }
            else {
                currentSum = currentSum + root.data;
                root.data = sum - currentSum;
            }
            greaterSumTree(root.right, sum);
        }
    }


    private static int sumOfNodes (Node root) {
        if(root==null)
            return 0;
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    private static void greaterSumTreeApproach2 (Node root) {
        if(root==null)
            return;
        greaterSumTreeApproach2(root.right);
        nodesSum = nodesSum + root.data;
        root.data = nodesSum -root.data;
        greaterSumTreeApproach2(root.left);
    }

    private static void smallerSubTree (Node root) {
        if(root== null)
            return;
        smallerSubTree(root.left);
        smallerTreeSum = smallerTreeSum + root.data;
        root.data= smallerTreeSum;
        smallerSubTree(root.right);
    }

    public static void main(String[] args){

        Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);

        inOrderTraversal(root);
        System.out.println();
        System.out.println("Greater Sum Tree :");
        int sum = sumOfNodes(root);
        greaterSumTree(root,sum);
        inOrderTraversal(root);

        Node root1 = new Node(11);
        root1.left = new Node(2);
        root1.right = new Node(29);
        root1.left.left = new Node(1);
        root1.left.right = new Node(7);
        root1.right.left = new Node(15);
        root1.right.right = new Node(40);
        root1.right.right.left = new Node(35);

        System.out.println();
        System.out.println("Greater Sum Tree Approach 2");
        greaterSumTreeApproach2(root1);
        System.out.println();
        inOrderTraversal(root1);

        Node root2 = new Node(9);
        root2.left = new Node(6);
        root2.right = new Node(15);
        System.out.println("Smaller Sub Tree ");
        System.out.println();
        inOrderTraversal(root2);
        smallerSubTree(root2);
        System.out.println();
        inOrderTraversal(root2);
    }




}
