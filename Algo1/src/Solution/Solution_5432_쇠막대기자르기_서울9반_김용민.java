package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution_5432_쇠막대기자르기_서울9반_김용민 {
	public static String []stack;
	public static int top = -1;
	public static Stack<String> sa;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_5432.txt"));
		
		Scanner sc = new Scanner(System.in);
		sa = new Stack<String>();
		int T = Integer.parseInt(sc.nextLine());
		for(int tc = 0; tc < T; tc++){
			String data = sc.nextLine();
			int sum =0;
			top = -1;
			stack = new String[1000];
			for(int i=0; i<data.length(); i++){
				String s = data.charAt(i)+"";
				switch(s){
				case "(":
				{
					sa.push(s);
					push(s);
					break;
				}
				case ")":
				{
					if(data.substring(i-1,i).equals("(")){
						sa.pop();

						sum += sa.size();						
						break;
					}
					else{
						sum += 1;
						sa.pop();
						break;
					}
				}
				}
//				System.out.println(Arrays.toString(stack));
			}
			System.out.println("#" + (tc+1) + " " + sum);
		}

	}

	private static void pop() {
		if(top < 0) {
			return ;
		}
		else{
			top--;
		}
	}
	private static void push(String x) {

		if(top >= stack.length-1){
			return;
		}
		stack[++top] = x;
	}
}
