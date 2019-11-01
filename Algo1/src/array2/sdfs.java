package array2;

import java.io.FileInputStream;
import java.util.Scanner;

public class sdfs {
	public static void main(String[] args) throws Exception {
		String str = "Starteatingwellwiththeseeighttipsforhealthyeating,whichcoverthebasicsofahealthydietandgoodnutrition";
		String tok ="ti";

		String []tmp;
		tmp = str.split(tok,-1);
		System.out.println(tmp.length-1);

	}
}


