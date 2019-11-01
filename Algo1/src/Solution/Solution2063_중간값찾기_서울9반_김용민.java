package Solution;


import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class Solution2063_중간값찾기_서울9반_김용민 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int []data = {1,2,3,4,5,6,7,8,9};
//		int size = sc.nextInt();
		int size = 9;
//		data = new int[size];
		
//		data = 
		
//		for(int i=0;i<data.length;i++){
//			data[i] = sc.nextInt();
//		}
		


//		for(int i=0;i<data.length-1;i++){
//			for(int j=0;j<data.length-1-i;j++){
//				int temp;
//				if(data[j]<data[j+1]){
//					temp = data[j];
//					data[j] = data[j+1];
//					data[j+1] = temp;
//				}
//				System.out.println(Arrays.toString(data));
//			}
//			System.out.println();
//		}
		
		
		for(int i=data.length-1;i>0;i--){
			exit : for(int j=0; j<i;j++){
				if(data.length/2==i) {
					System.out.println("i : " + i);
					break exit;
				}
				if(data[j]>data[j+1]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
				System.out.println(Arrays.toString(data));
			}
			System.out.println();
		}
		
		
		System.out.println(data[(data.length/2)]);




	}
}
