package string;

public class StringTest {

	public static void main(String[] args) {
		String s1 =	"홍길동";
		String s2 = "홍길동";
		
		String t1 = new String("홍길동");
		String t2 = new String("홍길동");
		
		System.out.println(s1 == s2);
		System.out.println(s1 == t1);
		System.out.println(t1 == t2);

		
	}

}
