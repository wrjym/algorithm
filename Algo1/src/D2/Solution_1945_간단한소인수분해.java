package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1945_간단한소인수분해 {
	public static int []n = {2,3,5,7,11};
	public static int []m = new int[5];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1945.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){

			int a = sc.nextInt();
			boolean flag = true;
			int i=4;
			int b = a;
			while(flag){
				a = b % n[i];
				if(a == 0){
					b = b / n[i];
					m[i]++;
				}
				
				if(a != 0 ){
					i--;
				}
				if(i==-1 || b == 0){
					flag = false;
					break;
				}

			}
			System.out.print("#" + tc + " ");
			for(int j=0; j<5; j++){
				System.out.print(m[j] + " ");
			}
			System.out.println();
			m = new int[5];
		}


	}

}
