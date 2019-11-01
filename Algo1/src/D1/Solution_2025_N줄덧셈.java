package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2025_N줄덧셈 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=T; i++){
			sum += i;
		}
		System.out.println(sum);
	}

}
