package D2;
/*
 *  간단한 369게임 -- 노가다..
 */
import java.util.Scanner;

public class D2_01 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    
	    for(int i=1;i<=N;i++)
	    {	
	    	if(i<10)
	    	{
	    		if(i%3==0)
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else
	    		{
	    			System.out.print(i+" ");
	    		}
	    	}
	    	else if (i>=10 && i<100)
	    	{
	    		String num =  Integer.toString(i);
	    		String a = num.substring(0,1);
	    		String b = num.substring(1,2);
	    		int F_chk =  Integer.parseInt(a);
	    		int S_chk =  Integer.parseInt(b);
	    		if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && S_chk > 0 )
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		else if ((F_chk % 3 != 0) && (S_chk % 3== 0) && S_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else if ((F_chk % 3 == 0) && (S_chk % 3!= 0) && S_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk == 0))
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else 
	    		{
	    			System.out.print(i+" ");
	    		}
	    	}
	    	else if (i>=100 && i<1000)
	    	{
	    		String num =  Integer.toString(i);
	    		String a = num.substring(0,1);
	    		String b = num.substring(1,2);
	    		String c = num.substring(2,3);
	    		int F_chk =  Integer.parseInt(a);
	    		int S_chk =  Integer.parseInt(b);
	    		int T_chk =  Integer.parseInt(c);
	    		if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("---"+" ");
	    		}
	    		else if ( (F_chk % 3 != 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 != 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 != 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk == 0 && T_chk > 0)
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk == 0)
	    		{
	    			System.out.print("--"+" ");
	    		}
	    		
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && (S_chk == 0 && T_chk == 0))
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 == 0) && (T_chk % 3 != 0) && S_chk == 0 && T_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		} 
	    		else if ( (F_chk % 3 != 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk == 0 && T_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 != 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk == 0)
	    		{
	    			System.out.print("-"+" ");
	    		} 
	    		else if ( (F_chk % 3 != 0) && (S_chk % 3 == 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk == 0)
	    		{
	    			System.out.print("-"+" ");
	    		} 
	    		else if ( (F_chk % 3 != 0) && (S_chk % 3 == 0) && (T_chk % 3 != 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		} 	
	    		else if ( (F_chk % 3 != 0) && (S_chk % 3 != 0) && (T_chk % 3 == 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		}
	    		else if ( (F_chk % 3 == 0) && (S_chk % 3 != 0) && (T_chk % 3 != 0) && S_chk > 0 && T_chk > 0)
	    		{
	    			System.out.print("-"+" ");
	    		} 
	    		else
	    		{
	    			System.out.print(i+" ");
	    		}
	    	}
	    	else 
	    	{
	    		System.out.print(i+" ");
	    	}
	    		
	    }
	    	
	     
	}

}
