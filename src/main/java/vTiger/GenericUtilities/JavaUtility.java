package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of Generic methods related to java
 * @author Rishabh
 *
 */

public class JavaUtility 
{
	/**
	 * This method will Generate random number for every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r= new Random();
		int value = r.nextInt(1000);
		return value;
	}
	/**
	 * This method will provide random string 
	 * @param charLength
	 * @return
	 */
	public String getRandomString(int charLength)
	{
		//what type of characters will append
		String characters="abcdefghijklmnopqwerstuvwxyz";
		String randomString="";
		Random rand=new Random();
		int length=rand.nextInt(charLength)+1;
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
		return randomString;
		
		
	}
	/**
	 * This method will provide system date
	 * @return
	 */
	public String getSystemDate() // we can use it for reports or we can attach with screenshot
	{
		Date d = new Date(); // take from java.Util
		String value = d.toString(); // convert it to string for print or utilise
		return value;
		
	}
	public String getSystemDateInFormat() 
	{
		Date d=new Date();	
		String[] dArr = d.toString().split(" ");// y method time date and day dega pr apn ko only date chahiye to split mtd se alag kr re h baki day 8 ki video dkho
		String date = dArr[2];					// split method will convert it to string array
		String month =dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-"); // we can not give : to save a filename try to make a folder with : name
		String dateInFormat=date+"_"+month+"_"+year+" " +time; //folder name also don't support /
		return dateInFormat;
				
	}
}
