package activities;

public class ActivitySix {

	public static void main(String[] args) {
		ActivitySix six = new ActivitySix();

		int[] arr = { 1, 2, 3, 4, 5 };

		six.twoSum(arr, 5);
		
		six.offByOne(arr);

	}

//	1. Classic - Two Sum
//	Given an array of integers, and an int n, return indicies of 2 numbers in the array that add up to n. What is the runtime of the solution you've came up with?

	
	public int twoSum(int[] arr, int n) {

		int sum = 0;

		int left = 0;
		int right = arr.length - 1;

		while (left < right)  /** has a runtime of O(nlog(n))*/ {

			sum = arr[left] + arr[right];

			if (sum == n) {
				System.out.printf("(%d, %d) %n", arr[left], arr[right]);
				left = left + 1;
				right = right - 1;
			}
			
			else if (sum < n) {
				left = left + 1;
			} 
			
			else if (sum > n) {
				right = right - 1;
			}

		}
	
		return 0;
	}
	
//	2. Off by One
//	Say you've factored some code that get a number n and splits each number into an element in an array (i.e. 1234 becomes {1, 2, 3, 4}). But then you realize the number was off by 1 because of an indexing issue. Convert the array back to a number, add 1, then convert the number back to an array. 
//	(Simpler terms - given an array of ints, convert the ints into a whole number, add 1, then convert the whole number back to the array of ints)
	
	public void offByOne(int[] arr) {
		
		StringBuilder strBuilder = new StringBuilder();
		
		for(int i = 0; i < arr.length; i++) {
			strBuilder.append(arr[i]);
		}
		
//		for(int i = 0; i < strBuilder.length(); i++) {
//			
//		}
		
		
		System.out.println(strBuilder);
		
	}
	
	
	
	
	
	
	
	

}
