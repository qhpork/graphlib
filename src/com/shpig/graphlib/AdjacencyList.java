package com.shpig.graphlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Cody on 3/02/2019.
 */
public class AdjacencyList<N extends Comparable<N>, T> implements DirectedGraph<N, T> {
	
	private ArrayList<Vertex> list;
	private HashMap<N, Vertex> mapping;
	
	public AdjacencyList() {
		list = new ArrayList<>();
		mapping = new HashMap<>();
	}
	
//	public AdjacencyList(ArrayList<Vertex> list) {
//		this.list = list;
//		mapping = new HashMap<N, Vertex>();
//		for (Vertex v : list) {
//			mapping.put(v.getName(), v);
//		}
//	}

    @Override
    public void addVertex(N name, T value) {
    	Vertex v = new Vertex(name, value);
    	list.add(v);
    	mapping.put(name, v);
    }

    @Override
    public T removeVertex(N name) {
    	T value;
       	for (Vertex v : list) {
      
       		v.removeEdge(name);

       		if (v.getName().equals(name)) {
       			value = v.getValue();
       			list.remove(v);
       			mapping.remove(name);
       			return value;
       		}
       	}
       	return null;
    }

    @Override
    public com.shpig.graphlib.Vertex<N, T> getVertex(N name) {
    	return mapping.get(name);
    }


    class Vertex implements com.shpig.graphlib.Vertex<N, T> {
    	
    	private N name;
    	private T value;
    	private com.shpig.graphlib.Vertex<N, T>[] adj_vertices;
    	private int[] adj_edges;
    	
    	public Vertex(N name, T value) {
    		this.name = name;
    		this.value = value;
    		adj_vertices = new com.shpig.graphlib.Vertex[0]; 
    		adj_edges = new int[0];
    	}
    	
    	public Vertex(Vertex v, N name) {
    		if (v.getGraph() != getGraph())
    			throw new RuntimeException("Tried to copy vertex from different graph");
    		this.name = name;
    		value = v.getValue();
    		adj_vertices =  v.getNeighbors();
    		adj_edges = v.getEdgeValues();
    	}
    	
    	public Vertex(Vertex v, T value) {
    		if (v.getGraph() != getGraph())
    		    throw new RuntimeException("Tried to copy vertex from different graph");
    		name = v.getName();
    		this.value = value;
    		adj_vertices =  v.getNeighbors();
    		adj_edges = v.getEdgeValues();
    	}
    	
        @Override
        public com.shpig.graphlib.Vertex<N, T>[] getNeighbors() {
            return Arrays.copyOf(adj_vertices, adj_vertices.length);
        }
        
        @Override
		public boolean isNeighbourOf(N name) {
            boolean isNeighbour = false;
            for(com.shpig.graphlib.Vertex v : adj_vertices) {
            	if (v.getName() == name) {
            		isNeighbour = true;
            	}
            }
            return isNeighbour;
        }

        @Override
        public int[] getEdgeValues() {
        	return Arrays.copyOf(adj_edges, adj_edges.length);
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public T setValue(T value) {
            return this.value = value;
        }

        @Override
        public N getName() {
            return name;
        }

        @Override
        public int getEdgeValue(N end) {
        	for(int i = 0; i<adj_edges.length; i++) {
        		if (adj_vertices[i].getName().equals(end)) {
        			return adj_edges[i];
        		}
        	}
            return 0;
        }
        
        @Override
		public int getSmallestEdgeValue(N end) {
        	int smallest = Integer.MAX_VALUE;
        	for(int i = 0; i<adj_edges.length; i++) {
        		if (adj_vertices[i].getName().equals(end) && adj_edges[i] < smallest) {
        			smallest = adj_edges[i];
        		}
        	}
        	return smallest;
        }
        
        @Override
		public int getBiggestEdgeValue(N end) {
        	int biggest = Integer.MIN_VALUE;
        	for(int i = 0; i<adj_edges.length; i++) {
        		if (adj_vertices[i].getName().equals(end) && adj_edges[i] > biggest) {
        			biggest = adj_edges[i];
        		}
        	}
        	return biggest;
        }

        @Override
        public int setEdgeValue(N end, int weight) {
        	int prev = 0;
        	for(int i = 0; i<adj_edges.length; i++) {
        		if (adj_vertices[i].getName().equals(end)) {
        			prev = adj_edges[i];
        			adj_edges[i] = weight;
        		}
        	}
        	return prev;
        }

        @Override
        public void addEdge(com.shpig.graphlib.Vertex<N, T> end, int weight) {
        	if (end.getGraph() == this.getGraph()) {
            	adj_vertices = Arrays.copyOf(adj_vertices, adj_vertices.length+1);
            	adj_vertices[adj_vertices.length-1] = end;
            	
            	adj_edges = Arrays.copyOf(adj_edges, adj_edges.length+1);
            	adj_edges[adj_edges.length-1] = weight;
        	} else throw new RuntimeException("Tried to add edge from different graph");

        }
        
        @Override
        public void removeEdge(N name) {
        	int size = 0;
        	
        	for(int i = 0; i<adj_vertices.length; i++) {
        		if( adj_vertices[i].getName().equals(name) ) {
					adj_vertices[i] = null;
        		} else {
        			size++;
				}
        	}

			com.shpig.graphlib.Vertex<N, T>[] new_vertices = new com.shpig.graphlib.Vertex[size];
        	int[] new_weights = new int[size];
        	int j = 0;
			for (int i = 0; i < adj_vertices.length; i++) {
				if (adj_vertices[i] != null) {
					new_vertices[j] = adj_vertices[i];
					new_weights[j] = new_weights[i];
				}
			}
			adj_vertices = new_vertices;
			adj_edges = new_weights;
		}

        @Override
        public DirectedGraph<N, T> getGraph() {
            return AdjacencyList.this;
        }
    }
}
