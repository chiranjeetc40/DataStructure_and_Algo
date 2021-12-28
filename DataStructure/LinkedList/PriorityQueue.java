package DataStructure_and_Algo.DataStructure.LinkedList;

import pratice.Book;

public class PriorityQueue<T extends Comparable<T>>{
	public DoublyLinkedList<T> priorityQueue = new DoublyLinkedList<T>();
	public T pop() {
		T data = null;
		if(priorityQueue.head!=null) {
			data = priorityQueue.head.data;
			priorityQueue.head = priorityQueue.head.next;
			if(priorityQueue.head!=null) priorityQueue.head.prev = null;
		}
		return data;
	}
	
	public boolean push(T data) {
		Node<T> new_node = new Node<>(data);
		
		if(priorityQueue.head==null) {
			priorityQueue.insertData(data);
			return true;
		}
		if(priorityQueue.head.data.compareTo(data) <= 0) {
			new_node.next = priorityQueue.head;
			priorityQueue.head = new_node;
			return true;
		}
		
		Node<T> this_node = priorityQueue.head.next;
		Node<T> previous_node = priorityQueue.head;
		
		while(this_node != null) {
			// if less than equal to
			if(this_node.data.compareTo(data) <= 0) {
				System.out.println("here");
				previous_node.next = new_node;
				new_node.next = this_node;
				new_node.prev = previous_node;
				this_node.prev = new_node;
				return true;
			}
			previous_node = this_node;
			this_node = this_node.next;
		}
		priorityQueue.tail.next = new_node;
		priorityQueue.tail.next.prev = priorityQueue.tail;
		priorityQueue.tail = priorityQueue.tail.next;
		return true;
	}
	
	public static void main(String[] args) {
		Book b1 = new Book(1, "java1", "me", 12, 32);
		Book b2 = new Book(2, "java", "me1", 13, 3);
		Book b3 = new Book(3, "java", "me2", 111, 3);
		Book b4 = new Book(4, "java", "me3", 1, 32);
		
		PriorityQueue<Book> prio_book = new PriorityQueue<>();
		prio_book.push(b1);
		prio_book.push(b2);
		prio_book.push(b3);
		prio_book.push(b4);
		prio_book.priorityQueue.display();
		System.out.println("--------------");
		prio_book.pop();
		Book b5 = new Book(5, "java", "me3", 1, 32);
		prio_book.push(b5);
		prio_book.priorityQueue.display();
		
	}
}
