package D4;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3143_가장 {
	public static String word[];
	public static String cut[];
	public static int cnt;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/3143.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		word = new String[2];
		cnt=0;
		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			cnt=0;
			word = a.split(" ");
			cut = new String[word[0].length()];
			
			cut = word[0].split(word[1]);
			
			System.out.println(Arrays.toString(cut));


			for(int i=0; i<word[0].length()-word[1].length()+1; i++){
				String b = a.substring(i, i+word[1].length());
				if(b.equals(word[1])){
					cnt++;
					i=i+word[1].length()-1;
				}
			}
			
			for(int i=0; i<cut.length; i++){
				if(cut[i]!=null){
					cnt += cut[i].length();
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

	}
}
