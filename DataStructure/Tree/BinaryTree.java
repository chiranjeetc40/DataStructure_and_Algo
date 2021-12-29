package DataStructure_and_Algo.DataStructure.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


class Node{
	int value;
	Node left;
	Node right;

	Node(int value){
		this.value = value;
		left = null;
		right = null;
	}
}

public class BinaryTree {
	Node root;
	
	BinaryTree(Node root){
		this.root = root;
	}
	
	/*
	 * Using BFS
	 */
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			Node temp = new Node(data);
			Node empty_node = BFS(root);

			if(empty_node.left==null)
				empty_node.left = temp;
			else
				empty_node.right = temp;
		}
	}
	/*
	 * return empty node not having both child Using BFS
	 */
	public Node BFS(Node root) {
		Node n;
		if(root.left == null || root.right == null)
			return root;
		else {
			n = BFS(root.left);
			n = BFS(root.right);
		}
		return n;
	}
	
	/*
	 * Inorder (Left, Root, Right) 
	 * Preorder (Root, Left, Right)  
	 * Postorder (Left, Right, Root)
	 * 
	 * Using recursion
	 */
	public void display(Node root) {
		if(root == null)
			return;
		//System.out.print(root.value+" ");  // preorder Traversal
		display(root.left);
		//System.out.print(root.value+" ");  // Inorder Traversal
		display(root.right);
		System.out.print(root.value+" ");  // postorder Traversal
	}
	
	/*
	 * Inorder & Preorder using Iteration
	 */
	public void displayInOrder() {
		Stack<Node> nodes = new Stack<>();
		Node curr_node = root;

		while(curr_node != null || !nodes.isEmpty()) {
			while(curr_node != null) {
				//System.out.print(tmp.value+" "); //PreOrder
				nodes.push(curr_node);
				curr_node = curr_node.left;
			}
			curr_node = nodes.pop();
			
			System.out.print(curr_node.value+" "); //InOrder
			curr_node = curr_node.right;
		}
		System.out.println();
	}
	
	public void displayPostOrder() {
		Stack<Node> nodes = new Stack<>();
		Stack<Node> right_node = new Stack<>();
		Node tmp = root;

		while(tmp!=null || !nodes.isEmpty()) {
			while(tmp!=null) {
				nodes.push(tmp);
				tmp = tmp.left;
			}
			tmp = nodes.pop();
			
			if(tmp.left==null)
			
			tmp = tmp.right;
			right_node.push(tmp);
		}
		
		System.out.println();
	}
	
	/*
	 * BFS or Level order Traversal using Queue or Iteration 
	 */
	public List<Integer> displayQueue() {
		Queue<Node> nodes = new LinkedList<>();
		List<Integer> values = new LinkedList<>();
		
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node tmp = nodes.poll();
			if(tmp!=null) {
				System.out.print(tmp.value+ " ");
				values.add(tmp.value);
			}
			if(tmp.left!=null)
				nodes.add(tmp.left);
			if(tmp.right!=null)
				nodes.add(tmp.right);
		}
		System.out.println();
		return values;
	}
	
	/*
	 *Insert Node using Queue/Iteration 
	 */
	public void insertQueue(int data) {
		Node new_node = new Node(data);
		
		if(root == null) {
			root = new_node;
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(! q.isEmpty()) {
			Node temp = q.poll();
			if(temp.left == null) {
				temp.left = new_node;
				break;
			}
			else
				q.add(temp.left);
			if(temp.right == null) {
				temp.right = new_node;
				break;
			}
			else
				q.add(temp.right);	
		}
		
	}
	
	public void delete(int data) {
		
	}
	
	public int height() {
		return heightRecu(this.root,0,0);
	}
	private int heightRecu(Node root,int max_height,int level) {
		if(root==null)
			return level;
		int h1 = heightRecu(root.left,max_height,level+1);
		int h2 = heightRecu(root.right,max_height,level+1);
		h1 = h1>h2?h1:h2;
		max_height = max_height>h1?max_height:h1;
		return max_height;
	}
	
}
