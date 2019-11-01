package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static int queue[] = new int[100];
	public static int front=-1;
	public static int rear=-1;

	public static boolean isEmpty(){
		if(front == rear) return true;
		else return false;
	}
	public static boolean isFull(){
		if(rear == queue.length-1) return true;
		return false;
	}
	public static void enqueue(int item){
		if(isFull()){
			System.out.println("Full");
			return;
		}
		queue[++rear]=item;
		int k = rear;
		for(int j=k-1; j>front; j--){
			if(queue[j]>queue[k]){
				int T = queue[j];
				queue[j]=queue[k];
				queue[k]=T;
				k=j;
			}
		}
	}
	public static int dequeue(){
		if(isEmpty()){
			System.out.println("Queue Empty");
			return -1;
		}
		return queue[++front];
	}

	public static int qpeek(){
		if(isEmpty()){
			System.out.println("Queue empty");
			return -1;
		}
		return queue[1+front];
	}
	
	
	public static void main(String[] args) {
		
		
		
		
		Queue<String> q = new LinkedList<>();
		q.offer("홍길동");
		q.offer("손오공");
		System.out.println(q.peek());
		q.poll();
		System.out.println(q.peek());
		System.out.println(q.size());
	}

}
