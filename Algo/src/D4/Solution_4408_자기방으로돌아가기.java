package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;


public class Solution_4408_자기방으로돌아가기 {
	public static int a,b;
	public static int[] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/4408.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			int c = sc.nextInt();
			int cnt=1;
			map = new int[401];
			for(int i=0; i<c; i++){
				a = sc.nextInt();
				b = sc.nextInt();
				swap(a,b);
				if(a%2 == 0){
					a -= 1;
				}
				if(b%2==1){
					b += 1;
				}
				for(int x=a; x<=b; x++){
					map[x]++;
				}
			}
			int max = 0;
			for(int i=0; i<401; i++){
				if(max < map[i]){
					max = map[i];
				}
			}
			System.out.println("#" + tc + " " + max);
			cnt = 0;
			max = 0;
			
		}
	}
	private static void swap(int x, int y) {
		if(x>y){
			int tmp = a;
			a = b;
			b = tmp;
		}
	}


}
