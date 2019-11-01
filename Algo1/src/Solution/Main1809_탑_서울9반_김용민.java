package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Pair{
	int data;
	int index;
	public Pair(int data, int index) {
		super();
		setData(data);
		setIndex(index);
	}	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}


}

public class Main1809_탑_서울9반_김용민 {

	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("rs/input_1809.txt"));

		Scanner sc = new Scanner(System.in);
//		for(int tc = 1; tc <= 10; tc++){
			int T = sc.nextInt();
			Stack<Pair> stack = new Stack<Pair>();
//			System.out.print("#" + tc + " ");
			for(int i=1; i<=T; i++){
				int data = sc.nextInt();
				if(stack.isEmpty()){			
					stack.push(new Pair(data,i));
					System.out.print(0 + " ");
				}
				else if (stack.peek().getData() < data && stack.size()==1){
					stack.pop();
					System.out.print(0 + " ");
					stack.push(new Pair(data,i));
				}
				else if(stack.peek().getData() < data){
					stack.pop();
					System.out.print(stack.peek().getIndex() + " ");
					stack.push(new Pair(data,i));
				}
				else{
					System.out.print(stack.peek().getIndex() + " ");
					stack.push(new Pair(data,i));
				}
			}
			System.out.println();
//		}
	}

}
