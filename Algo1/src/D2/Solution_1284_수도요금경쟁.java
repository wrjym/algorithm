package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1284_수도요금경쟁 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1284.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++){
			int P = sc.nextInt();	//1L당 요금
			int Q = sc.nextInt();	//R리터 이하 요금
			int R = sc.nextInt();	//R리터
			int S = sc.nextInt();	//1L당 요금
			int W = sc.nextInt();	//이번 달 수도의 양
			
			int A = W * P;
			int B;
			if(R < W){
				B = Q + (W-R)*S;
			}
			else{
				B = Q;
			}
			int min = Math.min(A, B);
			System.out.println("#" + tc + " " + min);
			
		}
		

	}

}
