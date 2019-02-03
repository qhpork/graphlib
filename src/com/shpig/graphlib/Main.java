package com.shpig.graphlib;

public class Main {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		AdjacencyList<String, Integer> graph = new AdjacencyList<String,Integer>();
		
		graph.addVertex("Three", Integer.parseInt("3"));
		graph.addVertex("Two", Integer.parseInt("2"));
		graph.addVertex("One", Integer.parseInt("1"));
		
		Vertex<String, Integer> test = graph.getVertex("Three");
		System.out.printf(test.getName().toString());
		
		
	}

	
}
