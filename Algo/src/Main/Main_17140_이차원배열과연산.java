package Main;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main_17140_이차원배열과연산 {
	static class Number{
		int num, count;
		public Number(int num, int count) {
			super();
			this.num = num;
			this.count = count;
		}
		@Override
		public String toString() {
			return "Number [num=" + num + ", count=" + count + "]";
		}

	}
	static int fr,fc,fk;
	static int r,c, ans;
	static int [][]map;
	static int [][]tmpMap;
	static int []row;
	static int []col;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("rs/17140.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		r = 3;
		c = 3;
		row = new int[101];
		col = new int[101];
		String tmp = br.readLine();
		String []tmps = tmp.split(" ");
		fr = Integer.parseInt(tmps[0])-1;
		fc = Integer.parseInt(tmps[1])-1;
		fk = Integer.parseInt(tmps[2]); 
		map = new int[101][101];
		tmpMap = new int[101][101];
		for(int i=0; i<r; i++){
			tmp = br.readLine();
			tmps = tmp.split(" ");
			for(int j=0; j<c; j++)
				map[i][j] = Integer.parseInt(tmps[j]);
		}
		int time = 0;
		while(true){
			if(map[fr][fc] == fk){
				ans = time;
				break;
			}
			boolean b = r >= c ? true : false;
			if(b)
				Rcalculate();
			else
				Ccalculate();
			for(int i=0; i<r; i++){
				for(int j=0; j<c; j++){
					map[i][j] = tmpMap[i][j];
					tmpMap[i][j] = 0;
				}
			}
			if(time>100)
				break;
			time++;
		}
		if(time == 101){
			ans = -1;
		}
		System.out.println(ans);
	}
	private static void Ccalculate() {
		int tmpCol = 0;
		for(int i=0; i<c; i++){
			for(int j=0; j<r; j++){
				if(map[j][i] > 0){
					col[map[j][i]]++;
				}
			}
			ArrayList<Number> collist = new ArrayList<>();
			for(int j=0; j<col.length; j++){
				if(col[j] != 0){
					collist.add(new Number(j, col[j]));
					col[j] = 0;
				}
			}
			sortList(collist);
			tmpCol = Math.max(tmpCol, collist.size()*2);
			for(int j=0; j<collist.size(); j++){
				tmpMap[j*2][i] = collist.get(j).num;
				tmpMap[j*2+1][i] = collist.get(j).count;
			}
		}
		r = tmpCol;
	}
	private static void Rcalculate() {
		int tmpRow = 0;
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if(map[i][j] > 0){
					row[map[i][j]]++;
				}
			}
			ArrayList<Number> rowlist = new ArrayList<>();
			for(int j=0; j<row.length; j++){
				if(row[j] != 0){
					rowlist.add(new Number(j, row[j]));
					row[j] = 0;
				}
			}
			sortList(rowlist);
			tmpRow = Math.max(tmpRow, rowlist.size()*2);
			for(int j=0; j<rowlist.size(); j++){
				tmpMap[i][j*2] = rowlist.get(j).num;
				tmpMap[i][j*2+1] = rowlist.get(j).count;
			}
		}
		c = tmpRow;
	}
	private static void sortList(ArrayList<Number> list) {
		Collections.sort(list, new Comparator<Number>() {
			@Override
			public int compare(Number o1, Number o2) {
				if(o1.count < o2.count)
					return -1;
				else if(o1.count > o2.count)
					return 1;
				else{
					if(o1.num < o2.num)
						return -1;
					else
						return 1;
				}	
			}
		});		
	}

}





