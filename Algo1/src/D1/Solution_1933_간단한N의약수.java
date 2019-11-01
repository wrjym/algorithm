package D1;

import java.util.Scanner;

public class Solution_1933_간단한N의약수 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++){
			if(T%i == 0)
				System.out.print(i + " ");
		}

	}

}
