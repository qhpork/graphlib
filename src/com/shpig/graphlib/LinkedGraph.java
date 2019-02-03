package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public class LinkedGraph<N extends Comparable<N>, T> implements DirectedGraph<N, T> {

    @Override
    public void addVertex(N label, T value) {
        
    }

    @Override
    public T removeVertex(N label) {
        return null;
    }

    @Override
    public Node<N, T> getVertex(N label) {
        return null;
    }
}
