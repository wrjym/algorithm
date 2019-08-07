package D1;
/*
 *   가위바위보 노가다
 */
import java.util.*;
public class D1_05 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		
		if(input1==1 && input2 ==3) // 가위 보
		{
			System.out.println("A");
		}
		else if(input1==1 && input2 ==2) //가위 바위
		{
			System.out.println("B");
		}
		else if(input1==2 && input2 ==3) // 바위 보
		{
			System.out.println("B");
		}
		else if(input1==2 && input2 ==1) // 바위 가위
		{
			System.out.println("A");
		}
		else if(input1==3 && input2 ==1) // 보 가위
		{
			System.out.println("B");
		}
		else if(input1==3 && input2 ==2) // 보 바위
		{
			System.out.println("A");
		}
		
	}
}
