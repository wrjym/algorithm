package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 사랑의 카운슬러
 * 
 * 입력
 * 1. 지렁이의 수가 입력된다.
 * 2. 지렁이들의 좌표값이 주어진다.
 * 
 * 풀이과정
 * 1. 지렁이의 좌표들중에 제일 작은 값을 호출한다.
 * 2. 문제를 분석해보면, 지렁이가 4명이라 가정한다.
 * 3. 1) 2) 3) 4)가 있으면 짝지어질 수 있는 경우의 수를 판단한다.
 * 4. 짝지어지기 때문에 (1,2)-(3,4), (1,3)-(2,4), (1,4)-(2,3) 등등의 수가 생긴다.
 * 5. 짝지어진 값들을 보면 앞에 있는 수를 앞반이 + 뒷반이 -라고 할 수 있다.
 * 6. 이 경우와 같이 짝으로 나눠진 것들을 집합이나 조합을 뽑아서 해당되는 애들을 구하고, 앞값을 플러스 뒷값은 마이너스로 둔다.
 * 7. 이 경우는 해당 알고리즘이 필요한것보다 문제분석이 중요.
 * 
 * 출력
 * : 지렁이를 짝지었을때, 가장 짧은 벡터값을 구한다.
 * 
 */



public class Solution_1494_사랑의카운슬러 {
	public static int[][] ji;
	public static long min = Long.MAX_VALUE;
	public static int []a = new int[10];
	public static int []b = new int[10];

	public static int []x = {100000, -100000};
	public static int []y = {100000, -100000};
	public static void main(String[] args) throws Exception {
				System.setIn(new FileInputStream("rs/1494.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
//			System.out.println(x.length);
			min = Long.MAX_VALUE;
			int totalX=0, totalY=0;
			x = new int[n];
			y = new int[n];
			
			for(int i=0;i<n; i++){	//지렁이의 x좌표, y좌표 입력
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			
			for(int i=0; i<x.length; i++){	//지렁이의 x,y좌표의 총합을 미리 구해둔다.
				totalX += x[i];
				totalY += y[i];
			}

			for(int i=0; i< (1<<n); i++){	
				int sumX=0, sumY=0;
				int cnt=0;
				a = new int[n];
				b = new int[n];
				for(int j=0; j<n; j++){
					if((i&1<<j)>0){
						System.out.println();
						a[cnt] = x[j];
						b[cnt++] = y[j];
						sumX += x[j];
						sumY += y[j];

					}
				}
				if(cnt==x.length/2){
//					System.out.println(Arrays.toString(a));
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
