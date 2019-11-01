package stack2;

public class Power {
	public static int pow(int base, int exponent){
		int r=1;
		for(int i=0; i<exponent; i++){
			r = r*base;
		}
		return r;
	}
	private static int power(int base, int exponent) {
		if(exponent==0) return 1;
		if(exponent==1) return base;
		if((exponent%2)==0){
			int newbase = power(base,exponent/2);
			return newbase*newbase;
		}else{
			int newbase = power(base,(exponent-1)/2);
			return newbase*newbase*base;
		}
	}

	public static void main(String[] args) {
		long start = System.nanoTime();
		System.out.println(pow(3,10));
		long end = System.nanoTime();
		System.out.println(end-start+" ns");

		start = System.nanoTime();
		System.out.println(power(3,10));
		end = System.nanoTime();
		System.out.println(end-start+" ns");


		System.out.println(pow(3,1));
		System.out.println(pow(3,2));
		System.out.println(pow(3,3));
		//		System.out.println(pow(3,4));
		//		System.out.println(pow(3,5));
		//		System.out.println(pow(3,10));

		System.out.println(Math.pow(3, 2));
		System.out.println(Math.pow(3, 3));
		System.out.println(Math.pow(3, 4));
		System.out.println(Math.pow(3, 5));
		System.out.println(Math.pow(9, 50));
	}


}
