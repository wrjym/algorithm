package Main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main2283_RGB마을_서울9반_김용민 {
	public static int [][]map;
	public static int [][]v;
	
	public static int sum =0, n;
	public static int cnt=0;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2283.txt"));
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][3];
		v = new int[n][3];

		for(int i=0; i<n; i++){
			for(int j=0; j<3; j++){
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<3; i++){
			v[0][i] = map[0][i];
		}
		for(int i=1; i<n; i++){
			for(int j=0; j<3; j++){
				switch(j){
				case 0:
					v[i][0] = Math.min(v[i-1][1], v[i-1][2]) + map[i][0];
					break;
				case 1:
					v[i][1] = Math.min(v[i-1][0], v[i-1][2]) + map[i][1];
					break;
				case 2:
					v[i][2] = Math.min(v[i-1][0], v[i-1][1]) + map[i][2];
					break;
				}
			}
		}
		int ans = Math.min(v[n-1][0], v[n-1][1]);
		ans = Math.min(ans, v[n-1][2]);
		
		System.out.println(ans);
		sc.close();
	}

}
