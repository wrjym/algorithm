package D1;

import java.util.Scanner;

public class Solution_1545_거꾸로출력해보아요 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=T; tc>=0; tc--){
			System.out.print(tc + " ");
		}
	}

}
