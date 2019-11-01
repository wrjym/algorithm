package list;

import java.util.LinkedList;

class LinkedStack{
	Node top = null;
	void print(){
		if(top==null){
			return;
		}
		Node n = top;
		while(n.next!=null){
			System.out.print(n.data+"<-");
			n=n.next;
		}
		System.out.println(n.data);
	}
	public boolean push(int i) {
		Node temp = new Node();
		temp.data = i;
		temp.next = top;
		top = temp;
		return true;
	}
	public int pop() {
		int item;
		Node temp = top;
		
		
		if(top == null){
			return 0;
		}
		else{
			item = temp.data;
			top = temp.next;
			return item;
		}
	}

}
public class LinkedStack_서울9반_김용민 {

	public static void main(String[] args) {
		LinkedStack ll = new LinkedStack();


		ll.push(3);
		ll.push(23);
		ll.pop();
		ll.print();
		
		ll.push(1);
		ll.push(5);
		ll.push(3);
		ll.print();
		
		
		
		
		
	}



}
