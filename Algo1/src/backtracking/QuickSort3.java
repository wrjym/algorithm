package backtracking;

import java.util.Arrays;

public class QuickSort3 {
	public static int[] a = {69, 19, 40, 2, 16, 8, 31, 22};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quick(int begin, int end) {
		if (begin < end) {
			int p = lomuto(begin, end);
			//System.out.println(Arrays.toString(a) +" p="+ p +" a["+p+"]=" + a[p]+" begin=" + begin+" end=" + end );
			quick(begin, p-1);
			quick(p+1, end);
		}
	}
	
	private static int lomuto(int begin, int end) {//hoare partition는 pivot이 left
		int x = a[end];
		int I = begin-1;
		
		for(int J = begin; J<=end-1; J++) {
			if(a[J] <=x) {
				I++;
				int temp = a[I]; a[I] = a[J]; a[J]=temp;
			}
		}
		int temp = a[I+1]; a[I+1] = a[end]; a[end] = temp;
		return I+1;
	}
}
