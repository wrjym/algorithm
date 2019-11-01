package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1218_괄호짝짓기_서울9반_김용민 {
	public static String [] stack;
	public static int top = -1;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_1218.txt"));

		Scanner sc = new Scanner(System.in);

		for(int tc = 0; tc < 10; tc++){
			int num = Integer.parseInt(sc.nextLine());
			stack = new String[num];
			String dd = sc.nextLine();
			int count = 1;
			for(int i=0;i<dd.length();i++){
				String s = dd.substring(i, i+1);

				String a;
				switch(s){
				case "{" : case "[" : case "(" : case "<" : 
				{
					push(s);
					break;
				}
				case "}" :
				{
					a = pop();
					if(!a.equals("{")){
						count = 0; i=dd.length(); continue;
					}
					break;
				}
				case "]" :
				{
					a = pop();
					if(!a.equals("[")){
						count = 0; i=dd.length(); continue;
					}
					break;
				}
				case ")" :
				{
					a = pop();
					if(!a.equals("(")){
						count = 0; i=dd.length(); continue;
					}
					break;
				} 
				case ">" :
				{
					a = pop();
					if(!a.equals("<")){
						count = 0; i=dd.length(); continue;
					}
					break;
				}
				}

			}
			System.out.println("#" + (tc+1) + " "+ count);

		}
	}

	private static String pop() {

		//		System.out.println("pop()");
		if(top < 0) {
			System.out.println("underflow");
			return " ";
		}
		else{
			String a = stack[top];
			stack[top--] = " ";
			return a;
		}

	}
	private static void push(String x) {
		//		System.out.println("push()");
		top = top +1;
		if(top > stack.length-1){
			System.out.println("overflow");
			top = stack.length-1;
			return;
		}
		else
			stack[top] = x;
	}




}