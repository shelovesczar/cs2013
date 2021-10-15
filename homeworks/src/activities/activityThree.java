package activities;

public class activityThree {

	public static void main(String[] args) {


		Integer[] randomValues = {1,2,13,1,5};
		String[] stringValues = {"here", "comes", "the boy"};
		Double[] doubleValues = { 2.3, 3.5, 1.4 };
		
		printArray(randomValues);
		System.out.println();
		printArray(doubleValues);
		System.out.println();
		printArray(stringValues);
		System.out.println();

		
		Sorting sortObjs = new Sorting();
		
		sortObjs.sort(randomValues);
		sortObjs.sort(doubleValues);
		sortObjs.sort(stringValues);
		
		System.out.print("Sorted Integer objects: ");
		printArray(randomValues);
		System.out.println();
		System.out.print("Sorted Double objects: ");
		printArray(doubleValues);
		System.out.println();
		System.out.print("Sorted String objects: ");
		printArray(stringValues);

		
	}
	
	
	public static <E> void printArray(E[] dataValues) {
		for(int i = 0; i < dataValues.length; i++) {
			System.out.print(dataValues[i] + " ");
		}
	}
	
	public static class Sorting {
				
		/** Sort an array of comparable objects */
		public <E extends Comparable<E>> void sort(E[] list) {
			E currentMin;
			int currentMinIndex;
			
			for (int i = 0; i <list.length - 1; i++) {
				// Find the minimum in the list[i+1..list.length−2]
				currentMin = list[i];
				currentMinIndex = i;
				
				for (int j = i + 1; j < list.length; j++) {
					
					if (currentMin.compareTo(list[j]) > 0 ) {
						currentMin = list[j];
						currentMinIndex = j;
					}
				}
				
				// Swap list[i] with list[currentMinIndex] if necessary;
				if (currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}
				
			}
		}	
				
	}

}
