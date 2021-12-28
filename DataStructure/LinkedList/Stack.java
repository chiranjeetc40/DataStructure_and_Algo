package DataStructure_and_Algo.DataStructure.LinkedList;

public class Stack<T> {
	public DoublyLinkedList<T> stack = new DoublyLinkedList<T>();
	
	public boolean push(T data) {
		if(stack.head==null) {
			stack.insertData(data);
			return true;
		}
		if(stack.isPresent(data))
			return false;
		Node<T> new_node = new Node<>(data);
		Node<T> tmp = stack.head;
		stack.head = new_node;
		stack.head.next = tmp;
		tmp.prev = new_node;
		return true;
	}
	
	public T pop() {
		T data = null;
		if(stack.head!=null) {
			data = stack.head.data;
			stack.head = stack.head.next;
			if(stack.head!=null) stack.head.prev = null;
		}
		return data;
	}

}
