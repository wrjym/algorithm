package D1;

import java.util.Arrays;
import java.util.Scanner;
/*
 * �߰����� ��� ������ ��ġ�� ũ�� ������ �迭 ���� �� ��ü�� �߾ӿ� ��ġ�ϴ� ��ġ�� ���Ѵ�."
 ũ�� ������ �迭�Ѵ����� �߾ӿ� ��ġ�� ���� ã�� �����Դϴ�.
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
