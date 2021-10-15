package examples;

public class NodeTester {
	public static void main(String[] args) {
		
		// This is only for testing, not the right way to build a list
		
		Node<Integer> n0 = new Node<>(10);
		Node<Integer> n1 = new Node<>(20);
		Node<Integer> n2 = new Node<>(30);
		Node<Integer> n3 = new Node<>(40);
		Node<Integer> n4 = new Node<>(50);
		Node<Integer> n5 = new Node<>(60);
		Node<Integer> n6 = new Node<>(70);

		Node<Integer> head = n0;
		Node<Integer> tail = n6;
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		Node<Integer> curr = head;
		
		while(curr != null ) {
			System.out.print(curr + " ");
			curr = curr.next;
		}
		
		
		
	}
}
