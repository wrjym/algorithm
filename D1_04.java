package D1;
/*
 *  Æò±Õ°ª
 */
import java.util.Scanner;

public class D1_04 {
	public static void main(String args[])
	{
		 Scanner input = new Scanner(System.in);
	        int line = input.nextInt();
	        double result = 0.0;
	        for(int i=0; i<line; i++){
	            for(int j=0; j<10; j++){
	                double num=input.nextDouble();
	                result = result + num;
	            }
	            result=result/10;
	            
	            System.out.println("#"+(i+1)+" "+Math.round(result));
	            result=0;
	        }
	}
}
