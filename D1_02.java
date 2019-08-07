package D1;
import java.util.*;
/*
 * 거꾸로출력
 */
public class D1_02 {
	public static void main(String args[]){
		Scanner scanner= new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		for(int i=0; i<=input;i++)
		{   
			int result=input-i;
			System.out.print(result+" ");
		}
		
	}
}
