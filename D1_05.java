package D1;
/*
 *   ���������� �밡��
 */
import java.util.*;
public class D1_05 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int input1 = sc.nextInt();
		int input2 = sc.nextInt();
		
		if(input1==1 && input2 ==3) // ���� ��
		{
			System.out.println("A");
		}
		else if(input1==1 && input2 ==2) //���� ����
		{
			System.out.println("B");
		}
		else if(input1==2 && input2 ==3) // ���� ��
		{
			System.out.println("B");
		}
		else if(input1==2 && input2 ==1) // ���� ����
		{
			System.out.println("A");
		}
		else if(input1==3 && input2 ==1) // �� ����
		{
			System.out.println("B");
		}
		else if(input1==3 && input2 ==2) // �� ����
		{
			System.out.println("A");
		}
		
	}
}
