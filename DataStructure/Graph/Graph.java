package DataStructure_and_Algo.DataStructure.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph<T extends Comparable<T>> {
	private Map<T,LinkedList<T>> graph = new HashMap<>();
	private Map<T,LinkedList<Map<T,Integer>>> weightedGraph = new HashMap<>();
	
	public void insertVertex(T vertex) {
		graph.put(vertex, new LinkedList<T>());
	}
	
	public void insertEdge(T source,T dest,boolean bi_directional) {
		if(!graph.containsKey(source))
			insertVertex(source);
		
		if(!graph.containsKey(dest))
			insertVertex(dest);
		
		graph.get(source).add(dest);
		
		if(!bi_directional)
			graph.get(dest).add(source);
	}
	
	public void display() {
		for( Map.Entry<T,LinkedList<T>> edge: graph.entrySet()) {
			System.out.print(edge.getKey()+" >");
			for(T v : edge.getValue()) {
				System.out.print(" "+v);
			}
			System.out.println();
		}
	}
	
	public void BFS(T vertex) {
		Queue<T> vertex_list = new LinkedList<>();
		Map<T,Boolean> visited = new HashMap<>();
		
		vertex_list.add(vertex);
		visited.put(vertex, true);
		
		while(!vertex_list.isEmpty()) {
			// Dequeue a vertex from the queue and display it.
			T v = vertex_list.poll();
			System.out.println(v);
			
			// Get all adjacent vertices of the dequeued vertex u.
			for(T edge: graph.get(v)) {
				 // If an adjacent vertex has not been visited, then mark it visited and enqueue it
				if(!visited.getOrDefault(edge,false)) {
					vertex_list.add(edge);
					visited.put(edge, true);
				}
			}
		}
	}
	
	/*
	 * Only change from BFS is Queue is changed to Stack
	 */
	public void DFS(T vertex,Map<T,Boolean> visited) {
		Stack<T> vertex_list = new Stack<>(); 
		//Map<T,Boolean> visited = new HashMap<>();
		
		vertex_list.push(vertex);
		visited.put(vertex, true);
		
		while(!vertex_list.isEmpty()) {
			// Dequeue a vertex from the queue and display it.
			T v = vertex_list.pop();
			System.out.println(v);
			
			// Get all adjacent vertices of the dequeued vertex u.
			for(T edge: graph.get(v)) {
				 // If an adjacent vertex has not been visited, then mark it visited and enqueue it
				if(!visited.getOrDefault(edge,false)) {
					vertex_list.push(edge);
					visited.put(edge, true);
				}
			}
		}
	}
	
	/*
	 * Visit All vertex in Directed Graph
	 */
	public void visitAll(T vertex) {
		Map<T,Boolean> visited = new HashMap<>();
		DFS(vertex,visited);
		System.out.println(visited);
		for( Map.Entry<T,LinkedList<T>> edge: graph.entrySet()) {
			if(!visited.containsKey(edge.getKey()))
				DFS(edge.getKey(),visited);
		}
	}
	
	/*
	 * 
	 */
	public boolean isCycle() {
		int parent[] = new int[graph.size()];
		
		for(int i=0;i<parent.length;i++)
			parent[i] = -1;
		
		for( Map.Entry<T,LinkedList<T>> edge: graph.entrySet()) {
			int x = findParent(parent,(int)edge.getKey());
			for(T v : edge.getValue()) {
				int y = findParent(parent,(int)v);
				if(x==y)
					return true;
				union(parent,x,y);
			}
		}
		
		return false;
	}
	
	private int findParent(int parent[],int elm) {
		if(parent[elm] == -1)
			return elm;
		return findParent(parent,parent[elm]);
	}
	
	private void union(int parent[],int src,int dest) {
		parent[src] = dest;
	}
	
}
