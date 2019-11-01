package queue;

class Node {
	int data;
	Node link;
	
	Node(int data,Node link){
		this.data = data;
		this.link = link;
	}
	Node(int data){
		this(data,null);
	}

}

public class QueueLinked {
	public static Node front = null;
	public static Node rear = null;
	
	public static boolean isEmpty(){
		if(front == rear) return true;
		else return false;
	}
//	public static boolean isFull(){
//		if( == front) return true;
//		return false;
//	}
	public static void enqueue(int item){
		Node end = new Node(item);
		if(front==null){
			front=end;
			rear=end;
		}
		else{
			rear.link=end;
			rear=end;
		}	
	}
	public static int dequeue(){
		if(isEmpty()){
			System.out.println("Queue Empty");
			return -1;
		}
		int data=front.data;
		front=front.link;
		if(front==null)
			rear=null;
		return data;
	}

	public static int qpeek(){
		if(isEmpty()){
			System.out.println("Queue Empty");
			return -1;
		}
		int data=front.data;
		return data;
	}
	
	
	public static void main(String args[]){
		
	}
	
	
	
}