package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface Node<N extends Comparable<N>, T> {
    Node[] getNeighbors();
    T getValue();
    N getName();
    void getEdgeValue(N end);
    int setEdgeValue(N end);
}
