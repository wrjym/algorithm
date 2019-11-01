package Main;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1018_십자카드문제 {
	public static String []data;
	public static String []data1 = new String[8];
	public static int min;
	public static int []check;
	public static int cnt;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		min = Integer.MAX_VALUE;
		data = a.split(" ");
		for(int i=0;i<data.length;i++){
			data1[i] = data[i];
			data1[i+4] = data[i];
		}
		
		for(int i=0; i<4; i++){
			a = "";
		
			for(int j=0; j<4; j++){
				a += data1[i+j];
			}
			int sizeA = Integer.parseInt(a);
			if(sizeA < min){
				min = sizeA;
			}
		}
		
		for(int i=1111; i<=min; i++){
			check(i);
		}
		System.out.println(cnt);
		
		
	}
	private static void check(int size) {
		int minValue=Integer.MAX_VALUE;
		int a = size/1000;
		int b = (size%1000)/100;
		int c = (size%100)/10;
		int d = (size%10);
		check = new int[8];
		check[0] = check[4] = a;
		check[1] = check[5] = b;
		check[2] = check[6] = c;
		check[3] = check[7] = d;
		
		for(int i=0; i<4; i++){
			int sum = check[i]*1000 + check[i+1]*100 + check[i+2]*10 + check[i+3];
			if(minValue > sum){
				minValue = sum;
			}
		}
		
		if(minValue == size){
			cnt++;
		}
		
		
		
	}


}
