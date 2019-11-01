package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1215_회문1 {
	public static char[][]map;
	public static int cnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1215.txt"));
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++){
			int n = Integer.parseInt(sc.nextLine());
			int sz = 8;
			map = new char[sz][sz];
			for(int i=0; i<sz; i++){
				String a = sc.nextLine();
				for(int j=0; j<sz; j++){
					map[i][j] = a.charAt(j);
				}
			}
			cnt=0;
			
			
			for(int i=0; i<sz; i++){
				StringBuilder sb = new StringBuilder();
				StringBuilder sb1 = new StringBuilder();
				for(int k=0; k<sz-n+1; k++){
					sb.setLength(0);
					sb1.setLength(0);
					for(int j=k; j<k+n; j++){
						sb.append(map[i][j] + "");
						sb1.append(map[j][i] + "");
					}
					String a = sb.toString();
					String b = sb.reverse().toString();
					
					
					String aa = sb1.toString();
					String bb = sb1.reverse().toString();
					if(aa.equals(bb)){
						cnt++;
					}
					if(a.equals(b)){
						cnt++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);

		}

	}

}
