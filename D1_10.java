package D1;
/*
 *  하나의 자연수를 입력 받아 각 자릿수의 합을 계산하는 프로그램을 작성하라.

[제약 사항]

자연수 N은 1부터 9999까지의 자연수이다. (1 ≤ N ≤ 9999)
[입력]

입력으로 자연수 N이 주어진다.

[출력]

각 자릿수의 합을 출력한다.
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
		   a=num/f; // 1000몫
		   num=num%f; // 1000 나머지
		   b=num/s;   // 100 몫
		   num=num%s;  // 100 나머지
		   c=num/t;   // 10 몫
		   d=num%t;  // 10 나머지
		   
		   System.out.println(a+b+c+d);
		  }
		  else if (num > s)
		  {
		   b=num/s;   // 100 몫
		   num=num%s;  // 100 나머지
		   c=num/t;   // 10 몫
		   d=num%t;  // 10 나머지
		   
		   System.out.println(b+c+d);
		  }
		  else if (num > f){
		   c=num/t;   // 10 몫
		   d=num%t;  // 10 나머지 
		   System.out.println(c+d);
		  }
		  
		  else {
		   c=num/t;   // 10 몫
		   d=num%t;  // 10 나머지
		   System.out.println(d);
		  } 
	}

}
