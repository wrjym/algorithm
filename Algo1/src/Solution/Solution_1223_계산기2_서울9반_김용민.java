package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1223_계산기2_서울9반_김용민 {
	public static String s;

	public static char[] stack = new char[100];
	public static int top = -1;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1223.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++){
			int T = Integer.parseInt(sc.nextLine());
			StringBuilder sb = new StringBuilder();
			s = sc.nextLine();
			for(int i=0; i<s.length(); i++){
				char c = s.charAt(i);
				if('0' <= c && c <='9'){
					sb.append(c);
				}
				else if(c == ')'){
					char t;
					while((t=stack[top--])!= '('){
						sb.append(t);
					}
				}else{
					while(getIcp(c)<=getIsp()){
						char t = stack[top--];		//pop
						sb.append(t);
					}
					stack[++top]=c;
				}		
			}
			while(top!=-1){
				sb.append(stack[top--]);
			}
//			System.out.println(sb);


			String s = sb.toString();
			int top = -1;		
			int[] stack = new int[100];
			for(int i=0; i<s.length(); i++){
				char c = s.charAt(i);
				if('0'<=c && c<='9'){
					stack[++top] = c-'0';
				}
				else{
					int n2 = stack[top--];
					int n1 = stack[top--];
					int nn = 0;
					switch(c){
					case '+':
						nn = n1+n2;	break;
					case '-':
						nn = n1-n2;	break;
					case '*':
						nn = n1*n2;	break;
					case '/':
						nn = n1/n2;	break;
					}
					stack[++top] = nn;	//push
				}
			}
			System.out.println("#" + tc + " " + stack[top--]);
		}
	}

	private static int getIsp() {
		char c = (top==-1)? '(':stack[top];
		switch(c){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 0;
		}
		return 0;
	}

	private static int getIcp(char c) {
		switch(c){
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '(':
			return 3;
		}
		return 0;
	}

}
