package DataStructure_and_Algo.DataStructure.Graph;

class Edge<T>{ 
	T src; 
	T dest; 
	int weight;

	public Edge(T src,T dest,int weight) { 
		this.src = src; this.dest = dest;
		this.weight = weight; 
	} 
}


public class GraphNode <T>{ 
	static class Node<T> { 
		T value; 
		int weight; 
		Node(T value, int weight) { 
			this.value = value; 
			this.weight = weight;
		} 
	};
}
