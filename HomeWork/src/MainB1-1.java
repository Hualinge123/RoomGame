import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		int i=0;
		int count=0;
		char p=0;
		int number=0;
		Scanner in = new Scanner(System.in);
		String s=in.nextLine();
		int[] a=new int[100];
	    
		
		
		for(int j=0;j<s.length();j++)
		{
			p=s.charAt(j);
			if(p==' '||p=='.') {
				
				a[i]=count;
				i++;
				count=0;
				continue;
				
			}
			count++;
		}
		
		
		
		for (int j=0;j<a.length;j++) 
		{
						
			if(a[j]!=0)
			{
				if(number>0)
				{
					System.out.print(" ");
				}
				System.out.print(a[j]);
				number++;
			}
			
		 }
		
	 }
		
}
	
	

