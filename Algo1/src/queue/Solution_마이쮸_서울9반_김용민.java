package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	private int count;
	private int num;


	public Pair(int num,int count) {
		this.num=num;
		this.count=count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


}

public class Solution_마이쮸_서울9반_김용민 {

	public static int total = 20;

	public static void Solution_마이쮸_서울9반_김용민(String[] args) {
		Queue<Pair> ll = new LinkedList();
		int user = 1;
		int count=1;
		ll.offer(new Pair(user++,count));
		while(total > 0 ){
			
			total -= ll.peek().getCount();
			if(total<=0){
				break;
			}
			ll.offer(new Pair(ll.peek().getNum(), ll.poll().getCount()+1));
			ll.offer(new Pair(user++,1));
			

		}
		System.out.println(ll.poll().getNum());

	}

}
