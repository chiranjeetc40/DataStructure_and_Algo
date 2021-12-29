package DataStructure_and_Algo.DataStructure.Tree;

import java.util.List;
import java.util.Optional;

public class TreeProblem {
	public static void longestPathSum(Node root) {
		
	}
	
	/*
	 * Two condition is there for each node:
	 * 	 Select root and it's grandChild  (root.data + root.left.left + root.left.right +root.right.left+root.right.left 
	 *   Select child:  root.left + root.right
	 *   
	 *   Memoization, DP can be done
	 */
	public static int maxSumNonAdjNode(Node root) {
		if(root==null)
			return 0;
		int root_inc = root.value;
		if(root.left!=null)
			root_inc += maxSumNonAdjNode(root.left.left) + maxSumNonAdjNode(root.left.right);
		if(root.right!=null)
			root_inc += maxSumNonAdjNode(root.right.left) + maxSumNonAdjNode(root.right.right);
		
		int root_exc = maxSumNonAdjNode(root.left) + maxSumNonAdjNode(root.right);
		return Math.max(root_inc, root_exc);
	}
		
	public static boolean isSumTree(BinaryTree b) {
		return false;
	}
	
	public int largestCyclePossible(Node root,int max_height,int level) {
		return 0;
	}

	
	public static void main(String[] args) {
		
		Node root = new Node(1);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.left.left = new Node(2);
        root.right = new Node(9);
        root.right.right = new Node(8);
        root.right.left = new Node(15);
        root.right.left.left = new Node(3);
        root.right.left.left = new Node(9);
        root.right.left.left.left = new Node(9);
        root.right.left.left.left.left = new Node(9);
		
        BinaryTree b = new BinaryTree(root);
		b.insertQueue(55);
		
		b.displayQueue();
		b.display(root);
		System.out.println("");
		System.out.println("DFS Stack Inorder");
		b.displayInOrder();
		//System.out.println("DFS Stack PostOrder");
		//b.displayPostOrder(root);
		System.out.println("------------");
		
		BinaryTree b1 = new BinaryTree(new Node(10));
		b1.insert(8);
		b1.insert(1);
		b1.insert(1);
		
		b1.display(b1.root);
		System.out.println("------------");
		if(TreeProblem.isSumTree(b1))
			System.out.println("Sum Tree");
		else
			System.out.println("Not a sum tree");
		System.out.println("------------");
		
		Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);
        
        root1.left.left.left = new Node(8);
        root1.left.left.right = new Node(9);
        root1.left.right.left = new Node(10);
        root1.left.left.left.left = new Node(11);
		
		System.out.println(TreeProblem.maxSumNonAdjNode(root1));
		System.out.println(new BinaryTree(root1).height());
		
	}

}

/*
 * 				1
 * 			11			9
 * 		7		55	15	 	8
 * 	2             3
 * 		        9	   
 */


