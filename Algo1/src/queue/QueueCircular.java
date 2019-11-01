package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCircular {
	public static int queue[] = new int[100];
	public static int n = queue.length;
	public static int front=0;
	public static int rear=0;

	public static boolean isEmpty(){
		if(front == rear) return true;
		else return false;
	}
	public static boolean isFull(){
		if((1+rear)%n == front) return true;
		return false;
	}
	public static void enqueue(int item){
		if(isFull()){
			System.out.println("Full");
			return;
		}
		queue[(++rear)%n]=item;
	}
	public static int dequeue(){
		if(isEmpty()){
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[(++front)%n];
	}

	public static int qpeek(){
		if(isEmpty()){
			System.out.println("Queue empty");
			return -1;
		}
		return queue[(1+front)%n];
	}
	
	
	public static void main(String[] args) {
		
		enqueue(1);
		enqueue(2);
		System.out.println("peek=" + qpeek());		
		
//		Queue<String> q = new LinkedList<>();
//		q.offer("홍길동");
//		q.offer("손오공");
//		System.out.println(q.peek());
//		q.poll();
//		System.out.println(q.peek());
//		System.out.println(q.size());
	}

}
