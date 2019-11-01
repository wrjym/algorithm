package Main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1239_비밀편지_서울9반_김용민 {
	public static String [][]code = {{"000000","A"}, {"001111","B"},{"010011","C"}, {"011100","D"}, {"100110","E"}, {"101001","F"}, {"110101","G"}, {"111010","H"}};
	public static int[] check;
	public static String []p;
	public static String []b;
	public static ArrayList<String> list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1239.txt"));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();

		boolean flag = true;
		p = new String[n];
		check = new int[8];
		b = new String[n];
		list = new ArrayList<>();
		String a = sc.nextLine();
		int cnt=0;
		for(int i=0; i<a.length(); i=i+6){
			p[cnt++] = a.substring(i, i+6);
		}

		for(int i=0; i<p.length; i++){
			for(int j=0; j<8; j++){
				cnt = 0;
				for(int z=0; z<6; z++){
					if(p[i].charAt(z) != code[j][0].charAt(z)){
						cnt++;
					}
				}
				check[j] = cnt;
			}
			
//			System.out.println(Arrays.toString(check));

			for(int j=0; j<8; j++){
				if(check[j]==0 || check[j]==1){
					b[i] = code[j][1];
					break;
				}
			}
			if(b[i]==null){
				flag = false;
				break;
			}
		}
		
		if(flag){
			for(int j=0; j<b.length;j++){
				System.out.print(b[j]);
			}
		}
		else{
			for(int j=0; j<b.length; j++){
				if(b[j]==null){
					System.out.println(j+1);
					break;
				}
			}
		}
		
		

	}

}
