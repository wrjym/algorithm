package Solution;

import java.io.FileInputStream;
import java.util.Scanner;


public class Solution1289_원재의메모리복구_서울9반_김용민 {

	static char[] str;
	static char[] zeroSetting;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		String startInput;
		for(int test_case = 0; test_case < T;test_case++){
			int count=0;
			startInput = sc.nextLine();
			char checknum='0';

			str = new char[startInput.length()];
			zeroSetting = new char[startInput.length()];

			for(int i=0; i<startInput.length(); i++){
				str[i]  = startInput.charAt(i);
				zeroSetting[i] = '0';
			}

			for(int i=0;i<zeroSetting.length;i++){
				boolean cheackdata = check();

				if(cheackdata){
					break;
				}
				else{
					if(zeroSetting[i] == str[i])
						continue;							
					
					else{
						count++;
						setting(i,str[i]);
					}
				}
			}
			
			System.out.println("#" + (test_case+1) + " " + count);

		}
	}
	private static void print(char []data) {
		for(int i=0;i<zeroSetting.length;i++){
			System.out.print(zeroSetting[i]);
		}
		System.out.println();

	}
	private static boolean check() {
		for(int i=0;i<str.length;i++){
			if(str[i] != zeroSetting[i]){
				return false;
			}
		}
		return true;
	}

	private static void setting(int index,char settingdata) {
		for(int i=index;i<zeroSetting.length;i++){
			zeroSetting[i] = settingdata;
		}
	}

}
