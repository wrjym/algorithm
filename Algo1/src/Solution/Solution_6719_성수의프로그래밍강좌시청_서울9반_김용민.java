package Solution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_6719_성수의프로그래밍강좌시청_서울9반_김용민 {

	public static void main(String[] args) throws Exception  {
		System.setIn(new FileInputStream("rs/input_6719.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int []cla;
		for(int tc=1; tc<=T; tc++){
			int N = sc.nextInt();	//총 강의의 레벨
			int K = sc.nextInt();	//선택한 강의수
			cla = new int[N];
			for(int i=0; i<N; i++){
				cla[i] = sc.nextInt();
			}
			Arrays.sort(cla);
			
			float A = 0;	//성수의 실력 초기
			
			for(int i=N-K; i<N; i++){
				A = (A + cla[i])/2;
			}
			
			System.out.println("#" +tc +" " + A);
			
			
			
		}
	}

}
