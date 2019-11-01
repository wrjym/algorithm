package brutegreedy;

public class Power {

	public static int power(int base, int exponent) {	// base : 3	exponent : 30
		if(exponent==0) return 1;
		if(exponent==1) return base;
		if(exponent%2==0) {
			int newbase = power(base, exponent/2);
			return newbase*newbase;
		}
		else {
			int newbase = power(base, (exponent-1)/2);
			return newbase*newbase*base;
		}
	}
	public static int pow(int base, int exponent) {
		int r=1; // 2^3    3 == 0011 -> 쉬프트연산해가면서 반복
		while(exponent>0) {
			if((exponent&1) == 1) { // 홀수면
				r = r*base;
			}
			exponent = exponent>>1;
			base = base*base;
		}
		/*for(int i=0; i<exponent; i++) {
			r = r*base;
		}*/
		return r;
	}
	
	public static void main(String [] args) {	
		long start = System.nanoTime();
		System.out.println(power(3, 30));
		long end = System.nanoTime();
		System.out.println(end-start+"ns");
		

		start = System.nanoTime();
		System.out.println(pow(3, 30));
		end = System.nanoTime();
		System.out.println(end-start+"ns");
		
		
		start = System.nanoTime();
		System.out.println(Math.pow(3, 30));
		end = System.nanoTime();
		System.out.println(end-start+"ns");
	}
}
