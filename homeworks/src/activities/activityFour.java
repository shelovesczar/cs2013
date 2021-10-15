package activities;

public class activityFour {
	
	

	public static void main(String[] args) {
		int[] intValues = {1,6,8,1,7,43};

		System.out.print(addingInts(0, intValues));


	}
	
	
	
	public static int addingInts(int index, int[] arr) {

		if(index == arr.length - 1) {
			return arr[index];
		}
		
		return (addingInts(index + 1, arr) + arr[index]);

	}
	

}
