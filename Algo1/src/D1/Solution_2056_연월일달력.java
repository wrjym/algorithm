package D1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_2056_연월일달력 {
	public static String []date = new String[3];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2056.txt"));
		Scanner sc = new Scanner(System.in);

		int T =	Integer.parseInt(sc.nextLine());
		for(int tc=1; tc<=T; tc++){
			String a = sc.nextLine();
			date[0] = a.substring(0, 4);
			date[1] = a.substring(4,6);
			date[2] = a.substring(6);

			System.out.print("#" + tc + " ");
			switch(date[1]){
			case "01": case "03": case "05": case "07": case "08": case "10": case "12":{
				if(1<=Integer.parseInt(date[2]) && Integer.parseInt(date[2])<=31){
					System.out.println(date[0] + "/" + date[1] + "/" + date[2]);
				}
				else
					System.out.println("-1");
				break;
			}

			case "04": case "06": case "09": case "11":{
				if(1<=Integer.parseInt(date[2]) && Integer.parseInt(date[2])<=30){
					System.out.println(date[0] + "/" + date[1] + "/" + date[2]);
				}
				else
					System.out.println("-1");
				break;
			}

			case "02":{
				if(1<=Integer.parseInt(date[2]) && Integer.parseInt(date[2])<=28){
					System.out.println(date[0] + "/" + date[1] + "/" + date[2]);
				}
				else{
					System.out.println("-1");
				}
				break;
			}
			default :{
				System.out.println("-1");
			}
			}

		}
	}
}
