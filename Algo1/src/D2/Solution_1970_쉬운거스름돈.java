package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1970_쉬운거스름돈 {
	public static int [][]money = {{50000,10000,5000,1000,500,100,50,10},{0,0,0,0,0,0,0,0}};
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1970.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			int b = a;
			int i=0;
			while(i<8){
				if(money[0][i] <= a){
//					System.out.println("a : " + a + "   money : " + money[0][i]);
					a -= money[0][i];
					money[1][i]++;
				}
				else{
					i++;
				}
				
			}
			System.out.println("#" + tc);
			for(i=0; i<8; i++){
				System.out.print(money[1][i] + " ");
				money[1][i] = 0;
			}
			System.out.println();
			
		}
	}

}
