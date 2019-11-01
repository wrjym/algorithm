package Solution;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Popup;

public class Solution_1222_계산기1_서울9반_김용민 {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("rs/input_1222.txt"));

		Scanner sc = new Scanner(System.in);


		for(int tc = 0; tc < 10; tc++){
			Stack<Integer> st =new Stack<Integer>();
			int T = Integer.parseInt(sc.nextLine());			
			String data = sc.nextLine();
			st.push((int)data.charAt(0));
			st.push((int)data.charAt(2));

			for(int i=3; i<data.length(); i++){
				char cha = data.charAt(i);
				if(cha == '+' ){
					int b = st.pop();
					int a = st.pop();
					st.push((int)(a+b));
				}
				else{
					st.push((int)cha);
				}
			}
			System.out.println("#"+(tc+1) + " " + (st.pop()+st.pop()-((T/2+1)*48)));

		}
	}



}
