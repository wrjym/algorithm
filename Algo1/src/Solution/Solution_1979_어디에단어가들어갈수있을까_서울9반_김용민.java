package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1979_어디에단어가들어갈수있을까_서울9반_김용민 {
	public static int [][]data;
	public static int N,K;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_1979.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc = 0; tc < T; tc++){
			N = sc.nextInt();
			K = sc.nextInt();
			data = new int[N][N];

			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					data[i][j] = sc.nextInt();
				}
			}

			System.out.println("#" + (tc+1) + " " + (searchrow()+serchcol()));
			;
		}
	}
	private static int serchcol() {
		int totalCount =0;
		for(int i=0; i<N; i++){
			int count =0;
			for(int j=0; j<N; j++){
				if(count == K && data[j][i] == 0){
					totalCount++;
					count = 0;
				}
				if(data[j][i] == 0){
					count = 0;
				}
				else{
					count++;
				}
			}
			if(count == K){
				totalCount++;
			}
		}
		return totalCount;
	}
	
	private static int searchrow() {
		int totalCount = 0;
		for(int i=0; i<N; i++){
			int count = 0;
			for(int j=0; j<N; j++){
				if(count == K && data[i][j] == 0){
					totalCount++;
					count = 0;
				}
				if(data[i][j] == 0)
					count = 0;
				else
					count++;
			}
			if(count == K){
				totalCount++;
			}
		}
		return totalCount;
	}
}
