package tree;

import java.util.Collections;

class BinaryTree{

	class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}

	}
	Node root;
	public void makeTree(int[] a) {
		root = makeTree(a,0,a.length-1);
	}
	private Node makeTree(int[] a, int start, int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		Node node = new Node(a[mid]);
		node.left = makeTree(a,start,mid-1);
		node.right = makeTree(a,mid+1,end);

		return node;
	}
	public void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			inorder(root.right);

		}
	}
	public void search(Node root, int data){
		if(data<root.data){
			System.out.println("smaller "+root.data);
			search(root.left,data);
		}
		else if(data>root.data){
			System.out.println("bigger " + root.data);
			search(root.right,data);
		}
		else{
			System.out.println("binggo");
		}
	}
}
/*

0 1 2 3 4 5 6 7 8 9

        4      
  1           7
0   2       6   8
      3   5       9

 */

public class BinaryTreeTest {

	public static void main(String[] args) {
//		int[] a = new int[10];
//		for(int i=0; i<a.length;i++)
//			a[i] = i;
		
		int[] a = {1,4,9,11,14,15,22,27,38,49};
		BinaryTree t = new BinaryTree();
		t.makeTree(a);
//		t.inorder(t.root);
		t.search(t.root, 22);	
	}

}
