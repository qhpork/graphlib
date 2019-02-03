package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface DirectedGraph<N extends Comparable<N>, T> {

    void addVertex(N label, T value);
    T removeVertex(N label);
    void addEdge(Node<N, T> start, Node<N, T> end, int weight);
    void addEdge(N start, N end, int weight);
    Node<N, T> getVertex(N label);
    T getVertexValue(N label);
    T setVertexValue(N label, T value);

    void getEdgeValue(N start, N end);
    int setEdgeValue(N start, N end);


    default void addEdge(Node<N, T> start, Node<N, T> end) {
        addEdge(start, end, 0);
    }
    default void addEdge(N start, N end) {
        addEdge(start, end, 0);
    }
}
