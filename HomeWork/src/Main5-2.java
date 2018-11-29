import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		int i=-1;
		int count=0;
		Scanner in = new Scanner(System.in);
		int[] a=new int[100];
		
		while(in.nextByte()!='.')
		{
			i++;
			if(in.nextByte()!=' ')
			{
				a[i]++;
			}
		}
		for (int j : a) {
			
			if(count>0)
			{
				System.out.println(" ");
			}
			if(a[j]!=0)
			{
				System.out.println(a[j]);
			}
			count++;
		}
		
		
		
	}
	
	
}
