package DataStructure_and_Algo.DataStructure.Graph;

import java.util.Arrays;

public class KruskalAlgo {
	public static void main(String[] args) {
		int vertices = 6; // Number of vertices
	    int edges = 8; // Number of edges
	    Graph2 G = new Graph2(vertices, edges);

	    G.edge[0].src = 0;
	    G.edge[0].dest = 1;
	    G.edge[0].weight = 4;

	    G.edge[1].src = 0;
	    G.edge[1].dest = 2;
	    G.edge[1].weight = 4;

	    G.edge[2].src = 1;
	    G.edge[2].dest = 2;
	    G.edge[2].weight = 2;

	    G.edge[3].src = 2;
	    G.edge[3].dest = 3;
	    G.edge[3].weight = 3;

	    G.edge[4].src = 2;
	    G.edge[4].dest = 5;
	    G.edge[4].weight = 2;

	    G.edge[5].src = 2;
	    G.edge[5].dest = 4;
	    G.edge[5].weight = 4;

	    G.edge[6].src = 3;
	    G.edge[6].dest = 4;
	    G.edge[6].weight = 3;
	    
	    G.edge[7].src = 5;
	    G.edge[7].dest = 4;
	    G.edge[7].weight = 3;
	   
	    Graph2.Edge edge[]  = G.KruskalAlgo();
	    for(int i=0;i<edge.length-1;i++) {
	    	System.out.println(edge[i]);
	    }
	    
	    G.primsAlgo();
	    G.dijkstraAlgo(0);
	}

}

class Graph2{
	class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int weight;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

		@Override
		public String toString() {
			return "Edge  " + src + " - " + dest + " : " + weight;
		}
		
	}
	
	private int V;
	private int E;
	public Edge edge[];
	
	public Graph2(int V,int E) {
		this.V = V;
		this.E = E;
		edge  = new Edge[E];
		
		for (int i = 0; i < E; ++i) {
		      edge[i] = new Edge();
		  }
	}
	
	private int findParent(int parent[],int elm) {
		if(parent[elm] == -1)
			return elm;
		return findParent(parent,parent[elm]);
	}
	
	private void union(int parent[],int src,int dest) {
		parent[src] = dest;
	}
	
	public Edge[] KruskalAlgo() {
		Edge result[] = new Edge[V];
		for(int i=0;i<V;i++)
			result[i] = new Edge();
		
		int parent[] = new int[V];
		for(int i=0;i<parent.length;i++)
			parent[i] = -1;
		
		Arrays.sort(edge);
		int e = 0,i=0;
		
		while(e < V-1) {
			int x = findParent(parent, edge[i].src);
			int y = findParent(parent,edge[i].dest);
			
			if(x!=y) {
				union(parent,x,y);
				result[e++] = edge[i];
			}
			i++;
		}
		  
		return result;
	}

	public void primsAlgo() {
		int parent[] = new int[V];
		int key[] = new int[V];
		boolean visited[] = new boolean[V];
		
		for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
		key[0] = 0;
		parent[0] = -1;
		
		for(int i=0;i < V;i++) {
			int u = minKey(key, visited);
			visited[u] = true;
			
			for(int j=0;j<E;j++) {
				if(edge[j].src == u && visited[edge[j].dest]==false && edge[j].weight < key[edge[j].dest]) {
					parent[edge[j].dest] = u;
					key[edge[j].dest] = edge[j].weight;
				}
			}
		}
		
		 System.out.println("Edge \tWeight");
	     for (int i = 1; i < V; i++)
	    	 System.out.println(parent[i] + " - " + i + "\t");
	}

	private int minKey(int[] key, boolean[] visited) {
		int min = Integer.MAX_VALUE, min_index = -1;
		 
        for (int i = 0; i < V; i++)
            if (visited[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
 
        return min_index;
	}

	public void dijkstraAlgo(int src) {
		int distance[] = new int[V];
		boolean visited[] = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			distance[i] = Integer.MAX_VALUE;
			visited[i] = false;
        }
		distance[src] = 0;
		
		for (int i = 0; i < V - 1; i++) {
            int u = minDistance(distance, visited);
            visited[u] = true;
            
            for (int v = 0; v < V; v++)
                if (!visited[v] && edge[v].src == u && distance[u] != Integer.MAX_VALUE && distance[u] + edge[v].weight < distance[v])
                	distance[v] = distance[u] + edge[v].weight;
        }
		printSolution(distance);
	}

	private int minDistance(int[] distance, boolean[] visited) {
		int min = Integer.MAX_VALUE, min_index = -1;
		 
	    for (int v = 0; v < V; v++)
	    	if (visited[v] == false && distance[v] <= min) {
	    		min = distance[v];
	            min_index = v;
	         }
	 
	    return min_index;
	}
	
	void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
}
