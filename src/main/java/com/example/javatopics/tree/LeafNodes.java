package com.example.javatopics.tree;

import static com.example.javatopics.tree.LevelOrderTraversal.insertNewNode;
/*
* Binary Tree Implementation
* PreOrder Traversal
* InOrder Traversal
* Post Order Traversal
* Count noOfLeafNodes
* Print leafNodes
* Count nodesWithOneChild
* PrintNodesWithOneChild
* PrintNodeWithTwoChild
* Count nodesWithTwoChild
* Count Total nodesCount
* Height of Tree
* PrintLargestNode
* PrintSmallestNode
* Sum Of All Nodes
* MaximumPathSum
* Level Order Traversal
* Mirror Image Of Tree
* Top View Of Tree
* Left View Of Tree
* Right View Of Tree
* Search Element In BST
* GreaterSumTree
* LowerSumTree
* */
public class LeafNodes {
    private static int totalNodes;
    private static int maxSum;

    static {
        totalNodes=0;
        maxSum= Integer.MIN_VALUE;
    }
    private static int noOfLeafNodes (Node root) {
        // Calculate the Total No of Leaf Nodes + Total No Of Right Nodes
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1 ;
        return noOfLeafNodes(root.left) + noOfLeafNodes(root.right);
    }
    private static void leafNodes (Node root) {
        if(root==null)
            return;
        if(root.left==null && root.right ==null)
            System.out.print(root.data + " ");
        leafNodes(root.left);
        leafNodes(root.right);
    }
    private static int nodesWithOneChild (Node root) {
        if(root==null){
            return 0;
        }if(root.left!=null && root.right==null){
            return 1 + nodesWithOneChild(root.left);
        }if(root.right!=null && root.left==null){
            return 1 + nodesWithOneChild(root.right);
        }return nodesWithOneChild(root.left) + nodesWithOneChild(root.right);
    }
    private static void PrintNodesWithOneChild (Node root) {
        if(root == null)
            return;
        if(root.left!=null && root.right==null || root.right!=null && root.left==null){
            System.out.print(root.data + " ");
        }
        PrintNodesWithOneChild(root.left);
        PrintNodesWithOneChild(root.right);
    }
    private static void PrintNodeWithTwoChild (Node root) {
        if(root==null)
            return;
        if(root.left!=null && root.right!=null)
            System.out.print(root.data + " ");
        PrintNodeWithTwoChild(root.left);
        PrintNodeWithTwoChild(root.right);
    }
    private static int nodesWithTwoChild (Node root) {
        if(root == null)
            return 0;
        if(root.left!=null && root.right!=null){
            return 1 + nodesWithTwoChild(root.left) + nodesWithTwoChild(root.right);
        }else
            return nodesWithTwoChild(root.left) + nodesWithTwoChild(root.right);
    }
    private static int nodesCount(Node root){
        if(root!=null){
            totalNodes++;
            nodesCount(root.left);
            nodesCount(root.right);
        }
        return totalNodes;
    }
    private static int nodesCountApproach2 (Node root) {
        if(root ==null)
            return 0;


        return nodesCountApproach2(root.left) + nodesCountApproach2(root.right) + 1;
    }
    private static int printLargestNode (Node root) {
        if(root.right==null){
            return root.data;
        }
        return printLargestNode(root.right);
    }
    private static int printSmallestNode (Node root) {
        if(root.left==null){
            return root.data;
        }
        return printSmallestNode(root.left);
    }
    private static int sumOfAllNodesInBST(Node root){
        if(root==null)
            return 0;
        return root.data + sumOfAllNodesInBST(root.left) + sumOfAllNodesInBST(root.right);
    }
    private static int maximumSumInGivenPath (Node root) {
        int[] arr = new int[1];
        arr[0]= Integer.MIN_VALUE;
        maxSumPath(root,arr);
        return arr[0];
    }

    private static int maxSumPath (Node root, int[] arr) {
        if(root == null)
            return 0;

        // Calculate the maximum path sum
        // for the left and right subtrees ignoring the negative node
        int leftSum = Math.max(0,maxSumPath(root.left,arr));
        int rightSum = Math.max(0,maxSumPath(root.right,arr));

        // Update the overall maximum
        // path sum including the current node ( Calculating each curve maximum)
        arr[0] = Math.max(arr[0],leftSum+rightSum+root.data);
        System.out.print(root.data + " ");

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return Math.max(leftSum,rightSum)+ root.data;
    }

    public static void main(String[] args) {

        Node root = null;

       /* root = insertNewNode(root,50);
        root = insertNewNode(root,40);
        root = insertNewNode(root,30);
        root = insertNewNode(root,20);
        root = insertNewNode(root,10);
        root = insertNewNode(root,45);
        root = insertNewNode(root,48);
        root = insertNewNode(root,70);
        root = insertNewNode(root,80);
        root = insertNewNode(root,75);
        root = insertNewNode(root,65);*/

        root = insertNewNode(root, -10);
        root = insertNewNode(root, 9);
        root = insertNewNode(root, 20);
        root = insertNewNode(null, 20);
        root = insertNewNode(null, 20);
        root = insertNewNode(root, 15);
        root = insertNewNode(root, 7);


        System.out.println("No Of Leaf Nodes : ");
        System.out.println(noOfLeafNodes(root));
        System.out.println("Print Leaf Nodes : ");
        leafNodes(root);
        System.out.println();
        System.out.println("Total No Of Nodes with One Child ");
        System.out.println(nodesWithOneChild(root));
        System.out.println("Nodes with One One Child ");
        PrintNodesWithOneChild(root);
        System.out.println();
        System.out.println("Nodes with Two Child ");
        PrintNodeWithTwoChild(root);
        System.out.println();
        System.out.println("Count Nodes with two Child");
        System.out.println(nodesWithTwoChild(root));
        System.out.println();
        System.out.println("Total No Of Nodes");
        System.out.println(nodesCount(root));
        System.out.println("Total No Of Nodes");
        System.out.println(nodesCountApproach2(root));
        System.out.println("Smallest Node ");
        System.out.println(printSmallestNode(root));
        System.out.println("Largest Node ");
        System.out.println(printLargestNode(root));
        System.out.println();
        System.out.println("Sum of All Nodes : ");
        System.out.println(sumOfAllNodesInBST(root));
        System.out.println();
        System.out.println("Maximum Sum for A Tree In Given Path");
        System.out.println("Max Sum for Path " + maximumSumInGivenPath(root));
        System.out.println("Top View Of Tree ");
    }



}
