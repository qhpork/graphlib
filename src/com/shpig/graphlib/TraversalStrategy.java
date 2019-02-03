package com.shpig.graphlib;

/**
 * Created by Cody on 4/02/2019.
 *
 * WIP
 */
public interface TraversalStrategy<T> {
    boolean add(T t);
    T remove();
    boolean isEmpty();
}
