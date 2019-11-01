package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) throws Exception {
				System.setIn(new FileInputStream("rs/2070.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.print("#" + tc + " ");
			if(a>b)
				System.out.println(">");
			else if (a<b)
				System.out.println("<");
			else
				System.out.println("=");
		}
	}

}
