package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
class Node{
	int now;
	String data;
	Node left, right;
}
class Tree{
	Node root;
	public Node TreeMaker(int now, String data, Node left, Node right){
		Node node = new Node();
		node.now = now;
		node.left = left;
		node.data = data;
		node.right = right;
		return node;
	}

	public void inorder(Node root){	//중위
		if(root!=null){
			inorder(root.left);
			System.out.print(root.data );
			inorder(root.right);
		}
	}
}
*/
public class Solution_1231_중위순회_서울9반_김용민 {
	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("rs/input_1231.txt"));
		Scanner sc = new Scanner(System.in);
		String []data = new String[10];
		Node []node;
		Tree t = new Tree();
		for(int tc=1; tc<=10; tc++){
			int n = Integer.parseInt(sc.nextLine());
			node = new Node[n+1];

			for(int i=1; i<=n; i++){
				node[i] = t.TreeMaker(i, null, null, null);
			}

			for(int i=1; i<=n; i++){
				String a = sc.nextLine();
				data = a.split(" ");
//				System.out.println(Arrays.toString(data));
				if(data.length==2){
					node[i].now = Integer.parseInt(data[0]);
					node[i].data = data[1];
				}else if(data.length==3){
					node[i].now = Integer.parseInt(data[0]);
					node[i].data = data[1];
					node[i].left = node[Integer.parseInt(data[2])];
				}else if(data.length==4){
					node[i].now = Integer.parseInt(data[0]);
					node[i].data = data[1];
					node[i].left = node[Integer.parseInt(data[2])];
					node[i].right = node[Integer.parseInt(data[3])];
				}
			}
			
			System.out.print("#" + tc + " ");
			t.inorder(node[1]);
			System.out.println();

			
			
		}


	}

}
