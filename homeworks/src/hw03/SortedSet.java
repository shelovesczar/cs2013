package hw03;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SortedSet<E extends Comparable<E>> {

	private E[] set;
	private int size; // initial capacity
	// size does not necessarily mean length

	public SortedSet() {
		this.set = (E[]) (new Comparable[10]);
		Arrays.sort(this.set);
	}

	public SortedSet(int capacity) {
		this.set = (E[]) (new Comparable[size]);
//		Arrays.sort(this.set);
	}

	// This constructor can accept an array or a comma-separated list of values.
	public SortedSet(E... values) {
		this.set = (E[]) (new Comparable[values.length]);
		System.arraycopy(values, 0, this.set, 0, values.length);
		Arrays.sort(this.set);
	}

	public SortedSet(SortedSet set) {
		this.set = (E[]) (new Comparable[set.size]); // Should I use length
		// Make a deep copy to prevent shared references.
		System.arraycopy(set, 0, this.set, 0, set.size); // Should I use length
	}
	
	public void remove(E value) {
		
		for(int i = 0; i < set.length; i++) {
			if(set[i] == value) {
			set[i] = (E) Objects.toString(0);
			}	
			
			if(set[i] == (E) Objects.toString(0)) {
				System.arraycopy(set, i, value, i, i);
			}
			
//			set[set.length - 1] =(E) Objects.toString(0);
//			set[i] = set[i + 1];

		}
		
	}

	public E get(int index) { // O(c)
		// add a way to check bounds
		return (E) set[index];
	}

	public int size() { // O(c)
		return size;
	}

	public void setSize(int size) { // O(c)
		this.size = size;
	}

	@Override
	public boolean equals(Object obj) {
		    
		if (!(obj instanceof SortedSet)) {
		return false;
		}
		
		SortedSet another = (SortedSet) obj;
		
		if(this.set.length != another.set.length) {
			return false;
		}
		
		for (int i = 0; i < another.set.length - 1; i++) {
			if(!(this.set[i] == another.set[i])) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E set : this.set) {
			sb.append(set.toString()).append(", ");

		}
		return sb.substring(0, sb.length() - 1);
	}

}
