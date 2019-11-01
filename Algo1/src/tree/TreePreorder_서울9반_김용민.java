package tree;

import java.util.Arrays;
import java.util.Scanner;
/*
13
1 2 1 3 2 4 3 5 3 6 4 7 5 8 5 9 6 10 6 11 7 12 11 13
 */
class Node{
	int data;
	Node left, right;
}

class Tree{
	Node root;

	public Node makeTree(Node left,int data, Node right){
		Node node = new Node();
		node.left = left;
		node.data = data;
		node.right = right;
		return node;
	}

	public void preorder(Node root){	//전위
		if(root!=null){
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

}

public class TreePreorder_서울9반_김용민 {
	public static int n;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Node[] node;
		n = sc.nextInt();
		Tree t = new Tree();

		node = new Node[n+1];
		for(int i=1; i<=n; i++){
			node[i] = t.makeTree(null, i, null);
		}
		

		for(int i=1; i<=n; i++){
			System.out.print(node[i].data + " ");
		}
		System.out.println();

		
		for(int i=1; i<n; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(node[a].left==null){
				node[a].left = node[b];
			}
			else{
				node[a].right= node[b];
			}
		}

		t.preorder(node[1]);

	}
	
}
