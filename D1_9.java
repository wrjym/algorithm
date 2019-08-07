package D1;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 중간값은 통계 집단의 수치를 크기 순으로 배열 했을 때 전체의 중앙에 위치하는 수치를 뜻한다."
 크기 순으로 배열한다음에 중앙에 위치한 값을 찾는 문제입니다.
 */
public class D1_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		  int count = sc.nextInt();
		  int tmp = 0;
		  int middle_count = Math.round(count/2);
		  int[] arr = new int[count];
		  
		  for (int i=0; i<count ;i++)
		  {
		   arr[i]=sc.nextInt(); 
		  }

		  Arrays.sort(arr);
		  System.err.print(arr[middle_count]);
		  
	}

}
