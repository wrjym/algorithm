package array2;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class FiboTest {
	public static int [] memo = new int[100];
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(fibo(40));
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms\n");
		
		memo[0] = 0;
		memo[1] = 1;
		
		start = System.nanoTime();
		System.out.println(fibo1(40));
		end = System.nanoTime();
		System.out.println((end - start) + "ns\n");
		
		start = System.nanoTime();
		System.out.println(fibo2(40));
		end = System.nanoTime();
		System.out.println((end - start) + "ns\n");
	}
	public static int fibo2(int n){
		for(int i=2; i<=n; i++){
			memo[i] = memo[i-1] + memo[i-2]; 
		}
		
		return memo[n];
	}
	
	public static int fibo1(int n){
		if(n>=2 && memo[n] == 0){
			memo[n] = fibo1(n-1) + fibo1(n-2);
		}
		return memo[n];
	}

	public static int fibo(int n) {
		// TODO Auto-generated method stub
		if(n<2) return n;
		else return fibo(n-1) + fibo(n-2);
	}

}
