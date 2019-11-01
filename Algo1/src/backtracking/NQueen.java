package backtracking;

import java.util.Scanner;

public class NQueen {
	
	public static int N;
	public static int [] col; //인덱스값이 i   배열의값이 j
	public static int cnt;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		col = new int[N];
		nqueen(0);
		System.out.println(cnt);
	}
	
	public static void nqueen(int i) {
		if(i==N) {
			cnt++;
		}
		else {
			for(int j=0; j<N; j++) {
				col[i]=j;
				if(promising(i)) nqueen(i+1); // promising : 현재 i가 넣을 수 있는 자리인가? => 가지치기
			}
		}
	}
	
	public static boolean promising(int i) {
		for(int j=0; j<i; j++) {
			if(col[j]==col[i] || Math.abs(col[i]-col[j])==(i-j)) return false; // 같은 세로줄이거나  대각선에 있거나
		}
		return true;
	}
}
