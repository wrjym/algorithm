package Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Main1169_주사위던지기1_서울9반_김용민 {

	public static int n, caseCount, data[];
	public static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		n = 3;//sc.nextInt();

		data = new int[3];

		caseCount=0;

		permutation(1,0);
		System.out.println(caseCount);
		sc.close();

	}

	private static void permutation(int before, int count) {

		if(count==3){
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}



		for(int i=before;i<=3;i++){
			data[count] = i;
			permutation(i,count+1);
		}

	}

}
