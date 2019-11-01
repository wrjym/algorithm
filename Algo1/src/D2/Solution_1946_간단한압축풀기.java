package D2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1946_간단한압축풀기 {
	public static String[] word;
	public static int[] num;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1946.txt"));
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.next());

		for(int tc=1; tc<=T; tc++){
			int a= Integer.parseInt(sc.next());
			word = new String[a];
			num = new int[a];
			int i=0;
			for(int j=0; j<a; j++)
			{
				word[j] = sc.next();
				num[j] = Integer.parseInt(sc.next());
			}
			int cnt=0;
			System.out.println("#" + tc);
			while(num[a-1]!=0){
				System.out.print(word[i]);
				cnt++;
				num[i]-=1;
				
				if(num[i]==0){
					i++;
				}
				if(cnt==10){
					System.out.println();
					cnt=0;
				}
			}
			System.out.println();
		}
	}

}
