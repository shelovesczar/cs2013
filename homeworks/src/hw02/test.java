package hw02;
import java.util.Arrays;


public class test {

	public static void main(String[] args) {
		
		
	
	
	MyArray arr = new MyArray(1,8,3,6);
	MyArray arr2 = new MyArray(1,"String One",3.3,'e');
	MyArray arr3 = new MyArray("One","Two","Three","Four");
	MyArray arr4 = new MyArray("One","Two","Three");


	System.out.println(arr.get(0,3));
	
	arr2.put(2, "thing");
	System.out.println(arr2.get(0,4));

	arr2.put(0, 3, "Text One", "Square",4);
	System.out.println(arr2.toString());

	
	System.out.println(arr.get(0,4));

	System.out.println(arr.equals(arr2));
	
	System.out.println(arr.max());
	System.out.println(arr.min());
	
	
	System.out.println(arr3.max());
	System.out.println(arr3.min());
	
	arr2.reverse();

	System.out.println(arr2.toString());

	arr.shuffle();
	System.out.println(arr.toString());

	
	arr.leftShift(3);
	
	arr2.rightShift(3);
	
	arr3.sort();
	
	System.out.println(arr.toString());
	System.out.println(arr2.toString());
	System.out.println(arr3.toString());

	System.out.println(arr4.max());
	System.out.println(arr4.min());

		
	}	

}
