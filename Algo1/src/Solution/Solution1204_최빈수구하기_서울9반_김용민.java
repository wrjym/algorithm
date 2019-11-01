package Solution;


import java.io.FileInputStream;
import java.util.Scanner;


public class Solution1204_최빈수구하기_서울9반_김용민 {
	public static void main(String args[]) throws Exception {
		int countnum1[] = new int [1000];

		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		int max=0;
		int best=0;
		for(int i=1;i<=T; i++){
			int a = sc.nextInt();
			for(int j=1;j<=100;j++){
				countnum1[j] = 0;
				max =0;
				best = 0;
			}
			for(int k=1;k<=1000;k++){
				int b = sc.nextInt();
				countnum1[b] += 1;
			}
			for(int l=1;l<=100;l++)
			{
				if(countnum1[l]>=max){
					max =countnum1[l];
					best = l;
				}

			}

			System.out.println("#" + a +" " + best);
		}



	}
}