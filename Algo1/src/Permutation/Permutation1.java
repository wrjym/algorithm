package Permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation1 {
	public static int n, caseCount, data[];
	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = 3;//sc.nextInt();
		data = new int[3];


		caseCount=0;
		
		permutation(0);
		System.out.println(caseCount);
		sc.close();
	}

	private static void permutation(int count) {
		if(count==n){
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		for(int i=1;i<=n;i++){
			data[count] = i;
			permutation(count+1);
			
		}
		
	}

}
