package extraPractice;



public class PraticeEmptyClass 
{

	public static void main(String[] args) 
	{	

		String s="hii my name is Rishabh";
		String[] spa = s.split(" ");
		
		for(int i=0;i<spa.length;i++)
		{
			String st = spa[i];
			String rev="";
			for(int j=st.length()-1;j>=0;j--)
			{
				rev=rev+st.charAt(j);
			}
			System.out.print(rev+" ");
		}
		
	}
						
}
	


	


