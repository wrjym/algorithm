package D1;
/*
 *  �ϳ��� �ڿ����� �Է� �޾� �� �ڸ����� ���� ����ϴ� ���α׷��� �ۼ��϶�.

[���� ����]

�ڿ��� N�� 1���� 9999������ �ڿ����̴�. (1 �� N �� 9999)
[�Է�]

�Է����� �ڿ��� N�� �־�����.

[���]

�� �ڸ����� ���� ����Ѵ�.
 */
import java.util.Scanner;

public class D1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
		  int num = sc.nextInt();
		  int f=1000;
		  int s=100;
		  int t=10;
		  int r=0;
		  int a,b,c,d=0;
		  if (num>f)
		  {
		   a=num/f; // 1000��
		   num=num%f; // 1000 ������
		   b=num/s;   // 100 ��
		   num=num%s;  // 100 ������
		   c=num/t;   // 10 ��
		   d=num%t;  // 10 ������
		   
		   System.out.println(a+b+c+d);
		  }
		  else if (num > s)
		  {
		   b=num/s;   // 100 ��
		   num=num%s;  // 100 ������
		   c=num/t;   // 10 ��
		   d=num%t;  // 10 ������
		   
		   System.out.println(b+c+d);
		  }
		  else if (num > f){
		   c=num/t;   // 10 ��
		   d=num%t;  // 10 ������ 
		   System.out.println(c+d);
		  }
		  
		  else {
		   c=num/t;   // 10 ��
		   d=num%t;  // 10 ������
		   System.out.println(d);
		  } 
	}

}
