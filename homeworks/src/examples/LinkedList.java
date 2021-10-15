package examples;

public class LinkedList<E extends Comparable<E>> {
	private Node<E> head;
	private Node<E> tail;
	private int size = 0; // initial size
	
	
	public LinkedList(E ... values) {
		for(E data: values) {
			this.addLast(data);
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null) {
			tail = head;
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		
		if (tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	public boolean isEmpty() {
		return (this.head == null && 
				this.tail == null && 
				this.size == 0);
	}
	
	
	
}
