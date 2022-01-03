package DataStructure_and_Algo.DataStructure.Graph;

public class GraphProblem {
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>();
		g.insertEdge(0, 1, true);
		g.insertEdge(1, 2, true);
		g.insertEdge(0, 3, true);
		g.insertEdge(1, 4, true);
		g.insertEdge(3, 6, true);
		g.insertEdge(4, 9, true);
		g.display();
		System.out.println("----------------");
		g.BFS(2);
		System.out.println("----------------");
		//System.out.println(g.isCycle());
		System.out.println("----------------");
		g.visitAll(2);
		System.out.println("----------------");
	}
}
