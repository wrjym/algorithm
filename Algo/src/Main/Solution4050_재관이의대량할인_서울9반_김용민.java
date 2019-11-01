package Main;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution4050_재관이의대량할인_서울9반_김용민 {
	public static int []num;
	public static ArrayList<Integer> list;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/11508.txt"));
		Scanner sc = new Scanner(System.in);
		list = new ArrayList<>();
		
		int n = sc.nextInt();
		num = new int[n+2];
		for(int i=0; i<n; i++){
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		Collections.reverse(list);
//		System.out.println(list);

		for(int i=0; i<list.size(); i++){
			num[i] = list.get(i);
		}
		int sum=0;
		for(int i=0; i<list.size(); i=i+3){
			if(num[i+1]==0	){
				sum += num[i];
			}
			else if(num[i+2]==0){
				sum += num[i] + num[i+1];
			}
			else{
				int min = Math.min(num[i], num[i+1]);
				min = Math.min(min, num[i+2]);
				sum += list.get(i) + list.get(i+1) + list.get(i+2);
				sum -= min;
			}
		}

		System.out.println(sum);
	}

}
