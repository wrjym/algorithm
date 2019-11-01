package array2;

import java.util.Arrays;
import java.util.Scanner;

public class StackTest {

	public static int []data = new int[10];
	public static int top = -1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aa = 0;
		while(aa != -1){
			aa = sc.nextInt();
			switch(aa){
			case 1:
				push(5);
				break;
			case 2:
				pop();
			}
		}
		System.out.println(Arrays.toString(data));
	}
	private static void pop() {
		if(top < 0) {
			System.out.println("underflow");
			return;
		}
		else{
			data[top--] = 0;
		}
	}
	private static void push(int x) {
		top = top +1;
		if(top > data.length-1){
			System.out.println("overflow");
			top = data.length-1;
			return;
		}
		else
			data[top] = x;
	}

}
