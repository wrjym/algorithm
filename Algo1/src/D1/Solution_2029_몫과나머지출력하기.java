package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2029_몫과나머지출력하기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2029.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			System.out.println("#" + tc + " " + (a/b) + " " + (a%b));
		}
	}

}
