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
        //Min Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int temp= 0;

        for (int i = 0; i < a.length; i++) {
            queue.add(a[i]);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        System.out.println(queue.peek());
    }

    private static void NthSmallest (int[] a, int k) {

        // Create a Max Heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<a.length;i++) {
            queue.add(a[i]);

            if (queue.size() > k) {
                queue.remove();
            }
        }
        System.out.println(queue.peek() + " ");
    }

    public static void main(String[] args)
    {
        int a[] = { 5, 20, 10, 7, 1  };
        int k = 2;
        NthLargest(a,k);
        NthSmallest(a,k);
    }
}
