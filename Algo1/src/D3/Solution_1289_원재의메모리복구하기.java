package D3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1289_원재의메모리복구하기 {
	public static String[] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1289.txt"));
		Scanner sc = new Scanner(System.in);

		int T = Integer.parseInt(sc.nextLine());

		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			map = new String[a.length()];
			map = a.split("");
			System.out.println(Arrays.toString(map));
		}

	}
}
