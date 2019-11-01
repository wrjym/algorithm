package tree;

import java.util.Arrays;
import java.util.Scanner;
/*
 13
 A B C D E F G H I J K L M
 * 
 */
public class TreeArray {
	public static int N;
	public static char[] a;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		a = new char[N+1];
		for(int i=1; i<=N; i++){
			a[i] = sc.next().charAt(0);
		}
		System.out.println(Arrays.toString(a));
		
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}
	private static void preorder(int i) {
		if(i<=N && a[i]!='\u0000'){
			System.out.print(a[i] + " ");
			preorder(2*i);
			preorder(2*i+1);
		}
	}
	
	private static void inorder(int i) {
		if(i<=N && a[i]!='\u0000'){
			inorder(2*i);
			System.out.print(a[i] + " ");
			inorder(2*i+1);
		}
	}
	
	private static void	postorder(int i) {
		if(i<=N && a[i]!='\u0000'){
			postorder(2*i);
			postorder(2*i+1);
			System.out.print(a[i] + " ");
		}
	}

}
