import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		int n=0;
		int m=0;
		boolean isPrime=true;
		final int K=0;
		int p=0;
		
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		
		for(int i=n;i<=m;i++)
		{
		  if(isPrime==wanshu(i))
		  {
			  if(p>K)
			  {
				  System.out.print(" ");
			  }
			  System.out.print(i);
			  p++;
			  
		  }
		
		}
		if(p==0)
		  {
			  
			  System.out.print("NIL");
			 
			  
		  }
		
	}
	
	public static boolean wanshu(int a)
	{
		boolean Prime=false;
		int sum=0;
		int[] l=new int[1000];
		
		for(int i=1; i<a; i++)
		{
			if(a%i==0)
			{
				sum+=i;
			}
		}
		if(sum==a)
		{
			Prime=true;
		}
		
		
		return Prime;
	}

}
