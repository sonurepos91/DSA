package com.example.javatopics.graph;

/*
* Undirected Graph Adjacency Matrix Representation
* Directed Graph Adjacency Matrix Representation
* */
public class AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph {

    private int[][] adjMatrix;
    private int vertices;

    public AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph(int vertices){
        this.vertices = vertices;
        adjMatrix = new int[vertices+1][vertices+1];
    }

    private void addEdges (int i, int j) {

        adjMatrix[i][j]=1;
        adjMatrix[j][i]=1;
    }

    private void addEdgesToDirectedGraph (int i, int j) {
        adjMatrix[i][j]=1;
    }

    private void printAdjMatrix () {
        for( int i=0;i<=5;i++){
            System.out.println();
            for(int j=0;j<=5;j++){
                adjMatrix[i][j]= adjMatrix[i][j]==1?1:0;
                System.out.print(adjMatrix[i][j] + " ");
            }
        }
    }

    public static void main(String[] args){

        AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph graph = new AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph(5);

        graph.addEdges(1,2); graph.addEdges(1,3);
        graph.addEdges(2,5);graph.addEdges(2,4);
        graph.addEdges(5,4);
        graph.addEdges(4,3);

        System.out.println("UnDirected Graph Representation");
        graph.printAdjMatrix();

        AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph graph1 = new AdjacencyMatrixRepresentationForUndirectedAndDirectedGraph(5);

        graph1.addEdgesToDirectedGraph(1,2);
        graph1.addEdgesToDirectedGraph(2,5);
        graph1.addEdgesToDirectedGraph(4,2);
        graph1.addEdgesToDirectedGraph(5,4);
        graph1.addEdgesToDirectedGraph(4,3);
        graph1.addEdgesToDirectedGraph(3,1);

        System.out.println();
        System.out.println("Directed Graph Representation");

        graph1.printAdjMatrix();


    }

}
