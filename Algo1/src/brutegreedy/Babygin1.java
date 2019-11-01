package brutegreedy;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Babygin1 {
	public static int N=6;
	public static int [] n = new int[N];
	public static int [] a = new int[N];
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/inputbabygin.txt"));

		Scanner scan = new Scanner(System.in);
		int T;
		T = scan.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			for(int i=0; i<N; i++) {
				n[i] = scan.nextInt();
			}
			System.out.println("#"+test_case+" "+permutation(0,0));
		}
	}
	
	public static int permutation(int pos, int used) {
		if(pos == N) {
			int tri=0;
			int run=0;
			for(int i=0; i<2; i++) {
				if(a[i*3+0]==a[i*3+1] && a[i*3+1]==a[i*3+2]) tri++;
				if(a[i*3+0]+1==a[i*3+1] && a[i*3+1]+1==a[i*3+2]) run++;
				if(tri+run==2) return 1;
			}
			
			return 0;
		}
		for(int i=0; i<N; i++) {
			if((used&(1<<i)) != 0) continue; 
			a[pos] = n[i];
			if(permutation(pos+1, used|(1<<i)) != 0) return 1;
		}
		return 0;
	}
}
