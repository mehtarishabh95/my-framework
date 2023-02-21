package vTiger.Practice;

import org.testng.annotations.Test;

public class DebuggingPractice
{

	@Test
	public void debugging()
	{
		System.out.println("debug");
		int result = div();
		System.out.println(result);
				
	}
	public int div()
	{
		int a=10;
		int b=0;
		int c=a/b;
		return c;
				
	}
}
