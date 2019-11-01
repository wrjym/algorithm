package array1;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fiboR(11));

	}

	private static int fiboR(int N) {
		// TODO Auto-generated method stub
		if(N == 0 || N==1)
			return N;
		
		return fiboR(N-1) + fiboR(N-2);
	}

}
