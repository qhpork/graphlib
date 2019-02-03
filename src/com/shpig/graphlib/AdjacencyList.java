package com.shpig.graphlib;

/**
 * Created by Cody on 3/02/2019.
 */
public class AdjacencyList<N extends Comparable<N>, T> implements DirectedGraph<N, T> {

    @Override
    public void addVertex(N label, T value) {

    }

    @Override
    public T removeVertex(N label) {
        return null;
    }

    @Override
    public com.shpig.graphlib.Vertex<N, T> getVertex(N label) {
        return null;
    }


    class Vertex implements com.shpig.graphlib.Vertex<N, T> {
        @Override
        public com.shpig.graphlib.Vertex[] getNeighbors() {
            return new com.shpig.graphlib.Vertex[0];
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
        public int getEdgeValue(N end) {
            return 0;
        }

        @Override
        public int setEdgeValue(N end, int weight) {
            return 0;
        }

        @Override
        public void addEdge(com.shpig.graphlib.Vertex<N, T> end, int weight) {

        }

        @Override
        public DirectedGraph<N, T> getGraph() {
            return AdjacencyList.this;
        }
    }
}
