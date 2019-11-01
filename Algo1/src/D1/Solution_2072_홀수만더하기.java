package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2072_홀수만더하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2072.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int sum = 0;
			for(int i=0; i<10; i++){
				int a = sc.nextInt();
				if(a%2 == 1){
					sum += a;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}
