package 못푼문제;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class 색종이3 {
	public static int [][]map;
	public static ArrayList<Integer> l;
	public static ArrayList<Integer> r;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		
		l = new ArrayList<>();
		r = new ArrayList<>();
		int n = sc.nextInt();
		map = new int [101][101];
		for(int i=0; i<n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			l.add(a);
			l.add(a+10);
			r.add(b);
			r.add(b+10);
			
			System.out.println(l);
			System.out.println(r);
		}


	}

}
