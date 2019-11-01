package D1;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_2068_최대수구하기 {
	public static int []a = new int[10];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2068.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			for(int i=0; i<10; i++){
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			System.out.println("#" + tc + " " + a[9]);
		}

	}

}
