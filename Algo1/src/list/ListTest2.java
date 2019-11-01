package list;

class MyLinkedList2{
	Node header = header=null;

	void addFirst(int data){
		Node n = new Node();
		n.data=data;
		n.next=header;
		header=n;
	}
	void append(int data){
		if(header==null)
			addFirst(data);
		else{
			Node end = new Node();
			end.data=data;
			Node n=header;
			while(n.next!=null){
				n=n.next;
			}
			n.next=end;
		}
	}

	void print(){
		if(header==null){
			return;
		}
		Node n = header;
		while(n.next!=null){
			System.out.print(n.data+"->");
			n=n.next;
		}
		System.out.println(n.data);
	}
	
	void delete(int data){
		if(header==null)
			return;
		if(header.data==data){
			header=header.next;
			return;
		}
		Node n = header;
		while(n.next!=null){
			if(n.next.data==data){
				n.next=n.next.next;
				return;
			}
			else
				n=n.next;
		}
	}
}

/*
class Node{
	int data;
	Node next;

}
*/

public class ListTest2 {

	public static void main(String[] args) {
//		ArrayList a = new ArrayList();
		MyLinkedList2 ll = new MyLinkedList2();
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.append(4);
		ll.append(5);
		ll.print();
		ll.delete(2);
		ll.print();
	}

}
