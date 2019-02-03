package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface DirectedGraph<N extends Comparable<N>, T> {

    /**
     * Add a vertex with name and value to the graph, no edges will be connected to this vertex
     * 
     * @param label	
     * @param value 
     */
    void addVertex(N label, T value);
    
    /**
     * Remove a vertex given its name, the vertex is returned
     * 
     * @param label
     * @return
     */
    T removeVertex(N label);
    
    /**
     * Add an edge between two pre-existing vertices
     * 
     * @param start
     * @param end
     * @param weight
     */
    void addEdge(N start, N end, int weight);
    
    /**
     * Find a specific vertex given its name, the vertex is returned
     * 
     * @param label
     * @return
     */
    Node<N, T> getVertex(N label);
    
    /**
     * Get the value of a vertex given its name
     * 
     * @param label
     * @return
     */
    T getVertexValue(N label);
    
    /**
     * Set the value of a vertex
     * 
     * @param label
     * @param value
     * @return the previous value is returned
     */
    T setVertexValue(N label, T value);

    /**
     * Get the value of a edge given the two contacting vertices
     * 
     * @param start
     * @param end
     */
    void getEdgeValue(N start, N end);
    
    /**
     * Set the value of a edge given the two contacting vertices
     * @param start
     * @param end
     * @return the previous value is returned
     */
    int setEdgeValue(N start, N end);

    
    /**
     * Add an edge between two pre-existing vertices, weight is default to 0
     * 
     * @param start
     * @param end
     */
    default void addEdge(N start, N end) {
        addEdge(start, end, 0);
    }
}
