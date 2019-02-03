package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public class LinkedGraph<N extends Comparable<N>, T> implements DirectedGraph<N, T>, Node<N, T> {
    @Override
    public Node[] getNeighbors() {
        return new Node[0];
    }

    @Override
    public int[] getWeights() {
        return new int[0];
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public N getName() {
        return null;
    }
}
