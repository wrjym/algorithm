package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_5162_두가지빵의딜레마 {
	public static int[] bread;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/5162.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int ab[] = new int[2];
			ab[0] = sc.nextInt();
			ab[1] = sc.nextInt();
			int c = sc.nextInt();
			bread = new int[c+1];
			bread[ab[0]] = bread[ab[1]] = 1;
			for(int i=1; i<=c; i++){
				if(bread[i] >= 0){
					for(int j=0; j<2; j++){
						int tmp = i - ab[j];
						if(0 < tmp ){
							bread[i] = Math.max(bread[tmp]+1 ,bread[i]);
							
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + bread[c]);
			
		}
	}

}
