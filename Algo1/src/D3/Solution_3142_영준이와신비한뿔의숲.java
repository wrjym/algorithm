package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_3142_영준이와신비한뿔의숲 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a=0,b=0;
			for(int i=0; i<=m; i++){
				if(((i*1)+((m-i)*2)==n)){
					
					a = i;
					b = m-i;
				}
			}
			System.out.println("#" + tc + " " + a + " " + b);

		}
	}

}
