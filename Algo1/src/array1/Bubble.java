package array1;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {55,7,78,12,42};

		for(int i=0;i<data.length-1;i++){
			for(int j=0;j<data.length-1-i;j++){
				int temp;
				if(data[j]>data[j+1]){
					temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
				System.out.println(Arrays.toString(data));
			}
			System.out.println();
		}
	}
}