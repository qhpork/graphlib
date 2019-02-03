package com.shpig.graphlib;

public class Main {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		AdjacencyList<String, Integer> graph = new AdjacencyList<String,Integer>();
		
		graph.addVertex("Three", 3);
		graph.addVertex("Two", 2);
		graph.addVertex("One", 1);
		
		Vertex<String, Integer> test = graph.getVertex("Three");
		System.out.printf(test.getName().toString());
		
		
	}

	
}
