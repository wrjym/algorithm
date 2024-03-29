package stack2;

import java.util.Arrays;

public class QuickSort2 {
	public static int[] a = {69,19,30,2,16,8,31,22};

	public static void quick(int begin, int end) {
		if(begin < end){
			int p = partition(begin,end);
			quick(begin,p-1);
			quick(p+1,end);

		}
	}
	public static int partition(int begin, int end) {
		int pivot=(begin+end)/2;
		int L=begin;
		int R=end;
		while(L<R){
			while(a[L]< a[pivot] && L<R)	L++;
			while(a[R]>=a[pivot] && L<R)	R--;
			if(L<R) {
				if(L==pivot)
					pivot=R;
				int T=a[L];
				a[L] = a[R];
				a[R] = T;
			}
		}
		int T=a[R];
		a[R] = a[pivot];
		a[pivot] = T;
		return R;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));

	}



}
