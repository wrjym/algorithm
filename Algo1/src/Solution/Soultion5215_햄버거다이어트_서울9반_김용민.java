package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Soultion5215_햄버거다이어트_서울9반_김용민 {
	
	static int [][]TK;
//	static int [][]TK = {{100,200},{300,500},{250,300},{500,1000},{400,400}};
	static int N, L;// N 재료의 수 , L 제한 칼로리
	static int ans; 

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int test_case = 0; test_case < T;test_case++){
			N = sc.nextInt();
			L = sc.nextInt();
			
			ans = 0;
			TK = new int[N][2];			
			for(int i=0;i<N;i++){
				for(int j=0;j<2;j++){
					TK[i][j] = sc.nextInt();	//data input
				}
			}
			
			check(TK[0][0],TK[0][1],1);
			check(0,0,1);
			
			
			System.out.println("#"+ (test_case+1)+ " " +ans);
		}
	}
	
	public static void check(int score, int cal, int index){

		if(index == N){
			ans = Math.max(score, ans);
			return;
		}
		if(L >= cal+TK[index][1]){
			check(score+ TK[index][0],cal+TK[index][1],index+1);
		}
		check(score,cal,index+1);
		
	}
}
