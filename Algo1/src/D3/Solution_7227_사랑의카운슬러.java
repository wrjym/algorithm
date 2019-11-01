package D3;

import java.util.Scanner;

public class Solution_7227_사랑의카운슬러 {

	public static int[][] ji;
	public static long min = Long.MAX_VALUE;
	public static int []a = new int[10];
	public static int []b = new int[10];

	public static int []x = {100000, -100000};
	public static int []y = {100000, -100000};
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			min = Long.MAX_VALUE;
			int totalX=0, totalY=0;
			x = new int[n];
			y = new int[n];

			for(int i=0;i<n; i++){
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
				System.out.println(x[i] + " : " + y[i]);
			}

			for(int i=0; i<x.length; i++){
				totalX += x[i];
				totalY += y[i];
			}
			System.out.println(totalX + " " + totalY);
			for(int i=0; i<(1<<n); i++){
				int sumX=0, sumY=0;
				int cnt=0;
				a = new int[n];
				b = new int[n];
				for(int j=0; j<n; j++){
					if((i&1<<j)>0){
						a[cnt] = x[j];
						b[cnt++] = y[j];
						sumX += x[j];
						sumY += y[j];

					}
				}
				if(cnt==x.length/2){
					//						System.out.println(Arrays.toString(a));
					long bb = sumX -(totalX-sumX);
					long cc = sumY -(totalY-sumY);
					long aa = (bb*bb) + (cc*cc);
					if(min > aa){
						min = aa;
					}
					cnt=0;
				}
			}

			System.out.println("#" + tc + " " + min);
		}

	}


}
