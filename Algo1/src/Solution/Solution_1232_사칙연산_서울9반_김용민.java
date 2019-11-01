package Solution;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
class Node{
	int now;
	String data;
	Node left, right;
}
class Tree{
	Node root;
	StringBuilder sb = new StringBuilder();
	public Node TreeMaker(int now, String data, Node left, Node right){
		Node node = new Node();
		node.now = now;
		node.left = left;
		node.data = data;
		node.right = right;
		return node;
	}

	public StringBuilder inorder(Node root){	//중위
		if(root!=null){
			inorder(root.left);
			inorder(root.right);

			sb.append(root.data + " ");
		}

		return sb;
	}
}
public class Solution_1232_사칙연산_서울9반_김용민 {

	public static void main(String[] args) throws Exception{

		System.setIn(new FileInputStream("rs/input_1232.txt"));
		Scanner sc = new Scanner(System.in);
		String []data = new String[10];
		String []sbdata = new String[100];
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

			StringBuilder sb = t.inorder(node[1]);
			sbdata = sb.toString().split(" ");
//			System.out.println(Arrays.toString(sbdata));
			Stack <Integer>stack = new Stack();
			int sum = 0;
			int a,b;
			for(int i=0; i<sbdata.length; i++){
				switch(sbdata[i]){
				case "-":
					a = stack.pop();
					b = stack.pop();
					sum = b-a;
					stack.push(sum);
					break;
				case "+":
					a = stack.pop();
					b = stack.pop();
					sum = b+a;
					stack.push(sum);
					break;
				case "/":
					a = stack.pop();
					b = stack.pop();
					sum = b/a;
					stack.push(sum);
					break;
				case "*":
					a = stack.pop();
					b = stack.pop();
					sum = b*a;
					stack.push(sum);
					break;
				default:
					stack.push(Integer.parseInt(sbdata[i]));
					break;
				}
			}
			
			System.out.println("#" + tc + " " + sum);

		}


	}


}
