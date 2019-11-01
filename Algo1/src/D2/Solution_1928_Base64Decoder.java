package D2;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Scanner;

public class Solution_1928_Base64Decoder {
	public static String[] va;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1928.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();


		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			int size = a.length()/3;
			va = new String[size];

			Decoder decoder = Base64.getDecoder();
			byte[] decodedBytes2 = decoder.decode(a);
			
			System.out.print("#" + tc + " ");
			System.out.println(new String(decodedBytes2, "UTF-8"));
		}

	}

}
