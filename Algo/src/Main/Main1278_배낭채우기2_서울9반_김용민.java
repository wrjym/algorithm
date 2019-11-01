package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1278_배낭채우기2_서울9반_김용민{
	public static int [][]sv;
	public static int []dp;
	public static int [][]map;
	public static int maxValue;
	public static int max,n;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1077.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		max = sc.nextInt();
		maxValue = 0;
		sv = new int[n][2];
		dp = new int[max+1];
		for(int i=0; i<n; i++){
			sv[i][0] = sc.nextInt();
			sv[i][1] = sc.nextInt();
		
		}
		Arrays.sort(sv, new Comparator<int []>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0])
					return -1;
				else if(o1[0] > o2[0])
					return 1;
				else {
					if(o1[1] < o2[1]){
						return -1;
					}
					else{
						return 1;
					}
				}
			}
		});
		map = new int[n+1][max+1];

		for(int i=1; i<=n; i++){
			for(int j=0; j<=max; j++){
				if(sv[i-1][0] > j){
					map[i][j] = map[i-1][j];
				}
				else{
					
					map[i][j] = Math.max( sv[i-1][1] + map[i-1][j-sv[i-1][0]] ,
							map[i-1][j]);
				}
			}
		}
//		for(int []a : map )	System.out.println(Arrays.toString(a));
		
		System.out.println(map[n][max]);
	}

}
