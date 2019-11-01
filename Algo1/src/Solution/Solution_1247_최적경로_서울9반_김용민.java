package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1247_최적경로_서울9반_김용민 {
	public static int [][]map;
	public static int distance = 0;
	public static int m;
	public static int []company;
	public static int []home;
	public static int sum;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/input_1247.txt"));
		Scanner sc = new Scanner(System.in);		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			m = sc.nextInt();
			company = new int [2];
			home = new int [2];
			sum = 1000000;
			for(int i=0;i<2;i++){
				company[i] = sc.nextInt();
			}
			for(int i=0;i<2;i++){
				home[i] = sc.nextInt();
			}
			map = new int[m][2];
			for(int i=0; i<m; i++){
				for(int j=0; j<2; j++){
					map[i][j] = sc.nextInt();
				}
			}
			perm(m,0);
			System.out.println("#" + tc + " " + sum);
		}
		
	}
	public static void swap(int i,int k){
		int []temp = map[i];
		map[i] = map[k];
		map[k] = temp;
	}
	public static void perm(int n, int k){
		int sum1 = 0;
		if(k==n){
			sum1 = Math.abs(company[0]-map[0][0]) + Math.abs(company[1]-map[0][1]);
			for(int i=0; i<m-1; i++){
				sum1 += Math.abs(map[i][0]-map[i+1][0]) + Math.abs(map[i][1]-map[i+1][1]);
			}
			sum1 += Math.abs(home[0]-map[n-1][0]) + Math.abs(home[1]-map[n-1][1]);
			
			if(sum > sum1){
				sum = sum1;
			}
			return ;
		}
		for(int i=k; i<n; i++){
			swap(i,k);
			perm(n,k+1);
			swap(i,k);
		}
	}

}
