package D3;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 숫자바꾸기 {

	public static void main(String[] args)  throws Exception{
		System.setIn(new FileInputStream("rs/1.txt"));
		Scanner sc = new Scanner(System.in);
		ArrayList<String> num = new ArrayList<>();
		
		String tmp = sc.nextLine();
		for(int i=0; i<tmp.length(); i++){
			num.add(tmp.charAt(i)+"");
		}
		Collections.reverse(num);
		for(int z=0; z<num.size(); z++){
			int n = Integer.parseInt(num.get(z)+"");
			switch(n){
			case 1: num.set(z, "일"); break;
			case 2: num.set(z, "이"); break;
			case 3: num.set(z, "삼"); break;
			case 4: num.set(z, "사"); break;
			case 5: num.set(z, "오"); break;
			case 6: num.set(z, "육"); break;
			case 7: num.set(z, "칠"); break;
			case 8: num.set(z, "팔"); break;
			case 9: num.set(z, "구"); break;
			case 0: num.set(z, ""); break;
			}
			
			int unit = z%4;
			switch(unit){
			case 1:if(num.get(z)!="")num.set(z, num.get(z)+"십");break;
			case 2:if(num.get(z)!="")num.set(z, num.get(z)+"백");break;
			case 3:if(num.get(z)!="")num.set(z, num.get(z)+"천");break;
			}
			unit = z;
			switch(unit){
			case 4: num.set(z, num.get(z)+"만 "); break;
			case 8: num.set(z, num.get(z)+"억 "); break;
			case 12: num.set(z, num.get(z)+"조 "); break;
			}
			
		}
		Collections.reverse(num);
		for(int i=0; i<num.size(); i++){
			System.out.print(num.get(i));
		}
	}

}
