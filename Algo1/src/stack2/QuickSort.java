package stack2;

import java.util.Arrays;

public class QuickSort {
	public static int[] a = {69,10,30,2,16,8,31,22};

	public static void quick(int begin, int end) {
		if(begin < end){
			int p = partition(begin,end);
			System.out.println(Arrays.toString(a) + "p=" +p+" a[" + p+"]="+a[p]+ " begin=" + begin + " end=" + end);
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
			System.out.println(Arrays.toString(a) + "1. pivot=" +pivot+" a[" + pivot +"]="+a[pivot]+ " begin=" + begin + " end=" + end);
			if(L<R) {
				int T=a[L];
				a[L] = a[R];
				a[R] = T;
				System.out.println(Arrays.toString(a) + "2. pivot=" +pivot+" a[" + pivot+"]="+a[pivot]+ " begin=" + begin + " end=" + end);
			}
		}
		int T=a[R];
		a[R] = a[pivot];
		a[pivot] = T;
		System.out.println(Arrays.toString(a) + "3. pivot=" +pivot+" a[" + pivot+"]="+a[pivot]+ " begin=" + begin + " end=" + end);
		return R;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));
		quick(0,a.length-1);
		System.out.println(Arrays.toString(a));

	}



}
