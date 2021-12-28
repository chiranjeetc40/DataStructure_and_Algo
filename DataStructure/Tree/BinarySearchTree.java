package DataStructure_and_Algo.DataStructure.Tree;

public class BinarySearchTree<T extends Comparable<T>> {
	class Node<V>{
		V key;
		Node<V> left,right;
		
		public Node(V key) {
			super();
			this.key = key;
		}
	}
	
	Node<T> root;
	
	public void put(T key) {
		this.root = insert(this.root,key);
	}
	
	private Node<T> insert(Node<T> root,T key) {
		if(root==null) {
			root = new Node<T>(key);
			return root;
		}
		if(root.key.compareTo(key) > 0)
			root.left = insert(root.left,key);
		else
			root.right = insert(root.right,key);
		
		return root;
	}
	
	public void inorderTraverse(Node<T> root) {
		if(root == null)
			return;
		//System.out.print(root.value+" ");  // pre order Traversal
		inorderTraverse(root.left);
		System.out.print(root.key+" ");  // In order Traversal
		inorderTraverse(root.right);
		//System.out.print(root.key+" ");  // post order Traversal
	}
	


	public Node<T> find(Node<T> root,T key) {
		if(root.key.compareTo(key)==0)
			return root;
		
		root = find(root.left,key);
		root = find(root.right,key);
		return root;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> b1 = new BinarySearchTree<>();
		b1.put(5);
		b1.put(3);
		b1.put(1);
		b1.put(2);
		b1.put(9);
		b1.put(1);
		b1.inorderTraverse(b1.root);
		
	}
}
