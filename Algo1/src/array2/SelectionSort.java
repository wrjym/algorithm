package array2;

import java.util.Arrays;

public class SelectionSort {
	public static int[] data = {65,25,10,22,11};
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(data));
		System.out.println();
		for(int i=0;i<data.length-1;i++){
			int min = i;
			for(int j=i+1;j<data.length;j++){
				if(data[j] < data[min])
					min = j;
				
			}
			int tmp = data[i];
			data[i] = data[min];
			data[min] = tmp;
			System.out.println(Arrays.toString(data));
		}
		
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]);
		}

	}

}
