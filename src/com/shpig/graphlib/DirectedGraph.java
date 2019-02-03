package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public interface DirectedGraph<N extends Comparable<N>, T> {

    /**
     * Add a vertex with name and value to the graph, no edges will be connected to this vertex
     * 
     * @param label	name of vertex
     * @param value value stored in vertex
     */
    void addVertex(N label, T value);
    
    /**
     * Remove a vertex given its name
     * 
     * @param label	name of the vertex to be removed
     * @return the vertex to be removed
     */
    T removeVertex(N label);
    
    /**
     * Add an edge between two pre-existing vertices
     * 
     * @param start	the first vertex for the edge to attach to
     * @param end	the other vertex for the edge to attach to
     * @param weight	the weight of the edge added
     */
    default void addEdge(N start, N end, int weight) {
        getVertex(start).addEdge(end, weight);
    }
    
    /**
     * Find a specific vertex given its name, the vertex is returned
     * 
     * @param label	name of the vertex to be found
     * @return
     */
    Node<N, T> getVertex(N label);
    
    /**
     * Get the value of a vertex given its name
     * 
     * @param label name of the required vertex
     * @return	the value of the vertex
     */
    default T getVertexValue(N label) {
        return getVertex(label).getValue();
    }
    
    /**
     * Set the value of a vertex
     * 
     * @param label name of the vertex
     * @param value	value to set the vertex as
     * @return the previous value is returned
     */
    default T setVertexValue(N label, T value) {
        return getVertex(label).setValue(value);
    }

    /**
     * Get the value of a edge given the two contacting vertices
     * 
     * @param start	the first vertex attached to the edge 
     * @param end	the other vertex attached to the edge
     */
    default int getEdgeValue(N start, N end) {
        return getVertex(start).getEdgeValue(end);
    }
    
    /**
     * Set the value of a edge given the two contacting vertices
     * 
     * @param start	the first vertex attached to the edge 
     * @param end	the other vertex attached to the edge
     * @param weight the new weight
     * @return the previous value is returned
     */
    default int setEdgeValue(N start, N end, int weight) {
        return getVertex(start).setEdgeValue(end, weight);
    }
    
    /**
     * Add an edge between two pre-existing vertices, weight is default to 0
     * 
     * @param start the first vertex for the edge to be attached to
     * @param end	the other vertex for the edge to be attached to
     */
    default void addEdge(N start, N end) {
        addEdge(start, end, 0);
    }
}
