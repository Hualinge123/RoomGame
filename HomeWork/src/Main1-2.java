import java.util.Scanner;

public class Main{

	public static void main(String[] args) 
	{
		
		String time="";
		Scanner in = new Scanner(System.in);
		
		
		while(true)
		{
			
			String s=in.nextLine();
			String s1="";
			int sum=0;
			int j=0;
			if(s.equals("END")) {
				break;
			}
			char[] c=s.toCharArray();
			String [] str=new String[100];
			StringBuffer sb= new StringBuffer();
			
			
            for(int i=0;i<c.length;i++) {
				
				if(c[i]==',')
				{
					str[j]=sb.toString();
					sb.setLength(0);
					j++;
					continue;
					
				}	
				sb.append(c[i]);
			}
			
			
			
			if(str[0].equals("$GPRMC")){
				for(int i=1;i<s.lastIndexOf('*');i++)
				{
					sum^=c[i];
				}
				s1=s.substring(s.lastIndexOf('*')+1);
				sum=sum%65536;
				
				if(sum==Integer.parseInt(s1,16))
				{
					
					if(str[2].equals("A")) {
						if(Integer.parseInt(str[1].substring(0, 1))<24&&Integer.parseInt(str[1].substring(2, 4))<60&&Integer.parseInt(str[1].substring(4,6))<60) {
							time=str[1];
						}
						
					}
				}
				
				
			}
			
			
		}
		
		timeFormat(time);		
	 }
	
	
	 static void  timeFormat(String str) {
		 
		 
		 String hourStr=str.substring(0, 2);
		 String minuStr=str.substring(2, 4);
		 String secoStr=str.substring(4, 6);
		 
		 int a =Integer.parseInt(hourStr)+8;
		
		 if(a>23) {
			 a=a-24;
		 }
		 if(a>9) {
			 hourStr=Integer.toString(a);
		 }else {
			 hourStr="0"+a;
		 }
		 
		 System.out.println(hourStr+":"+minuStr+":"+secoStr); 
	 }
		
}


 
	
	

