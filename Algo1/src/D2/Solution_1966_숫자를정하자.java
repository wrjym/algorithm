package D2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_1966_숫자를정하자 {
	public static ArrayList<Integer> list = new ArrayList();
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1966.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int tc=1; tc<=T; tc++){
			int a = sc.nextInt();

			for(int i=0; i<a; i++){
				list.add(sc.nextInt());
			}
			Collections.sort(list);
			System.out.print("#" + tc + " ");
			for(int i=0; i<a; i++){
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			list = new ArrayList<>();
		}
	}

}
