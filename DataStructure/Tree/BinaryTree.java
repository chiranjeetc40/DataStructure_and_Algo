package DataStructure_and_Algo.DataStructure.Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int value;
	Node left;
	Node right;
	
	Node(){}
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
	
	public void insertBFS(int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			Node temp = new Node(data);
			Node empty_node = BFS(root);
			System.out.println("Empty"+empty_node.value);
			if(empty_node.left==null)
				empty_node.left = temp;
			else
				empty_node.right = temp;
		}
	}
	
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
	
	
	public void displayBFS(Node root) {
		if(root == null)
			return;
		//System.out.print(root.value+" ");  // pre order Traversal
		displayBFS(root.left);
		//System.out.print(root.value+" ");  // In order Traversal
		displayBFS(root.right);
		System.out.print(root.value+" ");  // post order Traversal
	}
	
	//level order
	public void displayQueue(Node root) {
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);
		while(!nodes.isEmpty()) {
			Node tmp = nodes.poll();
			if(tmp!=null)
				System.out.print(tmp.value+ " ");
			if(tmp.left!=null)
				nodes.add(tmp.left);
			if(tmp.right!=null)
				nodes.add(tmp.right);
		}
		System.out.println();
	}
	
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
	
	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.right = new Node(8);
        root.right.left = new Node(15);
        
		
        BinaryTree b = new BinaryTree(root);
		b.insertQueue(55);
		b.displayQueue(root);
		b.displayBFS(root);
		
		
	}
}

/*
 * 				1
 * 			11			9
 * 		7		55	15	 	8
 */
