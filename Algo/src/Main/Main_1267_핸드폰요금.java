package Main;
import java.util.*;
import java.io.*;
public class Main_1267_핸드폰요금 {
	static int n;
	static int []useTime;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/1267.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		useTime = new int[n];
		for(int i=0; i<n; i++)
			useTime[i] = sc.nextInt();
		
		int Y = 0, M = 0;
		for(int i=0; i<n; i++){
			int Ytime = useTime[i], Mtime = useTime[i];
			int ymok = Ytime / 60;
			int yna = Ytime % 60;
			Y += ymok * 20;
			if(yna < 30)
				Y += 10;
			else
				Y += 20;
			int mmok = Mtime / 120;
			int mna = Mtime % 120;
			M += mmok * 30;
			if(mna < 60)
				M += 15;
			else
				M += 30;
		}
		
		
		if(Y < M)
			System.out.println("Y " + Y);
		else if(Y > M)
			System.out.println("M " + M);
		else
			System.out.println("Y M " + Y);
		sc.close();
		
	}

}
