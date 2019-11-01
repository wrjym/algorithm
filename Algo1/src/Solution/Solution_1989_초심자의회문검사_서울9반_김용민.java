package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1989_초심자의회문검사_서울9반_김용민 {
	public static String []word;
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("rs/input_1209.txt"));

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.next();
		word = new String[T];
		
		for(int i=0;i<T;i++){
			word[i] = sc.nextLine();
		}
		
		for(int tc = 0; tc < T; tc++){
			int start = 0;
			int end = (word[tc].length()-1);
			int count = 0;
			int size = (word[tc].length() / 2);
			for(int i=0;i<size;i++){
				if(word[tc].length()%2 == 1){ //홀
					if(word[tc].charAt(start) == word[tc].charAt(end)){
						start++;
						end--;
						count++;
					}
				}
				else{ // 짝
					if(word[tc].charAt(start) == word[tc].charAt(end)){
						start++;
						end--;
						count++;
					}
				}


			}
			if(count == size){
				System.out.println("#" + (tc+1)+ " " + 1);
			}
			else{
				System.out.println("#" + (tc+1)+ " " + 0);
			}
		}
	}

}
