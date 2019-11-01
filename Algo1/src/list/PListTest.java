package list;

class MyPLinkedList{
	Node header = new Node();

	void addFirst(int data){
		Node n = new Node();
		n.data=data;
		n.next=header.next;
		header.next=n;
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

	public void add(int data) {
		Node tmp = header;
		if(header==null)
			addFirst(data);
		else{
			Node end = new Node();
			end.data=data;
			Node n = header;
			while(n.next!=null){
				if(data < header.data){
					end.next=n.next;
					n.next=end;
					return;
				}else
					n=n.next;
			}
		}
	}
}

public class PListTest {

	public static void main(String[] args) {
		//		ArrayList a = new ArrayList();
		MyPLinkedList ll = new MyPLinkedList();

		ll.add(1);
		ll.add(3);
		ll.add(2);
		ll.print();


		//		ll.addFirst(3);
		//
		//		ll.append(6);
		//		ll.addFirst(2);
		//		ll.addFirst(1);
		//		ll.print();
		//		ll.delete(2);
		//		ll.print();
	}

}
