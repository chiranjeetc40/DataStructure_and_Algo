package DataStructure_and_Algo.DataStructure.LinkedList;


public class LinkedList<T>{
	
	class Node<V>{
		V data;
		Node<V> next;
		
		public Node(V data) {
			this.data = data;
			next = null;
		}
	}
	
	Node<T> head = null;
	
	public boolean insertData(T data) {
		if(head==null) {
			head = new Node<T>(data);
			return true;
		}
		Node<T> tmp = head;
		while(tmp.next!=null) {
			tmp =tmp.next;
		}
		tmp.next = new Node<T>(data);
		return true;
	}
	
	public boolean display(Node<T> head) {
		if(head==null)
			return false;
		Node<T> tmp = head;
		
		while(tmp!=null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
		return true;
	}
	
	public boolean remove(T data) {
		if(head==null)
			return false;
		if(head.data.equals(data)) {
			head = head.next;
			return true;
		}
		
		Node<T> next_node = head.next;
		Node<T> previous_node = head;
		
		while(next_node != null) {
			if(next_node.data.equals(data)) {
				previous_node.next = next_node.next;
				return true;
			}
			previous_node = next_node;
			next_node = next_node.next;
		}
		return false;
	}
	
	public Node<T> reverse(){
		Node<T> reverse_head = head;
		reverse_head.next = null;
		
		Node<T> tmp = head.next;
		
		while(tmp!=null) {
			Node<T> next_tmp = tmp.next;
			tmp.next = reverse_head;
			reverse_head = tmp;
			tmp = next_tmp;
		}
		return reverse_head;
	}

	public static void main(String[] args) {
		LinkedList<Double> ll = new LinkedList<>();
		ll.insertData(1.2);
		ll.insertData(2.5);
		ll.insertData(3.9);
		ll.insertData(4.1);
		ll.display(ll.head);
		System.out.println("-----------------");
		//ll.remove(3.9);
		ll.display(ll.reverse());
		
		
	}
}
