package com.example.javatopics.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NthLargestElement {

    /*Min-Heap
    In a Min-Heap the key present at the root node must be less than or equal among the keys present at all of its children.
    The same property must be recursively true for all sub-trees in that Binary Tree.
    In a Min-Heap the minimum key element present at the root. Below is the Binary Tree that satisfies all the property of Min Heap.
    Element Removal takes Place at root  Element having low value has the highest priority */


    /*In a Max-Heap
    the key present at the root node must be greater than or equal among the keys present at all of its children.
    The same property must be recursively true for all sub-trees in that Binary Tree.
    In a Max-Heap the maximum key element present at the root. Below is the Binary Tree that satisfies all the property of Max Heap.
    Element having Highest value has largest priority */

    private static void NthLargest (int[] a, int k){
        //Max Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int temp= 0;

        for(int i=0;i< a.length;i++){
            queue.add(a[i]);
        }
        while(k>0){
            temp=queue.poll();
            k--;
        }
        System.out.println(temp);
    }

    private static void NthSmallest (int[] a, int k) {

        // Create a Min Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0;i<a.length;i++){
            queue.add(a[i]);
        }
        int temp =0;
        while(k>0){
            temp = queue.poll();
            k--;
        }
        System.out.println();
        System.out.println(temp + " ");
    }

    public static void main(String[] args)
    {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int k = 3;
        NthLargest(a,k);
        NthSmallest(a,k);
    }


}
