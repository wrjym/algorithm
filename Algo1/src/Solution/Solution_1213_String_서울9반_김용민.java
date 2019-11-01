package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1213_String_서울9반_김용민 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/input_1213.txt"));

		Scanner sc = new Scanner(System.in);

		for(int i=1;i<=10;i++){
			int testcase = sc.nextInt();
			String abe = sc.next();
			String str = sc.next();
			int realcount=0;
			int z=0;
			int count=0;
			for(int j=0;j<str.length();j++){
				int aa = (int)str.charAt(j); 
				int bb = (int)abe.charAt(z);
				int aa1 = (int) abe.charAt(0);
				if( aa== bb ){
					count++;
					z++;
				}
				else if (aa==aa1){
					count=count;
				}
				else{
					count=0;
					z=0;					
				}

				if(count==abe.length()){

					realcount++;
					z=0;
					count=0;
				}

			}

			System.out.println("#"+ i + " " + realcount);
		}
	}
}