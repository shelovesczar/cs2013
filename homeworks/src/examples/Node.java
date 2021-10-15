package examples;

public class Node<E extends Comparable<E>> {

		protected E data;
		protected Node<E> next;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
		
	
	
}
