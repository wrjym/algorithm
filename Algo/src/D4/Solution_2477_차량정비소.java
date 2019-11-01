package D4;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_2477_차량정비소 {
	static class customer{
		public int customerNum;
		public int nSTime;
		public int mSTime;
		public int nNum;
		public int mNum;
		public customer(int customerNum, int nSTime, int mSTime, int nNum, int mNum) {
			super();
			this.customerNum = customerNum;
			this.nSTime = nSTime;
			this.mSTime = mSTime;
			this.nNum = nNum;
			this.mNum = mNum;
		}
		public int getCustomerNum() {
			return customerNum;
		}
		public void setCustomerNum(int customerNum) {
			this.customerNum = customerNum;
		}
		public int getnSTime() {
			return nSTime;
		}
		public void setnSTime(int nSTime) {
			this.nSTime = nSTime;
		}
		public int getmSTime() {
			return mSTime;
		}
		public void setmSTime(int mSTime) {
			this.mSTime = mSTime;
		}
		public int getnNum() {
			return nNum;
		}
		public void setnNum(int nNum) {
			this.nNum = nNum;
		}
		public int getmNum() {
			return mNum;
		}
		public void setmNum(int mNum) {
			this.mNum = mNum;
		}
		@Override
		public String toString() {
			return "customer [customerNum=" + customerNum + ", nSTime=" + nSTime + ", mSTime=" + mSTime + ", nNum="
					+ nNum + ", mNum=" + mNum + "]";
		}
		
	}
	static class Counter{
		public int customerNum;
		public int customerEndTime;
		public int counterTime;
		public Counter(int customerNum, int customerEndTime, int counterTime) {
			super();
			this.customerNum = customerNum;
			this.customerEndTime = customerEndTime;
			this.counterTime = counterTime;
		}
		public int getCustomerNum() {
			return customerNum;
		}
		public void setCustomerNum(int customerNum) {
			this.customerNum = customerNum;
		}
		public int getCustomerEndTime() {
			return customerEndTime;
		}
		public void setCustomerEndTime(int customerEndTime) {
			this.customerEndTime = customerEndTime;
		}
		public int getCounterTime() {
			return counterTime;
		}
		public void setCounterTime(int counterTime) {
			this.counterTime = counterTime;
		}
		@Override
		public String toString() {
			return "Counter [customerNum=" + customerNum + ", customerEndTime=" + customerEndTime + ", counterTime="
					+ counterTime + "]";
		}
	}

	public static int N,M,K,A,B;
	public static Counter []nCounter;
	public static Counter []mCounter;
	public static ArrayList<customer> nCusList,mCusList;
	public static Queue<customer> nQ,mQ;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("rs/2477.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++){
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			nCusList = new ArrayList<>();
			nQ = new LinkedList<>();
			mQ = new LinkedList<>();
			nCounter = new Counter[N];
			mCounter = new Counter[M];
			for(int i=1; i<=K; i++){
				nCusList.add(new customer(i,0,0,0,0));
			}

			for(int n=0; n<N; n++){
				nCounter[n] = new Counter(0,0,sc.nextInt());
			}
			for(int m=0; m<M; m++){
				mCounter[m] = new Counter(0,0,sc.nextInt());
			}
			for(int k=0; k<K; k++){
				nCusList.set(k, new customer(k+1,sc.nextInt(),0,0,0));
				nQ.offer(nCusList.get(k));
			}

			nCusList = new ArrayList<>();
			mCusList = new ArrayList<>();
			ArrayList<customer> end = new ArrayList<>();
			int time = nQ.peek().getnSTime()-1;
			while(true)	{
				if(nQ.isEmpty() && mQ.isEmpty() && end.size()==K)
					break;

				if(!nQ.isEmpty()){
					for(int n=0; n<N; n++){
						if(nCounter[n].customerNum==0 && !nQ.isEmpty() && nQ.peek().getnSTime() <= time){
							
							customer cu = nQ.poll();								//현재 창구가 비어있을 경우.
							nCounter[n].customerNum = cu.getCustomerNum();			//창구에 손님 번호 입력.
							nCounter[n].customerEndTime = time + nCounter[n].getCounterTime() - 1;

							cu.setnNum(n+1);										//접수창구 번호 입력.
							nCusList.add(cu);
						}

					}
				}

				if(nCusList.size() > 0){
					for(int n=0; n<N; n++){
						if(nCounter[n].customerEndTime == time){
							for(int k=0; k<nCusList.size(); k++){					//현재 창구에 있는 손님이 업무가 끝났을 때 번호를 찾아서 지워준다.
								if(nCounter[n].customerNum == nCusList.get(k).getCustomerNum()){
									nCounter[n].setCustomerNum(0);							//창구 비워두기.
									nCounter[n].customerEndTime = 0;						//창구 시간 초기화.
									mQ.offer(nCusList.get(k));								//정비창구 대기인원 추가.
									nCusList.remove(k);
									break;
								}
							}
						}
					}
				}

				if(!(mQ.isEmpty())){
					for(int m=0; m<M; m++){
						if(mCounter[m].customerNum==0 && !mQ.isEmpty()){
							customer cu = mQ.poll();
							mCounter[m].customerNum = cu.getCustomerNum();
							mCounter[m].customerEndTime = time + mCounter[m].getCounterTime() - 1;

							cu.setmSTime(time);
							cu.setmNum(m+1);
							mCusList.add(cu);
						}
					}
				}
				if(mCusList.size() > 0){
					for(int m=0; m<M; m++){
						if(mCounter[m].customerEndTime == time){
							for(int k=0; k<mCusList.size(); k++){
								if(mCounter[m].customerNum == mCusList.get(k).getCustomerNum()){
									mCounter[m].setCustomerNum(0);
									mCounter[m].customerEndTime = 0;
									end.add(mCusList.get(k));
									mCusList.remove(k);
									break;
								}
							}
						}
					}
				}
				time++;
			}
			int ans = 0;
			for(int i=0; i<end.size(); i++){
				if(end.get(i).nNum==A && end.get(i).mNum==B){
					ans += end.get(i).customerNum;
				}
			}

			System.out.print("#" + tc  + " " );
			if(ans==0){
				System.out.print(-1);
			}
			else{
				System.out.print(ans);
			}
			System.out.println();
		}
	}
}
