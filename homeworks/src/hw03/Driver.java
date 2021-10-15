package hw03;

public class Driver {

	public static void main(String[] args) {
		
		int[] sample = {1,4,5,3,2};
		
		SortedSet set = new SortedSet(1,4,5,3,2);
		SortedSet set2 = new SortedSet(1,4,5,3,6,2);

		System.out.println(set.get(0));
		System.out.println(set.toString());
		System.out.println(set2.toString());

		System.out.println(set.equals(set2));
		
		set2.remove(4);
		
		System.out.println(set2.toString());


	}

}
