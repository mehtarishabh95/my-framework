package vTiger.Practice;

import java.util.Random;

public class RandomStringPractice {

	public static void main(String[] args) 
	{
		
			//what type of characters will append
			String characters="ABCDEFGHIJKLMNOPQWERSTUVWXYZ";
			String randomString="";
			//int length=5;
			Random rand=new Random();
			int length=rand.nextInt(15);
			//convert chars into array
			char[] text=new char[length];
			for(int i=0 ; i<length ; i++)
			{
				text[i]=characters.charAt(rand.nextInt(characters.length()));
			}
			for(int i=0;i<text.length;i++)
			{
				randomString += text[i];
			}
			System.out.println(randomString); 

	}

}
	