package com.shpig.graphlib;

/**
 * Created by Cody on 4/02/2019.
 *
 * Depth first search TraversalStrategy
 */
public class DFSStrategy<T> extends java.util.Stack<T> implements TraversalStrategy<T> {
    @Override
    public T remove() {
        return pop();
    }
}
