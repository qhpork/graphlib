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
		list = new ArrayList<Vertex>();
		mapping = new HashMap<N, Vertex>();
	}
	
	public AdjacencyList(ArrayList<Vertex> list) {
		this.list = list;
		mapping = new HashMap<N, Vertex>();
		for (Vertex v : list) {
			mapping.put(v.getName(), v);
		}
	}

    @Override
    public void addVertex(N name, T value) {
    	list.add(new Vertex(name, value));
    	mapping.put(name, new Vertex(name, value));
    }

    @Override
    public T removeVertex(N name) {
    	T value;
       	for (Vertex v : list) {
       		if (v.isNeighbourOf(name)) {
       			v.removeEdge(name);
       		}
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
    	private com.shpig.graphlib.Vertex[] adj_vertices;
    	private int[] adj_edges;
    	
    	public Vertex(N name, T value) {
    		name = this.name;
    		value = this.value;
    		adj_vertices = new com.shpig.graphlib.Vertex[0]; 
    		adj_edges = new int[0];
    	}
    	
    	public Vertex(Vertex v, N name) {
    		this.name = name;
    		value = v.getValue();
    		adj_vertices =  v.getNeighbors();
    		adj_edges = v.getEdgeValues();
    	}
    	
    	public Vertex(Vertex v, T value) {
    		name = v.getName();
    		this.value = value;
    		adj_vertices =  v.getNeighbors();
    		adj_edges = v.getEdgeValues();
    	}
    	
        @Override
        public com.shpig.graphlib.Vertex[] getNeighbors() {
            return Arrays.copyOf(adj_vertices, adj_vertices.length);
        }
        
        @Override
		public boolean isNeighbourOf(N name) {
            boolean isNeighbour = false;
            for(com.shpig.graphlib.Vertex v:adj_vertices) {
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
        	}

        }
        
        @Override
        public void removeEdge(N name) {
        	int j = 0;
        	com.shpig.graphlib.Vertex[] temp_vertices = new com.shpig.graphlib.Vertex[adj_vertices.length-1];
        	int[] temp_edges = new int[adj_edges.length-1];
        	
        	for(int i = 0; i<adj_vertices.length; i++) {
        		if( !adj_vertices[i].getName().equals(name) ) {
        			temp_vertices[j] = adj_vertices[i];
        			temp_edges[j] = adj_edges[i];
        			j++;
        		}
        	}
        }

        @Override
        public DirectedGraph<N, T> getGraph() {
            return AdjacencyList.this;
        }
    }
}
