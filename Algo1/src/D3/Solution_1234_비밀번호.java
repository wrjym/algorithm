package D3;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1234_비밀번호 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/1234.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++){
			ArrayList<Integer> list = new ArrayList<>();
			ArrayList<Integer> delete = new ArrayList<>();
			String a = sc.nextLine();
			String []d;
			d = a.split(" ");
			for(int i=0; i<d[1].length(); i++){
				list.add(Integer.parseInt(d[1].charAt(i)+""));
			}
			
			boolean falg = true;
			int i=0;
			while(falg){
				if(list.get(i) == list.get(i+1)){
					list.remove(i);
					list.remove(i);
					i = 0;
				}
				i++;
				
				if(i == list.size()-1){
					if(list.get(0) == list.get(1)){
						list.remove(0);
						list.remove(0);
					}
					break;
				}
				
			}
			System.out.print("#" + tc + " ");
			for(i=0; i<list.size(); i++){
				System.out.print(list.get(i));
			}
			System.out.println();


			
		}
	}

}
