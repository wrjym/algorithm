package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_5549_홀수일까짝수일까 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/5549.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			int n = Integer.parseInt(a.charAt(a.length()-1)+"");
			System.out.print("#" + tc + " ");
			if(n%2==0){
				System.out.print("Even");
			}
			else{
				System.out.print("Odd");
			}
			System.out.println();
		}
	}

}
