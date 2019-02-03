package com.shpig.graphlib;

public class Main {

	public static void main(String args[]) {
		// TODO Auto-generated constructor stub
		AdjacencyList<String, Integer> graph = new AdjacencyList<String,Integer>();
		
		graph.addVertex("Three", 3);
		graph.addVertex("Two", 2);
		graph.addVertex("One", 1);
		graph.addVertex("Four", 4);
        graph.addVertex("Five", 5);
		graph.addEdge("One", "Two");
        graph.addEdge("Two", "Three");
        graph.addEdge("One", "Four");
        graph.addEdge("Four", "Five");
		
		//Vertex<String, Integer> test = graph.getVertex("Three");
		//System.out.println(test.getValue());

        //System.out.println(graph.getVertex("One").getNeighbors()[0].getNeighbors()[0].getName());
        graph.simpleTraversal(new BFSStrategy<>(), c -> System.out.println(c.getName()), "One");
        System.out.println();
        graph.simpleTraversal(new DFSStrategy<>(), c -> System.out.println(c.getName()), "One");

    }

	
}
