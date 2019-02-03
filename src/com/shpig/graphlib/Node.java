package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface Node<N extends Comparable<N>, T> {
    Node[] getNeighbors();
    int[] getEdgeValues();
    T getValue();
    N getName();
    void getEdgeValue(N end);
    int setEdgeValue(N end);
    void addEdge(Node<N, T> end, int weight);
    DirectedGraph<N, T> getGraph();


    default void addEdge(Node<N, T> end) {
        addEdge(end, 0);
    }
    default void addEdge(N end) {
        addEdge(end, 0);
    }
    default void addEdge(N end, int weight) {
        addEdge(getGraph().getVertex(end), weight);
    }
}
