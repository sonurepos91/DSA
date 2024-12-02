package com.example.javatopics.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraphRepresentation {

    public static void main(String[] args){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i =0;i<=5;i++){
            adj.add(new ArrayList<Integer>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(4).add(3);
        adj.get(3).add(4);


        for(int i=0;i< adj.size();i++){
            System.out.println();
            System.out.print(i + " : ");
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + ",");
            }
        }

    }
}
