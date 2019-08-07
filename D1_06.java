package D1;

import java.util.Scanner;
/*
 *  두입력값 부등호 비교
 */
public class D1_06 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 Scanner input = new Scanner(System.in);
	        int line = input.nextInt();
	        String result = "";
	        for(int i=0; i<line; i++){
	        	int num1 = input.nextInt();
	        	int num2 = input.nextInt();
	        	if (num1>num2) result=">";
	        	else if (num1<num2) result="<";
	        	else result="=";
	        		System.out.println("#"+(i+1)+" "+result);
	         
	        }
	}

}
