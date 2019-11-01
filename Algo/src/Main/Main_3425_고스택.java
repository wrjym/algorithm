package Main;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_3425_고스택 {
	public static ArrayList<String> list;
	public static ArrayList<Integer> stack;
	public static Scanner sc;
	public static boolean flag;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/3425.txt"));
		sc = new Scanner(System.in);
		list = new ArrayList<>();
		stack = new ArrayList<Integer>();

		while(true) {
			String text = sc.nextLine();
			if(text.equals("QUIT"))
				break;

			if(!text.equals("")) {
				list.add(text);
			}

			if(text.equals("END")) {
				inputData();
				list = new ArrayList<>();
				System.out.println();
			}
		}

	}

	private static void inputData() {
		int size = Integer.parseInt(sc.nextLine());
		for(int i=0; i<size; i++) {
			stack.add(Integer.parseInt(sc.nextLine()));
			goStack();

			stack = new ArrayList<>();
		}
	}

	private static void goStack() {
		flag = false;
		for(int i=0; i<list.size()-1; i++) {
			String text = list.get(i);
			findText(text);
			if(flag) {
				break;
			}
		}

		if(stack.size()>1 || stack.size()==0 || stack.get(0)>1000000000 || stack.get(0)<-1000000000 || flag) {
			System.out.println("ERROR");
		}
		else {
			System.out.println(stack.get(0));
		}
	}

	private static void findText(String text) {
		int one,two;
		switch(text) {
		case "POP":
			if(stack.size()>=1) 
				stack.remove(0);
			else
				flag=true;
			break;
		case "INV":
			if(stack.size()>=1) 
				stack.set(0, stack.get(0)*(-1));
			break;
		case "DUP":
			if(stack.size()>=1) 
				stack.add(0, stack.get(0));
			break;
		case "SWP":
		if(stack.size()>=2) {
			int tmp = stack.get(0);
			stack.set(0, stack.get(1));
			stack.set(1, tmp);
		}
		else{
			flag=true;
		}
			break;
		case "ADD":
			if(stack.size()>=2) {
				one = stack.get(0);
				two = stack.get(1);
				stack.remove(0);
				stack.remove(0);
				stack.add(0, one+two);
			}
			else{
				flag=true;
			}
			break;
		case "SUB":
			if(stack.size()>=2) {
				one = stack.get(0);
				two = stack.get(1);
				stack.remove(0);
				stack.remove(0);
				stack.add(0, two-one);
			}
			else{
				flag=true;
			}
			break;
		case "MUL":
			if(stack.size()>=2) {
				one = stack.get(0);
				two = stack.get(1);
				stack.remove(0);
				stack.remove(0);
				double onetmp = (double)one;
				double twotmp = (double)two;
				if(onetmp*twotmp<1000000000) {
					stack.add(0, one*two);
				}
			}
			break;
		case "DIV":
			if(stack.size()>=2) {
				one = stack.get(0);
				two = stack.get(1);
				if(one!=0) {
					stack.remove(0);
					stack.remove(0);
					stack.add(0, two/one);
				}
			}
			break;
		case "MOD":
			if(stack.size()>=2) {
				one = stack.get(0);
				two = stack.get(1);
				if(one!=0) {
					stack.remove(0);
					stack.remove(0);
					stack.add(0, two%one);
				}
			}
			break;
		default : 
			String []data = new String[2];
			data = text.split(" ");
			if(Integer.parseInt(data[1])>1000000000) {
				flag=true;
			}
			stack.add(0, Integer.parseInt(data[1]));
			break;
		}
	}
	//  System.out.println(stack);
}