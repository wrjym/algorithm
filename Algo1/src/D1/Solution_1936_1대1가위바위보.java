package D1;

import java.util.Scanner;

public class Solution_1936_1대1가위바위보 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a==1 && b == 2){
			System.out.println("B");
		}
		else if(a==2 && b==3){
			System.out.println("B");
		}
		else if(a==3 && b==1){
			System.out.println("B");
		}
		else
			System.out.println("A");
	
	}
}
