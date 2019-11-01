package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2050_알파벳을숫자로변환 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2050.txt"));
		Scanner sc = new Scanner(System.in);
		
		String a = sc.nextLine();
		
		for(int i=0; i<a.length(); i++){
			System.out.print((a.charAt(i) - a.charAt(0)+1 + " "));
		}
	}
}
