package array1;
import java.util.*;
public class Baby_gin_Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int babygin[] = new int[2];
//		int data[] = new int[6];
		
		int data[] = {1,2,3,1,2,3};
		int data1[] = new int[6];
		
//		for(int i=0;i<6;i++){
//			data[i] = (int)(Math.random()*10)+1;
//		}
		
		
		
		for(int i=0;i<6;i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
		Arrays.sort(data);
		System.out.println(Arrays.toString(data));
		int count=1;
		data1[0] = data[0];

		
	}

}
