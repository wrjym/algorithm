package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3456_직사각형길이찾기 {
	public static int[] tr = new int[3];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/3456.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			for(int i=0; i<3; i++){
				tr[i] = sc.nextInt();
			}
			Arrays.sort(tr);
			int ans=0;
			int cnt=0;
			int a = tr[0];
			for(int i=1; i<3; i++){
				if(tr[i]==a){
					cnt++;
				}
			}
			if(cnt==2){
				ans = a;
			}
			else{
				if(tr[1] == tr[2]){
					ans = a;
				}
				else{
					ans = tr[2];
				}
			}


			System.out.println("#" + tc + " " + ans);


		}
	}
}
