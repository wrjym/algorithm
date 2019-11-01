package array2;

public class BinarySearchArray {
	public static int []arr = {1,2,5,7,9,11,19,23};
	public static void main(String args[]){

		int key = 5;
		System.out.println(binary(key));
	}
	private static boolean binary(int key) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end){
			int middle = (start + end)/2;
			if(arr[middle] == key){
				return true;
			}
			else if(arr[middle] > key){
				end = middle -1;
			}
			else
				start = middle + 1;
		}
		return false;
	}


}
