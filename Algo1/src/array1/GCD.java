package array1;

public class GCD {

	public static void main(String[] args) {
		System.out.println(gcd(6, 4));
		System.out.println(gcdR(124,62));
		
		System.out.println(4%6);
		System.out.println(6%4);

	}

	private static int gcdR(int x, int y) {
		if(y == 0){
			return x;
		}
		
		return gcdR(y,x%y);
	}

	private static int gcd(int x, int y) {
		if (x<y){ //y가 크면 y와 x값을 바꿔준다. x y 해주는데
			// ex) 6 4  6%4 = 2    4 2가 되고
			// 다시 계산하면 4%2 = 0	2 0 이 되는데 0값은 의미 없으므로 2 return.
			int t = x;
			x = y;
			y = t;
		}
		while(y!=0){
			int n=x%y;
			x = y;
			y = n;
		}
		return x;
	}

}
