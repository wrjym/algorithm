package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		List<Integer> result = new ArrayList();
		while(left.size() > 0 || right.size() > 0){
			if(left.size() > 0 && right.size() > 0){
				if(left.get(0)<right.get(0)){
					result.add(left.remove(0));
				}else{
					result.add(right.remove(0));
				}
			}
			else if(left.size()>0){
				for(int i=0; i<left.size(); i++) result.add(left.remove(0));
			}
			else if(right.size()>0){
				for(int i=0; i<right.size(); i++) result.add(right.remove(0));
			}
		}
		return result;
		
	}
	public static List<Integer> mergesort(List<Integer> m) {
		if(m.size() == 1)
			return m;
		List<Integer> left = new ArrayList();
		List<Integer> right = new ArrayList();


		int mid = m.size()/2;
		for(int i=0; i<mid; i++)
			left.add(m.get(i));
		for(int i=mid; i<m.size(); i++){
			right.add(m.get(i));
		}

		left = mergesort(left);
		right = mergesort(right);
		return merge(left,right);

	}
	public static void main(String[] args) {
		int[] a={69,10,30,2,16,8,31,22};
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<a.length; i++){
			list.add(a[i]);
		}

		System.out.println(Arrays.toString(a));
		System.out.println(mergesort(list));
	}
}
