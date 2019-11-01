package Solution;


import java.io.FileInputStream;
import java.util.Scanner;


public class Solution2817_부분수열의합_서울9반_김용민 {
	public static int []data;
	public static int N,K,count;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input2817.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++){
			N = sc.nextInt();
			K = sc.nextInt();
			data = new int[N];
			for(int i=0;i<N;i++){
				data[i] = sc.nextInt();
			}
			count = 0;
			for(int i=0;i<16;i++){
				int sum=0;
				for(int j=0;j<N;j++)
					if((i&1<<j) != 0){
						sum += data[j];
					}
					if(sum == K){
						count++;
					}
			}
			System.out.println("#" + (tc+1) + " " + count);
		}
	}

}

