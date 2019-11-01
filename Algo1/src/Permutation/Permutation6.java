package Permutation;

import java.util.Arrays;
import java.util.Scanner;
//조합.
public class Permutation6 {
	public static int n,r, caseCount, data[];
	public static Scanner sc;

	private static void permutation(int before,int flag ,int count) {

		if(count==r){
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}

		for(int i=before;i<=n;i++){
			if((flag&1 << i) == 0){
				data[count] = i;
				permutation(i+1,flag|1<<i,count+1);
			}
		}
	}
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = 6;//sc.nextInt();
		r = 3;
		data = new int[r];

		caseCount=0;

		permutation(1,0,0);
		System.out.println(caseCount);
		sc.close();
	}




}
