package com.dsa.graphs;

public class Runner {

    public static void main(String[] args) {

        Runner runner = new Runner();
        runner.bfs();
    }

    private void bfs() {

        UndirectedGraphNode A = new UndirectedGraphNode(1);
        UndirectedGraphNode B = new UndirectedGraphNode(2);
        UndirectedGraphNode C = new UndirectedGraphNode(3);
        UndirectedGraphNode D = new UndirectedGraphNode(4);
        UndirectedGraphNode E = new UndirectedGraphNode(5);
        UndirectedGraphNode F = new UndirectedGraphNode(6);

        A.getNeighbors().add(A);
        A.getNeighbors().add(B);
        A.getNeighbors().add(D);

        B.getNeighbors().add(A);
        B.getNeighbors().add(C);

        C.getNeighbors().add(B);
        C.getNeighbors().add(D);
        C.getNeighbors().add(E);
        C.getNeighbors().add(F);

        D.getNeighbors().add(A);
        D.getNeighbors().add(C);

        E.getNeighbors().add(F);
        E.getNeighbors().add(C);

        F.getNeighbors().add(C);
        F.getNeighbors().add(E);

        CloneGraph cloneGraph = new CloneGraph();
        cloneGraph.bfs(A);

    }
}
