package D3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_3456_직사각형길이찾기1 {
	public static int[] nn = new int[101];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/3456.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			for(int i=0; i<3; i++){
				int a = sc.nextInt();
				nn[a] += 1;
			}
			int ans=0;
			for(int i=0; i<101; i++){
				if(nn[i]==3){
					ans = i;
				}
			}
			if(ans == 0){
				for(int i=0; i<101; i++){
					if(nn[i]==1){
						ans = i;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
			nn = new int[101];
		}
	}

}
