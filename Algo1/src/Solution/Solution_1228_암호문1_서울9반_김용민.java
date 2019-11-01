package Solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1228_암호문1_서울9반_김용민 {
	public static ArrayList list = new ArrayList();
	public static Scanner sc;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/input_1230.txt"));

		sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++){
			list = new ArrayList();
			int N = Integer.parseInt(sc.next());			

			for(int i=0; i<N; i++){
				list.add(sc.next());
			}

			int k = Integer.parseInt(sc.next());
			for(int z=0; z<k; z++){
				String ID = sc.next();
				switch(ID){
				case "I":
					int a = Integer.parseInt(sc.next());
					int b = Integer.parseInt(sc.next());
					add(a,b);
					break;
				case "D":
					int x = Integer.parseInt(sc.next());
					int y = Integer.parseInt(sc.next());
					del(x,y);
					break;
				case "A":
					int q = Integer.parseInt(sc.next());
					plus(q);
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for(int i=0;i<10;i++){
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
		}


	}
	private static void plus(int start) {
		for(int i=0; i<start; i++){
			list.add(sc.next());
		}
	}
	private static void del(int start, int end) {
		for(int i=0; i<end; i++){
			list.remove(start);
		}
	}
	private static void add(int start, int end) {
		for(int i=0; i<end; i++){
			list.add(start++, sc.nextInt());
		}
	}

}
