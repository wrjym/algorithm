package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1077_배낭채우기1_서울9반_김용민 {
	public static int [][]sv;
	public static int []dp;
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
//		for(int i=0; i<n; i++){
//			dp[sv[i][0]] = sv[i][1];
//		}
//		for(int []a : sv) System.out.println(Arrays.toString(a));
		for(int i=1; i<max+1; i++){
			int tmp=0;
			for(int j=0; j<sv.length; j++){
				tmp = i-sv[j][0];
				if(tmp<0){
					break;
				}
				dp[i] = Math.max(dp[i],
						dp[tmp]+sv[j][1]);
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[max]);
		sc.close();
	}

}
