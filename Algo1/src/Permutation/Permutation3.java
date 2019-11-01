package Permutation;

import java.util.Arrays;
import java.util.Scanner;
//순열.
public class Permutation3 {
	public static int n,r, caseCount, data[];
	public static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = 3;//sc.nextInt();
		data = new int[n];
		r=3;

		caseCount=0;
		
		permutation(0);
		System.out.println(caseCount);
		sc.close();
	}

	private static void permutation(int count) {
		
		
		if(count==r){
			for(int i=0;i<r;i++){
				for(int j=i+1;j<r;j++){
					if(data[i]==data[j]){
						return;
					}
				}
			}
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}

		for(int i=1;i<=6;i++){
			data[count] = i;
			permutation(count+1);			
		}
		
	}

}
