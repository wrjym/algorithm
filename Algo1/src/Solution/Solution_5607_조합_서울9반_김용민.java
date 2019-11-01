package Solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Solution_5607_조합_서울9반_김용민 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("rs/input_5607.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int P = 8;

		for(int tc=1; tc<=T; tc++){
			int n = sc.nextInt();
			int k = sc.nextInt();

			long bj=1;

			for(int i=n; i>0; i--){
				bj = (bj*i)%P;
			}
			//분자
			long bm = 1;
			for(int i=1; i<=(n-k); i++){
				bm = (bm*i) % P;
			}
//			System.out.println("8! : " + bm);
			//8! 분모
			for(int i=1;i<=k;i++){
				bm = (bm*i) %P;
			}
			//2! 분모합친
			
			int b = P;
			long kk = bm;
			long c = 2;
			long cc = c*c;
			kk = bm * bm;
			boolean flag = false;
			
			if(b%2 == 1){
				flag = true;
			}
			
			while(b!=1){
				bm = (bm*cc)%P;
				b /= 2;
				System.out.println(bm);
			}
			if(flag = true){
				bm = (bm * k);
				System.out.println("홀");
			}
			System.out.println("bm : " + bm);
			System.out.println("최종값 " + (bm*bj)%P);
		}
		System.out.println("END POINT");
	}


}
