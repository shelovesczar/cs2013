package activities;

public class activityFive {

	public static void main(String[] args) {

		
		int[] sample1 = {1,3,5,7,4,8};
		
//		try {
//		arrayContains(sample1, 3);
//		arrayContains(sample1, 7);
//		}
//		catch (ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
//		}
		
		System.out.print(bunnyEars(24, 0));
		
	}
	
	
	
	public static boolean arrayContains(int[] arr, int n) {
		
		int count = 0;
		
		
		
		if(arr[0] == n) {
			System.out.println("True");
			return true;
		}
		
		else if (!(arr[n] == n)){
			System.out.println("False");
			return false;
			}
		
		return arrayContains(arr, n + 1);
	}
	
	public static int bunnyEars(int numOfBunnies, int count) {
		if (numOfBunnies == 0) {
			return count;
		}
		
		else if (numOfBunnies % 2 == 1) {
			count += 3;
			return bunnyEars(numOfBunnies - 1, count);
		}
		
		else if (numOfBunnies % 2 == 0) {
			count += 3;
			return bunnyEars(numOfBunnies - 1, count);
		}
	
	return count;
	}
	
	
	

}
