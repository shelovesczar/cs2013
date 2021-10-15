package hw02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * 
 * @author Cesar Hernanedez, 303578319, CS2013-05 
 * https://calstatela.instructuremedia.com/embed/801c3530-f2ce-4ca3-8b41-d331d91c51a4
 * https://calstatela.instructuremedia.com/embed/a451faa7-13ca-45ec-828e-1bba7d489414
 *
 *This class contains various methods for manipulating arrays (such as sorting and inserting). 
 *
 * @param <E>
 */

public class MyArray<E extends Comparable<E>> {
	// No other data fields necessary.
	private E[] data;
	
/**
 *  Constructor creates new array with specified size
 * 
 * @param size: will be the size of the array
 */

	public MyArray(int size) {
		this.data = (E[]) (new Comparable[size]);
	}

	// This constructor can accept an array or a comma-separated list of values.
	public MyArray(E... elements) {
		this.data = (E[]) (new Comparable[elements.length]);
		// Make a deep copy to prevent shared references.
		System.arraycopy(elements, 0, this.data, 0, elements.length);
	}

	// Add other methods.
	
	
	/**
	 * Retrieves the size of the array
	 * 
	 * @return returns the value of the size 
	 */

	public int size() {
		return data.length;
	}
	
	/**
	 * Retrieves the element at the index position
	 * 
	 * @param index: location of the element
	 * @return returns the element at the position
	 * of the index
	 */

	public E get(int index) {
		return data[index];
	}
	
	/**
	 * Retrieves the elements from start position to the end position of the array
	 * the values are stored in an ArrayList. The method returns the elements at
	 * specified range.
	 * 
	 * @param start: initial position in the array
	 * @param end: final position in the array
	 * @return returns the elements from the array at specified range
	 */

	public E get(int start, int end) {

		ArrayList<E> storedValues = new ArrayList<>();

		for (int i = start; i < end; i++) {
			storedValues.add(data[i]);
		}

		return (E) storedValues.toString().replace("[", "").replace("]", "");
	}
	
	/**
	 * Places the given element at the given index position of the array. 
	 * 
	 * @param index: location for element placement
	 * @param value: given element to place in the array
	 */

	public void put(int index, E value) {
		 data[index] = value;
	}
	
	/**
	 * 
	 * Places the given elements at the start position to the end position
	 * by storing a copy of the original array in a new generic array. The 
	 * values that are to be changed are added to the created array. Once
	 * the values are added we set the old array to the new created array
	 * that have the passed values.  
	 * 	 
	 * @param start: initial position in the array
	 * @param end: final position in the array
	 * @param value: elements to be placed in the array
	 */

	public void put(int start, int end, E... value) {

		E[] storedValues = Arrays.copyOf(data, data.length);

		for (int i = start; i < end; i++) {
			storedValues[i] = value[i];
		}

		setData(storedValues);
	}
	
	/**
	 * Returns true if the two specified arrays of Objects 
	 * are equal one another.
	 * 
	 * Two arrays are considered equal if the number of elements covered by
     * each range is the same, and all corresponding pairs of elements over the
     * specified ranges in the two arrays are equal.  In other words, two arrays
     * are equal if they contain, over the specified ranges, the same elements
     * in the same order.
     * 
     * @param o is the object we are going to compare
     * 
	 */

	@Override
	public boolean equals(Object o) {

		if (o == this) {
			System.out.println("Are equal:");
			return true;
		}

		if (!(o instanceof MyArray)) {
			System.out.println("Are not equal:");
			return false;
		}

		MyArray existing = (MyArray) o;

		for (int i = 0; i < existing.size(); i++) {

			if (!Objects.equals(existing.get(i), data[i])) {
				return false;
			}

		}

		return true;
	}
	
	/**
	 * Gives the maximum value from the array
	 * Loops through the array to find the highest
	 * value element in the array.
	 * 
	 * @return maxValue the maximum value
	 */

	public E max() {

		E maxValue = data[0];

		for (E e : data) {
			if (maxValue.compareTo(e) < 0) {
				maxValue = e;
			}
		}

		System.out.println("Maximum value: ");
		return maxValue;
	}
	
	/**
	 * Gives the minimum value from the array.
	 * Loops through the array to find the lowest
	 * value element in the array.
	 * 
	 * @return minValue the minimum value
	 */

	public E min() {

		E minValue = data[0];

		for (E e : data) {
			if (minValue.compareTo(e) > 0) {
				minValue = e;
			}
		}

		System.out.println("Minimum value: ");
		return minValue;

	}
	
	/**
	 * Reverse the order of the array (e.g.)
	 * {1,2,3} will become {3,2,1}.
	 * 
	 */

	public void reverse() {

		int start = 0;
		int end = data.length - 1;

		// loops array while the start is not less than the end position
		while (start < end) {

			// temp is equal the element at specified start index
			E temp = data[start];
			// element at the start is equal to the element at the last 
			data[start] = data[end];
			// the last element in array is equal to the first element
			data[end] = temp;
			// increase the start position by 1
			start++;
			// decrease the end position by 1
			end--;

		}

	}
	
	/**
	 * Randomizes the order of elements within the array.
	 * Loops through the array. Generating random index 
	 * for elements to be swapped at specified index. 
	 * 
	 * @return placed elements at random positions 
	 */

	public E[] shuffle() {

		// Calls random in order to get random index
		Random rand = new Random();

		// Loops over data 
		for (int i = 0; i < data.length; i++) {
			
			// We set the indexToSwap to a random index from data[]
			
			int indexToSwap = rand.nextInt(data.length);
			
			// temp is given the element at the random location 
			E temp = data[indexToSwap];
			
			// data[] at random index equals element at data[index] 
			data[indexToSwap] = data[i];
			
			//data[i] is equal to the temp value
			data[i] = temp;
		}

		return data;
	}
	
	/**
	 * 
	 * Rotates the elements to the left. Element is moved from original 
	 * index to new specified index @param shiftDistance. The first position
	 * is shifted to the last position. 
	 * 
	 * 
	 * @param shiftDistance new index to move element to
	 */

	public void leftShift(int shiftDistance) {

		// Rotate the given array by n times toward left

		for (int i = 0; i < shiftDistance; i++) {

			int j;

			// Stores the first element of the array

			E first = data[0];

			for (j = 0; j < data.length - 1; j++) {

				// Shift element of array by one
				data[j] = data[j + 1];

			}

			// First element of array will be added to the end
			data[j] = first;
		}

	}
	
	/**
	 * 
	 * Rotates the elements to the right. Element is moved from original 
	 * index to new specified index @param shiftDistance. The last position
	 * is shifted to the first position. 
	 * 
	 * 
	 * @param shiftDistance new index to move element to
	 */
	
	public void rightShift(int shiftDistance) {
		
		   //Rotate the given array by n times toward right 
		
        for(int i = 0; i < shiftDistance; i++){   
        	
            int j;
            
            //Stores the last element of array    
            E last = data[data.length-1];    
            
            for(j = data.length-1; j > 0; j--){    
                //Shift element of array by one    
                data[j] = data[j-1];    
            }    
            //Last element of array will be added to the start of array.    
            data[0] = last;    
        }    
		
	}
	
	/**
	 * Sorts the array in ascending order. Elements are
	 * sorted alpha numerically.
	 * 
	 */
	
	public void sort() {
		Arrays.sort(data);
	}
	
	/**
	 * Overrides previous method and prints array values in a 
	 * formatted way.
	 * 
	 */

	@Override
	public String toString() {
		// grabs the elements from data and displays them
		return Arrays.toString(data).replace("[", "").replace("]", "");

	}

	public E[] getData() {
		// gets the array
		return data;
	}

	public void setData(E[] data) {
		// sets the array
		this.data = data;
	}

//	public void put(int index, E value) {
//		
//
//		E[] array = Arrays.copyOf(data, data.length + 1);
//		
//		E toBeReplaced = (array[data.length] = value);
//		E current = array[0];
//		
//		for(int i = index; i < array.length;i++) {
//			current = array[i];
//			array[i] = toBeReplaced;
//			toBeReplaced = current;
//		}
//		
//	 
//		setData(array);
//		
//	}

}