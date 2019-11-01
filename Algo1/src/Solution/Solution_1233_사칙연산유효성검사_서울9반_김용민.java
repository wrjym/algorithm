package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1233_사칙연산유효성검사_서울9반_김용민 {

	private static Scanner sc;

	public static void main(String[] args) throws Exception{
		sc = new Scanner(System.in);
		System.setIn(new FileInputStream("rs/input_1233.txt"));
		
		for(int tc=1; tc<=10; tc++){
			String []data = new String[10];
			int n = Integer.parseInt(sc.nextLine());
			int test=1;
			for(int i=1; i<=n; i++){
				String a = sc.nextLine();
				data = a.split(" ");

				if(data.length==2){
					if(data[1].equals("+") && data[1].equals("-") & data[1].equals("*") && data[1].equals("/")){
						test=0;
					}
				}else if(data.length==3){
					test=0;
				}else if(data.length==4){
					if(!data[1].equals("+") && !data[1].equals("-") && !data[1].equals("*") && !data[1].equals("/")){
						test=0;
					}
				}

			}
			System.out.println("#" + tc + " " + test);

		}


	}


}
