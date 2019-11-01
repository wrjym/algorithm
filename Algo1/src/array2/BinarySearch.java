package array2;

public class BinarySearch {
	public static int []arr = {1,2,5,7,9,11,19,23};
	public static void main(String[] args) {
		int low=0;
		int high=arr.length-1;
		int key=5;

		System.out.println(binarySearch(low,high,key));
	}
	private static boolean binarySearch(int low, int high, int key) {
		if(low>high)
			return false;

		int middle = (low+high) /2;
		
		if(key < arr[middle]){
			return binarySearch(low,middle-1,key);
		}
		else if(key > arr[middle]){
			return binarySearch(middle+1,high,key);
		}
		else 
			return true;

	}

}
