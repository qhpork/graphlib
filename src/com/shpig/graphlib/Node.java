package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface Node<N extends Comparable<N>, T> {

    /**
     * Get all the neighbouring nodes of this node
     * @return an array of all the nodes this node is connected to
     */
    Node[] getNeighbors();

    /**
     * Gets all the weights of the edges leaving this node,
     * the returned array is parallel to the array returned by
     * {@link #getNeighbors() getNeighbors()} and hence the ith weight in
     * the returned array corresponds to the edge connecting this node and the ith
     * node returned by {@link #getNeighbors() getNeighbors()}
     * @return The parallel array of edge weights
     */
    int[] getEdgeValues();

    /**
     * Get the value stored in this node
     * @return the value stored in this node
     */
    T getValue();

    /**
     * Set the value of this node
     * @param value the value to set
     * @return the old value stored in this node
     */
    T setValue(T value);

    /**
     * Get the name of the this node
     * @return the name of this node
     */
    N getName();

    /**
     * Get the weight of the edge starting at this node and finishing at "end"
     * @param end the end point of the target edge
     */
    int getEdgeValue(N end);

    /**
     * Set the weight of the edge starting at this node and finishing at "end"
     * @param end the end point of the target edge
     * @param weight the new weight
     * @return the old weight of the edge
     */
    int setEdgeValue(N end, int weight);

    /**
     * Add an edge connecting this node and the node specified by "end"
     * @param end the node to connect the edge to
     * @param weight the weight of the new edge
     */
    void addEdge(Node<N, T> end, int weight);

    /**
     * Get the graph this node belongs to
     * @return the graph this node belongs
     */
    DirectedGraph<N, T> getGraph();

    /**
     * Add an edge connecting this node and the node specified by "end",
     * with a weight of 0
     * @param end the node to connect the edge to
     */
    default void addEdge(Node<N, T> end) {
        addEdge(end, 0);
    }

    /**
     * Add an edge connecting this node and the node specified by "end",
     * with a weight of 0
     * @param end the node to connect the edge to
     */
    default void addEdge(N end) {
        addEdge(end, 0);
    }

    /**
     * Add an edge connecting this node and the node specified by "end"
     * @param end the node to connect the edge to
     * @param weight the weight of the new edge
     */
    default void addEdge(N end, int weight) {
        addEdge(getGraph().getVertex(end), weight);
    }
}
