package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 문제 해석
 * 게임 방법
 * : 두 사람이 양의 정수 N을 정하고, 1로 초기화된 x를 가지고 있다.
 * 게임 Alice Bob Alice Bob 홀수 : Alice 짝수 : Bob
 * x = 2x 또는 2x + 1
 * x > N 그 작업을 한 사람 패배.
 * 
 * 
 * 
 * 
 */

public class Solution_3459_승자예측하기 {
	public static Long[][] SE = new Long[60][2];
	public static void main(String[] args) throws Exception {
				System.setIn(new FileInputStream("rs/3459.txt"));

		Scanner sc = new Scanner(System.in);
		for(int i=1; i<60; i++){
			SE[i][0] = (long) Math.pow(2, i);
			SE[i][1] = (long) Math.pow(2, i+1)-1;
		}

		//		for(Long a[] : SE) System.out.println(Arrays.toString(a));
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			long a = sc.nextLong();
			System.out.println(a);
			for(int i=1; i<60; i++){
				if(a==1){
					System.out.println("Bob");
//					System.out.println(a + " is Bob win");
					break;
				}
				if(SE[i][0] <= a && a < SE[i][1]){
					if(i%2 == 1){
//						System.out.print(SE[i][0] + "<=" + a + "<=" + SE[i][1]+ "  ");
						System.out.println("Bob");
					}
					else{
//						System.out.println(SE[i][0] + "<=" + a + "<=" + SE[i][1]);
						System.out.println("Alice");
					}
					break;
				}
			}	

		}
	}
}
