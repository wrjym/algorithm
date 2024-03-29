package tree;

import tree.BST.Node;

class BST{
	class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
		
		@Override
		public String toString() {
			return ""+data;
		}
		
	}
	Node root;
	public void insert(int data){
		root=insert(root,data);
	}
	private Node insert(Node root, int data) {
		if(root==null){
			root = new Node(data);
			return root;
		}
		if(data<root.data){
			root.left=insert(root.left, data);
		}else if(data>root.data){
			root.right=insert(root.right,data);
		}
		return root;
	}
	
	public void inorder(){
		inorder(root);
//		System.out.println(root);
	}
	private void inorder(Node root) {
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	public char[] search(Node root2, int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void delete(int data){
		root=delete(root,data);
	}
	private Node delete(Node root, int data) {
		if(root==null){
			return root;
		}
		if(data<root.data){
			root.left=insert(root.left, data);
		}else if(data>root.data){
			root.right=insert(root.right,data);
		}else{
			if(root.left==null && root.right==null){
				return null;
			}else if(root.left==null){
				return root.right;
			}else if(root.right==null){
				return root.left;
			}
			
			root.data=findMin(root.right);
			root.right=delete(root.right,root.data);
			
		}
		return root;
	}
	private int findMin(Node root) {
		int min=root.data;
		while(root.right!=null){
			min=root.left.data;
			root=root.left;
			
		}
		return min;
	}
}
/*

       4
    2     6
   1 3   5 7


 */

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BST t = new BST();
		t.insert(4);
		t.insert(2);
		t.insert(3);
		t.insert(6);
		t.insert(1);
		t.insert(9);
		
		t.inorder();
		
		System.out.println(t.search(t.root,7));
	}

}
