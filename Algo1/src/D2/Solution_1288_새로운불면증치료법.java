package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1288_새로운불면증치료법 {
	public static boolean []check = new boolean[10];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1288.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();
			
			boolean flag = true;
			int b = a;
			int count = 0;
			while(flag){
				while(b != 0){
					int c = b % 10;
//					System.out.println("c : " + c + " b : " + b);
					check[c] = true;
					b = b / 10;
				}
				
				b = a * count;				
				count++;
//				System.out.println("b : " + b + "  count : " + count);
				int cnt=0;
				for(int i=0; i<10; i++){
					if(check[i]==true){
						cnt++;
					}
					if(cnt==10){
						flag = false;
					}
				}
				cnt=0;
				
			}

			check = new boolean[10];
			System.out.println("#" + tc + " " + (b-a));
			count=0;
			

		}
	}


}
