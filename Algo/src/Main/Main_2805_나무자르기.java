package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main_2805_나무자르기 {
	public static ArrayList<Long> li;
	public static long ans;
	public static long max,min,mid;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/2805.txt"));
		Scanner sc = new Scanner(System.in);

		max = 0;
		Long n = sc.nextLong();
		long k = sc.nextInt();
		li = new ArrayList<>();
		for(int i=0; i<n; i++){
			Long a = sc.nextLong();
			li.add(a);
			max = Math.max(a, max);
		}
		min = 0;
		while(max>min){
			mid = (max+min)/2;
			long sum = 0;
			for(int i=0; i<li.size(); i++){
				if(li.get(i) >= mid){
					sum += (li.get(i) - mid);
				}
			}
//			System.out.println(max + " " + min + " " + mid + " " + sum + " " + cnt + " " + k);
			
			if(sum == k || mid == min){
				ans = mid;
				break ;
			}
			
			if(sum < k){
				max = mid;
			}
			else if(sum > k){
				min = mid;
			}

		}

		System.out.println(ans);
	}

}
