package DataStructure_and_Algo.DataStructure.LinkedList;

import java.util.Objects;

class Node<V>{
	V data;
	Node<V> next;
	Node<V> prev;
	
	public Node(V data) {
		this.data = data;
		next = null;
		prev = null;
	}
}

public class DoublyLinkedList<T>{
	Node<T> head = null;
	Node<T> tail = null;
	
	public boolean insertData(T data) {
		Node<T> new_node = new Node<T>(data);
		if(head==null) {
			head = new_node;
			tail = head;
			return true;
		}
		tail.next = new_node;
		tail.next.prev = tail;
		tail = tail.next;
		return true;
	}
	
	public boolean display() {
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
			if(head!=null) head.prev = null;
			return true;
		}
		
		Node<T> this_node = head.next;
		Node<T> previous_node = head;
		
		while(this_node != null) {
			if(this_node.data.equals(data)) {
				previous_node.next = this_node.next;
				if(this_node.next!=null) this_node.next.prev = previous_node;
				return true;
			}
			previous_node = this_node;
			this_node = this_node.next;
		}
		return false;
	}
	
	public boolean reverse() {
		if(tail==null)
			return false;
		Node<T> tmp = tail;
		
		while(tmp.prev!=null) {
			System.out.println(tmp.data);
			tmp = tmp.prev;
		}
		return true;
	}
	
	public boolean isPresent(T data) {
		if(head==null)
			return false;
		Node<T> tmp = head;
		
		while(tmp!=null) {
			if(tmp.data.equals(data))
				return true;
			tmp = tmp.next;
		}
		return false;
	}
	
/*
	public static void main(String[] args) {
		DoublyLinkedList<Person> dll = new DoublyLinkedList<>();
		dll.insertData(new Person("Raj",23));
		dll.insertData(new Person("Waj",21));
		//dll.insertData(new Person("Saj",10));
		//dll.insertData(new Person("Maj",52));
		dll.display();
		System.out.println("--------------------");
		dll.reverse();
		System.out.println(dll.head.data);
		//System.out.println(dll.tail.data);
		System.out.println("--------------------");
		dll.remove(new Person("Waj",21));
		dll.display();
	}
*/
}

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}
