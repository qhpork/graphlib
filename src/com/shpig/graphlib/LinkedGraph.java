package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public class LinkedGraph<N extends Comparable<N>, T> implements DirectedGraph<N, T>, Node<N, T> {

    //DirectedGraph methods
    @Override
    public void addVertex(N label, T value) {

    }

    @Override
    public T removeVertex(N label) {
        return null;
    }

    @Override
    public void addEdge(N start, N end, int weight) {

    }

    @Override
    public Node<N, T> getVertex(N label) {
        return null;
    }

    @Override
    public T getVertexValue(N label) {
        return null;
    }

    @Override
    public T setVertexValue(N label, T value) {
        return null;
    }

    @Override
    public void getEdgeValue(N start, N end) {

    }

    @Override
    public int setEdgeValue(N start, N end) {
        return 0;
    }

    //Node methods

    @Override
    public Node[] getNeighbors() {
        return new Node[0];
    }

    @Override
    public int[] getEdgeValues() {
        return new int[0];
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public T setValue(T value) {
        return null;
    }

    @Override
    public N getName() {
        return null;
    }

    @Override
    public void getEdgeValue(N end) {

    }

    @Override
    public int setEdgeValue(N end, int weight) {
        return 0;
    }

    @Override
    public void addEdge(Node<N, T> end, int weight) {

    }

    @Override
    public DirectedGraph<N, T> getGraph() {
        return null;
    }
}
