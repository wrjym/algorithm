package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1926_간단한369게임 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1926.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int nag = 0;

		for(int tc=1; tc<=T; tc++){
			nag = tc;
			int cnt = 0;
			while(nag!=0){
				int mak = nag % 10;
				nag = nag / 10;	//나머

				if(mak == 3 || mak==6 || mak ==9){
					cnt++;
				}
			}

//			System.out.println(tc + "   " + cnt);
			if(cnt==0){
				System.out.print(tc + " ");
			}
			else{
				for(int i=0; i<cnt; i++){
					System.out.print("-");
				}
				System.out.print(" ");
			}

		}
	}

}
