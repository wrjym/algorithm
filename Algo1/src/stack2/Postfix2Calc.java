package stack2;

public class Postfix2Calc {
	public static void main(String[] args) {
		String s = "6528-*2/+";
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
		System.out.println(stack[top--]);
	}
	
	
	
	
	
	
	
	
	
	

}
