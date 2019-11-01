package backtracking;

import java.util.Arrays;

public class QuickSort2 {
	public static int[] a = {69,10,30,2,16,8,31,22};

	public static void quick(int begin, int end) {
		if(begin < end){
			int pivot = hoare(begin,end);
			quick(begin,pivot-1);
			quick(pivot+1,end);

		}
	}
	public static int hoare(int begin, int end) {
		int pivot = a[begin];
		int I = begin;
		int J = end;
		
		while(I<J){
			while(a[I]<=pivot && I<end)	I++;
			while(a[J]>=pivot && begin<J)	J--;
			if(I<J) {
				int T=a[J];
				a[J] = a[I];
				a[I] = T;
			}
		}
		int T=a[J];
		a[J] = a[begin];
		a[begin] = T;
		return J;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));

	}



}
