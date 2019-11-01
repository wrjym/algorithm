package array1;

import java.util.Arrays;

public class Counting_Sort {
	static int []data = {0,4,1,3,1,2,4,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []counts; 
		int []temps = new int[data.length];
		int max = max();
		System.out.println(max);
		
		counts = new int[max+1];

		for(int i=0;i<data.length;i++){
			counts[data[i]] += 1;
		}
		
		for(int i=1;i<counts.length;i++){
			counts[i] += counts[i-1]; 
		}
		
		System.out.println(Arrays.toString(counts));

		for(int i=data.length-1;i>=0;i--){
			counts[data[i]] -= 1;
			temps[counts[data[i]]] = data[i];
			System.out.println(Arrays.toString(temps));
		}
		
		System.out.println(Arrays.toString(temps));
		
		
	}

	private static int max() {
		int max = 0;
		for(int i=0;i<data.length;i++){
			if(data[i] > max)
				max = data[i];
		}
		
		return max;
	}

}
